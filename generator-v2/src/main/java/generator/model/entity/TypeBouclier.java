package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquestypesboucliers")
public class TypeBouclier extends TypeObjet {

  @Override
  public String toString() {
    return "TypeBouclier{" +
            "type='" + type + '\'' +
            ", prcMin=" + prcMin +
            ", prcMax=" + prcMax +
            ", id=" + id +
            '}';
  }
}
