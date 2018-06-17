package net.smallpigex.ranking.repository;

import java.util.Optional;
import net.smallpigex.ranking.domain.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RankingRepository extends JpaRepository<Ranking, Long> {

  @Query("select  new net.smallpigex.ranking.summary.UserSummary( "
      + "u.id, sum(Bet.amount) as totalAmount) "
      + "from User as u "
      + "join u.bet Bet group by u")
  Optional<Ranking> findRanking();
}
