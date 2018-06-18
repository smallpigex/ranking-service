package net.smallpigex.ranking.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import net.smallpigex.ranking.domain.Bet;
import net.smallpigex.ranking.domain.Bot;

public interface BotBettingGenerator {

  void generate(List<Bot> bots);
}
