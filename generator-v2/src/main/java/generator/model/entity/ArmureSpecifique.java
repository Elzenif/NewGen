package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmuresspecifiques")
public class ArmureSpecifique extends ObjetSpecifique {

  @Override
  public String toString() {
    return "ArmureSpecifique{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", arme='" + arme + '\'' +
        ", prcMax=" + prcMax +
        ", prix='" + prix + '\'' +
        ", id=" + id +
        '}';
  }
}
