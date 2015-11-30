package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import gsb.modele.Medicament;
import gsb.modele.dao.ConnexionMySql;

public class MedicamentDao {

	public static ArrayList<Medicament> retournerCollectionDesMedicaments() {
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from MEDICAMENT");
		try {
			while (reqSelection.next()) {
				String depotLegal = reqSelection.getString(1);
				collectionDesMedicaments.add(MedicamentDao.rechercherMedicament(depotLegal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}

	public static int ajouterEchantillon(Medicament unMedicament) {
		int result = 0;
		String requeteInsertion;
		String depotLegal = unMedicament.getDepotLegal();
		String nomCommercial = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets = unMedicament.getEffets();
		String contreIndication = unMedicament.getContreIndication();
		String codeFamille = unMedicament.getCodeFamille();
		String libelleFamille = unMedicament.getLibelleFamille();
		requeteInsertion = "insert into MEDICAMENT values('" + depotLegal + "','" + nomCommercial + "','" + composition
				+ "'," + "'" + effets + "','" + contreIndication + "','" + codeFamille + "','"
				+ libelleFamille + "')";
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("echec insertion Medicament");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static int stockVisiteur(String unMatricule) {
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select ..... from ...... where MATRICULE ='" + unMatricule + "'");
		int resultat = 0;
		try {
			if (reqSelection.next())
				resultat = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	

	public static Medicament rechercherMedicament(String depotLegal) {
		Medicament unMedicament = null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where depotLegal='" + depotLegal + "'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),
						reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), reqSelection.getString(7));
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}

}
