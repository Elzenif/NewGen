package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesbatons")
public class Baton extends DDRandomPuissanceEntity {

  private String baton;
  private Integer prix;

  public String getBaton() {
    return baton;
  }

  public void setBaton(String baton) {
    this.baton = baton;
  }

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "Baton{" +
        "baton='" + baton + '\'' +
        ", prix=" + prix +
        ", prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", id=" + id +
        '}';
  }
}
