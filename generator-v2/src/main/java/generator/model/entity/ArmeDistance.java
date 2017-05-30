package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesarmesdistance")
public class ArmeDistance extends Arme {

  private Integer prcMinMunition;
  private Integer prcMaxMunition;

  public Integer getPrcMinMunition() {
    return prcMinMunition;
  }

  public void setPrcMinMunition(Integer prcMinMunition) {
    this.prcMinMunition = prcMinMunition;
  }

  public Integer getPrcMaxMunition() {
    return prcMaxMunition;
  }

  public void setPrcMaxMunition(Integer prcMaxMunition) {
    this.prcMaxMunition = prcMaxMunition;
  }

  @Override
  public String toString() {
    return "ArmeDistance{" +
        "arme='" + arme + '\'' +
        ", prcMin=" + prcMin +
        ", prix=" + prix +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", prcMinMunition=" + prcMinMunition +
        ", prcMaxMunition=" + prcMaxMunition +
        '}';
  }
}
