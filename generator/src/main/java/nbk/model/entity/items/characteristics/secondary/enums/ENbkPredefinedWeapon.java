package nbk.model.entity.items.characteristics.secondary.enums;

import commons.model.entity.characteristics.primary.builders.ItemTypeBuilder;
import commons.model.entity.characteristics.primary.builders.MagicBuilder;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.characteristics.primary.enums.EMagic;
import commons.model.entity.characteristics.primary.fields.EntityType;
import commons.model.entity.characteristics.primary.fields.HasMagic;
import commons.model.entity.characteristics.secondary.Secondary;
import commons.model.entity.constraints.Constraints;
import commons.model.entity.constraints.GlobalConstraints;
import commons.utils.MathUtils;
import nbk.model.commons.characteristics.primary.enums.ESize;
import nbk.model.commons.characteristics.primary.fields.HasSize;
import nbk.model.entity.items.characteristics.primary.enums.ENbHands;
import nbk.model.entity.items.characteristics.primary.enums.ERange;
import nbk.model.entity.items.characteristics.primary.fields.HasNbHands;
import nbk.model.entity.items.characteristics.primary.fields.HasRange;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Germain on 23/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkPredefinedWeapon implements Secondary, EntityType<String>, HasMagic, HasRange, HasNbHands, HasSize {
  // Récupération
  GOURDIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Bonne branche", "Gourdin", "Pied de chaise")
          .common()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  BRANCHE(new ENbkPredefinedWeaponBuilder()
          .setNames("Branche moisie", "Manche de pioche")
          .common()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  CHAISE(new ENbkPredefinedWeaponBuilder()
          .setNames("Chaise", "Tabouret")
          .common()
          .setWeaponType(ENbkWeaponType.MARTEAU_2MAINS)),
  CHANDELIER(new ENbkPredefinedWeaponBuilder()
          .setNames("Chandelier du Colonel Moutarde")
          .uncommon()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  TISONNIER(new ENbkPredefinedWeaponBuilder()
          .setNames("Tisonnier", "Tisonnier chauffé au rouge")
          .common()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  // Lames courtes
  COUTEAU_DE_POCHE(new ENbkPredefinedWeaponBuilder()
          .setNames("Couteau de poche du grand-père", "Couteau de qualité")
          .common()
          .setWeaponType(ENbkWeaponType.LAME_COURTE)),
  POIGNARD_MIRFILU(new ENbkPredefinedWeaponBuilder()
          .setNames("Poignard d'Excellence de Mirfilu")
          .epic()
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  POIGNARD_XELOSS(new ENbkPredefinedWeaponBuilder()
          .setNames("Poignard sacrificiel de Xeloss")
          .epic()
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  DAGUE_TZINNTCH(new ENbkPredefinedWeaponBuilder()
          .setNames("Dague de Tzinntch")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  DAGUE_ELFIQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Dague elfique des temps anciens")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  // Lames 1 main
  RAPIERE_NOBLE(new ENbkPredefinedWeaponBuilder()
          .setNames("Rapière de noble pour frimer, poignée plaquée or")
          .epic()
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)),
  LAME_GLONZG(new ENbkPredefinedWeaponBuilder()
          .setNames("Lame d'excellence de Glonzg")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)
          .isMagic()),
  SABRE_GUY(new ENbkPredefinedWeaponBuilder()
          .setNames("Sabre de Guy le Batailleur")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)
          .isRelic()),
  SABRE_TRITHIL(new ENbkPredefinedWeaponBuilder()
          .setNames("Sabre en Trithil de Blaidh le Diurnambule")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)),
  // Lames 2 mains
  CLAYMORE_WALLACE(new ENbkPredefinedWeaponBuilder()
          .setNames("Grande Claymore de Wallace")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)),
  EVENTREUSE(new ENbkPredefinedWeaponBuilder()
          .setNames("Eventreuse de Kjeulien-la-mule")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isRelic()),
  EPEE_JUSTICE(new ENbkPredefinedWeaponBuilder()
          .setNames("Epée de justice Légendaire de Braav'")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isMagic()),
  EPEE_VORPALE(new ENbkPredefinedWeaponBuilder()
          .setNames("Epée vorpale +3")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isMagic()),
  EPEE_RUNIQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Epée runique +8 Souldrinker")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isMagic()),
  // Haches 1 main
  HACHE_NAIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache 1 main artisan Nain")
          .rare()
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)),
  HACHE_DECAPITATION(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de décapitation des Orcs")
          .epic()
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  HACHE_NIOURGL(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache des Puruls de Niourgl")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  HACHE_GOLTOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Goltor")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isRelic()),
  HACHE_KHORNETTOH(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Démembreuse de Khornettoh")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  HACHE_BLIZZARD(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Miraculeuse du Blizzard")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  // Haches de jet
  HACHE_PIRATE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de jet des piates mauves")
          .rare()
          .setWeaponType(ENbkWeaponType.HACHE_JET)),
  HACHE_FORGERON(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Jet du Grand Forgeron")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_JET)
          .isRelic()),
  // Haches 2 mains
  HACHE_CIMERIENNE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de combat cimérienne à double affûtage")
          .rare()
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_MORIAQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Marave Moriaque")
          .epic()
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_BERSERKERS(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Monstrueuse des Bersekers")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_SYLDERIENNE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Bataille Syldérienne")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_FEU(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Feu de Blizdand")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)
          .isMagic()),
  HACHE_DEMON(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Démoniaque de Makkedoh")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)
          .isRelic()),
  HACHE_ANNIHILATION(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache d'Annihilation de Nyarlapalathep")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)
          .isMagic()),
  // Marteaux 1 main
  MARTEAU_NAIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau d'artisan nain", "Masse d'artisan nain")
          .rare()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  MASSE_PAF(new ENbkPredefinedWeaponBuilder()
          .setNames("Masse PAF(TM)")
          .epic()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  MASSE_SLANOUSH(new ENbkPredefinedWeaponBuilder()
          .setNames("Masse du Destin de Slanoush")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isMagic()),
  MARTEAU_SKELOSS(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau d'anesthésie de Skeloss")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isMagic()),
  MARTEAU_PERES(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau des Pères Speteurs")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isRelic()),
  MARTEAU_JAMBFER(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau Légendaire de Jambfer")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isRelic()),
  MARTEAU_NIOURGL(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau Putréfiant de Niourgl")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isMagic()),
  // Marteaux 2 mains
  MARTEAU_SYLDERIEN(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau de Guerre Syldérien")
          .rare()
          .setWeaponType(ENbkWeaponType.MARTEAU_2MAINS)),
  MARTEAU_MORIAC(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau de Baston des Moriacs")
          .epic()
          .setWeaponType(ENbkWeaponType.MARTEAU_2MAINS)),
  GURSTAKER(new ENbkPredefinedWeaponBuilder()
          .setNames("Gurstaker")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_2MAINS)
          .isRelic()),
  // Lances
  LANCE_DROW(new ENbkPredefinedWeaponBuilder()
          .setNames("Lance de Bataille des Drows")
          .rare()
          .setWeaponType(ENbkWeaponType.LANCE)),
  LANCE_GZOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Lance Barbelée des troupes de Gzor")
          .rare()
          .setWeaponType(ENbkWeaponType.LANCE)),
  PIQUE_KOLEGRAM(new ENbkPredefinedWeaponBuilder()
          .setNames("Pique Légendaire de Kolegram")
          .legendary()
          .setWeaponType(ENbkWeaponType.LANCE)),
  HALLEBARDE_GEANTS(new ENbkPredefinedWeaponBuilder()
          .setNames("Hallebarde des Tueurs de Géants")
          .epic()
          .setWeaponType(ENbkWeaponType.LANCE)),
  TRIDENT_KJANIOUF(new ENbkPredefinedWeaponBuilder()
          .setNames("Trident de Kjaniouf")
          .rare()
          .setWeaponType(ENbkWeaponType.LANCE)),
  // Javelots
  JAVELOT_MORIAQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Javelot de chasse des Moriaques")
          .rare()
          .setWeaponType(ENbkWeaponType.JAVELOT)),
  JAVELOT_TANGO(new ENbkPredefinedWeaponBuilder()
          .setNames("Javelot du Tangorodrigue")
          .legendary()
          .setWeaponType(ENbkWeaponType.JAVELOT)
          .isRelic()),
  // Arcs
  ARC_SYLVAIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc composite d'elfe sylvain (imitation)")
          .uncommon()
          .setWeaponType(ENbkWeaponType.ARC_COURT)),
  ARC_DROW(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc long des Drows")
          .rare()
          .setWeaponType(ENbkWeaponType.ARC_LONG)),
  ARC_LUNELBAR(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc Ouvragé des Lunelbar")
          .rare()
          .setWeaponType(ENbkWeaponType.ARC_LONG)),
  ARC_MEULDOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc des Meuldors")
          .epic()
          .setWeaponType(ENbkWeaponType.ARC_LONG)),
  ARC_SOLIDE(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc solide d'Unrienmörn")
          .epic()
          .setWeaponType(ENbkWeaponType.ARC_COURT)),
  ARC_SYLVAIN_VERITABLE(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc composite d'elfe sylvain (véritable)")
          .legendary()
          .setWeaponType(ENbkWeaponType.ARC_LONG)),
  ARC_YEMISOLD(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc long de Yemisold")
          .legendary()
          .setWeaponType(ENbkWeaponType.ARC_LONG)
          .isMagic()),
  ARC_SYLDERIEN(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc de puissance des Syldériens")
          .legendary()
          .setWeaponType(ENbkWeaponType.ARC_LONG)),
  // Flèches
  FLECHE_MAUVE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Mauve des pirates")
          .uncommon()
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_DROW(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Noire des Drows")
          .uncommon()
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_MEURTRIERE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche d'elfe sylvain \"La Meutrière\"(TM)")
          .uncommon()
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_AGILE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche d'elfe sylvain \"L'Agile\"(TM)")
          .uncommon()
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_OGRE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Barbelée des Ogres Chasseurs")
          .rare()
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_FEU(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche de Blazing Fire")
          .rare()
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_DLUL(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Hypodermique de Dlul")
          .epic()
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_SLANOUSH(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Lubrique de Slanoush")
          .legendary()
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_THOLSADUM(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Ophidienne de Tholsadüm")
          .legendary()
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_KHORNETTOH(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Malveillante de Khornettoh")
          .legendary()
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  // Arbalète
  ARBALETE_GOBELIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète de gobelin")
          .uncommon()
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  ARBALETE_FRIMEUR(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète de Luxe pour frimeur")
          .rare()
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  ARBALETE_GZURULIA(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète Sauvage de Gzurulia")
          .epic()
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  ARBALETE_VONTORZ(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète double de Vontorz")
          .legendary()
          .setWeaponType(ENbkWeaponType.ARBALETE)
          .isRelic()),
  // Carreaux
  CARREAU_DLUL(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau de Dlul")
          .epic()
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  CARREAU_SLANOUSH(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau Vicelard de Slanoush")
          .legendary()
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  CARREAU_GZOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau Maudit des troupes de Gzor")
          .legendary()
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  CARREAU_KHORNETTOH(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau d'Assaut de Khornettoh")
          .legendary()
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  // Armes bizarres
  SARBACANE(new ENbkPredefinedWeaponBuilder()
          .setNames("Sarbacane")
          .uncommon()
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  NUNCHAKU(new ENbkPredefinedWeaponBuilder()
          .setNames("Nunchaku", "Nunchaku de Brouzli")
          .rare()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  FLEAU_MORIAC(new ENbkPredefinedWeaponBuilder()
          .setNames("Fléau Bourrinant des Moriacs")
          .epic()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)),
  LANCE_PIERRE(new ENbkPredefinedWeaponBuilder()
          .setNames("Lance-pierre Mythique D'hyshoul")
          .epic()
          .setWeaponType(ENbkWeaponType.HACHE_JET)
          .isRelic()),
  FAUCILLE_NIOURLG(new ENbkPredefinedWeaponBuilder()
          .setNames("Faucille Démentielle de Niourgl")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_COURTE)),
  BOOMERANG(new ENbkPredefinedWeaponBuilder()
          .setNames("Boomerang Stupéfiant de Mike Dundee")
          .legendary()
          .setWeaponType(ENbkWeaponType.HACHE_JET)),
  COUPERET(new ENbkPredefinedWeaponBuilder()
          .setNames("Couperet du Bourreau Velu D'Ukkuh")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isRelic()),
  FLAGELLATEUR(new ENbkPredefinedWeaponBuilder()
          .setNames("Flagellateur d'Oboulos")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  TRIPLE_FOUET(new ENbkPredefinedWeaponBuilder()
          .setNames("Triple Fouet des Lamentations de Slanoush")
          .legendary()
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  DOUBLES_SERRES(new ENbkPredefinedWeaponBuilder()
          .setNames("Doubles Serres du Moine Tatoncouto")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isRelic()),
  FAUX(new ENbkPredefinedWeaponBuilder()
          .setNames("Faux Léthale de Tormentor")
          .legendary()
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isRelic());

  private static final Constraints<ENbkPredefinedWeapon> CONSTRAINTS = Constraints.ConstraintsBuilder
      .<ENbkPredefinedWeapon>start()
      .setSecondaryClass(ENbkPredefinedWeapon.class)
      .setPrimaryClasses(EItemRarity.class)
      .build();
  private final List<String> names;
  private final EItemRarity rarity;
  private final ENbkWeaponType weaponType;
  private final EMagic magic;

  ENbkPredefinedWeapon(ENbkPredefinedWeaponBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    weaponType = builder.getWeaponType();
    magic = builder.getMagic();
  }

  public static Constraints<ENbkPredefinedWeapon> getConstraints() {
    return CONSTRAINTS;
  }

  @NotNull
  public static Predicate<ENbkPredefinedWeapon> getPredicate(GlobalConstraints globalConstraints) {
    Predicate<EItemRarity> rarityPredicate = globalConstraints.getPredicate(CONSTRAINTS, EItemRarity.class);
    Predicate<ENbkWeaponType> weaponTypePredicate = ENbkWeaponType.getPredicate(globalConstraints);
    return weapon -> rarityPredicate.test(weapon.getRarity())
        && weaponTypePredicate.test(weapon.getWeaponType());
  }

  @Override
  public String getName() {
    return MathUtils.chooseRandom(names);
  }

  @Override
  public EItemRarity getRarity() {
    return rarity;
  }

  public ENbkWeaponType getWeaponType() {
    return weaponType;
  }

  @Override
  public EMagic getMagic() {
    return magic;
  }

  @Override
  public ERange getRange() { return weaponType.getRange(); }

  @Override
  public ENbHands getNbHands() { return weaponType.getNbHands(); }

  @Override
  public ESize getSize() { return weaponType.getSize(); }

  private static class ENbkPredefinedWeaponBuilder implements ItemTypeBuilder, MagicBuilder {

    final List<String> names = new LinkedList<>();
    EItemRarity rarity;
    ENbkWeaponType weaponType;
    EMagic magic = EMagic.NOPE;

    @Override
    public ENbkPredefinedWeaponBuilder setNames(Object first, Object... others) {
      names.add((String) first);
      for (Object name : others) {
        names.add((String) name);
      }
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder common() {
      this.rarity = EItemRarity.COMMON;
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder uncommon() {
      this.rarity = EItemRarity.UNCOMMON;
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder rare() {
      this.rarity = EItemRarity.RARE;
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder epic() {
      this.rarity = EItemRarity.EPIC;
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder legendary() {
      this.rarity = EItemRarity.LEGENDARY;
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder isMagic() {
      magic = EMagic.MAGIC;
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder isRelic() {
      magic = EMagic.RELIC;
      return this;
    }

    @Override
    public List<String> getNames() {
      return names;
    }

    @Override
    public EItemRarity getRarity() {
      return rarity;
    }

    ENbkWeaponType getWeaponType() {
      return weaponType;
    }

    ENbkPredefinedWeaponBuilder setWeaponType(ENbkWeaponType weaponType) {
      this.weaponType = weaponType;
      return this;
    }

    @Override
    public EMagic getMagic() {
      return magic;
    }
  }
}
