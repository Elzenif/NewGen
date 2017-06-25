package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquestypesboucliers")
public class TypeBouclier extends TypeObjetPrix {

  @Override
  public String toString() {
    return "TypeBouclier{" +
        "prix=" + prix +
        ", type='" + type + '\'' +
        ", prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        '}';
  }
}
