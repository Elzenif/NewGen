package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 03/07/2017.
 */
@Embeddable
public class StatNameId implements Serializable {

  private Integer statId;
  private Integer localLanguageId;

  public StatNameId() {
  }

  public Integer getStatId() {
    return statId;
  }

  public void setStatId(Integer statId) {
    this.statId = statId;
  }

  public Integer getLocalLanguageId() {
    return localLanguageId;
  }

  public void setLocalLanguageId(Integer localLanguageId) {
    this.localLanguageId = localLanguageId;
  }

  @Override
  public String toString() {
    return "StatNameId{" +
        "statId=" + statId +
        ", localLanguageId=" + localLanguageId +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    StatNameId that = (StatNameId) o;

    if (statId != null ? !statId.equals(that.statId) : that.statId != null) return false;
    return localLanguageId != null ? localLanguageId.equals(that.localLanguageId) : that.localLanguageId == null;
  }

  @Override
  public int hashCode() {
    int result = statId != null ? statId.hashCode() : 0;
    result = 31 * result + (localLanguageId != null ? localLanguageId.hashCode() : 0);
    return result;
  }
}

