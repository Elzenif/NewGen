package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesboucliersproprietesspeciales")
public class ProprieteSpecialeBouclier extends ProprieteSpecialePrix {

  @Override
  public String toString() {
    return "ProprieteSpecialeBouclier{" +
            "prcMin=" + prcMin +
            ", puissance='" + puissance + '\'' +
            ", modificateurPrix=" + modificateurPrix +
            ", nom='" + nom + '\'' +
            ", prcMax=" + prcMax +
            ", modificateur=" + modificateur +
            ", id=" + id +
            '}';
  }
}
