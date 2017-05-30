package generator.model.repository;

import generator.model.entity.ArmeDistance;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Germain on 30/05/2017.
 */
public interface ArmeDistanceRepository extends BaseRandomRepository<ArmeDistance> {

  @Query("SELECT a FROM ArmeDistance a WHERE " +
      "a.prcMin <= ?1 AND a.prcMax >= ?1 AND " +
      "a.prcMinMunition <= ?2 AND a.prcMaxMunition >= ?2")
  ArmeDistance findArmeDistance(Integer r1, Integer r2);
}
