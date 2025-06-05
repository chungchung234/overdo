# Overdo

리그 오브 레전드 게임 데이터를 분석하고 시각화하는 웹 애플리케이션입니다.

## 기술 스택

- Backend: Spring Boot 3.2.3
- Frontend: React
- Database: MongoDB
- API: Riot Games API

## 시작하기

### 필수 조건

- Java 17
- Node.js
- MongoDB
- Riot Games API 키

### 환경 설정

1. Riot Games API 키 발급
   - [Riot Games Developer Portal](https://developer.riotgames.com/)에서 API 키를 발급받습니다.
   - 발급받은 API 키를 환경 변수로 설정합니다:
     ```bash
     export RIOT_API_KEY=your_api_key
     ```

2. MongoDB 설정
   - MongoDB를 설치하고 실행합니다.
   - 필요한 경우 `application.properties`에서 MongoDB 연결 설정을 수정합니다.

### 실행 방법

1. 백엔드 실행
   ```bash
   ./gradlew bootRun
   ```

2. 프론트엔드 실행
   ```bash
   cd frontend
   npm install
   npm start
   ```

## API 엔드포인트

### 소환사 정보 조회
```
GET /api/riot/summoner/{summonerName}
```

### 리그 정보 조회
```
GET /api/riot/league/{summonerId}
```

### 최근 매치 조회
```
GET /api/riot/matches/{puuid}
```

## 보안

- API 키는 환경 변수로 관리됩니다.
- 민감한 정보가 포함된 파일들은 `.gitignore`에 등록되어 있습니다.

## 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다. 