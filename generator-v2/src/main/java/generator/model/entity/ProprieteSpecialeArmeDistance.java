package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmesdistanceproprietesspeciales")
public class ProprieteSpecialeArmeDistance extends ProprieteSpeciale {

  @Override
  public String toString() {
    return "ProprieteSpecialeArmeDistance{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", nom='" + nom + '\'' +
        ", prcMax=" + prcMax +
        ", modificateur=" + modificateur +
        ", id=" + id +
        '}';
  }
}
