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

/**
 *
 * @author Schmocker
 */
public class MainFrame extends javax.swing.JFrame {

  public static InfoForm infoForm;

  /**
   * Creates new form MainFrame
   */
  public MainFrame() {
    initComponents();
    initFrames();
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
    jMenu2 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    graphicPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        graphicPanel1MouseClicked(evt);
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

    jMenuItem2.setText("open IGC");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem2);

    jMenuBar1.add(jMenu1);

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
    // get name of polygon
    Point p = new Point(evt.getX(), evt.getY());
    MainFrame.graphicPanel1.setNameOnClick(p);
    MainFrame.graphicPanel1.repaintPanel();
  }//GEN-LAST:event_graphicPanel1MouseClicked

  private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    // open file dialog
    File file;
    file = MyUtilities.getOpenFileDialog(this, "Open IGC-file", "Documents", "*.igc");
    
    Logger.getLogger(IGCprocessing.class.getName()).log(Level.INFO, null, "Load file: " + file.getName());
    DataHandler dHandler = new DataHandler( file );
    dHandler.processSingleFile();
  }//GEN-LAST:event_jMenuItem2ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static ch.manuel.igctoraster.graphics.GraphicPanel graphicPanel1;
  private static javax.swing.JMenu jMenu1;
  private static javax.swing.JMenu jMenu2;
  private static javax.swing.JMenuBar jMenuBar1;
  private static javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private static javax.swing.JTextField jTextField1;
  // End of variables declaration//GEN-END:variables
}
