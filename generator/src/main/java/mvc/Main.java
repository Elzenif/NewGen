package mvc;

import mvc.view.MainFrame;

import javax.swing.*;

/**
 * Created by Germain on 01/05/2016.
 */
public class Main {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }

    MainFrame mainFrame = new MainFrame();
    mainFrame.setVisible(true);
  }


}
