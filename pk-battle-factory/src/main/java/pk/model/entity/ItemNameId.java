package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 02/07/2017.
 */
@Embeddable
public class ItemNameId implements Serializable {

  private Integer itemId;
  private Integer localLanguageId;

  public ItemNameId() {
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Integer getLocalLanguageId() {
    return localLanguageId;
  }

  public void setLocalLanguageId(Integer localLanguageId) {
    this.localLanguageId = localLanguageId;
  }

  @Override
  public String toString() {
    return "ItemNameId{" +
        "itemId=" + itemId +
        ", localLanguageId=" + localLanguageId +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ItemNameId that = (ItemNameId) o;

    if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
    return localLanguageId != null ? localLanguageId.equals(that.localLanguageId) : that.localLanguageId == null;
  }

  @Override
  public int hashCode() {
    int result = itemId != null ? itemId.hashCode() : 0;
    result = 31 * result + (localLanguageId != null ? localLanguageId.hashCode() : 0);
    return result;
  }
}

