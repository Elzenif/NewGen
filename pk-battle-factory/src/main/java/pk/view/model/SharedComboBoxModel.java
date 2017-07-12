package pk.view.model;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Created by Germain on 12/07/2017.
 */
public class SharedComboBoxModel extends DefaultComboBoxModel<Object> implements ListDataListener {

  private DefaultComboBoxModel<Object> original;

  public SharedComboBoxModel(DefaultComboBoxModel<Object> original) {
    this.original = original;
  }

  @Override
  public int getSize() {
    return original.getSize();
  }

  @Override
  public Object getElementAt(int index) {
    return original.getElementAt(index);
  }

  @Override
  public void addListDataListener(ListDataListener l) {
    if (getListDataListeners().length == 0) {
      original.addListDataListener(this);
    }
    super.addListDataListener(l);
  }

  @Override
  public void removeListDataListener(ListDataListener l) {
    super.removeListDataListener(l);
    if (getListDataListeners().length == 0) {
      original.removeListDataListener(this);
    }
  }

  @Override
  public void addElement(Object anObject) {
    original.addElement(anObject);
  }

  @Override
  public void removeElement(Object anObject) {
    original.removeElement(anObject);
  }

  @Override
  public int getIndexOf(Object anObject) {
    return original.getIndexOf(anObject);
  }

  @Override
  public void insertElementAt(Object anObject, int index) {
    original.insertElementAt(anObject, index);
  }

  @Override
  public void removeAllElements() {
    original.removeAllElements();
  }

  @Override
  public void removeElementAt(int index) {
    original.removeElementAt(index);
  }

  @Override
  public void intervalAdded(ListDataEvent e) {
    fireIntervalAdded(this, e.getIndex0(), e.getIndex1());
  }

  @Override
  public void intervalRemoved(ListDataEvent e) {
    fireIntervalRemoved(this, e.getIndex0(), e.getIndex1());
  }

  @Override
  public void contentsChanged(ListDataEvent e) {
    fireContentsChanged(this, e.getIndex0(), e.getIndex1());
  }
}
