package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.PokemonSpeciesName;
import pk.model.entity.PokemonSpeciesNameId;

import java.util.List;

/**
 * Created by Germain on 02/07/2017.
 */
@org.springframework.stereotype.Repository
public interface PokemonSpeciesNameRepository extends Repository<PokemonSpeciesName, PokemonSpeciesNameId> {

  @Query("SELECT pn FROM PokemonSpeciesName pn " +
      "INNER JOIN pn.language l " +
      "INNER JOIN pn.pokemonSpecies p " +
      "WHERE l.iso639 = ?1 AND p.generationId <= ?2")
  List<PokemonSpeciesName> findAllByLanguageAndGeneration(String language, Integer generationMax);

  @Query("SELECT pn2.name FROM PokemonSpeciesName pn1 " +
      "INNER JOIN pn1.language l1 " +
      "INNER JOIN pn1.pokemonSpecies ps " +
      "INNER JOIN ps.pokemonSpeciesNames pn2 " +
      "INNER JOIN pn2.language l2 " +
      "WHERE pn1.name = ?1 AND l1.iso639 = ?2 AND l2.iso639 = ?3")
  String translate(String pkName, String fromLanguage, String toLanguage);
}
