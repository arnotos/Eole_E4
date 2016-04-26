package eole;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accueil {	
	public static void main(String[] args) {
      JFrame f = new JFrame("A JFrame");
      f.setTitle("Accueil");
      f.setSize(1009, 706);
      f.setLocation(300,200);
      f.getContentPane().setLayout(new BorderLayout(0, 0));
      
      JPanel panel = new JPanel();
    		  
      f.getContentPane().add(panel, BorderLayout.CENTER);
      
      JMenuBar menuBar = new JMenuBar();
      f.setJMenuBar(menuBar);
      
      JMenu mnVoilier = new JMenu("Voilier");
      menuBar.add(mnVoilier);
      
      JMenuItem mntmCrerUnVoilier = new JMenuItem("Cr�er un Voilier");
      mntmCrerUnVoilier.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new CreerVoilier();
      	}
      });
      mnVoilier.add(mntmCrerUnVoilier);
      
      JMenuItem mntmModifierVoilier = new JMenuItem("Modifier Voilier");
      mntmModifierVoilier.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new ModifierVoilier();
        	}
        });
      mnVoilier.add(mntmModifierVoilier);
      
      JMenuItem mntmSupprimerVoilier = new JMenuItem("Supprimer Voilier");
      mntmSupprimerVoilier.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new SupprimerVoilier();
      	}
      });
      mnVoilier.add(mntmSupprimerVoilier);
      
      JMenuItem mntmListeVoilier = new JMenuItem("Liste Voilier");
      mntmListeVoilier.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new ListerVoilier();
      	}
      });
      mnVoilier.add(mntmListeVoilier);
      
      JMenu mnRgate = new JMenu("R�gate");
      menuBar.add(mnRgate);
      
      JMenuItem mntmCrerUneRgate = new JMenuItem("Cr�er une R�gate");
      mntmCrerUneRgate.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new CreerRegate();
      	}
      });
      mnRgate.add(mntmCrerUneRgate);
      
      JMenuItem mntmModifierRgate = new JMenuItem("Modifier R\u00E9gate");
      mntmModifierRgate.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new ModifierRegate();
      	}
      });
      mnRgate.add(mntmModifierRgate);
      
      JMenuItem mntmSupprimerRgate = new JMenuItem("Supprimer R\u00E9gate");
      mntmSupprimerRgate.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new SupprimerRegate();
      	}
      });
      mnRgate.add(mntmSupprimerRgate);
      
      JMenuItem mntmListerRgate = new JMenuItem("Lister R\u00E9gate");
      mntmListerRgate.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		new ListerRegate();
      	}
      });
      mnRgate.add(mntmListerRgate);
      
      JMenuItem mntmInscrireVoilierSkipper = new JMenuItem("Inscrire Voilier/Skipper");
      mntmInscrireVoilierSkipper.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		new InscrireVoilierSkipper();
      	}
      });
      mnRgate.add(mntmInscrireVoilierSkipper);
      
      JMenuItem mntmLancerRgate = new JMenuItem("Lancer R\u00E9gate");
      mntmLancerRgate.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		new LancerRegate();
      	}
      });
      mnRgate.add(mntmLancerRgate);
      
      JMenuItem mntmRsultat = new JMenuItem("R\u00E9sultat");
      mntmRsultat.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new ListerResultat();
      	}
      });
      mnRgate.add(mntmRsultat);
      
      JMenu mnSkipper = new JMenu("Skipper");
      menuBar.add(mnSkipper);
      
      JMenuItem mntmAjouterSkipper = new JMenuItem("Ajouter Skipper");
      mntmAjouterSkipper.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		new CreerSkipper();
      	}
      });
      mnSkipper.add(mntmAjouterSkipper);
      
      JMenuItem mntmModifier = new JMenuItem("Modifier Skipper");
      mntmModifier.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		new ModifierSkipper();
      	}
      });
      mnSkipper.add(mntmModifier);
      
      JMenuItem mntmSupprimerSkipper = new JMenuItem("Supprimer Skipper");
      mntmSupprimerSkipper.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new SupprimerSkipper();
      	}
      });
      mnSkipper.add(mntmSupprimerSkipper);
      
      JMenuItem mntmLister = new JMenuItem("Liste des Skipper");
      mntmLister.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new ListerSkipper();
      	}
      });
      mnSkipper.add(mntmLister);
      f.setVisible(true);
    }
}
