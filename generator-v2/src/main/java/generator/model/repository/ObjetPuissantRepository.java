package generator.model.repository;

import generator.model.entity.ObjetPuissant;

/**
 * Created by Germain on 26/06/2017.
 */
public interface ObjetPuissantRepository extends BaseRepository<ObjetPuissant> {

  ObjetPuissant findFirstByNiveau(Integer niveau);
}
