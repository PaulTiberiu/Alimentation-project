
public abstract class Sauce extends Aliment{
	protected int niveauEpice;
	protected String additifs;
	protected static int nbsauce = 0;
	
	public abstract void supplementSauce();
	public static int getNbSauce() {
		return nbsauce;
	}
	public String getAdditifs(){
		return additifs;
	}
	
}
