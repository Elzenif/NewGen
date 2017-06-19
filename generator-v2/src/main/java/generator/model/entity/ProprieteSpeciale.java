package generator.model.entity;

import javax.persistence.MappedSuperclass;

@SuppressWarnings("SpellCheckingInspection")
@MappedSuperclass
public abstract class ProprieteSpeciale extends DDRandomPuissanceEntity {

  protected String nom;
  protected Integer modificateur;

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
}
