package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 10/07/2017.
 */
@Embeddable
public class TypeNameId implements Serializable {

  private Integer typeId;
  private Integer localLanguageId;

  public TypeNameId() {
  }

  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
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

    TypeNameId that = (TypeNameId) o;

    if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
    return localLanguageId != null ? localLanguageId.equals(that.localLanguageId) : that.localLanguageId == null;
  }

  @Override
  public int hashCode() {
    int result = typeId != null ? typeId.hashCode() : 0;
    result = 31 * result + (localLanguageId != null ? localLanguageId.hashCode() : 0);
    return result;
  }
}

