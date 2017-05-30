package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesanneaux")
public class Anneau extends DDRandomPuissanceEntity {

  private String nom;
  private Integer modificateur;
  private Integer prix;

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
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
    return "Anneau{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", nom='" + nom + '\'' +
        ", modificateur=" + modificateur +
        ", prix=" + prix +
        '}';
  }
}
