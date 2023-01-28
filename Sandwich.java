import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
	private static double kcal;
	private static double proteine;
	private static double quantitesucre;
	private static double matieregrasse;
	private static double poids;
	private static String additifs="";
	private static ArrayList<Aliment> sandwich = new ArrayList<Aliment>();
	private static Sandwich instance = null;
	private static double prix;
	public static int nbAliment=0;
	public static final double MARGE = 0.3;
	private Sandwich() {}
	
	public final static Sandwich getInstance() {
        if (Sandwich.instance == null) {
            Sandwich.instance = new Sandwich();
        }
        return Sandwich.instance;
    }
	
	public static void ajouterAliment(Aliment a) {
		sandwich.add(a);
		nbAliment++;
	}
	
	public static int getNbAliment() {
		return nbAliment;
	}
	
	public static double getPrix() {
		for(int i=0;i<nbAliment;i++) {
			prix += sandwich.get(i).prix;
		}
		prix = (MARGE*prix)+prix;
		return prix;
	}
	
	public static double totalKcal() {
		for(int i=0;i<nbAliment;i++) {
			kcal += sandwich.get(i).kcal;
		}
		return kcal;
    }
	
	public static double totalProteine() {
		for(int i=0;i<nbAliment;i++) {
			proteine += sandwich.get(i).proteine;
		}
		return proteine;
    }
	
	public static String totalAdditifs() {
		for(int i=0;i<nbAliment;i++) {
			if(sandwich.get(i) instanceof Sauce) {
	            additifs+=((Sauce) sandwich.get(i)).getAdditifs()+"| ";
	        }
		}
		return additifs;
    }
	
	
	public static double totalMatiereGrasse() {
		for(int i=0;i<nbAliment;i++) {
			matieregrasse += sandwich.get(i).matieregrasse;
		}
		return matieregrasse;
    }

	public static double totalQuantiteSucre() {
		for(int i=0;i<nbAliment;i++) {
			quantitesucre += sandwich.get(i).quantitesucre;
		}
		return quantitesucre;
    }
	
	public String toString() {
		return "Commande Sandwich n°"+(int)(Math.random()*200)+"\nKcal :"+String.format("%.3f",Sandwich.totalKcal())+"g\nProteine :"+String.format("%.3f",Sandwich.totalProteine())+"g\nMatiere grasse :"+String.format("%.3f",Sandwich.totalMatiereGrasse())+"g\nQuantite de sucre :"+String.format("%.3f",Sandwich.totalQuantiteSucre())+"\nAdditifs :"+totalAdditifs()+"\n\nPrix :"+String.format("%.3f",Sandwich.getPrix())+"€\n";
	}
	
	public void totalPrix() {
		prix = poids*0.00358;
	}
	
	public static void commande() {
		System.out.println("Bonjour et bienvenue dans notre restaurant !\n\nDemarrons ensemble votre commande.\n\n");
		Sandwich S1 = getInstance();
		try {
			@SuppressWarnings("resource")
			Scanner choix = new Scanner(System.in);
			System.out.println("--------------------MENU--------------------\n\n1- Le AmericanBeef : 6,065€\nPain normal\n200g de boeuf saignant\n2 portions d'oignons\n1 portion de sauce rouge\n\n2- Le ItalianPoulet : 8,796€\nPain normal\n200g de poulet\n1 portion de salade\n1 portion de tomate\n2 portions de sauce blanche\n\n3- Le Veggie : 1,762€\nPain Tortilla\n2 portions de salade\n2 portions de tomates\n1 portion d'oignon\n1 portion de sauce blanche\n\n4- Construisez-vous meme votre Sandwich !\n---------------------------------------------\n");
			String x = choix.next();
			if(Integer.parseInt(x) < 1 || Integer.parseInt(x) > 4) {
				throw new SandwichException();
			}
			else if(Integer.parseInt(x) == 4) {
				Pain.choix();
				Viande.choix();
				Salade.choix();
				Tomate.choix();
				Oignon.choix();
				SauceBlanche.choix();
				SauceRouge.choix();
				System.out.println("\nVoici le resume de votre commande :\n\n");
				System.out.println(S1.toString());
			}
			else if(Integer.parseInt(x) == 1) {
				Sandwich.ajouterAliment(Pain.getInstance(1));
				Sandwich.ajouterAliment(Viande.getInstance("Boeuf",200,"saignante"));
				Sandwich.ajouterAliment(new Oignon());
				Sandwich.ajouterAliment(new SauceRouge());
				System.out.println("\nVoici le resume de votre commande :\n\n");
				System.out.println(S1.toString());
			}
			else if(Integer.parseInt(x) == 2) {
				Sandwich.ajouterAliment(Pain.getInstance(1));
				Sandwich.ajouterAliment(Viande.getInstance("Poulet",200,"grill�"));
				Sandwich.ajouterAliment(new Salade());
				Sandwich.ajouterAliment(new Tomate());
				SauceBlanche sb = new SauceBlanche();
				sb.supplementSauce();
				Sandwich.ajouterAliment(sb);
				System.out.println("\nVoici le resume de votre commande :\n\n");
				System.out.println(S1.toString());
			}
			else {
				Sandwich.ajouterAliment(Pain.getInstance(2));
				Sandwich.ajouterAliment(new Oignon());
				Sandwich.ajouterAliment(new Salade());
				Sandwich.ajouterAliment(new Tomate());
				Sandwich.ajouterAliment(new SauceBlanche());
				System.out.println("\nVoici le resume de votre commande :\n\n");
				System.out.println(S1.toString());
			}
		} catch (SandwichException e) {
			e.printStackTrace();
		}
	}
}
