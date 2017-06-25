package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesmerveilleuxflasque")
public class MerveilleuxFlasque extends DDRandomEntity {

  private String contenu;

  public String getContenu() {
    return contenu;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  @Override
  public String toString() {
    return "MerveilleuxFlasque{" +
        "prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", id=" + id +
        ", contenu='" + contenu + '\'' +
        '}';
  }
}
