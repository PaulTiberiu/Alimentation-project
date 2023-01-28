import java.util.Scanner;

public class Pain extends Aliment{
	private String type;
	private static Pain instance = null;
	private Pain(int numero) {
		if(numero==1) {type="Normal";}
		else if(numero==2) {type="Tortilla";}
		poids=200;
		totalKcal();
		totalProteine();
		totalQuantiteSucre();
		totalMatiereGrasse();
		totalPrix();
	}
	
	public final static Pain getInstance(int type) {
        if (Pain.instance == null) {
            Pain.instance = new Pain(type);
        }
        return Pain.instance;
    }

	public void totalKcal() {
        kcal = poids * 1.9;
    }

    public void totalProteine() {
        proteine = poids * 0.008;
    }

    public void totalMatiereGrasse() {
        matieregrasse = poids * 0.0011;
    }

    public void totalQuantiteSucre() {
        quantitesucre = poids * 0.0012;
    }

	public String toString() {
		return "Pain "+type+" :"+super.toString();
	}

	public void totalPrix() {
		prix = poids*0.00288;
	}
	
	public static void choix() throws SandwichException {
		@SuppressWarnings("resource")
		Scanner choix = new Scanner(System.in);
		System.out.println("Quel sorte de pain voulez vous ?\n\n1- Pain normal\n\n2- Tortilla\n");
		String x = choix.next();
		try{
			if(Integer.parseInt(x)==1 || Integer.parseInt(x)==2) {
				Sandwich.ajouterAliment(Pain.getInstance(Integer.parseInt(x)));
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
