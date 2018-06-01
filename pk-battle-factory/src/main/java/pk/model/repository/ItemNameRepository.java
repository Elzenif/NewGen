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

  @Query("SELECT DISTINCT itemName FROM ItemName itemName " +
      "INNER JOIN itemName.language l " +
      "INNER JOIN itemName.item item " +
      "INNER JOIN item.itemCategory itemCategory " +
      "INNER JOIN item.itemGameIndices itemGameIndices " +
      "INNER JOIN itemGameIndices.generation generation " +
      "WHERE l.iso639 = ?1 " +
      "AND itemCategory.identifier IN " +
      "('effort-drop', 'medicine', 'in-a-pinch', 'picky-healing', 'type-protection', 'held-items', 'choice', " +
      "'bad-held-items', 'species-specific', 'type-enhancement') " +
      "AND generation.id <= ?2 " +
      "ORDER BY itemName.name")
  List<ItemName> findAllByLanguageForFactory(String language, Integer generationMax);

  @Query("SELECT itemName FROM ItemName itemName " +
      "INNER JOIN itemName.item item " +
      "INNER JOIN itemName.language l " +
      "WHERE itemName.name = ?1 AND l.iso639 = ?2")
  ItemName findByName(String itemName, String language);

  @Query("SELECT in2.name FROM ItemName in1 " +
      "INNER JOIN in1.language l1 " +
      "INNER JOIN in1.item i " +
      "INNER JOIN i.itemNames in2 " +
      "INNER JOIN in2.language l2 " +
      "WHERE in1.name = ?1 AND l1.iso639 = ?2 AND l2.iso639 = ?3")
  String translate(String itemName, String fromLanguage, String toLanguage);
}
