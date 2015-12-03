package gsb.service;

import gsb.modele.Stockage;
import gsb.modele.dao.StockageDao;

public class StockageService {
	
	public static Stockage rechercher(String reference){
		Stockage unStock = null;
		try{
		if (reference==null) {
            throw new Exception("Donnée obligatoire : code");
        }
		unStock = StockageDao.rechercher(reference);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unStock;
	}
	

}