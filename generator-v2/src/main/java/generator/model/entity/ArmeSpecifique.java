package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmesspecifiques")
public class ArmeSpecifique extends DDRandomPuissanceEntity {

  private String arme;
  private String prix;

  public String getArme() {
    return arme;
  }

  public void setArme(String arme) {
    this.arme = arme;
  }

  public String getPrix() {
    return prix;
  }

  public void setPrix(String prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "ArmeSpecifique{" +
            "prcMin=" + prcMin +
            ", puissance='" + puissance + '\'' +
            ", prcMax=" + prcMax +
            ", arme='" + arme + '\'' +
            ", id=" + id +
            ", prix='" + prix + '\'' +
            '}';
  }
}
