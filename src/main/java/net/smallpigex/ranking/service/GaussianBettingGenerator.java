package net.smallpigex.ranking.service;

import java.math.BigDecimal;
import java.util.List;
import net.smallpigex.ranking.domain.Bet;
import net.smallpigex.ranking.domain.Bot;

public class GaussianBettingGenerator implements BotBettingGenerator {

  List<Bet> realUserBets;
  BigDecimal topTotalAmount;

  public GaussianBettingGenerator(List<Bet> realUserBets, BigDecimal topTotalAmount) {
    this.realUserBets = realUserBets;
    this.topTotalAmount = topTotalAmount;
  }

  @Override
  public void generate(List<Bot> bots) {
    int i = 0;
    int botsSize = bots.size();
    while(bots.get(i % botsSize).getTotalAmount().compareTo(topTotalAmount) < 1) {
      // bot bet
      i++;
    }
  }
}
