package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesmerveilleux")
public class Merveilleux extends DDRandomPuissanceEntity {

  private String objet;
  private Integer prix;

  public String getObjet() {
    return objet;
  }

  public void setObjet(String objet) {
    this.objet = objet;
  }

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "Merveilleux{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", objet='" + objet + '\'' +
        ", prix=" + prix +
        '}';
  }
}
