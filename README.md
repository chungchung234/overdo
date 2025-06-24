# Overdo

Overdo is a minimal Spring Boot application. The project structure
is typical for a Gradle-based Java project and includes a
Docker Compose file for MongoDB.

## Branch strategy

The project follows the branch workflow defined in `codex.yaml`.
Development is carried out on the `develop` branch. Changes are
merged into `main` when they are ready for release.

## Building and testing

Use the Gradle wrapper to build and run tests:

```bash
./gradlew build   # compile and run tests
./gradlew test    # run tests only
```

## Scripts

The `scripts/` directory provides utilities for release tagging,
deployment and postmortem notes. It contains the following helper
scripts and is structured as follows:

```text
scripts/
├── auto-tag.sh
├── create-postmortem.sh
├── deploy-prod.sh
└── release-notes.sh
```
