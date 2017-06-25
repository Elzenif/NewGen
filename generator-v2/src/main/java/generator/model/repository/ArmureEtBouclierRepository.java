package generator.model.repository;

import generator.model.entity.ArmureEtBouclier;

@SuppressWarnings("SpellCheckingInspection")
public interface ArmureEtBouclierRepository extends BaseRandomPuissanceRepository<ArmureEtBouclier> {

  ArmureEtBouclier findFirstByModificateur(Integer modificateur);
}
