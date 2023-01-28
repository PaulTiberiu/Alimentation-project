import java.util.Scanner;

public class Tomate extends Aliment{
	public Tomate(double poids) {
		this.poids=poids;
		totalKcal();
		totalProteine();
		totalQuantiteSucre();
		totalMatiereGrasse();
		totalPrix();
	}
	//constructeur par copie
	public Tomate() {
		this(40.);
	}

	public void totalKcal() {
        kcal = poids * 0.211;
    }

    public void totalProteine() {
        proteine = poids * 0.009;
    }

    public void totalMatiereGrasse() {
        matieregrasse = poids * 0.002;
    }

    public void totalQuantiteSucre() {
        quantitesucre = poids * 0.026;
    }

	public String toString() {
		return "Tomate:"+super.toString();
	}

	public void totalPrix() {
		prix = poids*0.004;
	}
	
	public static void choix() throws SandwichException {
		@SuppressWarnings("resource")
		Scanner choix = new Scanner(System.in);
		System.out.println("Voulez vous des tomates dans votre sandwich ?\n\n0- Non\n\n1- Oui\n");
		String x = choix.next();
		try{
			if(Integer.parseInt(x)==0) {
				return;
			}
			else if(Integer.parseInt(x)==1) {
				System.out.println("Veuillez saisir la taille de votre portion de tomates :\n\n1- Petite\n\n2- Moyenne\n\n3- Grande\n");
				x = choix.next();
				double taille = 0;
				if(Integer.parseInt(x) <= 3 && Integer.parseInt(x) >= 1) {
					taille = Integer.parseInt(x);
				}
				else {
					throw new SandwichException();
				}
				System.out.println("Veuillez saisir le nombre de portions de tomates desire :\n");
				x = choix.next();
				for(int i=0;i<Integer.parseInt(x);i++) {
					if(taille == 2) {
						Sandwich.ajouterAliment(new Tomate());
					}
					else if(taille == 1) {
						Sandwich.ajouterAliment(new Tomate(35));
					}
					else {
						Sandwich.ajouterAliment(new Tomate(45));
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
