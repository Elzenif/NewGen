package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.StatName;
import pk.model.entity.StatNameId;

import java.util.List;

@org.springframework.stereotype.Repository
public interface StatNameRepository extends Repository<StatName, StatNameId> {

  @Query("SELECT sn FROM StatName sn " +
      "INNER JOIN sn.language l " +
      "WHERE l.iso639 = ?1")
  List<StatName> findByLanguageId(String language);
}
