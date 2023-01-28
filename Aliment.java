
public abstract class Aliment {
	protected double kcal;
	protected double proteine;
	protected double quantitesucre;
	protected double matieregrasse;
	protected double poids;
	protected double prix;
	protected int choix;
	
	public abstract void totalKcal();
	public abstract void totalProteine();
	public abstract void totalQuantiteSucre();
	public abstract void totalMatiereGrasse();
	public abstract void totalPrix();
	
	public String toString() {
		return " kcal=" + String.format("%.3f", kcal) + ", proteine=" + String.format("%.3f", proteine) + "g, quantitesucre=" + String.format("%.3f", quantitesucre)
				+"g"+ ", matieregrasse=" + String.format("%.3f", matieregrasse) + "g"+ ", poids=" + String.format("%.3f", poids)+"g"+", prix produit="+String.format("%.3f", prix)+"€";
	}
	
}