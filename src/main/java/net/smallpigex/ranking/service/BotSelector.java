package net.smallpigex.ranking.service;

import java.util.List;
import net.smallpigex.ranking.domain.Bot;

public interface BotSelector {

  List<Bot> selectBots();
}
