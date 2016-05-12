`genability-java` is the official Java client library for the [Genability API](http://genability.com).

# Now Available on Maven Central Repository
The Genability API Java client library is now available on the Maven Central Repository! Hosted on [Sonatype's OSSH](https://oss.sonatype.org/), you can now use the library with a couple of lines of XML. Just add the following to `pom.xml` in your Maven-enabled project:

```xml
<dependency>
  <groupId>com.genability</groupId>
  <artifactId>genability-client</artifactId>
  <version>1.5.1</version>
</dependency>
```

You'll still need an appId and appKey to make any requests. Get an appId at https://apps.genability.com/profile/organizations/current or [sign up](https://apps.genability.com/explorer/signup) if you are new to Genability.

Be sure to check out the [tutorial](http://genability.github.io/genability-java/tutorial.html) and the [tutorial app](https://github.com/Genability/java-client-tutorial) for some examples to get you started.

# How to Run the Tests
1. Get an appId and appKey.
2. Put the appId and appKey in the `src/test/resources/genability.properties` file.
3. Compile the library and run JUnit tests with `mvn test`.
4. Develop your own app. Read the API documentation at http://developer.genability.com.

You can see the Javadocs [here](http://genability.github.io/genability-java/javadoc/).
