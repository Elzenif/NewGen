package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmescorpsacorpsproprietesspeciales")
public class ProprieteSpecialeArmeCac extends ProprieteSpeciale {

  @Override
  public String toString() {
    return "ProprieteSpecialeArmeCac{" +
            "prcMin=" + prcMin +
            ", puissance='" + puissance + '\'' +
            ", nom='" + nom + '\'' +
            ", prcMax=" + prcMax +
            ", modificateur=" + modificateur +
            ", id=" + id +
            '}';
  }
}
