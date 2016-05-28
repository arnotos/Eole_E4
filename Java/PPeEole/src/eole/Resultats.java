package eole;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Resultats extends Outils {
	private JTable tblClasse1;
	private JTable tblClasse2;
	private JTable tblClasse3;
	private JTable tblClasse4;
	public Resultats(String NumRegate){
		JFrame frame  = new JFrame("R�sultat R�gate");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(706,722);
		frame.getContentPane().setLayout(new BorderLayout(0,0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		/////////////////////////////////////////////////////////////1
		
		JScrollPane scrollPaneClasse1 = new JScrollPane();
		scrollPaneClasse1.setBounds(36, 76, 622, 129);
		panel.add(scrollPaneClasse1);
		
		tblClasse1 = new JTable();
		tblClasse1.setRowSelectionAllowed(false);
		
		String[] entetes = {"Position", "NomVoilier", "NomSkipper", "Temps R�el", "Temps Compens�"};
		Object[][] data = {};
		DefaultTableModel modele1 = new DefaultTableModel(data, entetes);
		tblClasse1.setModel(modele1);
		
		
		
		scrollPaneClasse1.setViewportView(tblClasse1);
		
		////////////////////////////////////////////////////////////2
		
		JScrollPane scrollPaneClasse2 = new JScrollPane();
		scrollPaneClasse2.setBounds(36, 234, 622, 129);
		panel.add(scrollPaneClasse2);
		
		tblClasse2= new JTable();
		tblClasse2.setRowSelectionAllowed(false);

		DefaultTableModel modele2 = new DefaultTableModel(data, entetes);
		tblClasse2.setModel(modele2);
		
		
		
		scrollPaneClasse2.setViewportView(tblClasse2);
		
		/////////////////////////////////////////////////////////3
		
		JScrollPane scrollPaneClasse3 = new JScrollPane();
		scrollPaneClasse3.setBounds(36, 389, 622, 129);
		panel.add(scrollPaneClasse3);
		
		tblClasse3 = new JTable();
		tblClasse3.setRowSelectionAllowed(false);
		
		DefaultTableModel modele3 = new DefaultTableModel(data, entetes);
		tblClasse3.setModel(modele3);
		
    	
		
		scrollPaneClasse3.setViewportView(tblClasse3);
		
		///////////////////////////////////////////////////////4
		
		JScrollPane scrollPaneClasse4 = new JScrollPane();
		scrollPaneClasse4.setBounds(36, 529, 622, 129);
		panel.add(scrollPaneClasse4);
		
		tblClasse4 = new JTable();
		tblClasse4.setRowSelectionAllowed(false);

		DefaultTableModel modele4 = new DefaultTableModel(data, entetes);
		tblClasse4.setModel(modele4);
		
		
		Connection conn;
    	String requete = "SELECT p.NumVoilier, NumSkipper, TmpsReel, TmpsCompense, Classe FROM Participer p, Voilier v";
    	requete += " Where p.NumVoilier = v.NumVoilier and NumRegate = " + NumRegate + " ORDER BY TmpsReel DESC";
    	System.out.println(requete);
		try {
			int i1 = 1, i2 = 1, i3 = 1, i4 = 1;
			conn = DriverManager.getConnection(cheminBdd);
	    	Statement s = conn.createStatement();
	    	ResultSet rs = s.executeQuery(requete);
	    	while (rs.next()) {
	    		if(rs.getInt(5) == 1){
		    		modele1.addRow(new Object[] {i1, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)});
		    		i1 = i1 + 1;
	    		}
	    		if(rs.getInt(5) == 2){
		    		modele2.addRow(new Object[] {i2, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)});
		    		i2 = i2 + 1;
	    		}
	    		if(rs.getInt(5) == 3){
		    		modele3.addRow(new Object[] {i3, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)});
		    		i3 = i3 + 1;
	    		}
	    		if(rs.getInt(5) == 4){
		    		modele2.addRow(new Object[] {i4, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)});
		    		i4 = i4 + 1;
	    		}
	    	}
	    	conn.close();
	    	s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		scrollPaneClasse4.setViewportView(tblClasse4);
		
		JLabel lblRsultatDeLa = new JLabel("R\u00E9sultats de la r\u00E9gate :");
		lblRsultatDeLa.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblRsultatDeLa.setBounds(237, 11, 251, 41);
		panel.add(lblRsultatDeLa);
		
		JLabel lblClasse1 = new JLabel("Classe 1");
		lblClasse1.setBounds(36, 62, 90, 14);
		panel.add(lblClasse1);
		
		JLabel lblClasse2 = new JLabel("Classe 2");
		lblClasse2.setBounds(36, 213, 90, 14);
		panel.add(lblClasse2);
		
		JLabel lblClasse3 = new JLabel("Classe 3");
		lblClasse3.setBounds(36, 364, 90, 14);
		panel.add(lblClasse3);
		
		JLabel lblClasse4 = new JLabel("Classe 4");
		lblClasse4.setBounds(36, 516, 90, 14);
		panel.add(lblClasse4);
		
		
		frame.setVisible(true);
	}
}
