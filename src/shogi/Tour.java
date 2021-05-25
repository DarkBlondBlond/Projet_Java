package shogi;

/**
 * Caract�ristiques de la pi�ce "Tour (aussi appel�e "chariot")"
 */

public class Tour extends Piece {

    // constructeur
    public Tour(int joueur) {
        super(joueur);
        setNom("Tour");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {
        if(promu){
            if ((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1) && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
                return true;
            }
        }

        // v�rifier la pr�sence ou non d'une pi�ce sur la case o� veut se d�placer
        if (posArrivee.getP() != null) {
            // v�rifie que la pi�ce sur laquelle on veut se d�placer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // v�rifie que le d�placement se fait bien en ligne (X) ou en colonne (Y) uniquement, et pas en diagonale
        if((posDepart.getY() != posArrivee.getY()) && (posDepart.getX() != posArrivee.getX())) {
            return false;
        }

        // D�placement vers le haut du plateau
        if(posDepart.getX() - posArrivee.getX() > 0 ) {

            // parcours de la colonne pour v�rifier qu'il n'y ait pas de pi�ces avant la case d'arriv�e
            for(int i = posDepart.getX() - 1; i > posArrivee.getX(); i--) {

                // v�rifie que la case parcourue est libre
                if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                }
            }
        }

        // D�placement vers la gauche du plateau
        if(posDepart.getY() - posArrivee.getY() > 0 ) {

            // parcours de la colonne pour v�rifier qu'il n'y ait pas de pi�ces avant la case d'arriv�e
            for(int i = posDepart.getY() - 1; i > posArrivee.getY(); i--) {

                // v�rifie que la case parcourue est libre
                if(plateau.getCase(posDepart.getX(), i).getP() != null) {
                    return false;
                }
            }
        }

        // D�placement vers le bas du plateau
        if(posDepart.getX() - posArrivee.getX() < 0 ) {

            // parcours de la colonne pour v�rifier qu'il n'y ait pas de pi�ces avant la case d'arriv�e
            for(int i = posDepart.getX() + 1; i < posArrivee.getX(); i++) {

                // v�rifie que la case parcourue est libre
                if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                }
            }
        }

        // D�placement vers la droite du plateau
        if (posDepart.getY() - posArrivee.getY() < 0) {

            // parcours de la colonne pour v�rifier qu'il n'y ait pas de pi�ces avant la case d'arriv�e
            for (int i = posDepart.getY() + 1; i < posArrivee.getY(); i++) {

                // v�rifie que la case parcourue est libre
                if (plateau.getCase(posDepart.getX(), i).getP() != null) {
                    return false;
                }
            }
        }

        /**
         * retourne true car les 6 conditions pr�c�dentes interdisent le d�placement dela Tour, 
         * donc si on ne se trouve pas dans l'un de ces cas, la Tour peut se d�placer
         */
        return true;
    }
}