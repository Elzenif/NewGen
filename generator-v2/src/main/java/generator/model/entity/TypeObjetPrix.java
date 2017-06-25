package generator.model.entity;

import javax.persistence.MappedSuperclass;

@SuppressWarnings("SpellCheckingInspection")
@MappedSuperclass
public abstract class TypeObjetPrix extends TypeObjet {

  protected Integer prix;

  public Integer getPrix() {
    return prix;
  }

  public void setPrix(Integer prix) {
    this.prix = prix;
  }
}
