package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercher(String unMatricule) {
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from Visiteur where matricule='" + unMatricule + "'");
		try {
			if (reqSelection.next()) {
				unVisiteur = new Visiteur(reqSelection.getString(1), 
						reqSelection.getString(2), 
						reqSelection.getString(3),
						reqSelection.getString(4), 
						reqSelection.getInt(5), 
						reqSelection.getString(6),
						reqSelection.getDate(7), 
						reqSelection.getString(8), 
						reqSelection.getString(9));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from MEDICAMENT where depotLegal='"
					+ unMatricule + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
}
