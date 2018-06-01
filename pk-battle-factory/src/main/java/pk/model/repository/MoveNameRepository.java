package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.MoveName;
import pk.model.entity.MoveNameId;

import java.util.Collection;
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
      "WHERE l.iso639 = ?1 AND m.generationId <= ?2 " +
      "ORDER BY mn.name")
  List<MoveName> findAllByLanguage(String language, Integer generationMax);

  @Query("SELECT mn FROM MoveName mn " +
      "INNER JOIN mn.move m " +
      "INNER JOIN mn.language l " +
      "WHERE mn.name IN ?1 AND l.iso639 = ?2")
  List<MoveName> findByNames(Collection<String> moveNames, String language);

  @Query("SELECT mn2.name FROM MoveName mn1 " +
      "INNER JOIN mn1.language l1 " +
      "INNER JOIN mn1.move m " +
      "INNER JOIN m.moveNames mn2 " +
      "INNER JOIN mn2.language l2 " +
      "WHERE mn1.name = ?1 AND l1.iso639 = ?2 AND l2.iso639 = ?3")
  String translate(String moveName, String fromLanguage, String toLanguage);
}
