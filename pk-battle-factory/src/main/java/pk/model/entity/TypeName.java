package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Created by Germain on 10/07/2017.
 */
@Entity
@Table(name = "type_names")
public class TypeName {

  @EmbeddedId
  private TypeNameId id;
  @MapsId("typeId")
  @JoinColumn(name = "type_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Type type;
  @MapsId("localLanguageId")
  @JoinColumn(name = "local_language_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Language language;
  private String name;

  public TypeName() {
  }

  public TypeNameId getId() {
    return id;
  }

  public void setId(TypeNameId id) {
    this.id = id;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
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
    return "TypeName{" +
        "id=" + id +
        ", type=" + type.getId() +
        ", language=" + language.getId() +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TypeName typeName = (TypeName) o;

    return id != null ? id.equals(typeName.id) : typeName.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}