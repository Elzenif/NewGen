package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquestypesarmures")
public class TypeArmure extends TypeObjet {

  @Override
  public String toString() {
    return "TypeArmure{" +
            "type='" + type + '\'' +
            ", prcMin=" + prcMin +
            ", prcMax=" + prcMax +
            ", id=" + id +
            '}';
  }
}
