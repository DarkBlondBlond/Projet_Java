package shogi;

/**
 * Cr�ation d'une r�serve pour chaque joueur, pour y stocker les pi�ces prises � l'adversaire
 */

import java.util.ArrayList;

public class Reserve {
    private ArrayList<Piece> pieces = new ArrayList<Piece>();
    private int joueur;
    
    // Constructeur 
    public Reserve (int j) {
        this.joueur = j;
        for (int i = 0; i < 38; i ++) {
            pieces.add(null);  //  initialise une ArrayList nomm�e "pieces" avec 38 cases vides
        }
    }

    // M�thode getPiece qui retourne un objet de type Piece
    public Piece getPiece (int i) {
        return pieces.get(i);   // retourne la pi�ce stock�e � l'indice "i" dans l'ArrayList
    }

    // Setter pour stocker la piece "p" � l'indice "i" de la r�serve
    public void setPiece (int i, Piece p) {
        pieces.set(i, p);  
    }

    // Getter pour r�cup�rer le num�ro du joueur
    public int getJoueur () {
        return joueur;
    }

    // M�thode pour ajouter la pi�ce "p" dans la r�serve 
    public void ajouterPiece (Piece p) {
        // Parcours du tableau pour y trouver un emplacement vide pour y stocker la pi�ce "p"
        for (int i = 0; i < pieces.size(); i ++) {
            if (pieces.get(i) == null) {
                pieces.set(i, p);
                break;
            }
        }
    }

    // M�thode pour retirer une pi�ce "p" de la r�serve
    public void retirerPiece (Piece p) {
        for (int i = 0; i < pieces.size(); i ++) {
            // Parcours du tableau pour y trouver une pi�ce ayant le m�me nom que la pi�ce "p" plac�e en param�tre
            if (pieces.get(i).getNom().equals(p.getNom())) {   
                pieces.set(i, null);   // d�r�f�rence l'objet "p" localis� � l'indice "i" de l'ArrayList
                break;
            }
        }
    }

}
