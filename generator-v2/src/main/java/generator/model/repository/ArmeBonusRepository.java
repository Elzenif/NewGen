package generator.model.repository;

import generator.model.entity.ArmeBonus;

@SuppressWarnings("SpellCheckingInspection")
public interface ArmeBonusRepository extends BaseRandomPuissanceRepository<ArmeBonus> {

  ArmeBonus findFirstByBonus(String bonus);
}
