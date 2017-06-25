package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesparcheminsniveausorts")
public class ParcheminNiveauSort extends DDRandomPuissanceEntity {

  private Integer niveauSort;
  private Integer niveauLanceur;

  public Integer getNiveauSort() {
    return niveauSort;
  }

  public void setNiveauSort(Integer niveauSort) {
    this.niveauSort = niveauSort;
  }

  public Integer getNiveauLanceur() {
    return niveauLanceur;
  }

  public void setNiveauLanceur(Integer niveauLanceur) {
    this.niveauLanceur = niveauLanceur;
  }

  @Override
  public String toString() {
    return "ParcheminNiveauSort{" +
        "prcMin=" + prcMin +
        ", puissance='" + puissance + '\'' +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", niveauSort=" + niveauSort +
        ", niveauLanceur=" + niveauLanceur +
        '}';
  }
}
