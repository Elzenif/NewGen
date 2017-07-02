package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
  @OneToMany(mappedBy = "item")
  private List<ItemName> itemNames;

  public Item() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<ItemName> getItemNames() {
    return itemNames;
  }

  public void setItemNames(List<ItemName> itemNames) {
    this.itemNames = itemNames;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
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