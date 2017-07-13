package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Germain on 02/07/2017.
 */
@Entity
@Table(name = "items")
public class Item {

  @Id
  private Integer id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private ItemCategory itemCategory;
  @OneToMany(mappedBy = "item")
  private List<ItemName> itemNames;
  @OneToMany(mappedBy = "item")
  private List<ItemGameIndex> itemGameIndices;

  public Item() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ItemCategory getItemCategory() {
    return itemCategory;
  }

  public void setItemCategory(ItemCategory itemCategory) {
    this.itemCategory = itemCategory;
  }

  public List<ItemName> getItemNames() {
    return itemNames;
  }

  public void setItemNames(List<ItemName> itemNames) {
    this.itemNames = itemNames;
  }

  public List<ItemGameIndex> getItemGameIndices() {
    return itemGameIndices;
  }

  public void setItemGameIndices(List<ItemGameIndex> itemGameIndices) {
    this.itemGameIndices = itemGameIndices;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", itemCategory=" + itemCategory.getId() +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Item item = (Item) o;

    return id != null ? id.equals(item.id) : item.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}