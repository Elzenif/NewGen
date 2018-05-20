package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TypeEfficacyId implements Serializable {

  private Integer damageTypeId;
  private Integer targetTypeId;

  public TypeEfficacyId() {
  }

  public Integer getDamageTypeId() {
    return damageTypeId;
  }

  public void setDamageTypeId(Integer damageTypeId) {
    this.damageTypeId = damageTypeId;
  }

  public Integer getTargetTypeId() {
    return targetTypeId;
  }

  public void setTargetTypeId(Integer targetTypeId) {
    this.targetTypeId = targetTypeId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TypeEfficacyId that = (TypeEfficacyId) o;

    if (damageTypeId != null ? !damageTypeId.equals(that.damageTypeId) : that.damageTypeId != null) return false;
    return targetTypeId != null ? targetTypeId.equals(that.targetTypeId) : that.targetTypeId == null;
  }

  @Override
  public int hashCode() {
    int result = damageTypeId != null ? damageTypeId.hashCode() : 0;
    result = 31 * result + (targetTypeId != null ? targetTypeId.hashCode() : 0);
    return result;
  }
}

