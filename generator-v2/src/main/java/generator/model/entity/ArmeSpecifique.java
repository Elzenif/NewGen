package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmesspecifiques")
public class ArmeSpecifique extends ObjetSpecifique implements IArme {

  private boolean cac;
  private boolean munition;
  private boolean tranchant;
  private boolean perforant;
  private boolean contondant;

  @Override
  public boolean isCac() {
    return cac;
  }

  public void setCac(boolean cac) {
    this.cac = cac;
  }

  @Override
  public boolean isMunition() {
    return munition;
  }

  public void setMunition(boolean munition) {
    this.munition = munition;
  }

  public boolean isTranchant() {
    return tranchant;
  }

  public void setTranchant(boolean tranchant) {
    this.tranchant = tranchant;
  }

  public boolean isPerforant() {
    return perforant;
  }

  public void setPerforant(boolean perforant) {
    this.perforant = perforant;
  }

  public boolean isContondant() {
    return contondant;
  }

  public void setContondant(boolean contondant) {
    this.contondant = contondant;
  }

  @Override
  public String toString() {
    return "ArmeSpecifique{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", arme='" + arme + '\'' +
        ", prcMax=" + prcMax +
        ", prix=" + prix +
        ", id=" + id +
        ", cac=" + cac +
        ", munition=" + munition +
        ", tranchant=" + tranchant +
        ", perforant=" + perforant +
        ", contondant=" + contondant +
        '}';
  }
}
