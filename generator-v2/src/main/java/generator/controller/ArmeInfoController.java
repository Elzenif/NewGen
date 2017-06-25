package generator.controller;

import commons.utils.StringUtils;
import generator.model.entity.Arme;
import generator.model.entity.ArmeInfo;
import generator.model.entity.ArmeSpecifique;
import generator.model.entity.ProprieteSpeciale;
import generator.model.repository.ArmeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
@Service
public class ArmeInfoController extends AbstractController {

  private final ArmeInfoRepository armeInfoRepository;
  private final static List<String> constraintsArme = Arrays.asList("acérée", "destruction", "vorpale", "boomerang");
  private final static List<String> armesDeJet = Arrays.asList("Javeline", "Dard", "Bolas", "Shuriken");

  @Autowired
  public ArmeInfoController(ArmeInfoRepository armeInfoRepository) {
    this.armeInfoRepository = armeInfoRepository;
  }

  public boolean isCompatible(Arme arme, ProprieteSpeciale proprieteSpeciale) {
    String proprieteSpecialeNom = proprieteSpeciale.getNom();
    if (!constraintsArme.contains(proprieteSpecialeNom)) {
      return true;
    }
    if (arme.isMunition()) {
      return false;
    }
    String armeNom = StringUtils.removePatternAtEndOfString(arme.getArme(), "( )?\\(.*\\)");
    ArmeInfo armeInfo = armeInfoRepository.findFirstByNomContainingIgnoreCase(armeNom);
    String typeDegats = armeInfo.getTypeDegats();
    if (Objects.equals(proprieteSpecialeNom, "acérée")) {
      return typeDegats.contains("Perforant") || typeDegats.contains("perforant") || typeDegats.contains("Tranchant")
          || typeDegats.contains("tranchant");
    }
    if (Objects.equals(proprieteSpecialeNom, "destruction")) {
      return typeDegats.contains("Contondant");
    }
    if (Objects.equals(proprieteSpecialeNom, "vorpale")) {
      return typeDegats.contains("Tranchant") || typeDegats.contains("tranchant");
    }
    if (Objects.equals(proprieteSpecialeNom, "boomerang")) {
      return armesDeJet.contains(armeInfo.getNom());
    }
    return true;
  }

  public boolean isCompatible(ArmeSpecifique armeSpecifique, ProprieteSpeciale proprieteSpeciale) {
    String proprieteSpecialeNom = proprieteSpeciale.getNom();
    if (Objects.equals(proprieteSpecialeNom, "acérée")) {
      return armeSpecifique.isPerforant() || armeSpecifique.isTranchant();
    }
    if (Objects.equals(proprieteSpecialeNom, "destruction")) {
      return armeSpecifique.isContondant();
    }
    if (Objects.equals(proprieteSpecialeNom, "vorpale")) {
      return armeSpecifique.isTranchant();
    }
    if (Objects.equals(proprieteSpecialeNom, "boomerang")) {
      return !armeSpecifique.isMunition();
    }
    return true;
  }
}
