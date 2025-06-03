package se.overdo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

@Service
public class RiotApiService {
    
    private final WebClient webClient;
    
    public RiotApiService(@Value("${riot.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://kr.api.riotgames.com")
                .defaultHeader("X-Riot-Token", apiKey)
                .build();
    }
    
    // Riot ID로 계정 정보 조회
    public Mono<String> getAccountByRiotId(String gameName, String tagLine) {
        return webClient.get()
                .uri("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}", gameName, tagLine)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, e -> {
                    if (e.getStatusCode().value() == 403) {
                        return Mono.error(new RuntimeException("API 키가 유효하지 않거나 만료되었습니다."));
                    }
                    return Mono.error(e);
                });
    }
    
    // PUUID로 소환사 정보 조회
    public Mono<String> getSummonerByPuuid(String puuid) {
        return webClient.get()
                .uri("/lol/summoner/v4/summoners/by-puuid/{puuid}", puuid)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, e -> {
                    if (e.getStatusCode().value() == 403) {
                        return Mono.error(new RuntimeException("API 키가 유효하지 않거나 만료되었습니다."));
                    }
                    return Mono.error(e);
                });
    }
    
    // 소환사 ID로 랭크 정보 조회
    public Mono<String> getLeagueEntries(String summonerId) {
        return webClient.get()
                .uri("/lol/league/v4/entries/by-summoner/{summonerId}", summonerId)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, e -> {
                    if (e.getStatusCode().value() == 403) {
                        return Mono.error(new RuntimeException("API 키가 유효하지 않거나 만료되었습니다."));
                    }
                    return Mono.error(e);
                });
    }
    
    // PUUID로 최근 매치 정보 조회
    public Mono<String> getRecentMatches(String puuid) {
        return webClient.get()
                .uri("/lol/match/v5/matches/by-puuid/{puuid}/ids?start=0&count=5", puuid)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, e -> {
                    if (e.getStatusCode().value() == 403) {
                        return Mono.error(new RuntimeException("API 키가 유효하지 않거나 만료되었습니다."));
                    }
                    return Mono.error(e);
                });
    }
} 