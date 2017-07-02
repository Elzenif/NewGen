package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.PokemonFactory;
import pk.model.projection.PokemonFactoryProjection;

import java.util.List;

/**
 * Created by Germain on 02/07/2017.
 */
@org.springframework.stereotype.Repository
public interface PokemonFactoryRepository extends Repository<PokemonFactory, Integer> {

  @Query("SELECT pokemonFactory.id AS id, " +
      "pokemonSpeciesName.name AS pkName, " +
      "natureNames.name AS natureName, " +
      "itemNames.name AS itemName " +
      "FROM PokemonFactory pokemonFactory " +
      "INNER JOIN pokemonFactory.pokemonSpecies pokemonSpecies " +
      "INNER JOIN pokemonSpecies.pokemonSpeciesNames pokemonSpeciesName " +
      "INNER JOIN pokemonSpeciesName.language l1 " +
      "LEFT JOIN pokemonFactory.nature nature " +
      "LEFT JOIN nature.natureNames natureNames " +
      "LEFT JOIN natureNames.language l2 " +
      "LEFT JOIN pokemonFactory.item item " +
      "LEFT JOIN item.itemNames itemNames " +
      "LEFT JOIN itemNames.language l3 " +
      "WHERE pokemonSpeciesName.name = ?1 AND l1.iso639 = ?2 " +
      "AND (CASE WHEN (pokemonFactory.nature IS NULL) THEN ?2 ELSE l2.iso639 END) = ?2 " +
      "AND (CASE WHEN (pokemonFactory.item IS NULL) THEN ?2 ELSE l3.iso639 END) = ?2")
  List<PokemonFactoryProjection> find(String name, String language);

}
