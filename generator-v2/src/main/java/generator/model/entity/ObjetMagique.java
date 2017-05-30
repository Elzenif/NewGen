package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiques")
public class ObjetMagique extends DDRandomPuissanceEntity {

  private String categorie;

  public String getCategorie() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  @Override
  public String toString() {
    return "ObjectMagique{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", puissance='" + puissance + '\'' +
        ", categorie='" + categorie + '\'' +
        '}';
  }
}
