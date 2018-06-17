package net.smallpigex.ranking.service;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import net.smallpigex.ranking.domain.Ranking;
import net.smallpigex.ranking.repository.BetRepository;
import net.smallpigex.ranking.repository.RankingRepository;
import net.smallpigex.ranking.summary.UserSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

  @Autowired
  BetRepository betRepository;

  @Autowired
  RankingRepository rankingRepository;

  public Ranking getRanking(String timeInterval) {
    List<UserSummary> userSummaries = betRepository.findUserSummary();
    Ranking ranking = new Ranking();
    ranking.setUserSummaries(userSummaries);
    LocalDate today = LocalDate.now();

    LocalDate monday = today.with(previousOrSame(MONDAY));
    LocalDate sunday = today.with(nextOrSame(SUNDAY));
    ZoneId zone = ZoneId.systemDefault();
    ranking.setStartDate(Date.from(monday.atStartOfDay(zone).toInstant()));
    ranking.setEndDate(Date.from(sunday.atStartOfDay(zone).toInstant()));
    rankingRepository.findRanking();
    return ranking;
  }

}
