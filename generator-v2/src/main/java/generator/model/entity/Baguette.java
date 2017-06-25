package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesbaguettes")
public class Baguette extends DDRandomPuissanceEntity {

  private String baguette;
  private Integer prix;

  public String getBaguette() {
    return baguette;
  }

  public void setBaguette(String baguette) {
    this.baguette = baguette;
  }

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "Baguette{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", baguette='" + baguette + '\'' +
        ", id=" + id +
        ", prix=" + prix +
        '}';
  }
}
