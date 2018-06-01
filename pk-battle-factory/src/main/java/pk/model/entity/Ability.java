package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "abilities")
public class Ability {

  @Id
  private Integer id;
  private String identifier;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "generation_id", referencedColumnName = "id")
  private Generation generation;
  private Boolean isMainSeries;
  @OneToMany(mappedBy = "ability")
  private List<AbilityName> abilityNames;
  @OneToMany(mappedBy = "ability")
  private List<PokemonAbility> pokemonAbilities;

  public Ability() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Generation getGeneration() {
    return generation;
  }

  public void setGeneration(Generation generation) {
    this.generation = generation;
  }

  public Boolean getMainSeries() {
    return isMainSeries;
  }

  public void setMainSeries(Boolean mainSeries) {
    isMainSeries = mainSeries;
  }

  public List<AbilityName> getAbilityNames() {
    return abilityNames;
  }

  public void setAbilityNames(List<AbilityName> abilityNames) {
    this.abilityNames = abilityNames;
  }

  public List<PokemonAbility> getPokemonAbilities() {
    return pokemonAbilities;
  }

  public void setPokemonAbilities(List<PokemonAbility> pokemonAbilities) {
    this.pokemonAbilities = pokemonAbilities;
  }

  @Override
  public String toString() {
    return "Ability{" +
        "id=" + id +
        ", identifier='" + identifier + '\'' +
        ", generation=" + generation.getId() +
        ", isMainSeries=" + isMainSeries +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Ability ability = (Ability) o;

    return id != null ? id.equals(ability.id) : ability.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}