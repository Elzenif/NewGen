package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.Type;

import java.util.List;

/**
 * Created by Germain on 10/07/2017.
 */
@org.springframework.stereotype.Repository
public interface TypeRepository extends Repository<Type, Integer> {

  @Query("SELECT t FROM Type t " +
      "INNER JOIN t.pokemonTypes pTypes " +
      "INNER JOIN pTypes.pokemon pokemon " +
      "WHERE pokemon.id = ?1")
  List<Type> find(Integer pokemonId);

}
