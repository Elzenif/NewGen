package generator.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "dnd35_armes")
public class ArmeInfo extends DDEntity {

  private String type;
  private String sousType;
  private String nom;
  private String degatsP;
  private String degatsM;
  private String critique;
  private Integer portee;
  private Float poids;
  private String typeDegats;
  private Float prix;
  private Integer forceMin;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSousType() {
    return sousType;
  }

  public void setSousType(String sousType) {
    this.sousType = sousType;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getDegatsP() {
    return degatsP;
  }

  public void setDegatsP(String degatsP) {
    this.degatsP = degatsP;
  }

  public String getDegatsM() {
    return degatsM;
  }

  public void setDegatsM(String degatsM) {
    this.degatsM = degatsM;
  }

  public String getCritique() {
    return critique;
  }

  public void setCritique(String critique) {
    this.critique = critique;
  }

  public Integer getPortee() {
    return portee;
  }

  public void setPortee(Integer portee) {
    this.portee = portee;
  }

  public Float getPoids() {
    return poids;
  }

  public void setPoids(Float poids) {
    this.poids = poids;
  }

  public String getTypeDegats() {
    return typeDegats;
  }

  public void setTypeDegats(String typeDegats) {
    this.typeDegats = typeDegats;
  }

  public Float getPrix() {
    return prix;
  }

  public void setPrix(Float prix) {
    this.prix = prix;
  }

  public Integer getForceMin() {
    return forceMin;
  }

  public void setForceMin(Integer forceMin) {
    this.forceMin = forceMin;
  }

  @Override
  public String toString() {
    return "ArmeInfo{" +
        "type='" + type + '\'' +
        ", sousType='" + sousType + '\'' +
        ", id=" + id +
        ", nom='" + nom + '\'' +
        ", degatsP='" + degatsP + '\'' +
        ", degatsM='" + degatsM + '\'' +
        ", critique='" + critique + '\'' +
        ", portee=" + portee +
        ", poids=" + poids +
        ", typeDegats='" + typeDegats + '\'' +
        ", prix=" + prix +
        ", forceMin=" + forceMin +
        '}';
  }
}
