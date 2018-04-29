package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.Pokemon;

@org.springframework.stereotype.Repository
public interface PokemonRepository extends Repository<Pokemon, Long> {

  @Query("SELECT p FROM Pokemon p " +
      "INNER JOIN p.pokemonSpecies s " +
      "INNER JOIN s.pokemonSpeciesNames n " +
      "INNER JOIN n.language l " +
      "WHERE n.name = ?1 AND l.iso639 = ?2 AND p.id < 1000")
  Pokemon findByNameAndLanguage(String name, String language);
}
