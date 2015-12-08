package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Stockage;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.StockageDao;
import gsb.tests.Application;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JIFEchantillonStock extends JIFMedicament implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected JLabel JLcodeVisiteur;
	protected JTextField JTcodeVisiteur;
	protected ArrayList<Stockage> lesStocks;
	protected JScrollPane scrollPane;
    protected Application fenetreContainer;

    protected JButton JBafficherEchant;


	
	public JIFEchantillonStock(Application uneFenetreContainer) {
		super();
		fenetreContainer = uneFenetreContainer;
		// déclaration des sources d'évènements
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Fiche Médicament");
		
		//int nbLignes = lesStocks.size();


		p = new JPanel();
		pTexte = new JPanel(new GridLayout(7, 2));

		p.add(pTexte);
		Container contentPane = getContentPane();
		contentPane.add(p);

		JLcodeVisiteur = new JLabel("Code visiteur");
		
		JTcodeVisiteur = new JTextField(20);
		JTcodeVisiteur.setMaximumSize(JTcodeVisiteur.getPreferredSize());
		
		pTexte.add(JLcodeVisiteur);
		pTexte.add(JTcodeVisiteur);
		
		JBafficherEchant = new JButton("Afficher Echantillons");
        JBafficherEchant.addActionListener(this);
		
        pTexte.add(JBafficherEchant);
	}

	


	/*
	 * // ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
	 * addInternalFrameListener(new InternalFrameAdapter() { public void
	 * internalFrameClosing(InternalFrameEvent e) { // le code que tu veux
	 * exécuter à la fermeture de la // JInternalFrame } }
	 */

	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherEchant){
   			JBafficherEchant.setVisible(false);
   			
   			String codeVisiteur = JTcodeVisiteur.getText();
   			
			ArrayList<Stockage> lesStocks = StockageDao.retournerCollectionDesStocks(codeVisiteur);
			int nbLignes = lesStocks.size();
			JTable table;
			
			int i=0;
			String[][] data = new String[nbLignes][3] ;
			for(Stockage unStock : lesStocks){
				System.out.println(unStock.getUnMedicament().getDepotLegal());
				data[i][0] = unStock.getUnMedicament().getDepotLegal();
				data[i][1] = unStock.getUnMedicament().getNomCommercial();
				data[i][2] = Integer.toString(unStock.getStockQtite());
				i++;
			}
			
			
			
			String[] columnNames = {"Depot Legal", "Nom","Stock"};
			table = new JTable(data, columnNames);
			table.getTableHeader().setReorderingAllowed(false);

			scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(400, 200));
			scrollPane.setLocation(300, 0);
			p.add(scrollPane);
   		}	

} // fin actionPerformed
}