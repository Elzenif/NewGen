package pk.model.projection;

/**
 * Created by Germain on 02/07/2017.
 */
public interface PokemonFactoryProjection {

  Integer getId();

  String getPkName();

  String getNatureName();

  default String getString() {
    return getId() + " " + getPkName() + " " + getNatureName();
  }
}
