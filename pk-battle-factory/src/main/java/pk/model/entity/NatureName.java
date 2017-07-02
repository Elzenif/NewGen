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
@Table(name = "nature_names")
public class NatureName {

  @EmbeddedId
  private NatureNameId id;
  @MapsId("natureId")
  @JoinColumn(name = "nature_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Nature nature;
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;

  public NatureName() {
  }

  public NatureNameId getId() {
    return id;
  }

  public void setId(NatureNameId id) {
    this.id = id;
  }

  public Nature getNature() {
    return nature;
  }

  public void setNature(Nature nature) {
    this.nature = nature;
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
    return "NatureName{" +
        "nature=" + nature.getId() +
        ", language=" + language.getId() +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NatureName that = (NatureName) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}