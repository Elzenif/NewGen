package commons.view.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.JPanel;
import java.awt.Component;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Germain on 18/06/2016.
 */
public class ConstraintPanel extends JPanel {

  private final List<Component> components = new LinkedList<>();

  public ConstraintPanel() {

  }

  @Override
  public Component add(Component comp) {
    comp.setEnabled(false);
    components.add(comp);
    return super.add(comp);
  }

  @Override
  public Component add(String name, Component comp) {
    comp.setEnabled(false);
    components.add(comp);
    return super.add(name, comp);
  }

  @Override
  public Component add(Component comp, int index) {
    comp.setEnabled(false);
    components.add(comp);
    return super.add(comp, index);
  }

  @Override
  public void add(@NotNull Component comp, Object constraints) {
    comp.setEnabled(false);
    components.add(comp);
    super.add(comp, constraints);
  }

  @Override
  public void add(Component comp, Object constraints, int index) {
    comp.setEnabled(false);
    components.add(comp);
    super.add(comp, constraints, index);
  }

  @Override
  protected void addImpl(Component comp, Object constraints, int index) {
    comp.setEnabled(false);
    components.add(comp);
    super.addImpl(comp, constraints, index);
  }

  @Override
  public void remove(int index) {
    components.remove(index);
    super.remove(index);
  }

  @Override
  public void remove(Component comp) {
    components.remove(comp);
    super.remove(comp);
  }

  @Override
  public void removeAll() {
    components.removeAll(new LinkedList<>(components));
    super.removeAll();
  }

  @Override
  public void setEnabled(boolean enabled) {
    components.forEach(c -> c.setEnabled(enabled));
    super.setEnabled(enabled);
  }
}
