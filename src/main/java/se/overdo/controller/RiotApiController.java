package se.overdo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import se.overdo.service.RiotApiService;

@RestController
@RequestMapping("/api/riot")
public class RiotApiController {
    
    private final RiotApiService riotApiService;
    
    public RiotApiController(RiotApiService riotApiService) {
        this.riotApiService = riotApiService;
    }
    
    @GetMapping("/account/{gameName}/{tagLine}")
    public Mono<String> getAccountByRiotId(@PathVariable String gameName, @PathVariable String tagLine) {
        return riotApiService.getAccountByRiotId(gameName, tagLine);
    }
    
    @GetMapping("/summoner/{puuid}")
    public Mono<String> getSummonerByPuuid(@PathVariable String puuid) {
        return riotApiService.getSummonerByPuuid(puuid);
    }
    
    @GetMapping("/league/{summonerId}")
    public Mono<String> getLeagueEntries(@PathVariable String summonerId) {
        return riotApiService.getLeagueEntries(summonerId);
    }
    
    @GetMapping("/matches/{puuid}")
    public Mono<String> getRecentMatches(@PathVariable String puuid) {
        return riotApiService.getRecentMatches(puuid);
    }
} 