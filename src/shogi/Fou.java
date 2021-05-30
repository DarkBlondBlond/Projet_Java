package shogi;

/**
 * Caracteristiques de la piece "Fou"
 */

public class Fou extends Piece {

    // Constructeur
    public Fou(int joueur) {
        super(joueur);
        setNom("Fou");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {

    	// Deplacement de "Fou" apres sa promotion
        if(promu){ 
            if((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1) && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
                return true;
                
                /* Deplacement possible s'il est limite a 1 seule case */
            }
        }

        // Verifie que le deplacement soit bien une diagonale et que le joueur ne saute pas par-dessus une piece
        if(Math.abs(posDepart.getX() - posArrivee.getX()) == Math.abs(posDepart.getY() - posArrivee.getY())) {
            int trajectoireX = posArrivee.getX() > posDepart.getX() ? 1 : -1;
            int trajectoireY = posArrivee.getY() > posDepart.getY() ? 1 : -1;
            for(int i = 1; i < Math.abs(posArrivee.getY() - posDepart.getY()); i++) {
                if(plateau.getCase(posDepart.getX() + i * trajectoireX, posDepart.getY() + i * trajectoireY).getP() != null) {
                    return false;
                    
                    /* Verifie que les coordonnees X et Y restent egales tout au long du deplacement. Si ce n'est pas le cas,
                     * c'est que le deplacement n'est pas une diagonale.
                     * Parcourt ensuite toutes les cases de la diagonales pour verifier qu'elles soient bien vides. Si ce 
                     * n'est pas le cas, c'est que le joueur a saute au-dessus d'une piece qu cours de son deplacement */
                }
            }

            // Limite le deplacement a 1 case maximum en abscisse, avec la meme ordonnee
            if(joueur == 1 && posDepart.getX() - posArrivee.getX() == -1 
                || joueur == 2 && posDepart.getX() - posArrivee.getX() == 1) {
                    if(posDepart.getY() == posArrivee.getY()) {
                        return true;
                        
                        /* Le pion ne peut se deplacer que d'une seule case maximum, et toujours en avant (l'ordonnee (Y)
                         * ne doit pas changer pendant le deplacement et l'abscisse (X) ne doit depasser 1.
                         * On verifie egalement que le joueur 1 descend le plateau (la différence entre l'abscisse de la
                         * case de depart et l'abscisse de la case d'arrivee vaut -1) et que le joueur 2 remonte le plateau */
                }
            }
            
            // Deplacement interdit si la case d'arrivee est deja occupee par une piece appartenant au joueur actif
            if(posArrivee.getP() != null) {
                if(posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                    return false;
                }
            }
            
            // Deplacement possible si les conditions ci-dessus ne sont pas verifiees
            return true;
        }
        
        // Deplacement interdit si la condition ci-dessus n'est pas verifiee
        return false;
    }
}
