package pk.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.model.entity.Stat;

/**
 * Created by Germain on 15/07/2017.
 */
@Repository
public interface StatRepository extends JpaRepository<Stat, Integer> {

}
