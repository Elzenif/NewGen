package generator.model.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by Germain on 30/05/2017.
 */
@MappedSuperclass
public class Arme extends DDRandomEntity {

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
