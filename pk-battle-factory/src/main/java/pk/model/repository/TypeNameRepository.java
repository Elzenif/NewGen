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

  @Query("SELECT t FROM TypeName t INNER JOIN t.language l WHERE l.iso639 = ?1")
  List<TypeName> findAllByLanguage(String languageIso639);

}
