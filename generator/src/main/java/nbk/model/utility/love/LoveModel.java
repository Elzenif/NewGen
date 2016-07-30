package nbk.model.utility.love;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Germain on 24/07/2016.
 */
public class LoveModel {

  private final Map<ELoveDraw, ILoveDraw> loveDrawStringMap;

  public LoveModel() {
    loveDrawStringMap = new LinkedHashMap<>();
  }

  public void addSentence(ELoveDraw eLoveDraw, ILoveDraw iLoveDraw) {
    loveDrawStringMap.put(eLoveDraw, iLoveDraw);
  }

  public int getLoveScore() {
    return loveDrawStringMap.values().stream()
            .map(ILoveDraw::getLoveScore)
            .map(ELoveScore::getScore)
            .reduce(0, Integer::sum);
  }

  public String getPositionSentence() {
    return loveDrawStringMap.get(ELoveDraw.POSITION).getSentence();
  }

  public String getToolSentence() {
    return loveDrawStringMap.get(ELoveDraw.TOOL).getSentence();
  }

  public String getTargetSentence() {
    return loveDrawStringMap.get(ELoveDraw.TARGET).getSentence();
  }

  public String getActionSentence() {
    return loveDrawStringMap.get(ELoveDraw.ACTION).getSentence();
  }
}
