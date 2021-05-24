package shogi;

/**
 * Création d'une réserve pour chaque joueur, pour y stocker les pièces prises à l'adversaire
 */

import java.util.ArrayList;

public class Reserve {
    private ArrayList<Piece> pieces = new ArrayList<Piece>();
    private int joueur;
    
    // Constructeur 
    public Reserve (int j) {
        this.joueur = j;
        for (int i = 0; i < 38; i ++) {
            pieces.add(null);  //  initialise une ArrayList nommée "pieces" avec 38 cases vides
        }
    }

    // Méthode getPiece qui retourne un objet de type Piece
    public Piece getPiece (int i) {
        return pieces.get(i);   // retourne la pièce stockée à l'indice "i" dans l'ArrayList
    }

    // Setter pour stocker la piece "p" à l'indice "i" de la réserve
    public void setPiece (int i, Piece p) {
        pieces.set(i, p);  
    }

    // Getter pour récupérer le numéro du joueur
    public int getJoueur () {
        return joueur;
    }

    // Méthode pour ajouter la pièce "p" dans la réserve 
    public void ajouterPiece (Piece p) {
        // Parcours du tableau pour y trouver un emplacement vide pour y stocker la pièce "p"
        for (int i = 0; i < pieces.size(); i ++) {
            if (pieces.get(i) == null) {
                pieces.set(i, p);
                break;
            }
        }
    }

    // Méthode pour retirer une pièce "p" de la réserve
    public void retirerPiece (Piece p) {
        for (int i = 0; i < pieces.size(); i ++) {
            // Parcours du tableau pour y trouver une pièce ayant le même nom que la pièce "p" placée en paramètre
            if (pieces.get(i).getNom().equals(p.getNom())) {   
                pieces.set(i, null);   // déréférence l'objet "p" localisé à l'indice "i" de l'ArrayList
                break;
            }
        }
    }

}
