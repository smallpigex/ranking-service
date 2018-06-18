package net.smallpigex.ranking.controller;

import net.smallpigex.ranking.domain.Ranking;
import net.smallpigex.ranking.rest.resource.RankingResource;
import net.smallpigex.ranking.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management")
public class RankingManagementController {

  @Autowired
  RankingService rankingService;

  @GetMapping(value = "ranking")
  public ResponseEntity<RankingResource> getRanking(
      @RequestHeader("x-client-id") String clientId,
      @RequestHeader("x-secret") String scret,
      @RequestParam("timeInterval") String timeInterval) {

    Ranking ranking = rankingService.getRanking(timeInterval);
    RankingResource rankingResource = RankingResource.manageRankingBuilder(ranking);
    return new ResponseEntity<>(rankingResource, HttpStatus.OK);
  }
}
