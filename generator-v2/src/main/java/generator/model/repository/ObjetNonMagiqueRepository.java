package generator.model.repository;

import generator.model.entity.ObjetNonMagique;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Germain on 28/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
public interface ObjetNonMagiqueRepository extends BaseRepository<ObjetNonMagique> {

  @Query("SELECT o FROM ObjetNonMagique o WHERE " +
      "o.prcMinCat <= ?1 AND o.prcMaxCat >= ?1 AND " +
      "o.prcMinSsCat <= ?2 AND o.prcMaxSsCat >= ?2 AND " +
      "o.prcMinObj <= ?3 AND o.prcMaxObj >= ?3")
  ObjetNonMagique findObjetNonMagique(Integer r1, Integer r2, Integer r3);

}
