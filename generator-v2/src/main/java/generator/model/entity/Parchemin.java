package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesparchemins")
public class Parchemin extends DDRandomEntity {

  private String typeSort;
  private Integer niveauSort;
  private String sort;
  private Float prix;

  public String getTypeSort() {
    return typeSort;
  }

  public void setTypeSort(String typeSort) {
    this.typeSort = typeSort;
  }

  public Integer getNiveauSort() {
    return niveauSort;
  }

  public void setNiveauSort(Integer niveauSort) {
    this.niveauSort = niveauSort;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public Float getPrix() {
    return prix;
  }

  public void setPrix(Float prix) {
    this.prix = prix;
  }

  @Override
  public String toString() {
    return "Parchemin{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", typeSort='" + typeSort + '\'' +
        ", niveauSort=" + niveauSort +
        ", sort='" + sort + '\'' +
        ", prix=" + prix +
        '}';
  }
}
