package generator.model.entity;

import javax.persistence.MappedSuperclass;

/**
 * Created by Germain on 27/05/2017.
 */
@MappedSuperclass
public abstract class DDRandomEntity extends DDEntity {

  protected Integer prcMin;
  protected Integer prcMax;

  public Integer getPrcMin() {
    return prcMin;
  }

  public void setPrcMin(Integer prcMin) {
    this.prcMin = prcMin;
  }

  public Integer getPrcMax() {
    return prcMax;
  }

  public void setPrcMax(Integer prcMax) {
    this.prcMax = prcMax;
  }


}
