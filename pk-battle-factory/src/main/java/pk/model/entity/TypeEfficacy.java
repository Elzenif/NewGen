package pk.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "type_efficacy")
public class TypeEfficacy {

  @EmbeddedId
  private TypeEfficacyId id;
  @MapsId("damageTypeId")
  @JoinColumn(name = "damage_type_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Type damageType;
  @MapsId("targetTypeId")
  @JoinColumn(name = "target_type_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Type targetType;
  private Integer damageFactor;

  public TypeEfficacy() {
  }

  public TypeEfficacyId getId() {
    return id;
  }

  public void setId(TypeEfficacyId id) {
    this.id = id;
  }

  public Type getDamageType() {
    return damageType;
  }

  public void setDamageType(Type damageType) {
    this.damageType = damageType;
  }

  public Type getTargetType() {
    return targetType;
  }

  public void setTargetType(Type targetType) {
    this.targetType = targetType;
  }

  public Integer getDamageFactor() {
    return damageFactor;
  }

  public void setDamageFactor(Integer damageFactor) {
    this.damageFactor = damageFactor;
  }

  @Override
  public String toString() {
    return "TypeEfficacy{" +
        "id=" + id +
        ", damageType=" + damageType.getId() +
        ", targetType=" + targetType.getId() +
        ", damageFactor=" + damageFactor +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TypeEfficacy that = (TypeEfficacy) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}