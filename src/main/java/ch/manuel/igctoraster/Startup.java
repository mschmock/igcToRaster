/**
 * Autor: Manuel Schmocker
 * Datum: 03.09.2022
 */
package ch.manuel.igctoraster;

import ch.manuel.utilities.MyUtilities;
import ch.manuel.igctoraster.gui.InfoDialog;
import ch.manuel.igctoraster.gui.MainFrame;


// Main class and starting point
public class Startup {
  
  public static InfoDialog dialog;
  public static MainFrame mainFrame;
  private static DataLoader dataLoader;
  
  public static void main(String[] args) {

    // Set Look and Feel
    MyUtilities.setLaF("Windows");

    // open InfoPanel
    Startup.dialog = new InfoDialog(new javax.swing.JFrame(), true);
    Thread t1 = new Thread( Startup.dialog );
    t1.start();

    // Load data from resources
    dataLoader = new DataLoader();
    dataLoader.loadData();
    dataLoader.setStatusText();
    
    // Infopanel -> abschluss anzeigen
    Startup.dialog.setLoadingOK();

    // wait for InfoDialog to be closed
    try {
        t1.join();
    } catch (InterruptedException ex) {
        MyUtilities.getErrorMsg("Systemfehler", "Fehler im Thread 'dialog'. Programm wird beendet!");
        System.exit(0);
    }
    
    // open MainFrame
    
    java.awt.EventQueue.invokeLater(() -> {
      mainFrame = new MainFrame();
      mainFrame.setVisible(true);
    });

  }
  
}
