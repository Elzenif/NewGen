package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.Ability;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AbilityRepository extends Repository<Ability, Integer> {

  @Query("SELECT a FROM Ability a " +
      "INNER JOIN a.pokemonAbilities pa " +
      "INNER JOIN pa.pokemon p " +
      "INNER JOIN a.generation g " +
      "WHERE p.id = ?1 AND g.id <= 4 AND pa.isHidden = 0")
  List<Ability> findByPokemonId(Integer pokemonId);
}
