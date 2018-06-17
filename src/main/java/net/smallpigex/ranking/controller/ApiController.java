package net.smallpigex.ranking.controller;

import java.math.BigDecimal;
import net.smallpigex.ranking.domain.Bet;
import net.smallpigex.ranking.domain.Ranking;
import net.smallpigex.ranking.domain.User;
import net.smallpigex.ranking.repository.BetRepository;
import net.smallpigex.ranking.repository.UserRepository;
import net.smallpigex.ranking.rest.resource.RankingResource;
import net.smallpigex.ranking.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  @Autowired
  BetRepository betRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RankingService rankingService;

  @GetMapping(value = "addData")
  public ResponseEntity<String> addData() {

    User alice = new User();
    alice.setBrandAccountId(1);
    alice.setBrandId(1);

    Bet bet1 = new Bet();
    bet1.setAmount(BigDecimal.TEN);
    bet1.setUser(alice);

    Bet bet2 = new Bet();
    bet2.setAmount(BigDecimal.TEN);
    bet2.setUser(alice);

    userRepository.save(alice);
    betRepository.save(bet1);
    betRepository.save(bet2);

    User bob = new User();
    bob.setBrandAccountId(1);
    bob.setBrandId(1);

    Bet bobBet1 = new Bet();
    bobBet1.setAmount(BigDecimal.TEN);
    bobBet1.setUser(bob);

    Bet bobBet2 = new Bet();
    bobBet2.setAmount(BigDecimal.valueOf(100));
    bobBet2.setUser(bob);

    userRepository.save(bob);
    betRepository.save(bobBet1);
    betRepository.save(bobBet2);



    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(value = "ranking")
  public ResponseEntity<RankingResource> getRanking(@RequestParam("timeInterval") String timeInterval) {

    if("month".equalsIgnoreCase(timeInterval)) {
    } else {
    }
    Ranking ranking = rankingService.getRanking(timeInterval);
    RankingResource rankingResource = new RankingResource(ranking);
    return new ResponseEntity<>(rankingResource, HttpStatus.OK);
  }
}
