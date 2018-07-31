package pendu;

import java.util.Scanner;

public class Game {



	//mot vers tableau (rentrer un mot et le mettre dans char[]
	char[] motVersTab(String s) {

		//d�claration du tableau et initialisation de sa taille ( qui sera la taille du mot s.length)
		char[] mot = new char[s.length()];

		//on fait une boucle for pour placer les lettres de s dans le tableau mot
		for(int i=0; i<s.length(); i++) {

			//la methode charAt de la classe String permet de prendre une cha�ne de caract�re en char
			mot[i] = s.charAt(i); }

		//on retournera la tableau mot de type char
		return mot;
	}


	void affiche(char[] mot, boolean[] vu) {
		int i;
		for(i=0; i<mot.length; i++) {
			//on affiche les lettres trouv�es gr�ve au tableau boolean vu

			if (vu[i] == true) {
				System.out.print(mot[i]); }
			else {
				System.out.print("?");
			}
		}
	}


	boolean[] metAJour(char[] mot, boolean[] vu, char c) {
		int i;
		for(i=0; i<mot.length; i++) {
			if(c == mot[i]) {
				vu[i] = true; }
		}
		return vu;
	}
	boolean partieFinie(boolean vu[]) {
		int i;
		//tant qu'il y a un false la partie continue

		for(i=0; i<vu.length; i++) {
			if (vu[i] == false) {
				return false;
			}
		}
		//la methode retourne true si toutes les lettres sont trouv�es

		return true;

	}
	void partie(String mot) {
		//cr�ation du tableau de bool�ens de la longueur du tableau mot
		boolean[] vu = new boolean[motVersTab(mot).length];

		//permet d'afficher le mot cach�
		affiche(motVersTab(mot), vu);

		//tant que partieFinie ne renvoie pas true
		while (partieFinie(vu) == false) 
		{
			//l'utilisateur peut entrer une lettre
			Scanner input = new Scanner(System.in);
			System.out.println("\nEntrez une lettre : ");
			String userLetter = input.next();
			char userChar = userLetter.charAt(0);
			//le tableau de bool�ens est mis � jour

			metAJour(motVersTab(mot), vu, userChar);
			//on affiche le mot cach�

			affiche(motVersTab(mot), vu);
			//si partieFinie renvoie true

			if (partieFinie(vu)) 
			{
				//alors on affiche un message et la boucle s'arr�te
				System.out.println("\nLa partie est finie.");
			} 

		}
	}
}







