package pk.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.ItemName;
import pk.model.entity.ItemNameId;

import java.util.List;

/**
 * Created by Germain on 12/07/2017.
 */
@org.springframework.stereotype.Repository
public interface ItemNameRepository extends Repository<ItemName, ItemNameId> {

  @Query("SELECT i FROM ItemName i " +
      "INNER JOIN i.language l " +
      "WHERE l.iso639 = ?1 " +
      "ORDER BY i.name")
  List<ItemName> findAllByLanguage(String language);
}
