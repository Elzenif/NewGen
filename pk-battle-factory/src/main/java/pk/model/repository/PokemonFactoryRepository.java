package pk.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pk.model.entity.PokemonFactory;
import pk.model.projection.PokemonFactoryProjection;

import java.util.List;

/**
 * Created by Germain on 02/07/2017.
 */
@org.springframework.stereotype.Repository
public interface PokemonFactoryRepository extends JpaRepository<PokemonFactory, Integer> {

  @Query("SELECT pokemonFactory.id AS id, " +
      "pokemonSpeciesNames.name AS pkName, " +
      "natureNames.name AS natureName, " +
      "itemNames.name AS itemName, " +
      "pokemonFactory.encounter50 AS encounter50, " +
      "pokemonFactory.encounter100 AS encounter100, " +
      "pokemonSpecies.id AS pokemonSpeciesId " +
      "FROM PokemonFactory pokemonFactory " +
      "INNER JOIN pokemonFactory.pokemon pokemon " +
      "INNER JOIN pokemon.pokemonSpecies pokemonSpecies " +
      "INNER JOIN pokemonSpecies.pokemonSpeciesNames pokemonSpeciesNames " +
      "INNER JOIN pokemonSpeciesNames.language l1 " +
      "LEFT JOIN pokemonFactory.nature nature " +
      "LEFT JOIN nature.natureNames natureNames " +
      "LEFT JOIN natureNames.language l2 " +
      "LEFT JOIN pokemonFactory.item item " +
      "LEFT JOIN item.itemNames itemNames " +
      "LEFT JOIN itemNames.language l3 " +
      "WHERE pokemonSpeciesNames.name = ?1 AND l1.iso639 = ?2 AND pokemon.id < 1000 " +
      "AND (CASE WHEN (pokemonFactory.nature IS NULL) THEN ?2 ELSE l2.iso639 END) = ?2 " +
      "AND (CASE WHEN (pokemonFactory.item IS NULL) THEN ?2 ELSE l3.iso639 END) = ?2 " +
      "ORDER BY pokemon.id")
  List<PokemonFactoryProjection> findByNameAndLanguage(String name, String language);

  @Query("SELECT DISTINCT pokemonFactory.id AS id, " +
      "pokemonSpeciesNames.name AS pkName, " +
      "natureNames.name AS natureName, " +
      "itemNames.name AS itemName, " +
      "pokemonFactory.encounter50 AS encounter50, " +
      "pokemonFactory.encounter100 AS encounter100, " +
      "pokemonSpecies.id AS pokemonSpeciesId " +
      "FROM PokemonFactory pokemonFactory " +
      "INNER JOIN pokemonFactory.pokemon pokemon " +
      "INNER JOIN pokemon.pokemonSpecies pokemonSpecies " +
      "INNER JOIN pokemonSpecies.pokemonSpeciesNames pokemonSpeciesNames " +
      "INNER JOIN pokemonSpeciesNames.language l1 " +
      "INNER JOIN pokemon.pokemonTypes pokemonTypes " +
      "INNER JOIN pokemonTypes.type pType " +
      "INNER JOIN pType.typeNames typeNames " +
      "INNER JOIN typeNames.language l2 " +
      "LEFT JOIN pokemonFactory.nature nature " +
      "LEFT JOIN nature.natureNames natureNames " +
      "LEFT JOIN natureNames.language l3 " +
      "LEFT JOIN pokemonFactory.item item " +
      "LEFT JOIN item.itemNames itemNames " +
      "LEFT JOIN itemNames.language l4 " +
      "WHERE l1.iso639 = ?2 " +
      "AND typeNames.name = ?1 AND l2.iso639 = ?2 AND pokemon.id < 1000 " +
      "AND (CASE WHEN (pokemonFactory.nature IS NULL) THEN ?2 ELSE l3.iso639 END) = ?2 " +
      "AND (CASE WHEN (pokemonFactory.item IS NULL) THEN ?2 ELSE l4.iso639 END) = ?2 " +
      "ORDER BY pokemon.id")
  List<PokemonFactoryProjection> findByTypeAndLanguage(String type, String language);

  @Query("SELECT DISTINCT pokemonFactory.id AS id, " +
      "pokemonSpeciesNames.name AS pkName, " +
      "natureNames.name AS natureName, " +
      "itemNames.name AS itemName, " +
      "pokemonFactory.encounter50 AS encounter50, " +
      "pokemonFactory.encounter100 AS encounter100, " +
      "pokemonSpecies.id AS pokemonSpeciesId " +
      "FROM PokemonFactory pokemonFactory " +
      "INNER JOIN pokemonFactory.pokemon pokemon " +
      "INNER JOIN pokemon.pokemonSpecies pokemonSpecies " +
      "INNER JOIN pokemonSpecies.pokemonSpeciesNames pokemonSpeciesNames " +
      "INNER JOIN pokemonSpeciesNames.language l1 " +
      "INNER JOIN pokemonFactory.moves moves " +
      "INNER JOIN moves.moveNames moveNames " +
      "INNER JOIN moveNames.language l2 " +
      "LEFT JOIN pokemonFactory.nature nature " +
      "LEFT JOIN nature.natureNames natureNames " +
      "LEFT JOIN natureNames.language l3 " +
      "LEFT JOIN pokemonFactory.item item " +
      "LEFT JOIN item.itemNames itemNames " +
      "LEFT JOIN itemNames.language l4 " +
      "WHERE l1.iso639 = ?2 " +
      "AND moveNames.name = ?1 AND l2.iso639 = ?2 AND pokemon.id < 1000 " +
      "AND (CASE WHEN (pokemonFactory.nature IS NULL) THEN ?2 ELSE l3.iso639 END) = ?2 " +
      "AND (CASE WHEN (pokemonFactory.item IS NULL) THEN ?2 ELSE l4.iso639 END) = ?2 " +
      "ORDER BY pokemon.id")
  List<PokemonFactoryProjection> findByMoveAndLanguage(String move, String language);
}
