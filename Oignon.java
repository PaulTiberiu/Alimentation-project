import java.util.Scanner;

public class Oignon extends Aliment{
	public Oignon(double poids) {
		this.poids=poids;
		totalKcal();
		totalProteine();
		totalQuantiteSucre();
		totalMatiereGrasse();
		totalPrix();
	}
	//constructeur par copie
	public Oignon() {
		this(25.);
	}

	public void totalKcal() {
        kcal = poids * 0.378;
    }

    public void totalProteine() {
        proteine = poids * 0.011;
    }

    public void totalMatiereGrasse() {
        matieregrasse = poids * 0.002;
    }

    public void totalQuantiteSucre() {
        quantitesucre = poids * 0.042;
    }

	public String toString() {
		return "Oignon:"+super.toString();
	}
	
	public void totalPrix() {
		prix = poids*0.00358;
	}
	
	public static void choix() throws SandwichException {
		@SuppressWarnings("resource")
		Scanner choix = new Scanner(System.in);
		System.out.println("Voulez vous des oignons dans votre sandwich ?\n\n0- Non\n\n1- Oui\n");
		String x = choix.next();
		try{
			if(Integer.parseInt(x)==0) {
				return;
			}
			else if(Integer.parseInt(x)==1) {
				System.out.println("Veuillez saisir la taille de vos portions d'oignons :\n\n1- Petit\n\n2- Moyen\n\n3- Grand\n");
				x = choix.next();
				double taille = 0;
				if(Integer.parseInt(x) <= 3 && Integer.parseInt(x) >= 1) {
					taille = Integer.parseInt(x);
				}
				else {
					throw new SandwichException();
				}
				System.out.println("Veuillez saisir le nombre de portions d'oignons desire :\n");
				x = choix.next();
				for(int i=0;i<Integer.parseInt(x);i++) {
					if(taille == 2) {
						Sandwich.ajouterAliment(new Oignon());
					}
					else if(taille == 1) {
						Sandwich.ajouterAliment(new Oignon(20));
					}
					else {
						Sandwich.ajouterAliment(new Oignon(30));
					}
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
