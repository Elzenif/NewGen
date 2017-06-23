package generator.model.entity;

import javax.persistence.MappedSuperclass;

@SuppressWarnings("SpellCheckingInspection")
@MappedSuperclass
public abstract class ProprieteSpecialePrix extends ProprieteSpeciale {

  protected Integer modificateurPrix;

  public Integer getModificateurPrix() {
    return modificateurPrix;
  }

  public void setModificateurPrix(Integer modificateurPrix) {
    this.modificateurPrix = modificateurPrix;
  }
}
