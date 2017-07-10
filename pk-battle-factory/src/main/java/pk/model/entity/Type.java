package pk.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Germain on 10/07/2017.
 */
@Entity
@Table(name = "types")
public class Type {

  @Id
  private Integer id;
  @OneToMany(mappedBy = "type")
  private List<TypeName> typeNames;

  public Type() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<TypeName> getTypeNames() {
    return typeNames;
  }

  public void setTypeNames(List<TypeName> typeNames) {
    this.typeNames = typeNames;
  }

  @Override
  public String toString() {
    return "Type{" +
        "id=" + id +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Type type = (Type) o;

    return id != null ? id.equals(type.id) : type.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}