package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import pk.model.entity.MoveName;
import pk.model.entity.MoveNameId;

import java.util.List;

@org.springframework.stereotype.Repository
public interface MoveNameRepository extends Repository<MoveName, MoveNameId> {

  @Query("SELECT mn FROM MoveName mn " +
          "INNER JOIN mn.language l " +
          "INNER JOIN mn.move m " +
          "INNER JOIN m.pokemonFactoryList pf " +
          "WHERE pf.id = ?1 AND l.iso639 = ?2")
  List<MoveName> find(Integer pokemonFactoryId, String language);

  @Query("SELECT mn FROM MoveName mn " +
      "INNER JOIN mn.language l " +
      "INNER JOIN mn.move m " +
      "WHERE l.iso639 = ?1 AND m.generationId >= ?2 AND m.generationId <= ?3 " +
      "ORDER BY mn.name")
  List<MoveName> findAllByLanguage(String language, Integer generationMin, Integer generationMax);
}
