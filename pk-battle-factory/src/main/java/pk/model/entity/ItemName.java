package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 02/07/2017.
 */
@Entity
@Table(name = "item_names")
public class ItemName {

  @EmbeddedId
  private ItemNameId id;
  @MapsId("itemId")
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item item;
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;

  public ItemName() {
  }

  public ItemNameId getId() {
    return id;
  }

  public void setId(ItemNameId id) {
    this.id = id;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ItemName{" +
        "id=" + id +
        ", item=" + item.getId() +
        ", language=" + language.getId() +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ItemName itemName = (ItemName) o;

    return id != null ? id.equals(itemName.id) : itemName.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}