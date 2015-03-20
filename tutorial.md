---
layout: page
title: "Java Client Library Tutorial"
categories: genability java libraries tutorial how-to howto
---
## Table of Contents
{:.no_toc}

* TOC
{:toc}

## Overview
Creating an account, populating it, and then doing a savings analysis on it is one of most common ways to use the Genability API. This tutorial uses the [Java client tutorial app][jct] to show one simple way to do that. In this tutorial we will:

1. Get an introduction to the [Java client library][jcl] for the Genability API.
2. Learn how to use the library to create an account.
3. Populate the account that we create with enough data to do a savings analysis.
4. Calculate how much a residential customer could save in the first year by going solar.

This tutorial assumes that you've already set up an application within Genability's API. If you haven't done that yet, you should head to the [Quickstart][quickstart] page and get set up. Make sure to also download the [Java client library][jcl] and the [tutorial app][jct] so that you can follow along.

## Create a GenabilityClient Instance
Before you can make any calls to the API, you need to create a `GenabilityClient` instance. This object stores your `appKey` and `appId` so that they can be passed along with all of the requests that you make.

{% highlight java %}
// Store the appId and appKey in environment variables rather than directly
// in code
String appId = System.getenv("APP_ID");
String appKey = System.getenv("APP_KEY");

GenabilityClient client = new GenabilityClient(appId, appKey);
{% endhighlight %}

