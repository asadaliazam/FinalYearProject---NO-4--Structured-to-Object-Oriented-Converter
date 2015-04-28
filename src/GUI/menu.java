/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.apache.commons.io.FilenameUtils;

class MyCustomFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        // Allow only directories, or files with ".txt" extension
        return file.isDirectory() || file.getAbsolutePath().endsWith(".cpp");
    }

    @Override
    public String getDescription() {
            // This description will be displayed in the dialog,
        // hard-coded = ugly, should be done via I18N
        return "Text documents (*.cpp)";
    }
}

/**
 *
 * @author Moeez Haider
 */
public class menu extends javax.swing.JFrame implements ActionListener{

    String miniFile;
    String outputPath;
    ProjectController projectControllerObject;
    Timer timer;
    private int check = 0;
    int projectSelected;
    
    public menu() {
        initComponents();
    }
    menu(ProjectController obj, String miniFile, String outputPath) {
        projectSelected = 0;
        this.miniFile = miniFile;
        this.outputPath = outputPath;
        projectControllerObject = obj;
        timer = new Timer (300,this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        progressBar = new javax.swing.JProgressBar();
        startButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        open = new javax.swing.JMenu();
        NewFile = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Clear = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        fileChooser.setDialogTitle("This is my open dialog");
        fileChooser.setFileFilter(new MyCustomFilter());

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        textarea.setColumns(20);
        textarea.setRows(5);
        jScrollPane1.setViewportView(textarea);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NO4");

        startButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Desktop\\unnamed.png")); // NOI18N
        startButton.setText("");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Downloads\\Projectaaa\\NO4 (3)\\NO4 (3)\\Resources\\header.jpg")); // NOI18N

        jLabel4.setText("Input File");

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Desktop\\NextButton.jpg")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPane2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Before Uploading File please make sure:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("- The code is built through structured programming.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("- The code is programmed in C/C++.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("- The code is free of syntax errors.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Warning : Please make sure you have a backup available.");

        jMenuBar.setForeground(new java.awt.Color(51, 51, 255));

        open.setBackground(new java.awt.Color(51, 102, 255));
        open.setText("File");
        open.setMaximumSize(new java.awt.Dimension(30, 32767));
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        NewFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NewFile.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Downloads\\Projectaaa\\NO4 (3)\\NO4 (3)\\Resources\\Actions-project-open-icon.png")); // NOI18N
        NewFile.setText("New Project");
        NewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFileActionPerformed(evt);
            }
        });
        open.add(NewFile);

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        Open.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Downloads\\Projectaaa\\NO4 (3)\\NO4 (3)\\Resources\\images.jpg")); // NOI18N
        Open.setText("Open File");
        Open.setMaximumSize(new java.awt.Dimension(40000, 32767));
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        open.add(Open);

        Clear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Clear.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Downloads\\Projectaaa\\NO4 (3)\\NO4 (3)\\Resources\\Broom_icon.png")); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        open.add(Clear);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exit.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Downloads\\Projectaaa\\NO4 (3)\\NO4 (3)\\Resources\\Delete.png")); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        open.add(exit);

        jMenuBar.add(open);

        jMenu2.setText("Help");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asad\\Downloads\\Projectaaa\\NO4 (3)\\NO4 (3)\\Resources\\Actions-help-about-icon.png")); // NOI18N
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(51, 51, 51)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        if (projectSelected ==1)
        {
        JFileChooser chooser = new JFileChooser();
        int chooserValue = chooser.showOpenDialog(this);
        if (chooserValue == JFileChooser.APPROVE_OPTION)
        {
            String path= chooser.getSelectedFile().getAbsolutePath();
            String ext = FilenameUtils.getExtension(path);
            
                    if(ext.equalsIgnoreCase("cpp"))
                    {
                        try 
                        {
                            Scanner fin = new Scanner(chooser.getSelectedFile());
                            String buffer = "";
                            while (fin.hasNext())
                            {
                            buffer += fin.nextLine() +"\n";
                            }
                            textarea.setText(buffer);
                            miniFile = path;
                            jTextPane2.setText(path);
                            //startButton.setVisible(true);
                        }
                        catch (FileNotFoundException ex) 
                        {
                            //Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);   
                        }
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Please input .cpp or .c extension file",    "File Inaccessable",    JOptionPane.ERROR_MESSAGE);
                    }
            
            
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this,
    "Select New Project first",
    "Error",
    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        jTextPane2.setText("");
        JOptionPane.showMessageDialog(this, "Cleared");
    }//GEN-LAST:event_ClearActionPerformed

    private void NewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
        {
            String path= chooser.getSelectedFile().getAbsolutePath();
            String ext = FilenameUtils.getExtension(path);
            outputPath = path;
            projectSelected = 1;
            //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            //System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } 
        else 
        {
        System.out.println("No Selection ");
        }
    }//GEN-LAST:event_NewFileActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (projectSelected ==1)
        {
        JFileChooser chooser = new JFileChooser();
        int chooserValue = chooser.showOpenDialog(this);
        if (chooserValue == JFileChooser.APPROVE_OPTION)
        {
            String path= chooser.getSelectedFile().getAbsolutePath();
            String ext = FilenameUtils.getExtension(path);
            
                    if(ext.equalsIgnoreCase("cpp"))
                    {
                        try 
                        {
                            Scanner fin = new Scanner(chooser.getSelectedFile());
                            String buffer = "";
                            while (fin.hasNext())
                            {
                            buffer += fin.nextLine() +"\n";
                            }
                            textarea.setText(buffer);
                            miniFile = path;
                            jTextPane2.setText(path);
                            //startButton.setVisible(true);
                        }
                        catch (FileNotFoundException ex) 
                        {
                            //Logger.getLogger(TextEditorFrame.class.getName()).log(Level.SEVERE, null, ex);   
                        }
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Please input .cpp or .c extension file",    "File Inaccessable",    JOptionPane.ERROR_MESSAGE);
                    }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this,
    "Select New Project first",
    "Error",
    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_startButtonActionPerformed
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AboutFrame obj = new AboutFrame();
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timer.start();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void actionPerformed (ActionEvent e) {
      Random rand = new Random();  
      int i = progressBar.getValue ();
      if (i == progressBar.getMaximum ()) {
         timer.stop ();
      }
      int progress = rand.nextInt((40 - 30) + 30) + 30;
      progressBar.setValue (progressBar.getValue () + progress);
      
      if (progressBar.getValue()==100 && check==0)
      {
          check = 1;
          SelectedFile selectedFileObject = null;
          try {
              selectedFileObject = new SelectedFile(projectControllerObject, miniFile, outputPath);
          } catch (IOException ex) {
              Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
          }
          selectedFileObject.setVisible(true);
          this.setVisible(false);

      }
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Clear;
    private javax.swing.JMenuItem NewFile;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem exit;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JMenu open;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton startButton;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables

    private void startFunctions() throws Exception {
        projectControllerObject.getStartProcessCallfromGUI(miniFile, outputPath);
    }

}