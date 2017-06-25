package generator.model.repository;

import generator.model.entity.Parchemin;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
public interface ParcheminRepository extends BaseRandomRepository<Parchemin> {

  @Query("SELECT p FROM Parchemin p WHERE " +
      "p.typeSort = ?1 AND p.niveauSort = ?2 AND " +
      "p.prcMin <= ?3 AND p.prcMax >= ?3")
  Parchemin findParchemin(String typeSort, Integer niveauSort, Integer random);
}