## Create an Account
Next, you need to create an [Account](/documentation/api-reference/account-api/account/#account_1). An `Account` object holds information about your potential customer's electricity rate plan, electricity usage, and electricity costs. In the Java client, that looks like this:

{% highlight java %}
// Create the account object
Account account = new Account();
account.setAccountName("Genability Java Client Tutorial_" + UUID.randomUUID());

// Set its customer class to RESIDENTIAL (1)
PropertyData customerClass = new PropertyData();
customerClass.setKeyName("customerClass");
customerClass.setDataValue(1);
account.setProperty("customerClass", customerClass);

// Give it an address
Address addr = new Address();
addr.setAddressString(zipCode);
account.setAddress(addr);

// Send the request to the API and check the response
AccountService service = client.getAccountService();
Response<Account> response = service.addAccount(account);
if (response.getStatus().equals(Response.STATUS_SUCCESS)) {
    return response.getResults().get(0);
}
{% endhighlight %}

This account has the minimum amount of information required for a savings analysis: a location and a customer class. There are many additional properties that you can set on an account. For additional documentation, including a complete list of the properties available to set on an account, see the [Accounts API](http://developer.genability.com/documentation/api-reference/account-api/) page and the corresponding [Javadoc][javadoc].

### Making Requests
In the Java client, sending a request to the API is generally a three step process:

1. Instantiate a request object.
2. Populate the request with the appropriate parameters.
3. Send that request to the service class that corresponds to your request.

When creating objects, as in the code above, we get to short-circuit step 1 by directly passing the object that we want to create into the service class. As we'll see later, we'll have to use the full process when making other types of requests.

### Add Versus Update
The example above uses the `addAccount()` function and returns an account with a Genability-generated `accountId`. Alternatively, we could have used the `updateAccount()` function. This would have allowed us to set our own, internally generated `providerAccountId` on the account. That way, we wouldn't have to store Genability's `accountId` in our database. Accounts can be retrieved by `providerAccountId` just as easily as with an `accountId`.

### What is Returned?
For both an Add or an Update, the API returns the same thing: an instance of the newly created (or updated) object wrapped up in a `Response`. The `Response` object gives some information about whether the request succeeded or not, the type of the object returned, and then, in its `results` field, a list of returned objects. Even if there is only one instance returned -- as there will be when creating or updating an account -- the `results` field is still a list. You can see more information about API responses [here][response].

## Confirm the Customer's Utility
The next step is to confirm the customer's electrical utility. To do that, we can use the ZIP code that we set in the last step to get a list of utilities in the area (we call them Load Serving Entities or LSEs). For this request, we'll have to use the full three-step process [described above](#making-requests).

{% highlight java %}
// Get the LseService
LseService service = client.getLseService();

// Create a request object
GetLsesRequest request = new GetLsesRequest();

// Set the parameters of the request
String[] serviceTypes = {"ELECTRICITY"};
request.setZipCode(zipCode);
request.setResidentialServiceTypes(serviceTypes);

// Make the request
Response<Lse> response = service.getLses(request);

// Handle the response
if (response.getStatus().equals(Response.STATUS_SUCCESS)) {
    return response.getResults();
} else {
    return null;
}
{% endhighlight %}

Note the additional filter for residential and ELECTRICITY (`residentialServiceType`). Without this filter, the request will return **all** kinds of load serving entities for the area, which could include solar providers or other entities that you wouldn't normally think of as a utility. There are similar properties for C&I, and solar PV.

More information about the LoadServingEntity endpoint is available [here](http://developer.genability.com/documentation/api-reference/tariff-api/load-serving-entity/).

## Confirm the Customer's Tariff
Your customer will almost always have multiple tariffs to choose from. In order to get the most accurate savings analysis, we need to choose the right one. There are a number of ways to do that, but the best way is to utilize the information that we've already gathered and perform a `GetAccountTariffsRequest`. This type of tariff lookup uses the properties of the account in order to find the tariffs that are available to it.

{% highlight java %}
// Set up the request
GetAccountTariffsRequest request = new GetAccountTariffsRequest();
request.setAccountId(account.getAccountId());

// Make the request to the service
AccountService service = client.getAccountService();
Response<Tariff> response = service.getAccountTariffs(request);

// Handle the response
List<Tariff> tariffList = response.getResults();
{% endhighlight %}

Then, once the customer has confirmed their tariff, we have to actually set it on the account. We'll use the `updateAccount` function, which is part of the `AccountService`, to do that.

{% highlight java %}
// masterTariffId is part of the account's "properties" dictionary
PropertyData data = new PropertyData();
data.setKeyName("masterTariffId");
data.setDataValue(dataValue);
theAccount.setProperty(data);

// As always, make sure to get the service from the GenabilityClient object
// rather than creating it directly.
AccountService service = client.getAccountService();
Response<Account> response = service.updateAccount(theAccount);
{% endhighlight %}

### Default Tariffs
Although an account always has to have a `masterTariffId` in order to do a savings analysis with it, you don't necessarily have to set it yourself. When you set an account's address and utility, the Genability API automatically determines which tariff is the most likely one. This determination is made by comparing the account to other, similar ones in that service area. You can always override the API's guess, but in case you don't, you can still do a savings analysis.

## Get the Customer's Annual Energy Usage
Because customer energy consumption data comes in so many forms and in so many different levels of detail, the Genability API is very flexible when it comes to adding usage data to an account. Whether you have a single bill for a single month or an entire year's worth of interval data, you can still do an accurate analysis. For all of the different options, check out the documentation page for [Usage Profiles](http://developer.genability.com/documentation/api-reference/account-api/usage-profile/).

For this tutorial, we're only going to need the customer's total annual energy consumption in kilowatt-hours. Then, we'll use a [Typical Baseline][baseline] to transform that single number into a year of hourly data. By doing it this way, we don't have to store any profile data on the server, and can instead just pass the usage directly to the Savings Analysis calculator.

{% highlight java %}
// Prompt the user for their annual energy consumption and just save
// it in a variable. We don't need to save it on the server
// for this analysis.
System.out.print("Enter your annual energy usage (kWh): ");
int annualEnergyConsumption = inputScanner.nextInt();
{% endhighlight %}

## Perform a Savings Analysis
Now that we've got the customer's location, utility, tariff, and annual energy consumption, we're ready for the main event: the [Savings Analysis](http://developer.genability.com/documentation/api-reference/switch-api/savings-analysis/). This service is extremely flexible and can be used for all kinds of "What-If?" scenario modeling. In this tutorial, though, we're going to be doing a very straightforward analysis using the information that we've gathered so far.

### Scenarios
A key concept in the Savings Analysis API is the notion of a _scenario_. Fundamentally, the amount of money a customer can save by going solar is the difference between what they would have paid without solar and what they actually paid once solar was installed. Scenarios are the building blocks for calculating those values within a savings analysis.

In a savings analysis, there are three main scenarios: `before`, `solar`, and `after`. Each one represents a specific energy profile within the analysis.

* The `before` scenario is what happens if no solar power system is installed. It uses the energy usage supplied by the customer and the default tariff set on the account.
* The `solar` scenario is for the actual energy generated by the solar power system. If you apply a cost to it -- a monthly lease payment, for example -- it will calculate the cost of the system over the duration of the analysis.
* The `after` scenario is what happens if a system is installed. It uses the _net_ energy -- `before` minus `solar` -- to calculate how much the customer would pay to the utility if a solar system were to be installed.

To set up the analysis, we have to apply our desired settings to each of these scenarios.

### Analysis Settings
The Savings Analysis API has a lot of options. In this tutorial, we're only going to use a few of them. Here's the analysis that we're going to run:

* Apply a typical baseline profile to the annual energy consumption that the customer entered earlier, transforming it into hourly data for the year.
* For the `before` scenario, calculate the cost of that energy profile using the tariff that we selected earlier.
* For the `solar` scenario, use PVWatts to size the system to offset about 80% of the customer's annual usage.
* For the `after` scenario, just subtract the `solar` profile from the `before` profile and calculate the result using the customer's current tariff.

Here's what that looks like using the [Java client library][jcl]. We'll take it setting-by-setting. First, though, we have to create the request object:

{% highlight java %}
AccountAnalysisRequest request = new AccountAnalysisRequest();
request.setAccountId(theAccount.getAccountId());
request.setFromDateTime(DateTime.now());

// List of PropertyData to store the settings for this analysis
List<PropertyData> analysisSettings = new ArrayList<PropertyData>();
{% endhighlight %}

A request to the Savings Analysis API is done using an `AccountAnalysisRequest`. It has two required parameters, which we've set above: `accountId` and `fromDateTime`. `accountId` is, as expected, the ID of the account for which we want to do an analysis. If we had one, we could use the `providerAccountId` instead.

The `fromDateTime` parameter tells the calculator when to start the analysis. This is important when deciding which version of a tariff to use. Because tariffs change over time, an analysis starting on March 1, 2013 would have a different result than one starting on March 1, 2015. In the tutorial app, we're using `DateTime.now()` to make sure we just use whatever is most recent.

Next, we want to set up what our profiles will look like. Each setting is contained within a `PropertyData` object.

{% highlight java %}
PropertyData baselineSetting = new PropertyData();
baselineSetting.setScenarios("before,after,solar");
baselineSetting.setKeyName("baselineType");
baselineSetting.setDataValue("TYPICAL");
analysisSettings.add(baselineSetting);
{% endhighlight %}

What we're doing here is taking advantage of Genability's [Typical Baseline][baseline] service to reduce the amount of data that we need to gather for the analysis. Earlier, we only asked for the customer's annual energy consumption. That's useful, but it's not usually enough data to do an accurate savings analysis. Since most utilities charge different rates during different times of the year, it's important to know when the energy is used in addition to how much. This is where typical baselines come in.

Genability has gathered data from thousands of customers and PV systems across the country in order to develop a set of typical profiles across region, utility, and customer type. This setting tells the calculator that we want to use those profiles in our analysis instead of just dividing the annual energy consumption (or energy production) evenly by month. We use all three scenarios (`"before,after,solar"`) here because we want to apply the baselines to both the energy consumption and energy generation.

In the next setting, we input our annual energy consumption from earlier:

{% highlight java %}
PropertyData targetEnergyConsumptionSetting = new PropertyData();
targetEnergyConsumptionSetting.setScenarios("before,after");
targetEnergyConsumptionSetting.setKeyName("loadSize");

// We saved the annual energy consumption number from earlier in the
// targetEnergyConsumption variable
targetEnergyConsumptionSetting.setDataValue(targetEnergyConsumption);
targetEnergyConsumptionSetting.setUnit("kWh"); // make sure to set the units
analysisSettings.add(targetEnergyConsumptionSetting);
{% endhighlight %}

Here we use the `loadSize` setting to set the target energy consumption for the `before` and `after` scenarios to the annual value that we gathered earlier from the customer. The calculator will use this value to scale the typical baseline up or down.

Finally, we size the solar power system:

{% highlight java %}
PropertyData targetSolarOffsetSetting = new PropertyData();
targetSolarOffsetSetting.setScenarios("after,solar");

// Size the solar power system to offset 80% of the customer's annual
// energy consumption
targetSolarOffsetSetting.setKeyName("solarPvLoadOffset");
targetSolarOffsetSetting.setDataValue("80");
analysisSettings.add(targetSolarOffsetSetting);
{% endhighlight %}

The `solarPvLoadOffset` setting uses PVWatts to generate a solar profile at the customer's location. Here, we're sizing the profile to produce 80% of the customer's annual energy consumption.

### Do the Analysis
Now we can actually make the analysis request. As always, we get the `GenabilityClient` to create the service (in this case, the `AccountAnalysisService`) and then send our request through it. For the Savings Analysis API, an `AccountAnalysis` instance is returned in the response.

{% highlight java %}
request.setPropertyInputs(analysisSettings);
AccountAnalysisService service = client.getAccountAnalysisService();
Response<AccountAnalysis> result = service.calculateSavingsAnalysis(request);
{% endhighlight %}

### Look at the Results
This API returns a lot of information, the details of which can be seen on the [Savings Analysis](http://developer.genability.com/documentation/api-reference/switch-api/savings-analysis/#put-it-all-together) page. To just see how much money the customer could save in the first year, we can use the `netAvoidedCost` property:

{% highlight java %}
BigDecimal netAvoidedCost = summary.get("netAvoidedCost");
{% endhighlight %}

## Summary
In this tutorial, we've touched on most of the basic elements of a savings analysis using the Genability API. We took a customer's ZIP code, utility, tariff, and annual energy consumption and used it to calculate how much money they could save in the first year by going solar. This is just one way to do it though. You can use much more detailed usage data to get a more accurate result, or you can use the savings analysis calculator to run dozens of "What-If?" scenarios for different tariffs and system sizes. The combinations are almost endless.

## Resources
* Download the [source code][jct] for the application that goes along with this tutorial
* Download the [Java client library][jcl]
* Visit the [Genability Developer Network (GDN)](http://developer.genability.com) for detailed information about the entire Genability API


[jcl]: https://github.com/Genability/genability-java
[jct]: https://github.com/Genability/java-client-tutorial
[quickstart]: http://developer.genability.com/documentation/quickstart/
[javadoc]: https://genability.github.io/genability-java/javadoc
[response]: http://developer.genability.com/documentation/basics/responses/
[baseline]: http://developer.genability.com/documentation/api-reference/tariff-api/typical-baseline/
