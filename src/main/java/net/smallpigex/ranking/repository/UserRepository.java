package net.smallpigex.ranking.repository;

import net.smallpigex.ranking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findById(long id);
}
