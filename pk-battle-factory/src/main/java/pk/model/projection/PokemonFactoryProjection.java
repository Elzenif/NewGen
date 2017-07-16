package pk.model.projection;

/**
 * Created by Germain on 02/07/2017.
 */
public interface PokemonFactoryProjection {

  Integer getId();

  String getPkName();

  String getNatureName();

  String getItemName();

  String getEncounter50();

  String getEncounter100();

  default String getString() {
    return getId() + " " + getPkName() + " " + getNatureName() + " " + getItemName() + " " + getEncounter50() + " " +
        getEncounter100();
  }
}
