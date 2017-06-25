package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquestypesarmes")
public class TypeArme extends TypeObjet {

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
