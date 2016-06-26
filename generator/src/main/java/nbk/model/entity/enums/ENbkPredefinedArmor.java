package nbk.model.entity.enums;

import commons.model.entity.enums.EMagic;
import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.HasMagic;
import commons.model.entity.utils.ItemType;
import commons.model.entity.utils.ItemTypeBuilder;
import commons.utils.MathUtils;
import nbk.model.entity.utils.BodyPartBuilder;
import nbk.model.entity.utils.HasSize;
import nbk.model.entity.utils.HasWeight;
import nbk.model.entity.utils.IsBodyPart;
import nbk.model.entity.utils.MagicBuilder;
import nbk.model.entity.utils.SizeBuilder;
import nbk.model.entity.utils.WeightBuilder;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 26/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkPredefinedArmor implements ItemType<String>, HasMagic, HasWeight, IsBodyPart, HasSize {
  GAMBISON_BASE(new ENbkPredefinedArmorBuilder()
          .setNames("Gambison de base avec manches")
          .setBodyParts(EBodyPart.TORSO, EBodyPart.ARMS)),
  VESTE_BASE(new ENbkPredefinedArmorBuilder()
          .setNames("Veste toile renforcée avec manches")
          .setBodyParts(EBodyPart.TORSO, EBodyPart.ARMS)),
  GAMBISON_CORRECT(new ENbkPredefinedArmorBuilder()
          .setNames("Gambison correct avec manches")
          .setBodyParts(EBodyPart.TORSO, EBodyPart.ARMS)),
  VESTE_VOLEUR(new ENbkPredefinedArmorBuilder()
          .setNames("Veste toile renforcée noire, pour voleur")
          .uncommon()
          .setBodyParts(EBodyPart.TORSO, EBodyPart.ARMS));

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

    List<String> names = new LinkedList<>();
    ERarity rarity;
    EMagic magic = EMagic.NOPE;
    EnumSet<EBodyPart> bodyParts;
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
    public ENbkPredefinedArmorBuilder setBodyParts(EBodyPart first, EBodyPart... others) {
      bodyParts = EnumSet.of(first, others);
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
