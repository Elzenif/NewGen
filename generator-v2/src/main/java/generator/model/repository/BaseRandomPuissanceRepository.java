package generator.model.repository;

import generator.model.entity.DDRandomPuissanceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@NoRepositoryBean
public interface BaseRandomPuissanceRepository<T extends DDRandomPuissanceEntity> extends BaseRandomRepository<T> {

  @Query("SELECT t FROM #{#entityName} t WHERE t.puissance = ?1 AND t.prcMin <= ?2 AND t.prcMax >= ?2")
  T findRandomByPuissance(String puissance, Integer prc);

}
