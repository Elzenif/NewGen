package pk.model.repository;

import org.springframework.data.repository.Repository;
import pk.model.entity.PokemonSpeciesNames;
import pk.model.entity.PokemonSpeciesNamesId;

import java.util.List;

/**
 * Created by Germain on 02/07/2017.
 */
@org.springframework.stereotype.Repository
public interface PokemonSpeciesNamesRepository extends Repository<PokemonSpeciesNames, PokemonSpeciesNamesId> {

  List<PokemonSpeciesNames> findAllByIdLocalLanguageId(Integer localLanguageId);

}
