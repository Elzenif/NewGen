package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsart")
public class ObjetArt extends DDRandomEntity {

  private String valeur;
  private String exemples;

  public String getValeur() {
    return valeur;
  }

  public void setValeur(String valeur) {
    this.valeur = valeur;
  }

  public String getExemples() {
    return exemples;
  }

  public void setExemples(String exemples) {
    this.exemples = exemples;
  }

  @Override
  public String toString() {
    return "ObjetArt{" +
        "valeur='" + valeur + '\'' +
        ", exemples='" + exemples + '\'' +
        ", prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        '}';
  }
}
