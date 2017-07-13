package pk.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Germain on 13/07/2017.
 */
@Embeddable
public class ItemGameIndexId implements Serializable {

  private Integer itemId;
  private Integer generationId;

  public ItemGameIndexId() {
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Integer getGenerationId() {
    return generationId;
  }

  public void setGenerationId(Integer generationId) {
    this.generationId = generationId;
  }

  @Override
  public String toString() {
    return "ItemGameIndexId{" +
        "itemId=" + itemId +
        ", generationId=" + generationId +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ItemGameIndexId that = (ItemGameIndexId) o;

    if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
    return generationId != null ? generationId.equals(that.generationId) : that.generationId == null;
  }

  @Override
  public int hashCode() {
    int result = itemId != null ? itemId.hashCode() : 0;
    result = 31 * result + (generationId != null ? generationId.hashCode() : 0);
    return result;
  }
}

