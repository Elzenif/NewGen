package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmures")
public class ArmureEtBouclier extends DDRandomPuissanceEntity {

  private String type;
  private Integer modificateur;
  private Integer prix;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getModificateur() {
    return modificateur;
  }

  public void setModificateur(Integer modificateur) {
    this.modificateur = modificateur;
  }

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "ArmureEtBouclier{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", type='" + type + '\'' +
        ", id=" + id +
        ", modificateur=" + modificateur +
        ", prix=" + prix +
        '}';
  }
}
