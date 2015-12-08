package gsb.vue;

import gsb.modele.Medicament;
import gsb.modele.Stockage;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockageDao;
import gsb.tests.Application;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	
	
	protected JLabel JLdepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLcontreIndication;
	protected JLabel JLcodeFamille;
	protected JLabel JLlibelleFamille;

	
	

	protected JTextField JTdepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreIndication;
	protected JTextField JTcodeFamille;
	protected JTextField JTlibelleFamille;
    protected Application fenetreContainer;

    private ArrayList<Medicament> lesMedicaments;

	
	public JIFMedicament() {
		// déclaration des sources d'évènements
		setTitle("Fiche Médicament");

		p = new JPanel();
		pTexte = new JPanel(new GridLayout(7, 2));

		JLdepotLegal = new JLabel("Depot Legal");
		JLdepotLegal.setSize(200,150);
		JLnomCommercial = new JLabel("Nom Commercial");
		JLnomCommercial.setSize(200,150);
		JLcomposition = new JLabel("Composition");
		JLcomposition.setSize(200,150);
		JLeffets = new JLabel("Effets");
		JLeffets.setSize(200,150);
		JLcontreIndication = new JLabel("Contre Indications");
		JLcontreIndication.setSize(200,150);
		JLcodeFamille = new JLabel("Code Famille");
		JLcodeFamille.setSize(200,150);
		JLlibelleFamille = new JLabel("Libelle Famille");
		JLcodeFamille.setSize(200,150);

		JTdepotLegal = new JTextField(20);
		JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());
		JTnomCommercial = new JTextField();
		JTcomposition = new JTextField();
		JTeffets = new JTextField();
		JTcontreIndication = new JTextField();
		JTcodeFamille = new JTextField();
		JTlibelleFamille = new JTextField();

		pTexte.add(JLdepotLegal, BorderLayout.CENTER);
		pTexte.add(JTdepotLegal);
		pTexte.add(JLnomCommercial);
		pTexte.add(JTnomCommercial);
		pTexte.add(JLcomposition);
		pTexte.add(JTcomposition);
		pTexte.add(JLeffets);
		pTexte.add(JTeffets);
		pTexte.add(JLcontreIndication);
		pTexte.add(JTcontreIndication);
		pTexte.add(JLcodeFamille);
		pTexte.add(JTcodeFamille);
		pTexte.add(JLlibelleFamille);
		pTexte.add(JTlibelleFamille);
		
		p.add(pTexte);
		Container contentPane = getContentPane();
		contentPane.add(p);
		
		}
	
		public void remplirText(Medicament unMedicament) {
		// méthode qui permet de remplir les zones de texte à partir des valeurs
		// passées en paramètres
		JTdepotLegal.setText(unMedicament.getDepotLegal());
		JTnomCommercial.setText(unMedicament.getNomCommercial());
		JTcomposition.setText(unMedicament.getComposition());
		JTeffets.setText(unMedicament.getEffets());
		JTcontreIndication.setText(unMedicament.getContreIndication());
		JTcodeFamille.setText(unMedicament.getCodeFamille());
		JTlibelleFamille.setText(unMedicament.getLibelleFamille());
	}
		
		public void viderText() 	
	    {  // méthode qui permet de vider les zones de texte 
			JTdepotLegal.setText("");
			JTnomCommercial.setText("");
			JTcomposition.setText("");
			JTeffets.setText("");
			JTcontreIndication.setText("");
			JTcodeFamille.setText("");
			JTlibelleFamille.setText("");
	     }
		
		public void actionPerformed(ActionEvent evt) { 
			Object source = evt.getSource();
			String depotLegal = JTdepotLegal.getText();
			Medicament leMedicament = MedicamentDao.rechercherMedicament(depotLegal);
			remplirText(leMedicament);
		    	
		}
}

	
