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
@Table(name = "natures")
public class Nature {

  @Id
  private Integer id;
  @OneToMany(mappedBy = "nature")
  private List<NatureName> natureNames;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "decreased_stat_id", referencedColumnName = "id")
  private Stat decreasedStat;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "increased_stat_id", referencedColumnName = "id")
  private Stat increasedStat;

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

  public Stat getDecreasedStat() {
    return decreasedStat;
  }

  public void setDecreasedStat(Stat decreasedStat) {
    this.decreasedStat = decreasedStat;
  }

  public Stat getIncreasedStat() {
    return increasedStat;
  }

  public void setIncreasedStat(Stat increasedStat) {
    this.increasedStat = increasedStat;
  }

  @Override
  public String toString() {
    return "Nature{" +
        "id=" + id +
        ", decreasedStat=" + decreasedStat.getId() +
        ", increasedStat=" + increasedStat.getId() +
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