package gsb.service;

import gsb.modele.Stockage;
import gsb.modele.dao.StockageDao;

public class StockageService {
	
	public static Stockage rechercher(String matricule, String depotleg){
		Stockage unStock = null;
		try{
		if (matricule==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		unStock = StockageDao.rechercher(matricule, depotleg);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unStock;
	}
	

}