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
@Table(name = "natures")
public class Nature {

  @Id
  private Integer id;
  @OneToMany(mappedBy = "nature")
  private List<NatureName> natureNames;

  public Nature() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<NatureName> getNatureNames() {
    return natureNames;
  }

  public void setNatureNames(List<NatureName> natureNames) {
    this.natureNames = natureNames;
  }

  @Override
  public String toString() {
    return "Nature{" +
        "id=" + id +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Nature nature = (Nature) o;

    return id != null ? id.equals(nature.id) : nature.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}