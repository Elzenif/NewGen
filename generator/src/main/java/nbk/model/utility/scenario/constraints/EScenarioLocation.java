package nbk.model.utility.scenario.constraints;

/**
 * Created by Germain on 01/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum EScenarioLocation implements IScenarioDrawResult {

  SD1("une grotte à proximité"),
  SD2("un village à l'abandon, déserté par ses habitants"),
  SD3("un campement de fortune dans une forêt proche"),
  SD4("un campement de fortune dans une vallée proche"),
  SD5("une maison dans le village"),
  SD6("une cabane d'ermite à quelques kilomètres"),
  SD7("les égouts de la ville"),
  SD8("les alentours de la ville"),
  SD9("les ruines d'une ancienne demeure"),
  SD10("une caverne située dans des montagnes ou collines proches"),
  SD11("un port proche"),
  SD12("la demeure d'un noble"),
  SD13("une taverne insalubre"),
  SD14("une ruelle sombre"),
  SD15("une tour de guet abandonnée"),
  SD16("un vieux souterrain"),
  SD17("un donjon à quelques kilomètres"),
  SD18("un temple à proximité"),
  SD19("une maison close close"),
  SD20("un manoir abandonné");

  private final String sentence;

  EScenarioLocation(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String getSentence() {
    return sentence;
  }
}
