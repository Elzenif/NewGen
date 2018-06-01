package pk.model.repository;

import org.springframework.data.repository.Repository;
import pk.model.entity.AbilityName;
import pk.model.entity.AbilityNameId;

@org.springframework.stereotype.Repository
public interface AbilityNameRepository extends Repository<AbilityName, AbilityNameId> {

  AbilityName findByAbilityIdAndLanguage_Iso639(Integer abilityId, String languageIso639);
}
