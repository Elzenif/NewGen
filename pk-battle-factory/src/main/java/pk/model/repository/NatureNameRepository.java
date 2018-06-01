package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.NatureName;
import pk.model.entity.NatureNameId;

import java.util.List;

/**
 * Created by Germain on 12/07/2017.
 */
@org.springframework.stereotype.Repository
public interface NatureNameRepository extends Repository<NatureName, NatureNameId> {

  @Query("SELECT nn FROM NatureName nn " +
      "INNER JOIN nn.language l " +
      "WHERE l.iso639 = ?1 " +
      "ORDER BY nn.name")
  List<NatureName> findAllByLanguage(String language);

  @Query("SELECT nn FROM NatureName nn " +
      "JOIN FETCH nn.nature n " +
      "INNER JOIN nn.language l " +
      "JOIN FETCH n.decreasedStat dec " +
      "JOIN FETCH n.increasedStat inc " +
      "WHERE nn.name = ?1 AND l.iso639 = ?2")
  NatureName findByName(String natureName, String language);

  @Query("SELECT nn2.name FROM NatureName nn1 " +
      "INNER JOIN nn1.language l1 " +
      "INNER JOIN nn1.nature n " +
      "INNER JOIN n.natureNames nn2 " +
      "INNER JOIN nn2.language l2 " +
      "WHERE nn1.name = ?1 AND l1.iso639 = ?2 AND l2.iso639 = ?3")
  String translate(String natureName, String fromLanguage, String toLanguage);
}
