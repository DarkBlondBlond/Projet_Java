/**
 * Caractéristiques de la pièce "Général d'or (aussi appelée "or")"
 */

public class GeneralOr extends Piece {

    // constructeur
    public GeneralOr(int joueur) {
        super(joueur);
        setNom("GeneralOr");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if(posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                return false;
            }
        }

        // Dépacement limité à une seule case 
        if((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1) && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            if(joueur == 1) { 
                // Vérifie que le déplacement arrière ne soit pas une diagonale
                if(posDepart.getX() - posArrivee.getX() == 1) {
                    if(posDepart.getY() != posArrivee.getY()) {
                        return false;
                    }
                }
            }

            else if(joueur == 2) { 
                // Vérifie que le déplacement arrière ne soit pas une diagonale
                if(posDepart.getX() - posArrivee.getX() == -1) {
                    if(posDepart.getY() != posArrivee.getY()) {
                        return false;
                    }
                } 
            }
        }

        // Déplacement possible si les conditions du déplacement limité à 1 case sont remplies
        return true;
    }
}
