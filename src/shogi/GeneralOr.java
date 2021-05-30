package shogi;

/**
 * Caracteristiques de la piece "General d'or (aussi appelee "or")"
 */

public class GeneralOr extends Piece {

    // Constructeur
    public GeneralOr(int joueur) {
        super(joueur);
        setNom("GeneralOr");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // Limite le deplacement a une seule case 
        if((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1) && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            if(joueur == 1) { 
            	
            	// Verifie que le joueur 1 n'effectue pas un deplacement arriere en diagonale
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
                    
                    /* La 1ere condition verifie s'il y a deja une piece presente sur la case ou le joueur veut deplacer
                     * sa piece ("!= null").
                     * La 2nde condition verifie si la piece sur cette case appartient au joueur actif (".getP().getJoueur()"), 
                     * ce qui interdit son deplacement (ne peut pas manger ses propres pieces) */
                }
            }
            
            // Deplacement possible si les conditions ci-dessus ne sont pas verifiees
            return true;
        }
        
        // Deplacement interdit si la condition ci-dessus n'est pas verifiee
        return false;
    }
}
