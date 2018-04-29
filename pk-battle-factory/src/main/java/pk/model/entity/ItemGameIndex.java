package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 13/07/2017.
 */
@Entity
@Table(name = "item_game_indices")
public class ItemGameIndex {

  @EmbeddedId
  private ItemGameIndexId id;
  @MapsId("itemId")
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item item;
  @MapsId("generationId")
  @JoinColumn(name = "generation_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Generation generation;

  public ItemGameIndex() {
  }

  public ItemGameIndexId getId() {
    return id;
  }

  public void setId(ItemGameIndexId id) {
    this.id = id;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Generation getGeneration() {
    return generation;
  }

  public void setGeneration(Generation generation) {
    this.generation = generation;
  }

  @Override
  public String toString() {
    return "ItemGameIndex{" +
        "id=" + id +
        ", item=" + item.getId() +
        ", generation=" + generation.getId() +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ItemGameIndex that = (ItemGameIndex) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}