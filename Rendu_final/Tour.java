package shogi;

/**
 * Caracteristiques de la piece "Tour (aussi appelee "Chariot")"
 */

public class Tour extends Piece {

    // Constructeur
    public Tour(int joueur) {
        super(joueur);
        setNom("Tour");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {
    	
    	// Deplacement de "Tour" apres sa promotion
        if(promu){
            if((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1) && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
                return true;
            }
        }

        // Deplacement interdit si l'une des conditions ci-dessous est remplie :
        
        // Deplacement interdit si la case d'arrivee est deja occupee par une piece appartenant au joueur actif
        if(posArrivee.getP() != null) {
            if(posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // Interdit le deplacement en diagonale
        if((posDepart.getY() != posArrivee.getY()) && (posDepart.getX() != posArrivee.getX())) {
            return false;
        }

        // Deplacement vers le haut du plateau
        if(posDepart.getX() - posArrivee.getX() > 0) {
            for(int i = posDepart.getX() - 1; i > posArrivee.getX(); i--) {
            	if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                }
            }
        }

        // Deplacement vers la gauche du plateau
        if(posDepart.getY() - posArrivee.getY() > 0) {
        	for(int i = posDepart.getY() - 1; i > posArrivee.getY(); i--) {
        		if(plateau.getCase(posDepart.getX(), i).getP() != null) {
                    return false;
                }
            }
        }

        // Deplacement vers le bas du plateau
        if(posDepart.getX() - posArrivee.getX() < 0) {
            for(int i = posDepart.getX() + 1; i < posArrivee.getX(); i++) {
                if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                }
            }
        }

        // Deplacement vers la droite du plateau
        if(posDepart.getY() - posArrivee.getY() < 0) {
            for(int i = posDepart.getY() + 1; i < posArrivee.getY(); i++) {
                if(plateau.getCase(posDepart.getX(), i).getP() != null) {
                    return false;
                }
            }
        }
        
        // Deplacement possible si les conditions ci-dessus ne sont pas verifiees
        return true;
    }
}