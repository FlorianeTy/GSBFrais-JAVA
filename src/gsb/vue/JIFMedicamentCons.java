package gsb.vue;
import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import java.util.ArrayList;
public class JIFMedicamentCons extends JIFMedicament {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Medicament> lesMedicaments;
	// methode qui permet d'afficher les donnees d'un médicament
	public JIFMedicamentCons() {
		super();// lance le code du constructeur de la classe JIFMedicament
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Consultation donnees Medicament");
		// recuperation des donnees Medicament dans la collection
		lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();
		if (lesMedicaments.size() != 0) {
			// si collection non vide, affichage des donnees du premier Medicament
			Medicament unMedicament = lesMedicaments.get(0);
			remplirText(unMedicament);
		}
	}
}