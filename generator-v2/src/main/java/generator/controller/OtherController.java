package generator.controller;

import generator.model.entity.Anneau;
import generator.model.entity.Baguette;
import generator.model.entity.Baton;
import generator.model.entity.Merveilleux;
import generator.model.entity.MerveilleuxFlasque;
import generator.model.entity.MerveilleuxValhalla;
import generator.model.entity.PotionEtHuile;
import generator.model.entity.Sceptre;
import generator.model.repository.AnneauRepository;
import generator.model.repository.BaguetteRepository;
import generator.model.repository.BatonRepository;
import generator.model.repository.MerveilleuxFlasqueRepository;
import generator.model.repository.MerveilleuxRepository;
import generator.model.repository.MerveilleuxValhallaRepository;
import generator.model.repository.PotionEtHuileRepository;
import generator.model.repository.SceptreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class OtherController extends AbstractController {

  private final AnneauRepository anneauRepository;
  private final BaguetteRepository baguetteRepository;
  private final BatonRepository batonRepository;
  private final MerveilleuxRepository merveilleuxRepository;
  private final MerveilleuxValhallaRepository merveilleuxValhallaRepository;
  private final MerveilleuxFlasqueRepository merveilleuxFlasqueRepository;
  private final PotionEtHuileRepository potionEtHuileRepository;
  private final SceptreRepository sceptreRepository;

  @Autowired
  public OtherController(AnneauRepository anneauRepository, BaguetteRepository baguetteRepository,
                         BatonRepository batonRepository, MerveilleuxRepository merveilleuxRepository,
                         MerveilleuxValhallaRepository merveilleuxValhallaRepository,
                         MerveilleuxFlasqueRepository merveilleuxFlasqueRepository,
                         PotionEtHuileRepository potionEtHuileRepository, SceptreRepository sceptreRepository) {
    this.anneauRepository = anneauRepository;
    this.baguetteRepository = baguetteRepository;
    this.batonRepository = batonRepository;
    this.merveilleuxRepository = merveilleuxRepository;
    this.merveilleuxValhallaRepository = merveilleuxValhallaRepository;
    this.merveilleuxFlasqueRepository = merveilleuxFlasqueRepository;
    this.potionEtHuileRepository = potionEtHuileRepository;
    this.sceptreRepository = sceptreRepository;
  }

  public String generateAnneau(String puissance) {
    Anneau anneau = anneauRepository.findRandomByPuissance(puissance, roll100());
    return "Anneau " + anneau.getNom() +
        (anneau.getModificateur() == null ? "" : " +" + anneau.getModificateur()) +
        " (" + anneau.getPrix() + "po)";
  }

  public String generateBaguette(String puissance) {
    Baguette baguette = baguetteRepository.findRandomByPuissance(puissance, roll100());
    return "Baguette " + baguette.getBaguette() + " (" + baguette.getPrix() + "po)";
  }

  public String generateBaton(String puissance) {
    Baton baton = batonRepository.findRandomByPuissance(puissance, roll100());
    return "Baton " + baton.getBaton() + " (" + baton.getPrix() + "po)";
  }

  public String generateMerveilleux(String puissance) {
    Merveilleux merveilleux = merveilleuxRepository.findRandomByPuissance(puissance, roll100());
    if (Objects.equals(merveilleux.getObjet(), "Cor du Valhalla")) {
      MerveilleuxValhalla valhalla = merveilleuxValhallaRepository.findRandom(roll100());
      String s = "Cor du Valhalla en " + valhalla.getType();
      s += ". Invoque " + valhalla.getBarbares() + " barbares niveau " + valhalla.getNiveau();
      s += ". Condition : " + valhalla.getCond();
      merveilleux.setObjet(s);
    } else if (Objects.equals(merveilleux.getObjet(), "Flasque de fer")) {
      MerveilleuxFlasque flasque = merveilleuxFlasqueRepository.findRandom(roll100());
      merveilleux.setObjet("Flasque de fer (" + flasque.getContenu() + ")");
    }
    return merveilleux.getObjet() + " (" + merveilleux.getPrix() + "po)";
  }

  public String generatePotionHuile(String puissance) {
    PotionEtHuile potionEtHuile = potionEtHuileRepository.findRandomByPuissance(puissance, roll100());
    return potionEtHuile.getPotion() + " (" + potionEtHuile.getPrix() + "po)";
  }


  public String generateSceptre(String puissance) {
    Sceptre sceptre = sceptreRepository.findRandomByPuissance(puissance, roll100());
    return "Sceptre " + sceptre.getSceptre() + " (" + sceptre.getPrix() + "po)";
  }
}
