package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_gemmes")
public class Gemme extends DDRandomEntity {

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
    return "Gemme{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", valeur='" + valeur + '\'' +
        ", exemples='" + exemples + '\'' +
        '}';
  }
}
