package dd.model.entity.items.treasure.enums;

import commons.model.dice.Dice;
import commons.model.entity.characteristics.primary.CustomRarity;
import commons.utils.MathUtils;
import dd.model.entity.items.characteristics.builders.DDItemTypeBuilder;
import dd.model.entity.items.characteristics.fields.DDItemType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 29/10/2016.
 */
@SuppressWarnings({"HardCodedStringLiteral", "SpellCheckingInspection"})
public enum EDDGem implements DDItemType {

  GEM1(new GemBuilder()
      .setNames("agate rubanée", "agate iris", "agate de feu", "agate-mousse", "agate oeil-de-tigre", "azurite",
          "couronne d'argent", "fluorite", "hématite", "ivoire", "lapis-lazuli", "malachite", "nelvine", "néphrite",
          "obsidienne", "perle irrégulièré", "quartz bleu", "quartz laiteux", "rhodochrosite", "sanidine", "turquoise",
          "violine")
      .setRarity(new CustomRarity(25))
      .setValue(new Dice(4, 4), " po")
  ),
  GEM2(new GemBuilder()
      .setNames("andar", "aventurine", "calcédoine", "chrysoprase", "citrine", "cornaline", "héliotrope", "hydrophane",
          "iole", "iolite", "irtios", "jaspe", "onyx", "orprase", "péridot", "phénalope", "pierre de lune",
          "quartz cristal de roche", "quartz rose", "quartz fumé", "sardoine", "sardonyx", "spodumène", "tchazar",
          "zircon")
      .setRarity(new CustomRarity(25))
      .setValue(new Dice(2, 4), "0 po")
  ),
  GEM3(new GemBuilder()
      .setNames("ambre", "améthyste", "chrysobéryl", "coral", "étoile d'eau", "grenat rouge", "grenat vert sombre",
          "jade", "jais", "larmes de Laérale", "peau d'ange", "perle dorée", "perle rose", "perle argentée",
          "perle blanche", "spinelle rouge", "spinelle rouge sombre", "spinelle vert sombre", "tourmaline blanche",
          "tourmaline dorée", "tourmaline rose", "tourmaline perle d'argent")
      .setRarity(new CustomRarity(20))
      .setValue(new Dice(4, 4), "0 po")
  ),
  GEM4(new GemBuilder()
      .setNames("aigue-marine", "alexandrite", "grenat violet", "perle noire", "spinelle bleu nuit", "topaze jaune d'or")
      .setRarity(new CustomRarity(20))
      .setValue(new Dice(2, 4), "00 po")
  ),
  GEM5(new GemBuilder()
      .setNames("corbinare", "corindon jaune ambré", "corindon pourpre", "corindon noir", "corindon bleu", "émeraude",
          "jade de sépulcre", "larmes rouges", "opale blanche", "opale noire", "opale de feu", "opale d'eau", "orle",
          "rubis étoilé", "saphir", "saphir étoilé noir", "saphir étoilé bleu")
      .setRarity(new CustomRarity(9))
      .setValue(new Dice(4, 4), "00 po")
  ),
  GEM6(new GemBuilder()
      .setNames("belurile", "diamant limpide", "diamant jaune", "diamant rose", "diamant brun", "diamant bleu",
          "émeraude du vert le plus clair", "hyacynthe", "larmes de roi", "rubis")
      .setRarity(new CustomRarity(1))
      .setValue(new Dice(2, 4), "000 po")
  );

  private final List<String> names;
  private final CustomRarity rarity;
  private final Dice diceValue;
  private final String coinValue;

  EDDGem(GemBuilder builder) {
    names = builder.names;
    rarity = builder.rarity;
    diceValue = builder.diceValue;
    coinValue = builder.coinValue;
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

  private static class GemBuilder implements DDItemTypeBuilder<GemBuilder> {

    final List<String> names = new LinkedList<>();
    CustomRarity rarity;
    Dice diceValue;
    String coinValue;

    @Override
    public GemBuilder setNames(String first, String... others) {
      names.add(first);
      Collections.addAll(names, others);
      return this;
    }

    @Override
    public GemBuilder setRarity(CustomRarity rarity) {
      this.rarity = rarity;
      return this;
    }

    @Override
    public GemBuilder setValue(Dice diceValue, String coinValue) {
      this.diceValue = diceValue;
      this.coinValue = coinValue;
      return this;
    }
  }
}
