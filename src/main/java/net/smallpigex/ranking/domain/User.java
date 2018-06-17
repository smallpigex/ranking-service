package net.smallpigex.ranking.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class User extends EntityBase<User> {
  @Column(name = "brand_account_id")
  private int brandAccountId;

  @Column(name = "brand_id")
  private int brandId;

  @OneToMany(cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      mappedBy = "user")
  private Set<Bet> bet;

  public int getBrandAccountId() {
    return brandAccountId;
  }

  public void setBrandAccountId(int brandAccountId) {
    this.brandAccountId = brandAccountId;
  }

  public int getBrandId() {
    return brandId;
  }

  public void setBrandId(int brandId) {
    this.brandId = brandId;
  }

  public Set<Bet> getBet() {
    return bet;
  }

  public void setBet(Set<Bet> bet) {
    this.bet = bet;
  }
}
