package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquestypesparchemins")
public class TypeParchemin extends TypeObjet {

  @Override
  public String toString() {
    return "TypeParchemin{" +
        "type='" + type + '\'' +
        ", prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        '}';
  }
}
