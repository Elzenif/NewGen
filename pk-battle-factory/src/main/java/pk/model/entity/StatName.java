package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 03/07/2017.
 */
@Entity
@Table(name = "stat_names")
public class StatName {
  
  @EmbeddedId
  private StatNameId id;
  @MapsId("statId")
  @JoinColumn(name = "stat_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Stat stat;
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;

  public StatName() {
  }

  public StatNameId getId() {
    return id;
  }

  public void setId(StatNameId id) {
    this.id = id;
  }

  public Stat getStat() {
    return stat;
  }

  public void setStat(Stat stat) {
    this.stat = stat;
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
    return "StatName{" +
        "id=" + id +
        ", stat=" + stat.getId() +
        ", language=" + language.getId() +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    StatName statName = (StatName) o;

    return id != null ? id.equals(statName.id) : statName.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}