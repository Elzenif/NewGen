package generator.model.repository;

import generator.model.entity.DDRandomEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Germain on 28/05/2017.
 */
@NoRepositoryBean
public interface BaseRandomRepository<T extends DDRandomEntity> extends BaseRepository<T> {

  @Query("SELECT t FROM #{#entityName} t WHERE t.prcMin <= ?1 AND t.prcMax >= ?1")
  T findRandom(Integer prc);
}
