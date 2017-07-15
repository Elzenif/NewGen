package pk.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pk.model.entity.PokemonFactoryStat;
import pk.model.entity.PokemonFactoryStatId;

import java.util.List;

/**
 * Created by Germain on 03/07/2017.
 */
@org.springframework.stereotype.Repository
public interface PokemonFactoryStatRepository extends JpaRepository<PokemonFactoryStat, PokemonFactoryStatId> {

  @Query("SELECT pfs FROM PokemonFactoryStat pfs " +
      "INNER JOIN pfs.pokemonFactory pf " +
      "WHERE pf.id = ?1 " +
      "ORDER BY pfs.stat.id")
  List<PokemonFactoryStat> find(Integer pokemonFactoryId);
}
