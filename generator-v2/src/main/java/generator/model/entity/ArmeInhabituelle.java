package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmesinhabituelles")
public class ArmeInhabituelle extends Arme {

  @Enumerated(EnumType.STRING)
  private Type type;

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "ArmeInhabituelle{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", arme='" + arme + '\'' +
        ", prix=" + prix +
        ", type=" + type +
        '}';
  }

  private enum Type {
    cac, distance;
  }
}
