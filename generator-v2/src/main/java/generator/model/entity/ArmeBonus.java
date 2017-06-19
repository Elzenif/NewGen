package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmes")
public class ArmeBonus extends DDRandomPuissanceEntity {

  private String bonus;
  private Integer prixBase;

  public String getBonus() {
    return bonus;
  }

  public void setBonus(String bonus) {
    this.bonus = bonus;
  }

  public Integer getPrixBase() {
    return prixBase;
  }

  public void setPrixBase(Integer prixBase) {
    this.prixBase = prixBase;
  }

  @Override
  public String toString() {
    return "ArmeBonus{" +
            "prcMin=" + prcMin +
            ", puissance='" + puissance + '\'' +
            ", prcMax=" + prcMax +
            ", bonus='" + bonus + '\'' +
            ", id=" + id +
            ", prixBase=" + prixBase +
            '}';
  }
}
