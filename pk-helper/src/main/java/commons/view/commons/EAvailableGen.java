package commons.view.commons;

import commons.model.commons.Gen;
import commons.view.intf.ITabbedPanel;
import gen3.model.commons.Gen3;
import gen3.view.commons.Gen3TabbedPanelEmbedded;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * Created by Germain on 02/04/2017.
 */
public enum EAvailableGen implements ITabbedPanel<GenTabbedPanelEmbedded> {

  GEN_3(Gen3.getInstance(), true, new Gen3TabbedPanelEmbedded());

  public static final int NB_GENS = EAvailableGen.values().length;
  private final Gen gen;
  private final boolean def;
  private final GenTabbedPanelEmbedded genTabbedPanelEmbbedded;

  EAvailableGen(Gen gen, boolean def, GenTabbedPanelEmbedded genTabbedPanelEmbbedded) {
    this.gen = gen;
    this.def = def;
    this.genTabbedPanelEmbbedded = genTabbedPanelEmbbedded;
  }

  public static Gen getDefault() {
    return Arrays.stream(EAvailableGen.values())
        .findFirst()
        .map(EAvailableGen::getGen)
        .orElse(GEN_3.getGen());
  }

  @Contract(pure = true)
  public Gen getGen() {
    return gen;
  }

  @Contract(pure = true)
  @Override
  public boolean isDefault() {
    return def;
  }

  @Nullable
  @Contract(pure = true)
  @Override
  public GenTabbedPanelEmbedded getTabbedPanelEmbedded() {
    return genTabbedPanelEmbbedded;
  }
}
