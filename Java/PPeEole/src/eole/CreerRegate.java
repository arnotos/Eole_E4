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
import com.toedter.calendar.JDateChooser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;

public class CreerRegate extends Outils {
	private JTextField tfNom;
	private JTextField tfDistance;
	public CreerRegate(){
		final JFrame frmCreerUneR�gate = new JFrame("Cr�er un Skipper");
		frmCreerUneR�gate.setTitle("Cr\u00E9er une R\u00E9gate");
		frmCreerUneR�gate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCreerUneR�gate.setSize(279, 337);
		frmCreerUneR�gate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmCreerUneR�gate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(50, 53, 46, 14);
		panel.add(lblNom);
		
		tfNom = new JTextField();
		tfNom.setBounds(106, 50, 86, 20);
		panel.add(tfNom);
		tfNom.setColumns(10);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(50, 92, 46, 14);
		panel.add(lblDistance);
		
		tfDistance = new JTextField();
		tfDistance.setBounds(106, 89, 86, 20);
		panel.add(tfDistance);
		tfDistance.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(50, 167, 142, 20);
		panel.add(dateChooser);
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfNom.getText().isEmpty()){
					javax.swing.JOptionPane.showMessageDialog(null,"Le nom de la r�gate doit �tre remplie !");
				}else if(estEntier(tfDistance.getText())){
					javax.swing.JOptionPane.showMessageDialog(null,"La distance doit correctement �tre remplie !");
				}else{
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			    	Connection conn;
			    	String requete = "INSERT INTO Regate(NomRegate, Distance, DateHeure, estTermin�) VALUES ('" + tfNom.getText() + "', " +tfDistance.getText()+ ", #" + formatter.format(dateChooser.getDate()) + "#, No)";
					System.out.println(requete);
			    	try {
						conn = DriverManager.getConnection(cheminBdd);
				    	Statement s = conn.createStatement();
				    	s.executeUpdate(requete);
				    	conn.close();
				    	s.close();
				    	javax.swing.JOptionPane.showMessageDialog(null,"La r�gate a �tait renseign� avec succ�s !");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnValider.setBounds(10, 260, 89, 23);
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				System.exit(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAnnuler.setBounds(160, 260, 89, 23);
		panel.add(btnAnnuler);
		
		frmCreerUneR�gate.setVisible(true);
	}
}