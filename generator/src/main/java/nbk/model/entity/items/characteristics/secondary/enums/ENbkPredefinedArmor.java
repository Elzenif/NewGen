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
import nbk.model.entity.items.characteristics.primary.builders.BodyPartBuilder;
import nbk.model.entity.items.characteristics.primary.builders.SizeBuilder;
import nbk.model.entity.items.characteristics.primary.builders.WeightBuilder;
import nbk.model.entity.items.characteristics.primary.enums.EBodyPart;
import nbk.model.entity.items.characteristics.primary.enums.ESize;
import nbk.model.entity.items.characteristics.primary.enums.EWeight;
import nbk.model.entity.items.characteristics.primary.fields.HasSize;
import nbk.model.entity.items.characteristics.primary.fields.HasWeight;
import nbk.model.entity.items.characteristics.primary.fields.IsBodyPart;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Germain on 26/06/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum ENbkPredefinedArmor implements Secondary, EntityType<String>, HasMagic, HasWeight, IsBodyPart, HasSize {
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
      .setNames("Plastron de cuir luxe +2 force")
      .epic()
      .isMagic()
      .torsoPart()),
  PLASTRON_CUIR_ELFE(new ENbkPredefinedArmorBuilder()
      .setNames("Plastron de cuir luxe Haut-Elfe +4")
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
      .setNames("Plastron métal luxe +2 force")
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
      .setNames("Jambières métal luxe Protector(TM)")
      .legendary()
      .isMagic()
      .legsPart()
      .heavyWeight()),
  BRASSIERES_METAL_LOURDES(new ENbkPredefinedArmorBuilder()
      .setNames("Brassières métal, lourdes et grossières")
      .uncommon()
      .forearmsPart()
      .heavyWeight()),
  BRASSIERES_METAL_LEGERES(new ENbkPredefinedArmorBuilder()
      .setNames("Brassières métal légères")
      .rare()
      .forearmsPart()
      .heavyWeight()),
  BRASSIERES_METAL_LUXE(new ENbkPredefinedArmorBuilder()
      .setNames("Brassières métal luxe (artisan nain)")
      .epic()
      .forearmsPart()
      .heavyWeight()),
  BRASSIERES_METAL_LUXE1(new ENbkPredefinedArmorBuilder()
      .setNames("Brassières métal luxe +1 force")
      .epic()
      .isMagic()
      .forearmsPart()
      .heavyWeight()),
  BRASSIERES_METAL_PROTECTOR(new ENbkPredefinedArmorBuilder()
      .setNames("Brassières métal luxe Protector(TM)")
      .legendary()
      .isMagic()
      .forearmsPart()
      .heavyWeight()),
  // Cottes de maille
  COTTE_DE_MAILLES_NAIN(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte de mailles pour Nain 'Débutant' avec manches")
      .uncommon()
      .torsoPart().armsPart()
      .heavyWeight()
      .smallSize()),
  COTTE_DE_MAILLES_BASIQUE_SANS_MANCHES(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte de mailles basique sans manches")
      .uncommon()
      .torsoPart()
      .heavyWeight()),
  COTTE_DE_MAILLES_BASIQUE_AVEC_MANCHES(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte de mailles basique avec manches")
      .uncommon()
      .torsoPart().armsPart()
      .heavyWeight()),
  COTTE_DE_MAILLES_LUXE_AVEC_MANCHES(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte de mailles luxe avec manches (artisan nain)")
      .rare()
      .torsoPart().armsPart()
      .heavyWeight()),
  COTTE_DE_MAILLES_ACIER_CARBONE(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte de mailles acier carbone pour voleur, sans manches")
      .epic()
      .torsoPart()
      .heavyWeight()),
  COTTE_DE_MAILLES_ELFIQUE(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte de mailles elfique avec manches")
      .legendary()
      .isMagic()
      .torsoPart().armsPart()
      .heavyWeight()),
  COTTE_DE_MAILLES_THRITIL(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte de mailles Thritil avec manches")
      .legendary()
      .isMagic()
      .torsoPart().armsPart()
      .heavyWeight()),
  // Casques et heaumes
  CASQUE_DE_CUIR(new ENbkPredefinedArmorBuilder()
      .setNames("Casque de cuir")
      .common()
      .headPart()
      .lightWeight()),
  CASQUE_DE_CUIR_LUXE(new ENbkPredefinedArmorBuilder()
      .setNames("Casque de cuir luxe")
      .uncommon()
      .headPart()
      .lightWeight()),
  CASQUE_DE_METAL_DE_BASE(new ENbkPredefinedArmorBuilder()
      .setNames("Casque de métal de base")
      .common()
      .headPart()
      .heavyWeight()),
  CASQUE_DE_METAL_LEBOHAUM(new ENbkPredefinedArmorBuilder()
      .setNames("Casque de métal 'Lebohaum'")
      .uncommon()
      .headPart()
      .heavyWeight()),
  CASQUE_DE_METAL_CONFORT(new ENbkPredefinedArmorBuilder()
      .setNames("Casque de métal 'confort' léger et ouvragé")
      .rare()
      .headPart()),
  CASQUE_LUXE(new ENbkPredefinedArmorBuilder()
      .setNames("Casque luxe (artisan nain)")
      .epic()
      .headPart()
      .heavyWeight()),
  HEAUME_DE_GUERRIER(new ENbkPredefinedArmorBuilder()
      .setNames("Heaume de guerrier elfique")
      .legendary()
      .isMagic()
      .headPart()
      .lightWeight()),
  HEAUME_OR(new ENbkPredefinedArmorBuilder()
      .setNames("Heaume plaqué or ouvragé")
      .legendary()
      .headPart()),
  // Gantelets et bracelets
  GANTELETS_CUIR(new ENbkPredefinedArmorBuilder()
      .setNames("Gantelets cuir")
      .common()
      .handsPart()
      .lightWeight()),
  GANTELETS_CUIR_METAL(new ENbkPredefinedArmorBuilder()
      .setNames("Gantelets cuir et métal")
      .uncommon()
      .handsPart()),
  GANTELETS_MAILLE(new ENbkPredefinedArmorBuilder()
      .setNames("Gantelets maille")
      .uncommon()
      .handsPart()
      .heavyWeight()),
  GANTELETS_ELFIQUES(new ENbkPredefinedArmorBuilder()
      .setNames("Gantelets de combat elfiques")
      .epic()
      .handsPart()
      .lightWeight()),
  GANTELETS_THRITIL(new ENbkPredefinedArmorBuilder()
      .setNames("Gantelets Thritil")
      .legendary()
      .handsPart()
      .heavyWeight()),
  BRACELETS_CUIR(new ENbkPredefinedArmorBuilder()
      .setNames("Bracelets cuir")
      .common()
      .forearmsPart()
      .lightWeight()),
  BRACELETS_CUIR_METAL(new ENbkPredefinedArmorBuilder()
      .setNames("Bracelets cuir et métal")
      .uncommon()
      .forearmsPart()),
  BRACELETS_ELFIQUES(new ENbkPredefinedArmorBuilder()
      .setNames("Bracelets de combat elfiques")
      .epic()
      .forearmsPart()
      .lightWeight()),
  BRACELETS_THRITIL(new ENbkPredefinedArmorBuilder()
      .setNames("Bracelets Thritil")
      .legendary()
      .forearmsPart()
      .heavyWeight()),
  // Bottes, chaussures
  BOTTES_DE_CUIR_MINABLES(new ENbkPredefinedArmorBuilder()
      .setNames("Bottes de cuir minables")
      .common()
      .feetPart()
      .lightWeight()),
  BOTTES_DE_CUIR_STANDARD(new ENbkPredefinedArmorBuilder()
      .setNames("Bottes de cuir standard")
      .common()
      .feetPart()
      .lightWeight()),
  BOTTES_DE_CUIR_RENFORCEES_BASE(new ENbkPredefinedArmorBuilder()
      .setNames("Bottes de cuir renforcées de base")
      .uncommon()
      .feetPart()),
  BOTTES_DE_CUIR_RENFORCEES_LEGERES(new ENbkPredefinedArmorBuilder()
      .setNames("Bottes de cuir renforcées légères")
      .uncommon()
      .feetPart()
      .lightWeight()),
  BOTTES_ELFIQUES(new ENbkPredefinedArmorBuilder()
      .setNames("Bottes elfiques de danseur de guerre")
      .epic()
      .feetPart()
      .lightWeight()),
  BOTTES_DE_CUIR_LUXE(new ENbkPredefinedArmorBuilder()
      .setNames("Bottes de cuir luxe de champion")
      .epic()
      .feetPart()
      .lightWeight()),
  CHAUSSONS_DANSE(new ENbkPredefinedArmorBuilder()
      .setNames("Chaussons de danse de Rizmo Jarbé")
      .legendary()
      .isRelic()
      .feetPart()
      .lightWeight()),
  // Armures conmplètes
  SET_ARMURE_METAL_BAS_DE_GAMME(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure métal bas de gamme Donjon Facile")
      .uncommon()
      .fullBody()
      .heavyWeight()),
  SET_ARMURE_METAL_TINCAN(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure métal TinCan(TM) pour Nain")
      .rare()
      .fullBody()
      .heavyWeight()
      .smallSize()),
  SET_ARMURE_METAL_PETIT_PALOUF(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure métal 'Petit Palouf' du Donjon Facile")
      .epic()
      .fullBody()
      .heavyWeight()),
  SET_ARMURE_GRAND_PALOUF(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure 'Grand Palouf' du Donjon Facile")
      .legendary()
      .isMagic()
      .fullBody()
      .heavyWeight()),
  SET_ARMURE_JUSTICE_BRAAV(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure de Justice de Braav'")
      .legendary()
      .isRelic()
      .fullBody()
      .heavyWeight()),
  ARMURE_COMPLETE_THRITIL(new ENbkPredefinedArmorBuilder()
      .setNames("Armure complète en Thritil")
      .legendary()
      .fullBody()
      .heavyWeight()),
  SET_ARMURE_CUIR_ORQUE_TROUPIER(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure de cuir orque troupier")
      .common()
      .fullBody()),
  SET_ARMURE_CUIR_ORQUE_MERCENAIRE(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure de cuir orque mercenaire 'Tourkilak'")
      .uncommon()
      .fullBody()),
  SET_ARMURE_CUIR_100(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure de cuir 'Mercenaire 100'")
      .rare()
      .fullBody()),
  SET_ARMURE_CUIR_METAL_200(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure cuir-métal 'Maraveur 200'")
      .epic()
      .fullBody()),
  SET_ARMURE_CUIR_METAL_400(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure cuir-métal 'Bastonneur 400'")
      .epic()
      .fullBody()),
  SET_ARMURE_CUIR_ECAILLE_1000(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure cuir-écaille 'Destructeur 10000")
      .legendary()
      .fullBody()),
  SET_ARMURE_FOLONARIEL(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure elfique 'Folonariel'")
      .legendary()
      .isMagic()
      .fullBody()
      .lightWeight()),
  SET_ARMURE_DEMIGOD(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure Demigod(TM)")
      .legendary()
      .isMagic()
      .fullBody()
      .lightWeight()),
  SET_ARMURE_TALAIRFIN(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure elfique 'Talairfin'")
      .legendary()
      .isMagic()
      .fullBody()
      .lightWeight()),
  SET_ARMURE_KHORNETTOH(new ENbkPredefinedArmorBuilder()
      .setNames("Set d'armure du Massacre de Khornettoh")
      .legendary()
      .isMagic()
      .fullBody()
      .lightWeight()),
  SET_TUNIQUE_OMBRES(new ENbkPredefinedArmorBuilder()
      .setNames("Set Tunique/Pantalon des Ombres")
      .legendary()
      .isMagic()
      .torsoPart().armsPart().forearmsPart().legsPart()
      .lightWeight()),
  SET_TUNIQUE_FOURBE(new ENbkPredefinedArmorBuilder()
      .setNames("Set Tunique/Pantalon du Fourbe")
      .legendary()
      .isMagic()
      .torsoPart().armsPart().forearmsPart().legsPart()
      .lightWeight()),
  SET_TUNIQUE_VELOCITE(new ENbkPredefinedArmorBuilder()
      .setNames("Set Tunique/Pantalon de Vélocité")
      .legendary()
      .isMagic()
      .torsoPart().armsPart().forearmsPart().legsPart()
      .lightWeight()),
  SET_TUNIQUE_ETHER(new ENbkPredefinedArmorBuilder()
      .setNames("Set Tunique/Pantalon de l'Ether")
      .legendary()
      .isMagic()
      .torsoPart().armsPart().forearmsPart().legsPart()
      .lightWeight()),
  // Boucliers
  BOUCLIER_BASE(new ENbkPredefinedArmorBuilder()
      .setNames("Bouclier de base")
      .common()
      .shieldPart()),
  GRAND_BOUCLIER_BASE(new ENbkPredefinedArmorBuilder()
      .setNames("Grand bouclier de base")
      .common()
      .shieldPart()
      .heavyWeight()),
  BOUCLIER_SALDUR(new ENbkPredefinedArmorBuilder()
      .setNames("Bouclier Saldur (de luxe)")
      .uncommon()
      .shieldPart()),
  GRAND_BOUCLIER_LUXE(new ENbkPredefinedArmorBuilder()
      .setNames("Grand bouclier de luxe")
      .rare()
      .shieldPart()
      .heavyWeight()),
  BOUCLIER_ELFIQUE(new ENbkPredefinedArmorBuilder()
      .setNames("Bouclier elfique de luxe, ultra-léger")
      .epic()
      .shieldPart()
      .lightWeight()),
  BOUCLIER_CHAOS(new ENbkPredefinedArmorBuilder()
      .setNames("Bouclier ensorcelé de champion du Chaos")
      .legendary()
      .isMagic()
      .shieldPart()),
  // Semi-homme
  CALOTTE_CUIR(new ENbkPredefinedArmorBuilder()
      .setNames("Calotte de cuir du chef")
      .common()
      .headPart()
      .lightWeight()
      .smallSize()),
  CASQUE_GARDIEN(new ENbkPredefinedArmorBuilder()
      .setNames("Beau casque du Gardien")
      .uncommon()
      .headPart()
      .lightWeight()
      .smallSize()),
  SALADE_ALTROUILLE(new ENbkPredefinedArmorBuilder()
      .setNames("Salade de garde des Relparts d'Altrouille")
      .uncommon()
      .headPart()
      .lightWeight()
      .smallSize()),
  CASQUE_RILLETTEBOURG(new ENbkPredefinedArmorBuilder()
      .setNames("Casque de Sargent de Rillettebourg")
      .rare()
      .headPart()
      .smallSize()),
  POURPOINT(new ENbkPredefinedArmorBuilder()
      .setNames("Pourpoint de cuistot-brigand")
      .common()
      .torsoPart()
      .smallSize()),
  GAMBISON_FIERPATE(new ENbkPredefinedArmorBuilder()
      .setNames("Gambison de Fierpâté")
      .uncommon()
      .torsoPart().armsPart()
      .smallSize()),
  GAMBISON_ALTROUILLE(new ENbkPredefinedArmorBuilder()
      .setNames("Gambison d'Altrouille")
      .rare()
      .torsoPart().armsPart()
      .smallSize()),
  VESTON(new ENbkPredefinedArmorBuilder()
      .setNames("Veston redoutable de Terrineville")
      .rare()
      .torsoPart().armsPart()
      .smallSize()),
  GAMBISON_JOLI(new ENbkPredefinedArmorBuilder()
      .setNames("Gambison Joli")
      .epic()
      .isMagic()
      .torsoPart().armsPart()
      .smallSize()),
  COTTE_GILBERT(new ENbkPredefinedArmorBuilder()
      .setNames("Cotte Magnifique de Gilbert")
      .epic()
      .isMagic()
      .torsoPart()
      .smallSize()),
  BRACELETS_TITGARS(new ENbkPredefinedArmorBuilder()
      .setNames("Bracelets de cuir du Tit'gars")
      .uncommon()
      .forearmsPart()
      .lightWeight()
      .smallSize()),
  GRANDBOTTES(new ENbkPredefinedArmorBuilder()
      .setNames("Grand'bottes chourées à Boombardil")
      .rare()
      .feetPart().legsPart()
      .lightWeight()
      .smallSize()),
  // Gnome
  VESTE_CUIR_BRICOLEE(new ENbkPredefinedArmorBuilder()
      .setNames("Veste en cuir bricolée")
      .uncommon()
      .torsoPart()
      .lightWeight()
      .smallSize()),
  VESTE_CUIR_MESURE(new ENbkPredefinedArmorBuilder()
      .setNames("Veste en cuir sur mesure")
      .rare()
      .torsoPart().armsPart()
      .lightWeight()
      .smallSize()),
  VESTE_CUIR_ARTISAN(new ENbkPredefinedArmorBuilder()
      .setNames("Veste en cuir sur mesure d'artisan")
      .epic()
      .torsoPart().armsPart()
      .lightWeight()
      .smallSize()),
  MINI_CASQUE(new ENbkPredefinedArmorBuilder()
      .setNames("Mini-casque de protection forgé sur mesure")
      .epic()
      .headPart()
      .lightWeight()
      .smallSize()),
  BRAIES_ACROBATIE(new ENbkPredefinedArmorBuilder()
      .setNames("Braies d'acrobate sur mesure")
      .epic()
      .legsPart()
      .lightWeight()
      .smallSize()),
  VESTE_EXCEPTION(new ENbkPredefinedArmorBuilder()
      .setNames("Veste en toile renforcée d'exception")
      .epic()
      .isMagic()
      .torsoPart().armsPart()
      .lightWeight()
      .smallSize()),
  // Ogre
  GRAND_CASQUE(new ENbkPredefinedArmorBuilder()
      .setNames("Grand casque du Bourreau")
      .uncommon()
      .headPart()
      .heavyWeight()
      .largeSize()),
  TUNIQUE_BOUCHER(new ENbkPredefinedArmorBuilder()
      .setNames("Tunique Renforcée du Boucher")
      .uncommon()
      .torsoPart().armsPart()
      .largeSize()),
  PAGNE(new ENbkPredefinedArmorBuilder()
      .setNames("Pagne de cuir solide")
      .common()
      .legsPart()
      .lightWeight()
      .largeSize()),
  BRAIES_BOUCHER(new ENbkPredefinedArmorBuilder()
      .setNames("Braies de cuir du Boucher")
      .rare()
      .legsPart()
      .largeSize()),
  SURCOT_DEPECEUR(new ENbkPredefinedArmorBuilder()
      .setNames("Grand Surcot du Dépeceur")
      .epic()
      .isMagic()
      .torsoPart()
      .largeSize());


  private static final Constraints<ENbkPredefinedArmor> CONSTRAINTS = Constraints.ConstraintsBuilder
      .<ENbkPredefinedArmor>start()
      .setSecondaryClass(ENbkPredefinedArmor.class)
      .setPrimaryClasses(EItemRarity.class, EBodyPart.class, EWeight.class, ESize.class)
      .build();
  private final List<String> names;
  private final EItemRarity rarity;
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

  public static Constraints<ENbkPredefinedArmor> getConstraints() {
    return CONSTRAINTS;
  }

  @NotNull
  public static Predicate<ENbkPredefinedArmor> getPredicate(GlobalConstraints globalConstraints) {
    Predicate<EItemRarity> rarityPredicate = globalConstraints.getPredicate(CONSTRAINTS, EItemRarity.class);
    Predicate<EBodyPart> bodyPartPredicate = globalConstraints.getPredicate(CONSTRAINTS, EBodyPart.class);
    Predicate<EWeight> weightPredicate = globalConstraints.getPredicate(CONSTRAINTS, EWeight.class);
    Predicate<ESize> sizePredicate = globalConstraints.getPredicate(CONSTRAINTS, ESize.class);
    return armor -> rarityPredicate.test(armor.getRarity())
        && armor.getBodyParts().stream().filter(bodyPartPredicate).findAny().isPresent()
        && weightPredicate.test(armor.getWeight())
        && sizePredicate.test(armor.getSize());
  }

  @Override
  public String getName() {
    return MathUtils.chooseRandom(names);
  }

  @Override
  public EItemRarity getRarity() {
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
    final EnumSet<EBodyPart> bodyParts = EnumSet.noneOf(EBodyPart.class);
    EItemRarity rarity;
    EMagic magic = EMagic.NOPE;
    EWeight weight = EWeight.NORMAL;
    ESize size = ESize.MEDIUM;

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
      rarity = EItemRarity.COMMON;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder uncommon() {
      rarity = EItemRarity.UNCOMMON;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder rare() {
      rarity = EItemRarity.RARE;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder epic() {
      rarity = EItemRarity.EPIC;
      return this;
    }

    @Override
    public ENbkPredefinedArmorBuilder legendary() {
      rarity = EItemRarity.LEGENDARY;
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
    public ENbkPredefinedArmorBuilder fullBody() {
      List<EBodyPart> bodyParts = Stream.of(EBodyPart.values())
          .filter(bodyPart -> bodyPart != EBodyPart.SHIELD)
          .collect(Collectors.toList());
      this.bodyParts.addAll(bodyParts);
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
    public EItemRarity getRarity() {
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
