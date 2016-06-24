package nbk.model.entity.enums;

import commons.model.entity.enums.EMagic;
import commons.model.entity.enums.ERarity;
import commons.model.entity.utils.ItemType;
import commons.model.entity.utils.ItemTypeBuilder;
import commons.utils.MathUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 23/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkPredefinedWeapon implements ItemType<String> {
  // Récupération
  GOURDIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Bonne branche", "Gourdin", "Pied de chaise")
          .setRarity(ERarity.COMMON)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  BRANCHE(new ENbkPredefinedWeaponBuilder()
          .setNames("Branche moisie", "Manche de pioche")
          .setRarity(ERarity.COMMON)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  CHAISE(new ENbkPredefinedWeaponBuilder()
          .setNames("Chaise", "Tabouret")
          .setRarity(ERarity.COMMON)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  CHANDELIER(new ENbkPredefinedWeaponBuilder()
          .setNames("Chandelier du Colonel Moutarde")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  TISONNIER(new ENbkPredefinedWeaponBuilder()
          .setNames("Tisonnier", "Tisonnier chauffé au rouge")
          .setRarity(ERarity.COMMON)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  // Lames courtes
  COUTEAU_DE_POCHE(new ENbkPredefinedWeaponBuilder()
          .setNames("Couteau de poche du grand-père", "Couteau de qualité")
          .setRarity(ERarity.COMMON)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)),
  POIGNARD_MIRFILU(new ENbkPredefinedWeaponBuilder()
          .setNames("Poignard d'Excellence de Mirfilu")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  POIGNARD_XELOSS(new ENbkPredefinedWeaponBuilder()
          .setNames("Poignard sacrificiel de Xeloss")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  DAGUE_TZINNTCH(new ENbkPredefinedWeaponBuilder()
          .setNames("Dague de Tzinntch")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  DAGUE_ELFIQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Dague elfique des temps anciens")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isMagic()),
  // Lames 1 main
  RAPIERE_NOBLE(new ENbkPredefinedWeaponBuilder()
          .setNames("Rapière de noble pour frimer, poignée plaquée or")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)),
  LAME_GLONZG(new ENbkPredefinedWeaponBuilder()
          .setNames("Lame d'excellence de Glonzg")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)
          .isMagic()),
  SABRE_GUY(new ENbkPredefinedWeaponBuilder()
          .setNames("Sabre de Guy le Batailleur")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)
          .isRelic()),
  SABRE_TRITHIL(new ENbkPredefinedWeaponBuilder()
          .setNames("Sabre en Trithil de Blaidh le Diurnambule")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_1MAIN)),
  // Lames 2 mains
  CLAYMORE_WALLACE(new ENbkPredefinedWeaponBuilder()
          .setNames("Grande Claymore de Wallace")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)),
  EVENTREUSE(new ENbkPredefinedWeaponBuilder()
          .setNames("Eventreuse de Kjeulien-la-mule")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isRelic()),
  EPEE_JUSTICE(new ENbkPredefinedWeaponBuilder()
          .setNames("Epée de justice Légendaire de Braav'")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isMagic()),
  EPEE_VORPALE(new ENbkPredefinedWeaponBuilder()
          .setNames("Epée vorpale +3")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isMagic()),
  EPEE_RUNIQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Epée runique +8 Souldrinker")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isMagic()),
  // Haches 1 main
  HACHE_NAIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache 1 main artisan Nain")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)),
  HACHE_DECAPITATION(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de décapitation des Orcs")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  HACHE_NIOURGL(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache des Puruls de Niourgl")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  HACHE_GOLTOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Goltor")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isRelic()),
  HACHE_KHORNETTOH(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Démembreuse de Khornettoh")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  HACHE_BLIZZARD(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Miraculeuse du Blizzard")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_1MAIN)
          .isMagic()),
  // Haches de jet
  HACHE_PIRATE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de jet des piates mauves")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.HACHE_JET)),
  HACHE_FORGERON(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Jet du Grand Forgeron")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_JET)
          .isRelic()),
  // Haches 2 mains
  HACHE_CIMERIENNE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de combat cimérienne à double affûtage")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_MORIAQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Marave Moriaque")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_BERSERKERS(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Monstrueuse des Bersekers")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_SYLDERIENNE(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Bataille Syldérienne")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)),
  HACHE_FEU(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache de Feu de Blizdand")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)
          .isMagic()),
  HACHE_DEMON(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache Démoniaque de Makkedoh")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)
          .isRelic()),
  HACHE_ANNIHILATION(new ENbkPredefinedWeaponBuilder()
          .setNames("Hache d'Annihilation de Nyarlapalathep")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_2MAINS)
          .isMagic()),
  // Marteaux 1 main
  MARTEAU_NAIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau d'artisan nain", "Masse d'artisan nain")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  MASSE_PAF(new ENbkPredefinedWeaponBuilder()
          .setNames("Masse PAF(TM)")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  MASSE_SLANOUSH(new ENbkPredefinedWeaponBuilder()
          .setNames("Masse du Destin de Slanoush")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isMagic()),
  MARTEAU_SKELOSS(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau d'anesthésie de Skeloss")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isMagic()),
  MARTEAU_PERES(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau des Pères Speteurs")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isRelic()),
  MARTEAU_JAMBFER(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau Légendaire de Jambfer")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isRelic()),
  MARTEAU_NIOURGL(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau Putréfiant de Niourgl")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)
          .isMagic()),
  // Marteaux 2 mains
  MARTEAU_SYLDERIEN(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau de Guerre Syldérien")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.MARTEAU_2MAINS)),
  MARTEAU_MORIAC(new ENbkPredefinedWeaponBuilder()
          .setNames("Marteau de Baston des Moriacs")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.MARTEAU_2MAINS)),
  GURSTAKER(new ENbkPredefinedWeaponBuilder()
          .setNames("Gurstaker")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_2MAINS)
          .isRelic()),
  // Lances
  LANCE_DROW(new ENbkPredefinedWeaponBuilder()
          .setNames("Lance de Bataille des Drows")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.LANCE)),
  LANCE_GZOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Lance Barbelée des troupes de Gzor")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.LANCE)),
  PIQUE_KOLEGRAM(new ENbkPredefinedWeaponBuilder()
          .setNames("Pique Légendaire de Kolegram")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LANCE)),
  HALLEBARDE_GEANTS(new ENbkPredefinedWeaponBuilder()
          .setNames("Hallebarde des Tueurs de Géants")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.LANCE)),
  TRIDENT_KJANIOUF(new ENbkPredefinedWeaponBuilder()
          .setNames("Trident de Kjaniouf")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.LANCE)),
  // Javelots
  JAVELOT_MORIAQUE(new ENbkPredefinedWeaponBuilder()
          .setNames("Javelot de chasse des Moriaques")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.JAVELOT)),
  JAVELOT_TANGO(new ENbkPredefinedWeaponBuilder()
          .setNames("Javelot du Tangorodrigue")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.JAVELOT)
          .isRelic()),
  // Arcs
  ARC_SYLVAIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc composite d'elfe sylvain (imitation)")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.ARC)),
  ARC_DROW(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc long des Drows")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.ARC)),
  ARC_LUNELBAR(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc Ouvragé des Lunelbar")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.ARC)),
  ARC_MEULDOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc des Meuldors")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.ARC)),
  ARC_SOLIDE(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc solide d'Unrienmörn")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.ARC)),
  ARC_SYLVAIN_VERITABLE(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc composite d'elfe sylvain (véritable)")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.ARC)),
  ARC_YEMISOLD(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc long de Yemisold")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.ARC)
          .isMagic()),
  ARC_SYLDERIEN(new ENbkPredefinedWeaponBuilder()
          .setNames("Arc de puissance des Syldériens")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.ARC)),
  // Flèches
  FLECHE_MAUVE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Mauve des pirates")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_DROW(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Noire des Drows")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_MEURTRIERE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche d'elfe sylvain \"La Meutrière\"(TM)")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_AGILE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche d'elfe sylvain \"L'Agile\"(TM)")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_OGRE(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Barbelée des Ogres Chasseurs")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.FLECHE)),
  FLECHE_FEU(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche de Blazing Fire")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_DLUL(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Hypodermique de Dlul")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_SLANOUSH(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Lubrique de Slanoush")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_THOLSADUM(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Ophidienne de Tholsadüm")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  FLECHE_KHORNETTOH(new ENbkPredefinedWeaponBuilder()
          .setNames("Flèche Malveillante de Khornettoh")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.FLECHE)
          .isMagic()),
  // Arbalète
  ARBALETE_GOBELIN(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète de gobelin")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  ARBALETE_FRIMEUR(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète de Luxe pour frimeur")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  ARBALETE_GZURULIA(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète Sauvage de Gzurulia")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  ARBALETE_VONTORZ(new ENbkPredefinedWeaponBuilder()
          .setNames("Arbalète double de Vontorz")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.ARBALETE)
          .isRelic()),
  // Carreaux
  CARREAU_DLUL(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau de Dlul")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  CARREAU_SLANOUSH(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau Vicelard de Slanoush")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  CARREAU_GZOR(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau Maudit des troupes de Gzor")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  CARREAU_KHORNETTOH(new ENbkPredefinedWeaponBuilder()
          .setNames("Carreau d'Assaut de Khornettoh")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.CARREAU)
          .isMagic()),
  // Armes bizarres
  SARBACANE(new ENbkPredefinedWeaponBuilder()
          .setNames("Sarbacane")
          .setRarity(ERarity.UNCOMMON)
          .setWeaponType(ENbkWeaponType.ARBALETE)),
  NUNCHAKU(new ENbkPredefinedWeaponBuilder()
          .setNames("Nunchaku", "Nunchaku de Brouzli")
          .setRarity(ERarity.RARE)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  FLEAU_MORIAC(new ENbkPredefinedWeaponBuilder()
          .setNames("Fléau Bourrinant des Moriacs")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)),
  LANCE_PIERRE(new ENbkPredefinedWeaponBuilder()
          .setNames("Lance-pierre Mythique D'hyshoul")
          .setRarity(ERarity.EPIC)
          .setWeaponType(ENbkWeaponType.ARC)
          .isRelic()),
  FAUCILLE_NIOURLG(new ENbkPredefinedWeaponBuilder()
          .setNames("Faucille Démentielle de Niourgl")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)),
  BOOMERANG(new ENbkPredefinedWeaponBuilder()
          .setNames("Boomerang Stupéfiant de Mike Dundee")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.HACHE_JET)),
  COUPERET(new ENbkPredefinedWeaponBuilder()
          .setNames("Couperet du Bourreau Velu D'Ukkuh")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isRelic()),
  FLAGELLATEUR(new ENbkPredefinedWeaponBuilder()
          .setNames("Flagellateur d'Oboulos")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  TRIPLE_FOUET(new ENbkPredefinedWeaponBuilder()
          .setNames("Triple Fouet des Lamentations de Slanoush")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.MARTEAU_1MAIN)),
  DOUBLES_SERRES(new ENbkPredefinedWeaponBuilder()
          .setNames("Doubles Serres du Moine Tatoncouto")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_COURTE)
          .isRelic()),
  FAUX(new ENbkPredefinedWeaponBuilder()
          .setNames("Faux Léthale de Tormentor")
          .setRarity(ERarity.LEGENDARY)
          .setWeaponType(ENbkWeaponType.LAME_2MAINS)
          .isRelic());

  private final List<String> names;
  private final ERarity rarity;
  private final ENbkWeaponType weaponType;
  private final EMagic magic;

  ENbkPredefinedWeapon(ENbkPredefinedWeaponBuilder builder) {
    names = builder.getNames();
    rarity = builder.getRarity();
    weaponType = builder.getWeaponType();
    magic = builder.getMagic();
  }

  @Override
  public String getName() {
    return MathUtils.chooseRandom(names);
  }

  @Override
  public ERarity getRarity() {
    return rarity;
  }

  public ENbkWeaponType getWeaponType() {
    return weaponType;
  }

  public EMagic getMagic() {
    return magic;
  }


  private static class ENbkPredefinedWeaponBuilder implements ItemTypeBuilder {

    List<String> names = new LinkedList<>();
    ERarity rarity;
    ENbkWeaponType weaponType;
    EMagic magic = EMagic.NOPE;

    ENbkPredefinedWeaponBuilder setNames(String... names) {
      Collections.addAll(this.names, names);
      return this;
    }

    @Override
    public ENbkPredefinedWeaponBuilder setRarity(ERarity rarity) {
      this.rarity = rarity;
      return this;
    }

    ENbkPredefinedWeaponBuilder setWeaponType(ENbkWeaponType weaponType) {
      this.weaponType = weaponType;
      return this;
    }

    ENbkPredefinedWeaponBuilder isMagic() {
      magic = EMagic.MAGIC;
      return this;
    }

    ENbkPredefinedWeaponBuilder isRelic() {
      magic = EMagic.RELIC;
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

    ENbkWeaponType getWeaponType() {
      return weaponType;
    }

    EMagic getMagic() {
      return magic;
    }
  }
}
