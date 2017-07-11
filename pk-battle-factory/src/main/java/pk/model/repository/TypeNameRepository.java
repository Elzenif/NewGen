package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.TypeName;
import pk.model.entity.TypeNameId;

import java.util.List;

/**
 * Created by Germain on 10/07/2017.
 */
@org.springframework.stereotype.Repository
public interface TypeNameRepository extends Repository<TypeName, TypeNameId> {

  @Query("SELECT tn FROM TypeName tn " +
      "INNER JOIN tn.language l " +
      "INNER JOIN tn.type t " +
      "WHERE l.iso639 = ?1 AND t.generationId <= ?2 AND t.damageClassId IS NOT NULL")
  List<TypeName> findAllByLanguage(String language, Integer generationMax);

}
