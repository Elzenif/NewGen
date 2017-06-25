package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquessceptres")
public class Sceptre extends DDRandomPuissanceEntity {

  private String sceptre;
  private Integer prix;

  public String getSceptre() {
    return sceptre;
  }

  public void setSceptre(String sceptre) {
    this.sceptre = sceptre;
  }

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "Sceptre{" +
        "sceptre='" + sceptre + '\'' +
        ", prcMin=" + prcMin +
        ", prix=" + prix +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", id=" + id +
        '}';
  }
}
