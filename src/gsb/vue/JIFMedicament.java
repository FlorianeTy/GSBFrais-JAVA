package gsb.vue;

import gsb.modele.Medicament;
import gsb.tests.Application;

import java.awt.Container;
import java.awt.GridLayout;

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


	
	public JIFMedicament() {
		
		
		// déclaration des sources d'évènements
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Fiche Médicament");

		p = new JPanel();
		pTexte = new JPanel(new GridLayout(7, 2));

		

		JLdepotLegal = new JLabel("Depot Legal");
		JLnomCommercial = new JLabel("Nom Commercial");
		JLcomposition = new JLabel("Composition");
		JLeffets = new JLabel("Effets");
		JLcontreIndication = new JLabel("Contre Indications");
		JLcodeFamille = new JLabel("Code Famille");
		JLlibelleFamille = new JLabel("Libelle Famille");

		JTdepotLegal = new JTextField(20);
		JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());
		JTnomCommercial = new JTextField();
		JTcomposition = new JTextField();
		JTeffets = new JTextField();
		JTcontreIndication = new JTextField();
		JTcodeFamille = new JTextField();
		JTlibelleFamille = new JTextField();

		pTexte.add(JLdepotLegal);
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
		
}

	
