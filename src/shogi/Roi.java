package shogi;

/**
 * Caracteristiques de la piece "Roi (aussi appelee "Regnant")"
 */

public class Roi extends Piece {

    // Constructeur 
    public Roi(int joueur) {
        super(joueur);
        setNom("Roi");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

    	// Deplacement possible si les conditions ci-dessous sont verifiees :
    	
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

        // Limite le deplacement a 1 case maximum en ordonnee et en abscisse
        if((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1) && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
            return true;
        }

        // Deplacement interdit si les conditions ci-dessus ne sont pas verifiees
        return false;
    }
}
