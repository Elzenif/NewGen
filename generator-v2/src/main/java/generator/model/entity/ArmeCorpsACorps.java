package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmescorpsacorps")
public class ArmeCorpsACorps extends Arme {

  @Override
  public String toString() {
    return "ArmesCorpsACorps{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", arme='" + arme + '\'' +
        ", id=" + id +
        ", prix=" + prix +
        '}';
  }
}
