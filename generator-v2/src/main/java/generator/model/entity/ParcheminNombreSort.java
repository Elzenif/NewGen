package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_objetsmagiquesparcheminsnombresorts")
public class ParcheminNombreSort extends DDEntity {

  private String puissance;
  private String nombre;

  public String getPuissance() {
    return puissance;
  }

  public void setPuissance(String puissance) {
    this.puissance = puissance;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "ParcheminNombreSort{" +
        "id=" + id +
        ", puissance='" + puissance + '\'' +
        ", nombre='" + nombre + '\'' +
        '}';
  }
}
