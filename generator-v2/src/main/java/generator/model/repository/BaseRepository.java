package generator.model.repository;

import generator.model.entity.DDEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Created by Germain on 28/05/2017.
 */
@NoRepositoryBean
public interface BaseRepository<T extends DDEntity> extends Repository<T, Integer> {

}
