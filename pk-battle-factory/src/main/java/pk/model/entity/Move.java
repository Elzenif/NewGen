package pk.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "moves")
public class Move {

  @Id
  private String id;
  @OneToMany(mappedBy = "move")
  private List<MoveName> moveNames;
  @ManyToMany(mappedBy = "moves")
  private List<PokemonFactory> pokemonFactoryList;

  public Move() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<MoveName> getMoveNames() {
    return moveNames;
  }

  public void setMoveNames(List<MoveName> moveNames) {
    this.moveNames = moveNames;
  }

  public List<PokemonFactory> getPokemonFactoryList() {
    return pokemonFactoryList;
  }

  public void setPokemonFactoryList(List<PokemonFactory> pokemonFactoryList) {
    this.pokemonFactoryList = pokemonFactoryList;
  }

  @Override
  public String toString() {
    return "Move{" +
            "id='" + id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Move move = (Move) o;

    return id != null ? id.equals(move.id) : move.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
