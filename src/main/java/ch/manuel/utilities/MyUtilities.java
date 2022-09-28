//Autor: Manuel Schmocker
//Datum: 24.02.2014
package ch.manuel.utilities;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

//Klasse mit verschiedenen Hilfsmittel
public class MyUtilities {

  //Kann der String in eine Zahl umgewandelt werden
  //Gibt true zurück, falls kein Fehler auftritt
  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  //Kann der String in einen Int umgewandelt werden
  //Gibt true zurück, falls kein Fehler auftritt
  public static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return false;
    }
    // only got here if we didn't return false
    return true;
  }

  //Kann der String in eine Boolean umgewandelt werden
  //Gibt true zurück, falls kein Fehler auftritt
  public static boolean isBoolean(String str) {
    if (str.equals("true")) {
      return true;
    }
    if (str.equals("True")) {
      return true;
    }
    if (str.equals("TRUE")) {
      return true;
    }
    if (str.equals("false")) {
      return true;
    }
    if (str.equals("False")) {
      return true;
    }
    if (str.equals("FALSE")) {
      return true;
    }
    return false;
  }

  //String in Boolean
  //Achtung: nur in Kombination mit "isBoolean" anwenden
  private static boolean stringToBoolean(String str) {
    if (str.equals("true")) {
      return true;
    }
    if (str.equals("True")) {
      return true;
    }
    if (str.equals("TRUE")) {
      return true;
    }
    if (str.equals("false")) {
      return false;
    }
    if (str.equals("False")) {
      return false;
    } else {
      return false;
    }
  }

  //Fehler bei Eingabe: Fenster mit Fehlercode
  public static void getErrorMsg(String titel, String initTxt) {
    JOptionPane.showMessageDialog(null, initTxt, titel, JOptionPane.ERROR_MESSAGE);
  }

  //Look and Feel festlegen
  public static void setLaF(String lf) {
    //Setze das Look & Feel: "Windows" falls vorhanden
    String lookandfeel = lf;     //Nimbus, Metal, Windows, Windows Classic, CDE/Motif
    boolean isSupported = false;        //Wird das gewünschte L&F unterstützt
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
      if (lookandfeel.equals(info.getName())) {
        isSupported = true;
        lookandfeel = info.getClassName();
        break;
      }
    }
    //System.out.println(UIManager.getLookAndFeel().getName());
    try {
      if (isSupported) {
        UIManager.setLookAndFeel(lookandfeel);
      } else {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
    } catch (Exception e) {
      // If Nimbus is not available, you can set the GUI to another look and feel.
    }
    //System.out.println(UIManager.getLookAndFeel().getName());
  }

  //Die Zahl auf eine bestimmte Anzahl Stellen runden: s
  public static double runden(double d, int s) {
    double d1;
    d1 = d * Math.pow(10, s);
    d1 = Math.round(d1) / Math.pow(10, s);

    return d1;
  }

  // Zahl als String
  public static String getStringFromDbl(double d) {
    NumberFormat formatter = new DecimalFormat("#0.00");
    return formatter.format(d);
  }

  //Look and Feel während der Laufzeit ändern
  //Siehe Menu: "Edit"
  public static void laf() {
    int nb = 0;
    String txt;

    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
      nb++;
    }
    String obj[] = new String[nb];
    int i = 0;
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
      obj[i] = info.getName();
      i++;
    }

    //Auswahlfeld anzeigen
    txt = (String) JOptionPane.showInputDialog(
            null, //parentComponent
            "Look & Feel:", //message
            "Design wählen", //title
            JOptionPane.PLAIN_MESSAGE, //message type
            null, //icon
            obj, //selection Values
            "Bitte wählen");                //initial Value

    if (txt == null) {     //Dialog Schliessen bei Abbruch: True
      //nichts...
    } else {
      //L&F ändern
      setLaF(txt);
      //Main.myFrame.updateLaF();
    }
  }

  // save file
  public static File getSaveFileDialog(String title, FileFilter filter, String fName) {
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jfc.setDialogTitle(title);
    jfc.setSelectedFile(new File(fName));
    int retval = jfc.showSaveDialog(null);

    if (retval == JFileChooser.APPROVE_OPTION) {
      return jfc.getSelectedFile();
    } else {
      return null;
    }
  }

  // open file
  public static File getOpenFileDialog(String title, FileFilter filter) {
    File selectedFile = null;
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jfc.setDialogTitle(title);
    if (filter != null) {
      jfc.addChoosableFileFilter(filter);
    }

    int returnValue = jfc.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      selectedFile = jfc.getSelectedFile();
    }
    return selectedFile;
  }

  // select folder
  public static File getSelectFolderDialog(String title) {
    File selectedFile = null;
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    jfc.setDialogTitle(title);

    int returnValue = jfc.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      selectedFile = jfc.getSelectedFile();
    }
    return selectedFile;
  }

  //Nachricht anzeigen: Titel + Warning icon
  private static void getMessage(String text1, String text2) {
    JOptionPane.showMessageDialog(null, text1, text2, JOptionPane.WARNING_MESSAGE);
  }

  // YES - NO Dialog
  public static int getYesNoDialog(String txt, String title) {
    //default icon, custom title
    return JOptionPane.showConfirmDialog(
            null, txt, title, JOptionPane.YES_NO_OPTION);
  }

}
