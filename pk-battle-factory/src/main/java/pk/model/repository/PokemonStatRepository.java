package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.PokemonStat;
import pk.model.entity.PokemonStatId;

import java.util.List;

/**
 * Created by Germain on 17/07/2017.
 */
@org.springframework.stereotype.Repository
public interface PokemonStatRepository extends Repository<PokemonStat, PokemonStatId> {

  @Query("SELECT pokemonStat FROM PokemonStat pokemonStat " +
      "INNER JOIN pokemonStat.stat stat " +
      "INNER JOIN pokemonStat.pokemon pokemon " +
      "INNER JOIN pokemon.pokemonSpecies pokemonSpecies " +
      "INNER JOIN pokemonSpecies.pokemonFactories pokemonFactories " +
      "WHERE pokemonFactories.id = ?1 AND pokemon.id < 10000 " +
      "ORDER BY stat.id")
  List<PokemonStat> findStats(Integer pokemonFactoryId);
}
