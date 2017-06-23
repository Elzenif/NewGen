package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesboucliersspecifiques")
public class BouclierSpecifique extends ObjetSpecifique {

  @Override
  public String toString() {
    return "BouclierSpecifique{" +
            "prcMin=" + prcMin +
            ", puissance='" + puissance + '\'' +
            ", arme='" + arme + '\'' +
            ", prcMax=" + prcMax +
            ", prix='" + prix + '\'' +
            ", id=" + id +
            '}';
  }
}
