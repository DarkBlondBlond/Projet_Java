package shogi;

/**
 * Creation d'une reserve pour chaque joueur, pour y stocker les pieces capturees a l'adversaire
 */

import java.util.ArrayList;

public class Reserve {
	
    private ArrayList<Piece> pieces = new ArrayList<Piece>();
    private int joueur;
    
    /**
     * Definit les attributs de la classe "Reserve" :
	 *  
	 * @param pieces cree une ArrayList pour stocker les pieces presentes dans la reserve de chaque joueur
	 * @param joueur determine si la reserve appartient au joueur 1 ou 2
     */
    
    // Constructeur 
    public Reserve (int j) {
        this.joueur = j;
        for (int i = 0; i < 38; i++) {
            pieces.add(null);  
        }
    }

    // Getters
    public int getJoueur () {
        return joueur;
    }
    
    public Piece getPiece (int i) {
        return pieces.get(i); 
    }

    // Setter 
    public void setPiece (int i, Piece p) {
        pieces.set(i, p); 
    }

    // Methode pour ajouter une piece dans la reserve 
    public void ajouterPiece (Piece p) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i) == null) {
                pieces.set(i, p);
                break;
            }
        }
    }

    // Methode pour retirer une piece de la reserve
    public void retirerPiece (Piece p) {
        for (int i = 0; i < pieces.size(); i++) {
            // Parcours du tableau pour y trouver 
            if (pieces.get(i).getNom().equals(p.getNom())) {   
                pieces.set(i, null); 
                break;
            }
        }
    }

}