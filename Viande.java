import java.util.Scanner;

public class Viande extends Aliment {
    private String cuisson;
    private int type;
    private static Viande instance = null;
    //vollatile
    //interface bio qui augmente le prixtotal de chaque aliment
   
    
    private Viande(String type,double poids,String cuisson){
        this.cuisson = cuisson;
        this.poids = poids;
        if(type == "Poulet") {
        	this.type = 2;
        }
        else if(type == "Boeuf") {
        	this.type = 1;
        }
        totalKcal();
        totalProteine();
        totalMatiereGrasse();
        totalPrix();
    }
    
    public final static Viande getInstance(String type,double poids,String cuisson) {
        if (Viande.instance == null) {
            Viande.instance = new Viande(type,poids,cuisson);
        }
        return Viande.instance;
    }
    
    public String toString() {
        return type+" "+cuisson+super.toString()+"\n";
    }

    public void totalKcal() {
        if(type == 1) {
            kcal = poids * 1.75;
        }
        else if(type == 2) {
            kcal = poids * 1.2;
        }
    }

    public void totalProteine() {
        if(type == 1) {
            proteine = poids * 0.27;
        }
        else if(type == 2) {
            proteine = poids * 0.29;
        }
    }

    public void totalMatiereGrasse() {
        if(type == 1) {
            matieregrasse = poids * 0.15;
        }
        else if(type == 2) {
            matieregrasse = poids * 0.067;
        }
    }

    public void totalQuantiteSucre() {
        quantitesucre = 0;
    }

	public void totalPrix() {
		if(type==1){
			prix = poids*0.0175;
		}
		else if(type==2) {
			prix = poids *0.025;
		}
		else {
			System.out.println("On ne peut pas dire le prix pour une viande qu'on ne sert pas.");
		}
	}

	public static void choix() throws SandwichException {
		@SuppressWarnings("resource")
		Scanner choix = new Scanner(System.in);
		System.out.println("Voulez vous de la viande dans votre sandwich ?\n\n0- Non\n\n1- Oui\n");
		String x = choix.next();
		try{
			if(Integer.parseInt(x)==0) {
				return;
			}
			else if(Integer.parseInt(x)==1) {
				System.out.println("Veuillez saisir le type de viande que vous souhaitez :\n\n1- Boeuf\n\n2- Poulet\n");
				x = choix.next();
				if(Integer.parseInt(x) == 1) {
					System.out.println("Veuillez saisir la cuisson :\n\n1- Bleue\n\n2- Saignante\n\n3- A point\n\n4- Bien cuit\n");
					x = choix.next();
					String c;
					if(Integer.parseInt(x) == 1) {c="Bleue";}
					else if(Integer.parseInt(x) == 2) {c="Saignante";}
					else if(Integer.parseInt(x) == 3) {c="A point";}
					else if(Integer.parseInt(x) == 4) {c="Bien cuit";}
					else {
						throw new SandwichException();
					}
					System.out.println("Veuillez saisir le poids (en grammes) de votre viande :\n");
					x = choix.next();
					if(Integer.parseInt(x) < 1) {
						throw new SandwichException();
					}
					double p = Integer.parseInt(x);
					Sandwich.ajouterAliment(Viande.getInstance("Boeuf",p,c));
				}
				else if(Integer.parseInt(x) == 2) {
					System.out.println("Veuillez saisir le poids de votre viande (en gramme):\n");
					x = choix.next();
					if(Integer.parseInt(x) < 1) {
						throw new SandwichException();
					}
					double p = Integer.parseInt(x);
					Sandwich.ajouterAliment(Viande.getInstance("Poulet",p,"Grille"));
				}
				else {
					throw new SandwichException();
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
