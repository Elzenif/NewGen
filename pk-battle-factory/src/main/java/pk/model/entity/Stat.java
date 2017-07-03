package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Germain on 03/07/2017.
 */
@Entity
@Table(name = "stats")
public class Stat {

  @Id
  private Integer id;
  @OneToMany(mappedBy = "stat")
  private List<StatName> statNames;

  public Stat() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<StatName> getStatNames() {
    return statNames;
  }

  public void setStatNames(List<StatName> statNames) {
    this.statNames = statNames;
  }

  @Override
  public String toString() {
    return "Stat{" +
        "id=" + id +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Stat stat = (Stat) o;

    return id != null ? id.equals(stat.id) : stat.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}