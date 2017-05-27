package generator.model.repository;

import generator.model.entity.Tresor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Germain on 25/05/2017.
 */
public interface TresorRepository extends CrudRepository<Tresor, Integer> {

  List<Tresor> findByNiveau(int niveau);
}
