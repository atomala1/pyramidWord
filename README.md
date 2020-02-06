# Pyramid Word WebService

The pyramid word service is a Gradle/Kotlin/Spring Web MVC/Junit 5

## Prerequisites

The application requires Java 11 to run.

## Running tests

```bash
./gradlew clean test
```

## Running the Application

The application runs on port 8080

```bash
./gradlew bootRun
```

## Accessing the API

```bash
curl -X GET \
  'http://localhost:8080/pyramid?word=dbdbccdcdA'
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0/)