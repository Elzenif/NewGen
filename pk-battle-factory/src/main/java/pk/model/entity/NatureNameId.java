package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 02/07/2017.
 */
@Embeddable
public class NatureNameId implements Serializable {

  private Integer natureId;
  private Integer localLanguageId;

  public NatureNameId() {
  }

  public Integer getNatureId() {
    return natureId;
  }

  public void setNatureId(Integer natureId) {
    this.natureId = natureId;
  }

  public Integer getLocalLanguageId() {
    return localLanguageId;
  }

  public void setLocalLanguageId(Integer localLanguageId) {
    this.localLanguageId = localLanguageId;
  }

  @Override
  public String toString() {
    return "NatureNameId{" +
        "natureId=" + natureId +
        ", localLanguageId=" + localLanguageId +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NatureNameId that = (NatureNameId) o;

    if (natureId != null ? !natureId.equals(that.natureId) : that.natureId != null) return false;
    return localLanguageId != null ? localLanguageId.equals(that.localLanguageId) : that.localLanguageId == null;
  }

  @Override
  public int hashCode() {
    int result = natureId != null ? natureId.hashCode() : 0;
    result = 31 * result + (localLanguageId != null ? localLanguageId.hashCode() : 0);
    return result;
  }
}

