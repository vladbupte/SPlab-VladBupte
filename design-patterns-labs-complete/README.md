
# design-patterns-labs

Minimal Spring Boot sample project implementing the labs:
- Composite model for Book/Section/Paragraph/Image
- Strategy (not fully exercised in REST demo, model included)
- Observer via Server-Sent Events (SSE)
- Command pattern: minimal interfaces and executor
- Spring Data JPA with H2

How to run:
- Ensure Java 8+ and Gradle
- From project root: `./gradlew bootRun`
- H2 console available at http://localhost:8080/h2-console (JDBC URL shown in application.properties)
- SSE demo: open http://localhost:8080/ (index.html will connect to /books-sse)


## Additions made on user's request
- Strategy pattern (AlignStrategy + AlignLeft/Right/Center) and Paragraph supports alignment.
- RequestLoggingFilter that logs before/after each request.
- Full Command implementations for CRUD and AsyncCommandExecutor.
- CrudRepository interface and SpringDataBooksAdapter adapter.
