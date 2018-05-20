package pk.model.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pk.model.entity.TypeEfficacy;
import pk.model.entity.TypeEfficacyId;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TypeEfficacyRepository extends Repository<TypeEfficacy, TypeEfficacyId> {

  @Query("SELECT te FROM TypeEfficacy te " +
      "INNER JOIN FETCH te.damageType dt " +
      "INNER JOIN FETCH te.targetType tt " +
      "WHERE dt.generationId <= ?1 AND tt.generationId <= ?1")
  List<TypeEfficacy> findAll(Integer generationMax);

}
