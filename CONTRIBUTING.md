# Contributing

이 프로젝트에 기여하려면 다음 규칙을 지켜 주세요.

## 커밋 메시지

- 메시지는 반드시 한국어로 작성합니다.
- 첫 줄은 50자 이내로 요약합니다.
- [Conventional Commits](https://www.conventionalcommits.org/ko/v1.0.0/) 형식을 사용합니다.

예시:

```
feat: 사용자 로그인 기능 추가
```

## Git 훅 설치

커밋 메시지 형식을 자동으로 검증하려면 아래 명령을 실행하여 훅을 활성화합니다.

```bash
git config core.hooksPath githooks
```

자세한 내용은 `AGENTS.md`를 참고하세요.
