`genability-java` is the official Genability maintained Java client library for the [Genability APIs](https://developer.genability.com).

* There is a [Getting Started Guide](https://genability.github.io/genability-java/tutorial.html) thats a good place to start.
* You can see the [Javadocs here](https://genability.github.io/genability-java/javadoc/).

# Get the JAR from Maven Central Repository
The Genability API Java client library is now available on the Maven Central Repository! Hosted on [Sonatype's OSSH](https://oss.sonatype.org/), you can now use the library with a couple of lines of XML. Just add the following to `pom.xml` in your Maven-enabled project:

```xml
<dependency>
  <groupId>com.genability</groupId>
  <artifactId>genability-client</artifactId>
  <version>1.13.0</version>
</dependency>
```

You'll still need an appId and appKey to make any requests. Get an appId at https://dash.genability.com/org/applications or [sign up](https://dash.genability.com/signup) if you are new to Genability.

Be sure to check out the [tutorial](https://genability.github.io/genability-java/tutorial.html) and the [tutorial app](https://github.com/Genability/java-client-tutorial) for some examples to get you started.

# How to Run the Tests
1. Get a Genability appId and appKey.
2. Copy the `src/test/resources/genability.properties` file into a new `src/test/resources/genability.local.properties`. This copy is gitignored.
3. Fill in your appId and appKey into the `.local.properties`.
4. Run `mvn test`: compiles the library and runs JUnit tests.
5. Develop your own app. Read the API documentation at http://developer.genability.com.
