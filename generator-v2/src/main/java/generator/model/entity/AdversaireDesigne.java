package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesadversairesdesignes")
public class AdversaireDesigne extends DDRandomEntity {

  private String adversaire;

  public String getAdversaire() {
    return adversaire;
  }

  public void setAdversaire(String adversaire) {
    this.adversaire = adversaire;
  }

  @Override
  public String toString() {
    return "AdversaireDesigne{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", adversaire='" + adversaire + '\'' +
        ", id=" + id +
        '}';
  }
}
