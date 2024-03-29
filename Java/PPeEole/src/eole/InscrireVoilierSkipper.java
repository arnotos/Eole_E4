package eole;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscrireVoilierSkipper extends Outils{
	private JTable table;
	public InscrireVoilierSkipper(){
		final JFrame frmListeDesRegates = new JFrame("Cr�er un Voilier");
		frmListeDesRegates.setTitle("Liste des R\u00E9gates en attente");
		frmListeDesRegates.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListeDesRegates.setSize(389, 400);
		frmListeDesRegates.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmListeDesRegates.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 359, 292);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		
		String[] entetes = {"Nom", "Distance", "Date", "Id"};
		Object[][] data = {};
		DefaultTableModel modele = new DefaultTableModel(data, entetes);
		table.setModel(modele);
		
		Connection conn;
    	String requete = "Select * From Regate Where estTermin� = false";
		try {
			conn = DriverManager.getConnection(cheminBdd);
	    	Statement s = conn.createStatement();
	    	ResultSet rs = s.executeQuery(requete);
	    	conn.close();
	    	s.close();
	    	while (rs.next()) {
	    		modele.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3).substring(0, 10), rs.getString(4)});
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		
		JButton btnInscrire = new JButton("Inscrire");
		btnInscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					new PopUpSkipperVoilier((String)table.getValueAt(table.getSelectedRow(), 3));
				}catch (Exception e){
					javax.swing.JOptionPane.showMessageDialog(null,"Veuillez choisir une r�gate !");
				}
			}
		});
		btnInscrire.setBounds(38, 314, 89, 23);
		panel.add(btnInscrire);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		frmListeDesRegates.dispose();
		      	}
		      });
		btnQuitter.setBounds(232, 314, 89, 23);
		panel.add(btnQuitter);
		
		frmListeDesRegates.setVisible(true);
	}
}