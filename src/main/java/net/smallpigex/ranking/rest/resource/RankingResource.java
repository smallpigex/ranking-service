package net.smallpigex.ranking.rest.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.smallpigex.ranking.domain.Ranking;
import net.smallpigex.ranking.summary.UserSummary;

public class RankingResource {

  @JsonProperty(value = "data")
  private List<UserResource> userResources = new ArrayList<>();
  private Date startDate;
  private Date endDate;


  public RankingResource(Ranking ranking) {
    List<UserSummary> users = ranking.getUserSummaries();
    for (UserSummary summary : users) {
      UserResource userResource = new UserResource();
      userResource.setTotalAmount(summary.getTotalAmount().toString());
      userResource.setAccount(summary.getBrandAccount());
      userResources.add(userResource);
    }
    startDate = ranking.getStartDate();
    endDate = ranking.getEndDate();
  }

  public RankingResource() {}


  public static RankingResource manageRankingBuilder(Ranking ranking) {
    RankingResource rankingResource = new RankingResource();
    List<UserSummary> users = ranking.getUserSummaries();
    for (UserSummary summary : users) {
      UserResource userResource = new UserResource();
      userResource.setId(summary.getId());
      userResource.setTotalAmount(summary.getTotalAmount().toString());
      userResource.setAccount(summary.getBrandAccount());
      rankingResource.userResources.add(userResource);
    }
    rankingResource.setEndDate(ranking.getStartDate());
    rankingResource.setEndDate(ranking.getEndDate());
    return rankingResource;
  }

  public List<UserResource> getUserResources() {
    return userResources;
  }

  public void setUserResources(
      List<UserResource> userResources) {
    this.userResources = userResources;
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
