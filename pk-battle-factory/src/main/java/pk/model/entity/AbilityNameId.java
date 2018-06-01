package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AbilityNameId implements Serializable {

  private Integer abilityId;
  private Integer localLanguageId;

  public AbilityNameId() {
  }

  public Integer getAbilityId() {
    return abilityId;
  }

  public void setAbilityId(Integer abilityId) {
    this.abilityId = abilityId;
  }

  public Integer getLocalLanguageId() {
    return localLanguageId;
  }

  public void setLocalLanguageId(Integer localLanguageId) {
    this.localLanguageId = localLanguageId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbilityNameId that = (AbilityNameId) o;

    if (abilityId != null ? !abilityId.equals(that.abilityId) : that.abilityId != null) return false;
    return localLanguageId != null ? localLanguageId.equals(that.localLanguageId) : that.localLanguageId == null;
  }

  @Override
  public int hashCode() {
    int result = abilityId != null ? abilityId.hashCode() : 0;
    result = 31 * result + (localLanguageId != null ? localLanguageId.hashCode() : 0);
    return result;
  }
}

