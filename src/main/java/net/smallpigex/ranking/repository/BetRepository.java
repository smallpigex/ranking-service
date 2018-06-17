package net.smallpigex.ranking.repository;

import java.util.List;
import java.util.Optional;
import net.smallpigex.ranking.summary.UserSummary;
import net.smallpigex.ranking.domain.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

  @Query("select new net.smallpigex.ranking.summary.UserSummary("
      + "u.id, sum(Bet.amount)) "
      + "from User as u "
      + "join u.bet Bet group by u")
  List<UserSummary> findUserSummary();
}
