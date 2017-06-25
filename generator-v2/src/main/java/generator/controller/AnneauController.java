package generator.controller;

import commons.utils.MathUtils;
import generator.model.entity.Anneau;
import generator.model.repository.AnneauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Germain on 30/05/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class AnneauController {

  private final AnneauRepository anneauRepository;

  @Autowired
  public AnneauController(AnneauRepository anneauRepository) {
    this.anneauRepository = anneauRepository;
  }

  public String generate(String puissance) {
    int r1 = MathUtils.random(1, 100);
    Anneau anneau = anneauRepository.findRandomByPuissance(puissance, r1);
    return "Anneau " + anneau.getNom() +
        (anneau.getModificateur() == null ? "" : " +" + anneau.getModificateur()) +
        " (" + anneau.getPrix() + ")";
  }
}
