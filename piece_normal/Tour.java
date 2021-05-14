/**
 * Caractéristiques de la pièce "Tour (aussi appelée "chariot")"
 */

public class Tour extends Piece {

    // constructeur
    public Tour(int joueur) {
        super(joueur);
        setNom("Tour");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // vérifie que le déplacement se fait bien en ligne (X) ou en colonne (Y) uniquement, et pas en diagonale
        if((posDepart.getY() != posArrivee.getY()) && (posDepart.getX() != posArrivee.getX())) {
            return false;
        }

        // Déplacement vers le haut du plateau
        if(posDepart.getX() - posArrivee.getX() > 0 ) {

            // parcours de la colonne pour vérifier qu'il n'y ait pas de pièces avant la case d'arrivée
            for(int i = posDepart.getX() - 1; i > posArrivee.getX(); i--) {

                // vérifie que la case parcourue est libre
                if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                }
            }
        }

        // Déplacement vers la gauche du plateau
        if(posDepart.getY() - posArrivee.getY() > 0 ) {

            // parcours de la colonne pour vérifier qu'il n'y ait pas de pièces avant la case d'arrivée
            for(int i = posDepart.getY() - 1; i > posArrivee.getY(); i--) {

                // vérifie que la case parcourue est libre
                if(plateau.getCase(i, posDepart.getX()).getP() != null) {
                    return false;
                }
            }
        }

        // Déplacement vers le bas du plateau
        if(posDepart.getX() - posArrivee.getX() < 0 ) {

            // parcours de la colonne pour vérifier qu'il n'y ait pas de pièces avant la case d'arrivée
            for(int i = posDepart.getX() + 1; i < posArrivee.getX(); i++) {

                // vérifie que la case parcourue est libre
                if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                }
            }
        }

        // Déplacement vers la droite du plateau
        if (posDepart.getY() - posArrivee.getY() < 0) {

            // parcours de la colonne pour vérifier qu'il n'y ait pas de pièces avant la case d'arrivée
            for (int i = posDepart.getY() + 1; i < posArrivee.getY(); i++) {

                // vérifie que la case parcourue est libre
                if (plateau.getCase(i, posDepart.getX()).getP() != null) {
                    return false;
                }
            }
        }

        /**
         * retourne true car les 6 conditions précédentes interdisent le déplacement dela Tour, 
         * donc si on ne se trouve pas dans l'un de ces cas, la Tour peut se déplacer
         */
        return true;
    }
}
