package net.smallpigex.ranking.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntityBase<T extends EntityBase<T>> {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  /**Returns the identity of this entity object.*/
  public Long getId(){return id;}

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, updatable = false)
  @CreatedDate
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false)
  @LastModifiedDate
  private Date updatedAt;

  /**
   * Entities compare by identity, not by attributes.
   *
   * @param that The other entity of the same type
   * @return true if the identities are the same, regardless of the other attributes.
   * @throws IllegalStateException one of the entities does not have the identity attribute set.
   */
  public boolean sameIdentityAs(final T that){
    return this.equals(that);
  }

  @Override
  public boolean equals(final Object object) {
    if (!(object instanceof EntityBase)) {
      return false;
    }
    final EntityBase<?> that = (EntityBase<?>) object;
    _checkIdentity(this);
    _checkIdentity(that);
    return this.id.equals(that.getId());
  }

  /**
   * Checks the passed entity, if it has an identity. It gets an identity only by saving.
   * @throws IllegalStateException the passed entity does not have the identity attribute set.
   */
  private void _checkIdentity(final EntityBase<?> entity) {
    if(entity.getId()==null){
      throw new IllegalStateException("Identity missing in entity: " + entity);
    }
  }

  @Override
  public int hashCode() {
    return getId() != null ? getId().hashCode() : 0;
  }
}
