# Codex Agent Guide

This repository uses Codex automation.

## Prerequisites
- Install the Codex CLI: `pip install codex`.
- Run `codex init` once to link the repository.

## Workflow
- All feature work starts from the `develop` branch.
- Follow the branch rules described in `codex.yaml`.
- Run `./gradlew test` before pushing changes.

## Commit style
- 커밋 메시지는 한국어로 작성합니다.
- 첫 줄은 50자를 넘기지 않도록 요약합니다.
- Conventional Commits 형식을 권장합니다.
  - feat: 새로운 기능 추가
  - fix: 버그 수정
  - docs: 문서 수정
  - style: 코드 포맷 등 비기능적 변경
  - refactor: 코드 리팩토링
  - test: 테스트 추가 또는 수정
- chore: 기타 변경 사항
- PR 제목도 동일한 규칙을 따릅니다.

커밋 메시지 규칙을 자동으로 검사하는 Git 훅이 `githooks/commit-msg`에 포함되어 있습니다. 아래 명령으로 활성화하세요.

```bash
git config core.hooksPath githooks
```


