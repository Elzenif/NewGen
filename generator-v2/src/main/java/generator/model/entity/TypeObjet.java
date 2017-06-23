package generator.model.entity;

import javax.persistence.MappedSuperclass;

@SuppressWarnings("SpellCheckingInspection")
@MappedSuperclass
public abstract class TypeObjet extends DDRandomEntity {

  protected String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
