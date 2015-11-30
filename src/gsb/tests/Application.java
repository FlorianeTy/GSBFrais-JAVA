
package gsb.tests;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gsb.vue.JIFAjoutStock;
import gsb.vue.JIFEchantillonStock;
import gsb.vue.JIFMedecinCons;
import gsb.vue.JIFMedecinListe;
import gsb.vue.JIFMedicamentListe;

public class Application extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 2591453837113855452L;
	
	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane dp;
	
	public Application(){
		super();
				
		build();
	}
	
	private void build(){
		myJInternalFrame = new JInternalFrame();// pour affichage d'une seule JInternalFrame � la fois
		
		dp = new JDesktopPane();
		dp.setBackground(Color.lightGray);
		setContentPane(dp);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuMedecins = new JMenu("Medecins");
		
		JMenuItem medecinConsultation = new JMenuItem("Consultation Medecin");
		medecinConsultation.addActionListener(this); // installation d'un �couteur d'action
		menuMedecins.add(medecinConsultation);
		JMenuItem medecinListe = new JMenuItem("Liste Medecins");
		medecinListe.addActionListener(this); // installation d'un �couteur d'action
		menuMedecins.add(medecinListe);

		JMenu menuMedicaments = new JMenu("Medicaments");
		JMenuItem medicListe = new JMenuItem("Liste des Medicament");
		medicListe.addActionListener(this); // installation d'un �couteur d'action
		menuMedicaments.add(medicListe);
		JMenuItem medicStockEchant = new JMenuItem("Stock des Echantillons");
		medicStockEchant.addActionListener(this); // installation d'un �couteur d'action
		menuMedicaments.add(medicStockEchant);
		JMenuItem medicAjoutEchant = new JMenuItem("Ajouter des Echantillons");
		medicAjoutEchant.addActionListener(this); // installation d'un �couteur d'action
		menuMedicaments.add(medicAjoutEchant);

		/*JMenu menuVisites = new JMenu("Visites");
		JMenuItem visiteCons = new JMenuItem("Consultation Visite");
		visiteCons.addActionListener(this); // installation d'un �couteur d'action
		menuVisites.add(visiteCons);
		JMenuItem visiteAjout = new JMenuItem("Ajout Visite");
		visiteAjout.addActionListener(this); // installation d'un �couteur d'action
		menuVisites.add(visiteAjout);*/

		menuBar.add(menuMedecins);
		menuBar.add(menuMedicaments);
		/*menuBar.add(menuVisites);*/
		
		setJMenuBar(menuBar);
		
		setTitle("GSB"); //On donne un titre � l'application
		setSize(800,500); //On donne une taille � notre fen�tre
		setLocationRelativeTo(null); //On centre la fen�tre sur l'�cran
		setResizable(true); //On autorise la redimensionnement de la fen�tre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de se fermer lors du clic sur la croix
		
		
		
		
	}
	 
	public void actionPerformed(ActionEvent e) {
		// TODO Raccord de m�thode auto-g�n�r�
		if (e.getSource() instanceof JMenuItem) {
		String ChoixOption = e.getActionCommand();

			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fen�tre
				ouvrirFenetre(new JIFMedecinCons());

			} else if (ChoixOption.equals("Liste Medecins")) {
				// Creation d'une sous-fen�tre
				ouvrirFenetre(new JIFMedecinListe(this));
				
			} else if (ChoixOption.equals("Liste des Medicament")) {
				// Creation d'une sous-fen�tre
				ouvrirFenetre(new JIFMedicamentListe(this));

			} else if (ChoixOption.equals("Stock des Echantillons")) {
				//ouvrirFenetre(new JIFEchantillonStock());

			} else if (ChoixOption.equals("Ajouter des Echantillons")) {
				ouvrirFenetre(new JIFAjoutStock(this));
			}
		}
				 
	}
	
	public void ouvrirFenetre(JInternalFrame uneFenetre) {

		myJInternalFrame.dispose(); // si une fen�tre �tait dej� affich�e, elle
									// est lib�r�e
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(false);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(480, 380);
		dp.add(myJInternalFrame);
		myJInternalFrame.setVisible(true);
	}
	
	
	
}