package generator.controller;

import commons.model.dice.Dice;
import generator.model.entity.Parchemin;
import generator.model.entity.ParcheminNiveauSort;
import generator.model.repository.ParcheminNiveauSortRepository;
import generator.model.repository.ParcheminNombreSortRepository;
import generator.model.repository.ParcheminRepository;
import generator.model.repository.TypeParcheminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Germain on 25/06/2017.
 */
@SuppressWarnings("SpellCheckingInspection")
@Service
public class ParcheminController extends AbstractController {

  private final ParcheminRepository parcheminRepository;
  private final ParcheminNiveauSortRepository parcheminNiveauSortRepository;
  private final ParcheminNombreSortRepository parcheminNombreSortRepository;
  private final TypeParcheminRepository typeParcheminRepository;

  @Autowired
  public ParcheminController(ParcheminRepository parcheminRepository,
                             ParcheminNiveauSortRepository parcheminNiveauSortRepository,
                             ParcheminNombreSortRepository parcheminNombreSortRepository,
                             TypeParcheminRepository typeParcheminRepository) {
    this.parcheminRepository = parcheminRepository;
    this.parcheminNiveauSortRepository = parcheminNiveauSortRepository;
    this.parcheminNombreSortRepository = parcheminNombreSortRepository;
    this.typeParcheminRepository = typeParcheminRepository;
  }

  public String generate(String puissance) {
    String type = typeParcheminRepository.findRandom(roll100()).getType();
    String nombreSort = parcheminNombreSortRepository.findFirstByPuissance(puissance).getNombre();
    int nb = Dice.getRollFromString(nombreSort).orElse(1);
    ParcheminNiveauSort parcheminNiveauSort = parcheminNiveauSortRepository.findRandomByPuissance(puissance, roll100());
    int niveauSort = parcheminNiveauSort.getNiveauSort();
    int niveauLanceur = parcheminNiveauSort.getNiveauLanceur();
    List<Parchemin> parchemins = IntStream.rangeClosed(1, nb).boxed()
        .map(i -> parcheminRepository.findParchemin(type, niveauSort, roll100()))
        .collect(Collectors.toList());
    String s = "Parchemin (sorts niveau " + niveauSort + ", lanceur niveau " + niveauLanceur + "): ";
    s += parchemins.stream().map(Parchemin::getSort).collect(Collectors.joining(", "));
    s += " (" + parchemins.stream().mapToInt(p -> p.getPrix().intValue()).sum() + "po)";
    return s;
  }
}
