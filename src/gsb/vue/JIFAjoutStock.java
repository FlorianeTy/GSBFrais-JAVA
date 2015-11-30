package gsb.vue;
  
import gsb.modele.Stockage;
import gsb.modele.dao.StockageDao;
import gsb.tests.Application;
  
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
  

public class JIFAjoutStock extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
  
    protected JPanel p;
    protected JPanel pSaisie;
    
    
    protected JTextField JTdepotLegal;
    protected JTextField JTcodeVisiteur;
    protected JTextField JTquantite;
    
    protected JLabel JLdepotLegal;
    protected JLabel JLcodeVisiteur;
    protected JLabel JLquantite;
    
    
    protected JButton JBajoutStock;
    protected Application fenetreContainer;

	public Stockage unStock;


      
  
    public JIFAjoutStock(Application uneFenetreContainer) {
      
        fenetreContainer = uneFenetreContainer;
        // récupération des données Medecin dans la collection
         setTitle("Ajout échantillons pour un visiteur");
         
           
        p = new JPanel(); // panneau principal de la fenêtre
        pSaisie = new JPanel(new GridLayout(4,2));
        
        JTcodeVisiteur = new JTextField();
        JTdepotLegal = new JTextField(20);
        JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());
        JTquantite = new JTextField();
        
        JLdepotLegal = new JLabel("Depot légal");
        JLcodeVisiteur = new JLabel("Code visiteur");
        JLquantite = new JLabel("Quantité");
        
        JBajoutStock = new JButton("Ajouter quantité");
        JBajoutStock.addActionListener(this);
        pSaisie.add(JLcodeVisiteur);
        pSaisie.add(JTcodeVisiteur);
        pSaisie.add(JLdepotLegal);
        pSaisie.add(JTdepotLegal);
        pSaisie.add(JLquantite);
        pSaisie.add(JTquantite);
        pSaisie.add(JBajoutStock);
        p.add(pSaisie);
          
        // mise en forme de la fenêtre
        Container contentPane = getContentPane();
        contentPane.add(p);
          
          
    }
  
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object source = arg0.getSource();
        if (source == JBajoutStock){
            StockageDao.ajouterStock(unStock);
           } 
    }
      
}