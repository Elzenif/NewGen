package dd.model.entity.items.treasures.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import commons.utils.MathUtils;
import dd.model.entity.items.characteristics.builders.DDOneRarityItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDOneRarityItemType;

import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EDDGem implements DDOneRarityItemType {

  GEM1(new DDOneRarityItemTypeBuilder()
      .setNames("agate rubanée", "agate iris", "agate de feu", "agate-mousse", "agate oeil-de-tigre", "azurite",
          "couronne d'argent", "fluorite", "hématite", "ivoire", "lapis-lazuli", "malachite", "nelvine", "néphrite",
          "obsidienne", "perle irrégulièré", "quartz bleu", "quartz laiteux", "rhodochrosite", "sanidine", "turquoise",
          "violine")
      .setRarity(new CustomRarity(25))
      .setDiceValue(new Dice(4, 4))
      .setCoinValue(" po")
  ),
  GEM2(new DDOneRarityItemTypeBuilder()
      .setNames("andar", "aventurine", "calcédoine", "chrysoprase", "citrine", "cornaline", "héliotrope", "hydrophane",
          "iole", "iolite", "irtios", "jaspe", "onyx", "orprase", "péridot", "phénalope", "pierre de lune",
          "quartz cristal de roche", "quartz rose", "quartz fumé", "sardoine", "sardonyx", "spodumène", "tchazar",
          "zircon")
      .setRarity(new CustomRarity(25))
      .setDiceValue(new Dice(2, 4))
      .setCoinValue("0 po")
  ),
  GEM3(new DDOneRarityItemTypeBuilder()
      .setNames("ambre", "améthyste", "chrysobéryl", "coral", "étoile d'eau", "grenat rouge", "grenat vert sombre",
          "jade", "jais", "larmes de Laérale", "peau d'ange", "perle dorée", "perle rose", "perle argentée",
          "perle blanche", "spinelle rouge", "spinelle rouge sombre", "spinelle vert sombre", "tourmaline blanche",
          "tourmaline dorée", "tourmaline rose", "tourmaline perle d'argent")
      .setRarity(new CustomRarity(20))
      .setDiceValue(new Dice(4, 4))
      .setCoinValue("0 po")
  ),
  GEM4(new DDOneRarityItemTypeBuilder()
      .setNames("aigue-marine", "alexandrite", "grenat violet", "perle noire", "spinelle bleu nuit", "topaze jaune d'or")
      .setRarity(new CustomRarity(20))
      .setDiceValue(new Dice(2, 4))
      .setCoinValue("00 po")
  ),
  GEM5(new DDOneRarityItemTypeBuilder()
      .setNames("corbinare", "corindon jaune ambré", "corindon pourpre", "corindon noir", "corindon bleu", "émeraude",
          "jade de sépulcre", "larmes rouges", "opale blanche", "opale noire", "opale de feu", "opale d'eau", "orle",
          "rubis étoilé", "saphir", "saphir étoilé noir", "saphir étoilé bleu")
      .setRarity(new CustomRarity(9))
      .setDiceValue(new Dice(4, 4))
      .setCoinValue("00 po")
  ),
  GEM6(new DDOneRarityItemTypeBuilder()
      .setNames("belurile", "diamant limpide", "diamant jaune", "diamant rose", "diamant brun", "diamant bleu",
          "émeraude du vert le plus clair", "hyacynthe", "larmes de roi", "rubis")
      .setRarity(new CustomRarity(1))
      .setDiceValue(new Dice(2, 4))
      .setCoinValue("000 po")
  );

  private final List<String> names;
  private final CustomRarity rarity;
  private final Dice diceValue;
  private final String coinValue;

  EDDGem(DDOneRarityItemTypeBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    diceValue = builder.getDiceValue();
    coinValue = builder.getCoinValue();
  }

  @Override
  public String getName() {
    return MathUtils.chooseRandom(names);
  }

  @Override
  public CustomRarity getRarity() {
    return rarity;
  }

  @Override
  public String getValue() {
    diceValue.roll();
    return diceValue.getScore() + coinValue;
  }
}
