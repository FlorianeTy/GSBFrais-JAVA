package gsb.modele;

import java.util.ArrayList;

public class Stockage {
	protected String StockReference;
	protected String StockDepotLegal;
	protected String StockQtite;
	protected ArrayList<Stockage> lesStocks;
	
	public Stockage(String StockReference, String StockDepotLegal, String StockQtite) {
		
		this.StockReference = StockReference;
		this.StockDepotLegal = StockDepotLegal;
		this.StockQtite = StockQtite;
		lesStocks = new ArrayList<Stockage>();
	}


	public String getStockReference() {
		return StockReference;
	}


	public void setStockReference(String stockReference) {
		StockReference = stockReference;
	}


	public String getStockDepotLegal() {
		return StockDepotLegal;
	}


	public void setStockDepotLegal(String stockDepotLegal) {
		StockDepotLegal = stockDepotLegal;
	}


	public String getStockQtite() {
		return StockQtite;
	}


	public void setStockQtite(String stockQtite) {
		StockQtite = stockQtite;
	}

	public ArrayList<Stockage> getLesStocks() {
		return lesStocks;
	}

	
	public void setLesStocks(ArrayList<Stockage> lesStocks) {
		this.lesStocks = lesStocks;
	}
	
	
}