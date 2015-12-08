package gsb.vue;
  
import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.tests.Application;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
  
  
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
  

public class JIFMedicamentListe extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
  
    private ArrayList<Medicament> lesMedicaments;
  
  
    protected JPanel p;
    protected JScrollPane scrollPane; 
    protected JPanel pSaisie;
    protected JTextField JTdepotLegal;
    protected JButton JBafficherFiche;
    protected Application fenetreContainer;
      
    public JIFMedicamentListe(Application uneFenetreContainer) {
        setTitle("Liste des médicaments");
        fenetreContainer = uneFenetreContainer;
        // récupération des données Medicament dans la collection
        lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();
                
        int nbLignes = lesMedicaments.size();
  
        JTable table;
          
          
  
        p = new JPanel(); // panneau principal de la fenêtre
  
        int i=0;
        String[][] data = new String[nbLignes][3] ;
        for(Medicament unMedicament : lesMedicaments){
            data[i][0] = unMedicament.getDepotLegal();
            data[i][1] = unMedicament.getNomCommercial();
            data[i][2] = unMedicament.getLibelleFamille();
            i++;
            }
        String[] columnNames = {"Depot Legal", "Nom Commercial","Libelle Famille"};
        table = new JTable(data, columnNames);
          
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        p.add(scrollPane);
          
        pSaisie = new JPanel();
        JTdepotLegal = new JTextField(20);
        JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());
        
        JBafficherFiche = new JButton("Afficher Fiche médicament");
        JBafficherFiche.addActionListener(this);
        pSaisie.add(JTdepotLegal);
        pSaisie.add(JBafficherFiche);
        p.add(pSaisie);
          
        // mise en forme de la fenêtre
        Container contentPane = getContentPane();
        contentPane.add(p);
          
          
    }
  
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Medicament unMedicament = MedicamentDao.rechercherMedicament(JTdepotLegal.getText());
   			if (unMedicament!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			} else  {
   				JOptionPane.showInternalMessageDialog(JTdepotLegal, "Depot Legal valide obligatoire");
   			}
   		}	
	}

}