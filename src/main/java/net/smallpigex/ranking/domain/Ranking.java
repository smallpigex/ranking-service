package net.smallpigex.ranking.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import net.smallpigex.ranking.summary.UserSummary;

@Entity
public class Ranking extends EntityBase<Ranking> {

  @ElementCollection
  @CollectionTable(
      name="user_summary",
      joinColumns=@JoinColumn(name="owner_id")
  )
  private List<UserSummary> userSummaries;
  private Date startDate;
  private Date endDate;

  public List<UserSummary> getUserSummaries() {
    return userSummaries;
  }

  public void setUserSummaries(List<UserSummary> userSummaries) {
    this.userSummaries = userSummaries;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}
