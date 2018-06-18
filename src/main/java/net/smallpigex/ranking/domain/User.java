package net.smallpigex.ranking.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class User extends EntityBase<User> {
  @Column(name = "brand_account_id")
  private int brandAccountId;

  @Column(name = "brand_id")
  private long brandId;

  @OneToMany(cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      mappedBy = "user")
  private List<Bet> bets;

  @Transient
  private BigDecimal totalAmount = new BigDecimal(0);

  public int getBrandAccountId() {
    return brandAccountId;
  }

  public void setBrandAccountId(int brandAccountId) {
    this.brandAccountId = brandAccountId;
  }

  public long getBrandId() {
    return brandId;
  }

  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }

  public List<Bet> getBets() {
    return bets;
  }

  public void setBets(List<Bet> bets) {
    this.bets = bets;
  }

  public void addBet(Bet bet) {
    bets.add(bet);
  }

  public BigDecimal getTotalAmount() {
    calcTotalAmount();
    return totalAmount;
  }

  private void calcTotalAmount() {
    for (Bet bet : bets) {
      totalAmount = totalAmount.add(bet.getAmount());
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    User user = (User) o;
    return brandAccountId == user.brandAccountId &&
        brandId == user.brandId;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), brandAccountId, brandId);
  }
}
