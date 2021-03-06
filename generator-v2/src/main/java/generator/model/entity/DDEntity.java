package generator.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Germain on 27/05/2017.
 */
@MappedSuperclass
public abstract class DDEntity {

  @Id
  @GeneratedValue
  protected Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
