package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquespotionshuiles")
public class PotionEtHuile extends DDRandomPuissanceEntity {

  private String potion;
  private Integer prix;

  public String getPotion() {
    return potion;
  }

  public void setPotion(String potion) {
    this.potion = potion;
  }

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "PotionEtHuile{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", potion='" + potion + '\'' +
        ", prix=" + prix +
        '}';
  }
}
