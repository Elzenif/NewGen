package generator.model.entity;

import javax.persistence.MappedSuperclass;

@SuppressWarnings("SpellCheckingInspection")
@MappedSuperclass
public abstract class ObjetSpecifique extends DDRandomPuissanceEntity {

  protected String arme;
  protected Integer prix;

  public String getArme() {
    return arme;
  }

  public void setArme(String arme) {
    this.arme = arme;
  }

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }
}
