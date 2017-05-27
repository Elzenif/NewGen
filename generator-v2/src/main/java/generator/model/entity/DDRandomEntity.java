package generator.model.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by Germain on 27/05/2017.
 */
@MappedSuperclass
public abstract class DDRandomEntity extends DDEntity {

  public abstract Integer getPrcMin();

  public abstract Integer getPrcMax();


}
