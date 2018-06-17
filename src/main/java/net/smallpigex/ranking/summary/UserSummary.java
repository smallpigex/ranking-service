package net.smallpigex.ranking.summary;

import java.math.BigDecimal;
import javax.annotation.Resource;
import javax.persistence.Embeddable;

@Resource
@Embeddable
public class UserSummary {

  private long id;
  private String brandAccount;
  private String brandId;
  private BigDecimal totalAmount;

  public UserSummary(long id, BigDecimal totalAmount) {
    this.id = id;
    this.totalAmount = totalAmount;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBrandAccount() {
    return brandAccount;
  }

  public void setBrandAccount(String brandAccount) {
    this.brandAccount = brandAccount;
  }

  public String getBrandId() {
    return brandId;
  }

  public void setBrandId(String brandId) {
    this.brandId = brandId;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Override
  public String toString() {
    return "UserSummary{" +
        "id=" + id +
        ", totalAmount=" + totalAmount +
        '}';
  }
}
