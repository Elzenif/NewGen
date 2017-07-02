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

  @Query("SELECT p FROM PokemonSpeciesName p INNER JOIN p.language l WHERE l.iso639 = ?1")
  List<PokemonSpeciesName> findAllByLanguage(String languageIso639);
}
