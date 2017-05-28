package generator.model.repository;

import generator.model.entity.Tresor;

import java.util.List;

/**
 * Created by Germain on 25/05/2017.
 */
public interface TresorRepository extends BaseRandomRepository<Tresor> {

  List<Tresor> findByNiveauAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(Integer niveau, Integer prcMin,
                                                                           Integer prcMax);
}
