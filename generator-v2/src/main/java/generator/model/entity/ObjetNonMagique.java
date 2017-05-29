package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsnonmagiques")
public class ObjetNonMagique extends DDEntity {

  private Integer prcMinCat;
  private Integer prcMaxCat;
  private Integer prcMinSsCat;
  private Integer prcMaxSsCat;
  private Integer prcMinObj;
  private Integer prcMaxObj;
  private String categorie;
  private String objet;
  private Integer prcMinTailleP;
  private Integer prcMaxTailleP;
  private Integer prcMinTailleM;
  private Integer prcMaxTailleM;

  public Integer getPrcMinCat() {
    return prcMinCat;
  }

  public void setPrcMinCat(Integer prcMinCat) {
    this.prcMinCat = prcMinCat;
  }

  public Integer getPrcMaxCat() {
    return prcMaxCat;
  }

  public void setPrcMaxCat(Integer prcMaxCat) {
    this.prcMaxCat = prcMaxCat;
  }

  public Integer getPrcMinSsCat() {
    return prcMinSsCat;
  }

  public void setPrcMinSsCat(Integer prcMinSsCat) {
    this.prcMinSsCat = prcMinSsCat;
  }

  public Integer getPrcMaxSsCat() {
    return prcMaxSsCat;
  }

  public void setPrcMaxSsCat(Integer prcMaxSsCat) {
    this.prcMaxSsCat = prcMaxSsCat;
  }

  public Integer getPrcMinObj() {
    return prcMinObj;
  }

  public void setPrcMinObj(Integer prcMinObj) {
    this.prcMinObj = prcMinObj;
  }

  public Integer getPrcMaxObj() {
    return prcMaxObj;
  }

  public void setPrcMaxObj(Integer prcMaxObj) {
    this.prcMaxObj = prcMaxObj;
  }

  public String getCategorie() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  public String getObjet() {
    return objet;
  }

  public void setObjet(String objet) {
    this.objet = objet;
  }

  public Integer getPrcMinTailleP() {
    return prcMinTailleP;
  }

  public void setPrcMinTailleP(Integer prcMinTailleP) {
    this.prcMinTailleP = prcMinTailleP;
  }

  public Integer getPrcMaxTailleP() {
    return prcMaxTailleP;
  }

  public void setPrcMaxTailleP(Integer prcMaxTailleP) {
    this.prcMaxTailleP = prcMaxTailleP;
  }

  public Integer getPrcMinTailleM() {
    return prcMinTailleM;
  }

  public void setPrcMinTailleM(Integer prcMinTailleM) {
    this.prcMinTailleM = prcMinTailleM;
  }

  public Integer getPrcMaxTailleM() {
    return prcMaxTailleM;
  }

  public void setPrcMaxTailleM(Integer prcMaxTailleM) {
    this.prcMaxTailleM = prcMaxTailleM;
  }

  @Override
  public String toString() {
    return "ObjetNonMagique{" +
        "id=" + id +
        ", prcMinCat=" + prcMinCat +
        ", prcMaxCat=" + prcMaxCat +
        ", prcMinSsCat=" + prcMinSsCat +
        ", prcMaxSsCat=" + prcMaxSsCat +
        ", prcMinObj=" + prcMinObj +
        ", prcMaxObj=" + prcMaxObj +
        ", categorie='" + categorie + '\'' +
        ", objet='" + objet + '\'' +
        ", prcMinTailleP=" + prcMinTailleP +
        ", prcMaxTailleP=" + prcMaxTailleP +
        ", prcMinTailleM=" + prcMinTailleM +
        ", prcMaxTailleM=" + prcMaxTailleM +
        '}';
  }
}
