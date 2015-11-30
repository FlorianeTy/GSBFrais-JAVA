package gsb.modele;

import java.util.ArrayList;

public class Medicament {
	protected String depotLegal;
	protected String nomCommercial;
	protected String composition;
	protected String effets;
	protected String contreIndication;
	protected float  prixEchantillon;
	protected String codeFamille;
	protected String libelleFamille;
	protected ArrayList<Medicament> lesMedicaments;
	
	public Medicament(String depotLegal, String nomCommercial, String composition, String effets,
			String contreIndication, String codeFamille, String libelleFamille) {
		
		this.depotLegal = depotLegal;
		this.nomCommercial = nomCommercial;
		this.composition = composition;
		this.effets = effets;
		this.contreIndication = contreIndication;
		this.codeFamille = codeFamille;
		this.libelleFamille = libelleFamille;
		lesMedicaments = new ArrayList<Medicament>();
	}

	public  String getDepotLegal() {
		return depotLegal;
	}

	public void setDepotLegal(String depotLegal) {
		this.depotLegal = depotLegal;
	}

	public String getNomCommercial() {
		return nomCommercial;
	}

	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getEffets() {
		return effets;
	}

	public void setEffets(String effets) {
		this.effets = effets;
	}

	public String getContreIndication() {
		return contreIndication;
	}

	public void setContreIndication(String contreIndication) {
		this.contreIndication = contreIndication;
	}

	public String getCodeFamille() {
		return codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	public String getLibelleFamille() {
		return libelleFamille;
	}

	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}
	
	public ArrayList<Medicament> getLesMedicaments() {
		return lesMedicaments;
	}

	
	public void setLesStocks(ArrayList<Medicament> lesMedicaments) {
		this.lesMedicaments = lesMedicaments;
	}
	
}