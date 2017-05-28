package generator.model.repository;

import generator.model.entity.DDRandomEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Germain on 28/05/2017.
 */
@NoRepositoryBean
public interface BaseRandomRepository<T extends DDRandomEntity> extends BaseRepository<T> {

  T findFirstByPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(Integer prcMin, Integer prcMax);
}
