package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ProgressBar  implements ActionListener {
   
   JProgressBar progressBar = new JProgressBar (0, 100);
   Timer timer = new Timer (300, this);
   
   void makeUI () {
      
      JFrame frame = new JFrame ("");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setSize (300, 50);
      frame.add (progressBar);
      frame.setLocationRelativeTo (null);
      frame.setVisible (true);
      
      timer.start ();
      
   }
   
   public void actionPerformed (ActionEvent e) {
      
      int i = progressBar.getValue ();
      if (i == progressBar.getMaximum ()) {
         timer.stop ();
      }
      progressBar.setValue (progressBar.getValue () + 50);
      if (progressBar.getValue()==100)
      {
          
          System.exit(0);
      }
   }
   
   public static void main (String[] args) {
      SwingUtilities.invokeLater (new Runnable () {
         public void run () {
            new ProgressBar ().makeUI ();
         }
      });
   }
}