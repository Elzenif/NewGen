package pk.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "move_names")
public class MoveName {

  @EmbeddedId
  private MoveNameId id;
  @MapsId("moveId")
  @JoinColumn(name = "move_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Move move;
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;

  public MoveName() {
  }

  public MoveNameId getId() {
    return id;
  }

  public void setId(MoveNameId id) {
    this.id = id;
  }

  public Move getMove() {
    return move;
  }

  public void setMove(Move move) {
    this.move = move;
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
    return "MoveName{" +
            "id=" + id +
            ", move=" + move.getId() +
            ", language=" + language.getId() +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MoveName moveName = (MoveName) o;

    return id != null ? id.equals(moveName.id) : moveName.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
