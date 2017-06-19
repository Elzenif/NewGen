package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquestypesarmes")
public class TypeArme extends DDRandomEntity {

  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "TypeArme{" +
            "prcMin=" + prcMin +
            ", prcMax=" + prcMax +
            ", type='" + type + '\'' +
            ", id=" + id +
            '}';
  }
}
