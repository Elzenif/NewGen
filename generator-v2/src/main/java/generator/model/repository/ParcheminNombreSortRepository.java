package generator.model.repository;

import generator.model.entity.ParcheminNombreSort;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
public interface ParcheminNombreSortRepository extends BaseRepository<ParcheminNombreSort> {

  ParcheminNombreSort findFirstByPuissance(String puissance);

}
