package generator.model.repository;

import generator.model.entity.DDRandomPuissanceEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@NoRepositoryBean
public interface BaseRandomPuissanceRepository<T extends DDRandomPuissanceEntity> extends BaseRandomRepository<T> {

  T findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(String puissance, Integer prcMin,
                                                                        Integer prcMax);

}
