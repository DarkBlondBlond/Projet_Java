package shogi;

/**
 * Caracteristiques de la piece "Pion"
 */

public class Pion extends Piece {

    // Constructeur
    public Pion(int joueur) {	
        super(joueur);
        setNom("Pion");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

    	// Deplacement de "Pion" apres sa promotion
        if(promu){
            if((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)
                    && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            	
                // Verifie que le joueur 1 n'effectue pas un deplacement arriere en diagonale
                if(joueur == 1) {
                    if(posDepart.getX() - posArrivee.getX() == 1) {
                        if(posDepart.getY() != posArrivee.getY()) {
                            return false;
                        }
                    }
                }

                // Verifie que le joueur 2 n'effectue pas un deplacement arriere en diagonale
                else if(joueur == 2) {
                    if(posDepart.getX() - posArrivee.getX() == -1) {
                        if(posDepart.getY() != posArrivee.getY()) {
                            return false;
                        }
                    }
                }
                
                // Deplacement interdit si la case d'arrivee est deja occupee par une piece appartenant au joueur actif
                if(posArrivee.getP() != null) {
                    if(posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                        return false;
                    }
                }
                
                // Deplacement possible pour un pion promu si les conditions ci-dessus ne sont pas verifiees
                return true;
            }
            
            // Deplacement impossible si l'une des conditions ci-dessus est verifiee
            return false;
        }

        // Deplacement interdit si la case d'arrivee est deja occupee par une piece appartenant au joueur actif
        if(posArrivee.getP() != null) {
            if(posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                return false;
                
                /* La 1ere condition verifie s'il y a deja une piece presente sur la case ou le joueur veut deplacer
                 * sa piece ("!= null").
                 * La 2nde condition verifie si la piece sur cette case appartient au joueur actif (".getP().getJoueur()"), 
                 * ce qui interdit son deplacement (ne peut pas manger ses propres pieces) */
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

        // Deplacement interdit si la condition ci-dessus n'est pas verifiee
        return false;
    }
}
