package shogi;

/**
 * Caracteristiques de la piece "Roi (Regnant)"
 */

public class Roi extends Piece {

    // constructeur 
    public Roi(int joueur) {
        super(joueur);
        setNom("Roi");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

    	// Deplacement possible si les conditions ci-dessous sont remplies
    	// Controle si une piece est deja presente sur la case ou le joueur veut deplacer sa piece
        if (posArrivee.getP() != null) {  
        	
            // Interdit le deplacement si le joueur veut deplacer sa piece sur une case occupee par une de ses pieces
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {  
                return false;
            }
        }  

        // Limite le deplacement a 1 case maximum en ordonnee et en abscisse
        if ((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1) && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
            return true;
        }

        // Deplacement interdit si les conditions ci-dessus ne sont pas remplies
        return false;
    }
}