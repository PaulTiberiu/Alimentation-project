import java.util.Scanner;

public class SauceBlanche extends Sauce implements Epice{
	public SauceBlanche() {
		poids=10.;
		additifs="Acide citrique E330, Gomme de guar E412, Glutamate monosodique E621";
		nbsauce++;
		totalKcal();
		totalProteine();
		totalQuantiteSucre();
		totalMatiereGrasse();
		totalPrix();
		getNiveauEpice();
	}
	
	public void addPimentRouge() {
		niveauEpice++;
		prix+=0.5;
	}

	public void enleverPimentRouge() {
		if(niveauEpice>0) {
			niveauEpice--;
		}
		else {System.out.println("Niveau d'epice est deja au minimum");}
	}

	public int getNiveauEpice() {
		return niveauEpice;
		
	}

	public void totalKcal() {
		kcal=53.5;//une portion de sauce rouge(dans un sandwich) vaut environ 50kcal
	}

	public void totalProteine() {
		proteine=0.032;//grammes par portion sauce
	}

	public void totalQuantiteSucre() {
		quantitesucre=0.018;//grammes par portion sauce
	}

	public void totalMatiereGrasse() {
		matieregrasse=0.067;//grammes par portion sauce
	}

	public void totalPrix() {
		prix+=nbsauce*0.5;
	}

	public void supplementSauce() {
		poids+=poids;
		kcal+=kcal;//une portion de sauce rouge(dans un sandwich) vaut environ 50kcal
		proteine+=proteine;//grammes par portion sauce
		quantitesucre+=quantitesucre;//grammes par portion sauce
		matieregrasse+=matieregrasse;//grammes par portion sauce
		prix+=prix;
		nbsauce++;
	}
	
	public String toString() {
		return "SauceBlanche, niveau epice= "+getNiveauEpice()+" "+super.toString();
	}
	
	public static void choix() throws SandwichException {
		@SuppressWarnings("resource")
		Scanner choix = new Scanner(System.in);
		System.out.println("Voulez vous de la sauce blanche dans votre sandwich ?\n\n0- Non\n\n1- Oui\n");
		String x = choix.next();
		try{
			if(Integer.parseInt(x)==0) {
				return;
			}
			else if(Integer.parseInt(x)==1) {
				SauceBlanche sauce = new SauceBlanche();
				Sandwich.ajouterAliment(sauce);
				System.out.println("Veuillez saisir le nombre de portions desire :\n");
				x = choix.next();
				if(Integer.parseInt(x)<1) {
					throw new SandwichException();
				}
				for(int i=1;i<Integer.parseInt(x);i++) {
					sauce.supplementSauce();
				}
				System.out.println("Voulez-vous epicer votre sauce ?\n\n0- Non\n\n1- Oui\n");
				x = choix.next();
				if(Integer.parseInt(x)==1) {
					System.out.println("Combien de portions de piment souhaitez-vous ?\n");
					x = choix.next();
					if(Integer.parseInt(x)<1) {
						throw new SandwichException();
					}
					for(int i=0;i<Integer.parseInt(x);i++) {
						sauce.addPimentRouge();
					}
				}
				else if(Integer.parseInt(x)==0) {
					return;
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
