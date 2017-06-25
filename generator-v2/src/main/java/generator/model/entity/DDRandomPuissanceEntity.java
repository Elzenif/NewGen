package generator.model.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by Germain on 30/05/2017.
 */
@MappedSuperclass
public abstract class DDRandomPuissanceEntity extends DDRandomEntity {

  protected String puissance;

  public String getPuissance() {
    return puissance;
  }

  public void setPuissance(String puissance) {
    this.puissance = puissance;
  }
}
