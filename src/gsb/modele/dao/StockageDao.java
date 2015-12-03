package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.Stockage;
import gsb.modele.Visiteur;

public class StockageDao {

	public static Stockage rechercher(String matricule) {
		Stockage unStock = null;
		/*String depotLegal = MedicamentDao.rechercher(depotLegal);*/
		
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from STOCKAGE where MATRICULE='" + matricule + "'");
		try {
			if (reqSelection.next()) {
				Medicament unMedicament = MedicamentDao.rechercherMedicament(reqSelection.getString(2));
				Visiteur unVisiteur = VisiteurDao.rechercher(reqSelection.getString(1));
				unStock = new Stockage(unVisiteur, unMedicament, reqSelection.getInt(3));
			}
			;

		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from STOCKAGE where MATRICULE='"
					+ matricule + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unStock;
	}

	public static ArrayList<Stockage> retournerCollectionDesStocks(String matricule) {
		ArrayList<Stockage> collectionDesStocks = new ArrayList<Stockage>();
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from STOCKAGE where Matricule ='" + matricule + "'");
		try {
			while (reqSelection.next()) {
				Stockage unStock = StockageDao.rechercher(matricule);
				collectionDesStocks.add(unStock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesStocks()");
		}
		return collectionDesStocks;
	}
	
	public static int ajouterStock(Stockage unStock){
		int result = 0;
		String requeteInsertion;
		String depotLegal = unStock.unMedicament.getDepotLegal();
		String codeVisiteur = unStock.unVisiteur.getMatricule();
		int quantite= unStock.getStockQtite();
		
		requeteInsertion = "insert into STOCKAGE values('"+codeVisiteur+"','"+depotLegal+"',"+quantite+")";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion STOCKAGE");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
