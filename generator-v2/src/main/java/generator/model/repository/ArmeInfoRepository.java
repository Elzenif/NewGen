package generator.model.repository;

import generator.model.entity.ArmeInfo;

@SuppressWarnings("SpellCheckingInspection")
public interface ArmeInfoRepository extends BaseRepository<ArmeInfo> {

  ArmeInfo findFirstByNomContainingIgnoreCase(String nom);
}
