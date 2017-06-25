package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesmerveilleuxvalhalla")
public class MerveilleuxValhalla extends DDRandomEntity {

  private String type;
  private String barbares;
  private Integer niveau;
  private String cond;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getBarbares() {
    return barbares;
  }

  public void setBarbares(String barbares) {
    this.barbares = barbares;
  }

  public Integer getNiveau() {
    return niveau;
  }

  public void setNiveau(Integer niveau) {
    this.niveau = niveau;
  }

  public String getCond() {
    return cond;
  }

  public void setCond(String cond) {
    this.cond = cond;
  }

  @Override
  public String toString() {
    return "MerveilleuxValhalla{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", type='" + type + '\'' +
        ", barbares='" + barbares + '\'' +
        ", niveau=" + niveau +
        ", cond='" + cond + '\'' +
        '}';
  }
}
