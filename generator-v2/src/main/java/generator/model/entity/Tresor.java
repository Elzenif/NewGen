package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Created by Germain on 25/05/2017.
 */
@Entity
@Table(name = "dnd35_tresors")
public class Tresor extends DDRandomEntity {

  private Integer niveau;
  private Integer prcMin;
  private Integer prcMax;
  @Enumerated(value = EnumType.STRING)
  private TresorType type;
  private String detail;

  public Integer getNiveau() {
    return niveau;
  }

  public void setNiveau(Integer niveau) {
    this.niveau = niveau;
  }

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

  public TresorType getType() {
    return type;
  }

  public void setType(TresorType type) {
    this.type = type;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public String toString() {
    return "Tresor{" +
        "id=" + id +
        ", niveau=" + niveau +
        ", prcMin=" + prcMin +
        ", prcMax=" + prcMax +
        ", type='" + type + '\'' +
        ", detail='" + detail + '\'' +
        '}';
  }
}
