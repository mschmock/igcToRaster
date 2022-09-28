// Autor: Manuel Schmocker
// Datum: 17.09.2022
package ch.manuel.igctoraster.gui;

import ch.manuel.igctoraster.DataHandler;
import ch.manuel.igctoraster.IGCprocessing;
import ch.manuel.utilities.MyUtilities;
import java.awt.Point;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Schmocker
 */
public class MainFrame extends javax.swing.JFrame {

  public static InfoForm infoForm;
  private static DataHandler dHandler;
  private static Point ptClicked;
  private static Point ptDragged;

  /**
   * Creates new form MainFrame
   */
  public MainFrame() {
    initComponents();
    initFrames();

    ptClicked = null;
  }

  /**
   * Creates the depending frames
   */
  private void initFrames() {
    // create InfoFrame, don't show it
    java.awt.EventQueue.invokeLater(() -> {
      infoForm = new InfoForm(new javax.swing.JFrame(), true);
      infoForm.setVisible(false);
    });
  }

  // class methodes
  public static void setStatusText(String str) {
    MainFrame.jTextField1.setText(str);
  }

  public static void updateGraphicPanel() {
    MainFrame.graphicPanel1.repaintPanel();
  }

  public static void setMenuSaveActive() {
    MainFrame.jMenuItem3.setEnabled(true);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    graphicPanel1 = new ch.manuel.igctoraster.graphics.GraphicPanel();
    jTextField1 = new javax.swing.JTextField();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    graphicPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        graphicPanel1MouseDragged(evt);
      }
    });
    graphicPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
      public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
        graphicPanel1MouseWheelMoved(evt);
      }
    });
    graphicPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        graphicPanel1MouseClicked(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        graphicPanel1MouseReleased(evt);
      }
    });

    jTextField1.setEditable(false);
    jTextField1.setBackground(new java.awt.Color(255, 255, 255));
    jTextField1.setForeground(new java.awt.Color(102, 102, 102));
    jTextField1.setText("Status: No info");
    jTextField1.setBorder(null);

    javax.swing.GroupLayout graphicPanel1Layout = new javax.swing.GroupLayout(graphicPanel1);
    graphicPanel1.setLayout(graphicPanel1Layout);
    graphicPanel1Layout.setHorizontalGroup(
      graphicPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphicPanel1Layout.createSequentialGroup()
        .addGap(0, 580, Short.MAX_VALUE)
        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    graphicPanel1Layout.setVerticalGroup(
      graphicPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphicPanel1Layout.createSequentialGroup()
        .addGap(0, 564, Short.MAX_VALUE)
        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jMenu1.setText("File");

    jMenuItem2.setText("Open IGC");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem2);

    jMenuItem5.setText("Open IGC (multiple)");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem5ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem5);

    jMenuItem3.setText("Save geoTiff");
    jMenuItem3.setEnabled(false);
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem3);

    jMenuBar1.add(jMenu1);

    jMenu3.setText("View");

    jMenuItem4.setText("Reset view");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem4);

    jMenuBar1.add(jMenu3);

    jMenu2.setText("Info");

    jMenuItem1.setText("About");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu2.add(jMenuItem1);

    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(graphicPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(graphicPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    // show InfoForm
    infoForm.setVisible(true);
  }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void graphicPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphicPanel1MouseClicked
    // click on panel
    Point p = new Point(evt.getX(), evt.getY());
    MainFrame.graphicPanel1.setNameOnClick(p);
    MainFrame.graphicPanel1.repaintPanel();
  }//GEN-LAST:event_graphicPanel1MouseClicked

  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    // open file dialog
    File file;
    FileFilter filter = new FileNameExtensionFilter("IGC files", "igc");
    file = MyUtilities.getOpenFileDialog("Open IGC-File", filter);
    if (file != null) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, "Load file: " + file.getName());
      dHandler = new DataHandler(file);
      dHandler.processSingleFile();
    } else {
      Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, "No file...");
    }
  }//GEN-LAST:event_jMenuItem2ActionPerformed

  private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    // open save dialog
    File file;
    FileFilter filter = new FileNameExtensionFilter("IGC files", "igc");
    file = MyUtilities.getSaveFileDialog("Save Tiff", filter, "image.png");
    dHandler.saveImage(file);
  }//GEN-LAST:event_jMenuItem3ActionPerformed

  private void graphicPanel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_graphicPanel1MouseWheelMoved
    // zoom
    Point p = new Point(evt.getX(), evt.getY());
    if (evt.getWheelRotation() < 0) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, "zoom in" + p.toString());
      MainFrame.graphicPanel1.zoomIn(p);
    } else if (evt.getWheelRotation() > 0) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, "zoom out" + p.toString());
      MainFrame.graphicPanel1.zoomOut(p);
    }
  }//GEN-LAST:event_graphicPanel1MouseWheelMoved

  private void graphicPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphicPanel1MouseDragged
    if (ptClicked == null) {
      ptClicked = new Point(evt.getX(), evt.getY());
    }
    ptDragged = new Point(evt.getX() - (int) ptClicked.getX(), evt.getY() - (int) ptClicked.getY());
    System.out.println("Clicked: " + ptClicked.toString());
    System.out.println("Dragged: " + ptDragged.toString());
  }//GEN-LAST:event_graphicPanel1MouseDragged

  private void graphicPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphicPanel1MouseReleased
    MainFrame.graphicPanel1.dragMap(ptDragged);
    ptClicked = null;
  }//GEN-LAST:event_graphicPanel1MouseReleased

  private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    MainFrame.graphicPanel1.resetView();
  }//GEN-LAST:event_jMenuItem4ActionPerformed

  private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    // open file dialog
    File file;
    file = MyUtilities.getSelectFolderDialog("Select folder");
    if (file != null) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, "Open folder: " + file.getName());
      dHandler = new DataHandler(file);
      dHandler.processFiles();
    } else {
      Logger.getLogger(MainFrame.class.getName()).log(Level.INFO, "No file...");
    }
  }//GEN-LAST:event_jMenuItem5ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static ch.manuel.igctoraster.graphics.GraphicPanel graphicPanel1;
  private static javax.swing.JMenu jMenu1;
  private static javax.swing.JMenu jMenu2;
  private static javax.swing.JMenu jMenu3;
  private static javax.swing.JMenuBar jMenuBar1;
  private static javax.swing.JMenuItem jMenuItem1;
  private static javax.swing.JMenuItem jMenuItem2;
  private static javax.swing.JMenuItem jMenuItem3;
  private static javax.swing.JMenuItem jMenuItem4;
  private static javax.swing.JMenuItem jMenuItem5;
  private static javax.swing.JTextField jTextField1;
  // End of variables declaration//GEN-END:variables
}
