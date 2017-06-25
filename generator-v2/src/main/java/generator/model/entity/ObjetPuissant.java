package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 26/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquespuissants")
public class ObjetPuissant extends DDEntity {

  private Integer niveau;
  private Integer nb;

  public Integer getNiveau() {
    return niveau;
  }

  public void setNiveau(Integer niveau) {
    this.niveau = niveau;
  }

  public Integer getNb() {
    return nb;
  }

  public void setNb(Integer nb) {
    this.nb = nb;
  }

  @Override
  public String toString() {
    return "ObjetPuissant{" +
        "niveau=" + niveau +
        ", nb=" + nb +
        ", id=" + id +
        '}';
  }
}
