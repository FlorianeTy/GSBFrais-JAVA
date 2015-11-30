package gsb.modele;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Visiteur;

public class Stockage {

	protected int stockQtite;
	protected ArrayList<Stockage> lesStocks;
	public Medicament unMedicament;
	public Visiteur unVisiteur;
	
	public Stockage(int stockQtite, Medicament unMedicament, Visiteur unVisiteur) {
	
		this.stockQtite = stockQtite;
		this.unMedicament = unMedicament;
		this.unVisiteur = unVisiteur;
		lesStocks = new ArrayList<Stockage>();
	}

	public int getStockQtite() {
		return stockQtite;
	}


	public void setStockQtite(int stockQtite) {
		this.stockQtite = stockQtite;
	}

	public ArrayList<Stockage> getLesStocks() {
		return lesStocks;
	}

	
	public void setLesStocks(ArrayList<Stockage> lesStocks) {
		this.lesStocks = lesStocks;
	}

	public Medicament getUnMedicament() {
		return unMedicament;
	}

	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}

	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
	
	
}