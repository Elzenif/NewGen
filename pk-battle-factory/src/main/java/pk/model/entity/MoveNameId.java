package pk.model.entity;

import javax.persistence.Embeddable;

@Embeddable
public class MoveNameId {

  private Integer moveId;
  private Integer localLanguageId;

  public Integer getMoveId() {
    return moveId;
  }

  public void setMoveId(Integer moveId) {
    this.moveId = moveId;
  }

  public Integer getLocalLanguageId() {
    return localLanguageId;
  }

  public void setLocalLanguageId(Integer localLanguageId) {
    this.localLanguageId = localLanguageId;
  }

  @Override
  public String toString() {
    return "MoveNameId{" +
            "moveId=" + moveId +
            ", localLanguageId=" + localLanguageId +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MoveNameId that = (MoveNameId) o;

    if (moveId != null ? !moveId.equals(that.moveId) : that.moveId != null) return false;
    return localLanguageId != null ? localLanguageId.equals(that.localLanguageId) : that.localLanguageId == null;
  }

  @Override
  public int hashCode() {
    int result = moveId != null ? moveId.hashCode() : 0;
    result = 31 * result + (localLanguageId != null ? localLanguageId.hashCode() : 0);
    return result;
  }
}
