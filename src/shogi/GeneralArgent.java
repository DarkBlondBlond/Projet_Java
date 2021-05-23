package shogi;

/**
 * Caractéristiques de la pièce "Général d'argent (aussi appelée "argent")"
 */

public class GeneralArgent extends Piece {

    // constructeur
    public GeneralArgent(int joueur) {
        super(joueur);
        setNom("GeneralArgent");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                return false;
            }
        }

        // Dépacement limité à une seule case 
        if((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1) && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            if(joueur == 1) {
                // Vérifie qu'il y ait un changement de ligne pour le déplacement
                if(posDepart.getX() - posArrivee.getX() == 1) {
                    // Vérifie que le Général d'Argent ne se déplace pas d'une case en arrière dans la même colonne
                    if(posDepart.getY() == posArrivee.getY()) {
                        return false;
                    }
                }
            }
            else if(joueur == 2) {
                if(posDepart.getX() - posArrivee.getX() == -1) {
                    if(posDepart.getY() == posArrivee.getY()) {
                        return false;
                    }
                }
            }

            // Vérifie que la pièce ne se déplace pas latéralement et qu'elle change de ligne
            if(posDepart.getX() == posArrivee.getX()) {
                return false;
            }
        }

        // Déplacement possible si toutes les conditions au-dessus ne sont pas réalisées
        return true;
    }
}
