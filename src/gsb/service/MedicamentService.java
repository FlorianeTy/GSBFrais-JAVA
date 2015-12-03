package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	
	public static Medicament rechercherMedicament(String unDepotLegal){
		Medicament unMedicament = null;
		try{
		if (unDepotLegal==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		unMedicament = MedicamentDao.rechercherMedicament(unDepotLegal);
		}
		catch(Exception e){
			System.out.println("Erreur depot Legal");
		}
		return unMedicament;
	}
	
	

}