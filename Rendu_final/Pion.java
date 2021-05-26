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
            }
        }

        // Limite le deplacement a 1 case maximum en abscisse, avec la meme ordonnee
        if(joueur == 1 && posDepart.getX() - posArrivee.getX() == -1 
            || joueur == 2 && posDepart.getX() - posArrivee.getX() == 1) {
                if(posDepart.getY() == posArrivee.getY()) {
                    return true;
                }
        }

        // Deplacement interdit si la condition ci-dessus n'est pas verifiee
        return false;
    }
}