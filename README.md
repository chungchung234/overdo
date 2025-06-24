# Overdo

Overdo is a minimal Spring Boot application. The project structure
is typical for a Gradle-based Java project and includes a
Docker Compose file for MongoDB.

## Branch strategy

The project follows the branch workflow defined in `codex.yml`.
Development is carried out on the `work` branch. Changes are
merged into `master` when they are ready for release.

## Building and testing

Use the Gradle wrapper to build and run tests:

```bash
./gradlew build   # compile and run tests
./gradlew test    # run tests only
```

## Scripts

There is currently no `scripts/` directory in this repository.
This section can describe script usage once scripts are added.
