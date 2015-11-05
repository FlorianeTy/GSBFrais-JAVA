package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import gsb.modele.Medicament;
public class MedicamentDao {

	public static int ajouterEchantillon (Medicament unMedicament) {
		int result = 0;
		String requeteInsertion;
		String depotLegal = unMedicament.getDepotLegal();
		String nomCommercial = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets = unMedicament.getEffets();
		String contreIndication = unMedicament.getContreIndication();
		Float prixEchantillon = unMedicament.getPrixEchantillon();
		String codeFamille = unMedicament.getCodeFamille();
		String libelleFamille = unMedicament.getLibelleFamille();
		requeteInsertion = "insert into MEDICAMENT values('" + depotLegal + "','" + nomCommercial + "','" + composition
				+ "'," + "'" + effets + "','" + contreIndication + "','" + prixEchantillon + "','" + codeFamille + "','"
				+ libelleFamille + "')";
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("echec insertion Medicament");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	
	
	public static int stockVisiteur (String unMatricule){
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select ..... from ...... where MATRICULE ='"+unMatricule+"'");
		int resultat = 0;
		try {
			if (reqSelection.next()) resultat = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
		
	
	
	public static int ficheMedicament (String unDepotLegal){
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where DEPOTLEGAL ='"+unDepotLegal+"'");
		int resultat = 0;
		try {
			if (reqSelection.next()) resultat = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}	
	
	public static int listeMedicament() {
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DepotLegal, NomCommercial from MEDICAMENT");
		int resultat = 0;
		try{
			if (reqSelection.next()) resultat = 1;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return resultat;
	}
	
	
	}
	
	
	

