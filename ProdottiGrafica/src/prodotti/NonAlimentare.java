package prodotti;

public class NonAlimentare extends Prodotti {

	String materiale;

	public NonAlimentare(String codice, String descrizione, float prezzo, String materiale) {
		super(codice, descrizione, prezzo);
		this.materiale = materiale;
	}

	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}

	public String getMateriale() {
		return materiale;
	}
	
	@Override
	public void applicaSconto() {
		// TODO Auto-generated method stub
		if (materiale.equals("carta") || materiale.equals("vetro")) {
			prezzo = prezzo *0.90f;
		} else {
			super.applicaSconto();
		}
	}

	@Override
	public String toString() {
		return "Non Alimentare [codice=" + codice + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", materiale=" + materiale + "]";
	}
}
