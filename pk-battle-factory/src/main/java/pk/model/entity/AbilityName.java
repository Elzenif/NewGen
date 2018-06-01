package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "ability_names")
public class AbilityName {

  @EmbeddedId
  private AbilityNameId id;
  @MapsId("abilityId")
  @JoinColumn(name = "ability_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Ability ability;
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;

  public AbilityName() {
  }

  public AbilityNameId getId() {
    return id;
  }

  public void setId(AbilityNameId id) {
    this.id = id;
  }

  public Ability getAbility() {
    return ability;
  }

  public void setAbility(Ability ability) {
    this.ability = ability;
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
    return "AbilityName{" +
        "id=" + id +
        ", ability=" + ability.getId() +
        ", language=" + language.getId() +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbilityName that = (AbilityName) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}