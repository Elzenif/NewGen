package nbk.model.entity.characteristics.secondary.enums;

import commons.model.entity.characteristics.primary.builders.ItemTypeBuilder;
import commons.model.entity.characteristics.primary.builders.MagicBuilder;
import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.characteristics.primary.enums.ERarity;
import commons.model.entity.characteristics.primary.fields.HasMagic;
import commons.model.entity.characteristics.primary.fields.ItemType;
import commons.utils.MathUtils;
import nbk.model.entity.characteristics.primary.builders.BodyPartBuilder;
import nbk.model.entity.characteristics.primary.builders.SizeBuilder;
import nbk.model.entity.characteristics.primary.builders.WeightBuilder;
import nbk.model.entity.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.characteristics.primary.enums.ESize;
import nbk.model.entity.characteristics.primary.enums.EWeight;
import nbk.model.entity.characteristics.primary.fields.HasSize;
import nbk.model.entity.characteristics.primary.fields.HasWeight;
import nbk.model.entity.characteristics.primary.fields.IsBodyPart;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 26/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkPredefinedArmor implements ItemType<String>, HasMagic, HasWeight, IsBodyPart, HasSize {
  // Vestes
  GAMBISON_BASE(new ENbkPredefinedArmorBuilder()
          .setNames("Gambison de base avec manches")
          .common()
          .torsoPart().armsPart()),
  VESTE_BASE(new ENbkPredefinedArmorBuilder()
          .setNames("Veste toile renforcée avec manches")
          .common()
          .torsoPart().armsPart()),
  GAMBISON_CORRECT(new ENbkPredefinedArmorBuilder()
          .setNames("Gambison correct avec manches")
          .common()
          .torsoPart().armsPart()),
  VESTE_VOLEUR(new ENbkPredefinedArmorBuilder()
          .setNames("Veste toile renforcée noire, pour voleur")
          .uncommon()
          .torsoPart().armsPart()),
  // Plastrons cuir
  PLASTRON_CUIR_BASE(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron de cuir de base")
          .common()
          .torsoPart()),
  PLASTRON_CUIR_CORRECT(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron de cuir bouilli correct")
          .common()
          .torsoPart()),
  PLASTRON_CUIR_MOULE(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron de cuir moulé sur mesure")
          .uncommon()
          .torsoPart()),
  PLASTRON_CUIR_METAL(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron de cuir renforcé métal")
          .uncommon()
          .torsoPart()
          .heavyWeight()),
  PLASTRON_CUIR_LUXE(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron de cuir luxe (renforcé métal et décoré)")
          .rare()
          .torsoPart()
          .heavyWeight()),
  PLASTRON_CUIR_LUXE2(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron de cuir luxe +2 force (ench base 3)")
          .epic()
          .isMagic()
          .torsoPart()),
  PLASTRON_CUIR_ELFE(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron de cuir luxe Haut-Elfe +4 (ench base 3)")
          .legendary()
          .isMagic()
          .torsoPart()),
  // Plastrons métal
  PLASTRON_METAL_LOURD(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron métal, lourd et grossier")
          .uncommon()
          .torsoPart()
          .heavyWeight()),
  PLASTRON_METAL_LEGER(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron métal léger")
          .rare()
          .torsoPart()
          .heavyWeight()),
  PLASTRON_METAL_LUXE(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron métal luxe (artisan nain)")
          .epic()
          .torsoPart()
          .heavyWeight()),
  PLASTRON_METAL_LUXE2(new ENbkPredefinedArmorBuilder()
          .setNames("Plastron métal luxe +2 force (ench base 4)")
          .legendary()
          .isMagic()
          .torsoPart()
          .heavyWeight()),
  // Accessoires métal
  JAMBIERES_METAL_lOURDES(new ENbkPredefinedArmorBuilder()
          .setNames("Jambières métal, lourdes et grossières")
          .uncommon()
          .legsPart()
          .heavyWeight()),
  JAMBIERES_METAL_LEGERES(new ENbkPredefinedArmorBuilder()
          .setNames("Jambières métal légères")
          .rare()
          .legsPart()
          .heavyWeight()),
  JAMBIERES_METAL_LUXE(new ENbkPredefinedArmorBuilder()
          .setNames("Jambières métal luxe (artisan nain)")
          .epic()
          .legsPart()
          .heavyWeight()),
  JAMBIERES_METAL_LUXE1(new ENbkPredefinedArmorBuilder()
          .setNames("Jambières métal +1 dex")
          .legendary()
          .isMagic()
          .legsPart()
          .heavyWeight()),
  JAMBIERES_METAL_PROTECTOR(new ENbkPredefinedArmorBuilder()
          .setNames("Jambières métal luxe Protector(TM) (ench base 1)")
          .legendary()
          .isMagic()
          .legsPart()
          .heavyWeight());

  private final List<String> names;
  private final ERarity rarity;
  private final EMagic magic;
  private final EnumSet<EBodyPart> bodyParts;
  private final EWeight weight;
  private final ESize size;

  ENbkPredefinedArmor(ENbkPredefinedArmorBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    magic = builder.getMagic();
    bodyParts = builder.getBodyParts();
    weight = builder.getWeight();
    size = builder.getSize();
  }

  @Override
  public String getName() {
    return MathUtils.chooseRandom(names);
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  @Override
  public EMagic getMagic() {
    return magic;
  }

  @Override
  public EnumSet<EBodyPart> getBodyParts() {
    return bodyParts;
  }

  @Override
  public EWeight getWeight() {
    return weight;
  }

  @Override
  public ESize getSize() {
    return size;
  }

  private static class ENbkPredefinedArmorBuilder implements ItemTypeBuilder, MagicBuilder, WeightBuilder,
          BodyPartBuilder, SizeBuilder {

    final List<String> names = new LinkedList<>();
    ERarity rarity;
    EMagic magic = EMagic.NOPE;
    final EnumSet<EBodyPart> bodyParts = EnumSet.noneOf(EBodyPart.class);
    EWeight weight = EWeight.NORMAL;
    ESize size = ESize.NORMAL;

    @Override
    public ENbkPredefinedArmorBuilder setNames(Object first, Object... others) {
      names.add((String) first);
      for (Object name : others) {
        names.add((String) name);
      }
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder common() {
      rarity = ERarity.COMMON;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder uncommon() {
      rarity = ERarity.UNCOMMON;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder rare() {
      rarity = ERarity.RARE;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder epic() {
      rarity = ERarity.EPIC;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder legendary() {
      rarity = ERarity.LEGENDARY;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder isMagic() {
      magic = EMagic.MAGIC;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder isRelic() {
      magic = EMagic.RELIC;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder headPart() {
      bodyParts.add(EBodyPart.HEAD);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder torsoPart() {
      bodyParts.add(EBodyPart.TORSO);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder armsPart() {
      bodyParts.add(EBodyPart.ARMS);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder legsPart() {
      bodyParts.add(EBodyPart.LEGS);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder forearmsPart() {
      bodyParts.add(EBodyPart.FOREARMS);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder handsPart() {
      bodyParts.add(EBodyPart.HANDS);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder feetPart() {
      bodyParts.add(EBodyPart.FEET);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder shieldPart() {
      bodyParts.add(EBodyPart.SHIELD);
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder lightWeight() {
      weight = EWeight.LIGHT;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder heavyWeight() {
      weight = EWeight.HEAVY;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder smallSize() {
      size = ESize.SMALL;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder largeSize() {
      size = ESize.LARGE;
      return this;
    }

    @Override
    public List<String> getNames() {
      return names;
    }

    @Override
    public ERarity getRarity() {
      return rarity;
    }

    @Override
    public EMagic getMagic() {
      return magic;
    }

    @Override
    public EnumSet<EBodyPart> getBodyParts() {
      return bodyParts;
    }

    @Override
    public EWeight getWeight() {
      return weight;
    }

    @Override
    public ESize getSize() {
      return size;
    }
  }
}
