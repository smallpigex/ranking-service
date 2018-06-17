package net.smallpigex.ranking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Brand extends EntityBase<Brand> {

  @Column(name = "brand_name")
  private String brandName;

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }
}
