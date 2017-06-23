package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmuresproprietesspeciales")
public class ProprieteSpecialeArmure extends ProprieteSpecialePrix {

  @Override
  public String toString() {
    return "ProprieteSpecialeArmure{" +
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
