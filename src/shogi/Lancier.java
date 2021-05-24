package shogi;

/**
 * Caractéristiques de la pièce "Lancier"
 */

public class Lancier extends Piece {

    // constructeur
    public Lancier(int joueur) {
        super(joueur);
        setNom("Lancier");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // Verifie que la pièce reste sur la même colone
        if(posDepart.getY() == posArrivee.getY()) {
            // Vérifie si sa trajectoire est vide si c'est le joueur 1
            if(joueur == 1) {
                // Vérifie qu'il tente bien de descendre le tableau
                if(posDepart.getX() - posArrivee.getX() < 0) {
                    // Parcours la colonne
                    for(int i = posDepart.getX() + 1; i < posArrivee.getX(); i++) {
                        // Vérifie que la case est vide
                        if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                            return false;
                        }
                    }
                }
            }
            else {
                return false;
            }

            if(joueur == 2) {
                if(posDepart.getX() - posArrivee.getX() > 0) {
                    for(int i = posDepart.getX() - 1; i > posArrivee.getX(); i--) {
                        if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                            return false;
                        }
                    }
                }
            }
            else {
                return false;
            }

            // Déplacement possible 
            return true;
        }

        // Déplacement par défaut
        return false;
    }
}