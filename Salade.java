import java.util.Scanner;

public class Salade extends Aliment{
	public Salade() {
		poids=30.;
		totalKcal();
		totalProteine();
		totalQuantiteSucre();
		totalMatiereGrasse();
		totalPrix();
	}

	public void totalKcal() {
		kcal = poids*0.15;
	}

	public void totalProteine() {
		proteine = poids*0.013;
	}

	public void totalQuantiteSucre() {
		quantitesucre = poids*0.017;
	}

	public void totalMatiereGrasse() {
		matieregrasse = poids*0.002;
	}

	public String toString() {
		return "Salade:"+super.toString();
	}

	public void totalPrix() {
		prix = poids*0.001;
	}
	
	public static void choix() throws SandwichException {
		@SuppressWarnings("resource")
		Scanner choix = new Scanner(System.in);
		System.out.println("Voulez vous de la salade dans votre sandwich ?\n\n0- Non\n\n1- Oui\n");
		String x = choix.next();
		try{
			if(Integer.parseInt(x)==0) {
				return;
			}
			else if(Integer.parseInt(x)==1) {
				System.out.println("Veuillez saisir le nombre de portion de salade desire :\n");
				x = choix.next();
				for(int i=0;i<Integer.parseInt(x);i++) {
					Sandwich.ajouterAliment(new Salade());
				}
			}
			else {
				throw new SandwichException();
			}
		}
		catch(NumberFormatException e){
			throw new SandwichException();
		}
	}
}
