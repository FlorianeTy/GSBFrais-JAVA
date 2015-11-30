package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import gsb.modele.Medicament;
public class JIFMedicament extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JLabel JLcode;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLfamille;
	protected JTextField JTcode;
	protected JTextField JTnom;
	protected JTextField JTfamille; //nanani nanana

	public JIFMedicament() {
		p = new JPanel(); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(8, 2));
		JLcode = new JLabel("Code");
		JLnom = new JLabel("Nom");
		JLfamille = new JLabel("Famille");
		JTcode = new JTextField(20);
		JTcode.setMaximumSize(JTcode.getPreferredSize());
		JTnom = new JTextField();
     	JTfamille = new JTextField();
		
		pTexte.add(JLcode);
		pTexte.add(JTcode);
		pTexte.add(JLnom);
		pTexte.add(JTnom);
		pTexte.add(JLfamille);
		pTexte.add(JTfamille);
		p.add(pTexte);
		p.add(pBoutons);
		
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void remplirText(Medicament unMedicament){ 
		// méthode qui permet de remplir les zones de texte à partir des valeurs
		// passées en paramètres
		JTcode.setText(unMedicament.getCodeFamille());
		JTnom.setText(unMedicament.getNomCommercial());
		JTfamille.setText(unMedicament.getLibelleFamille());
	}

	public void viderText(){ // méthode qui permet de vider les zones de texte

		JTcode.setText("");
		JTnom.setText("");
		JTfamille.setText("");
	}

	public void actionPerformed(ActionEvent arg0) {}

}