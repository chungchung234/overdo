# Overdo

Overdo is a minimal Spring Boot application. The project structure
is typical for a Gradle-based Java project and includes a
Docker Compose file for MongoDB.

It now includes a simple JPA-based Task API under `/tasks`.

## Branch strategy

The project follows the branch workflow defined in `codex.yaml`.
At the moment, all development happens directly on the `main` branch.

## Building and testing

Use the Gradle wrapper to build and run tests:

```bash
./gradlew build   # compile and run tests
./gradlew test    # run tests only
```

Requires JDK 21 or higher.

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

## License

This project is licensed under the [MIT License](LICENSE).

## Codex automation

For commit and branch guidelines see [AGENTS.md](AGENTS.md).


