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
                
                /* La 1ere condition verifie s'il y a deja une piece presente sur la case ou le joueur veut deplacer
                 * sa piece ("!= null").
                 * La 2nde condition verifie si la piece sur cette case appartient au joueur actif (".getP().getJoueur()"), 
                 * ce qui interdit son deplacement (ne peut pas manger ses propres pieces) */
            }
        }

        // Interdit le deplacement en diagonale
        if((posDepart.getY() != posArrivee.getY()) && (posDepart.getX() != posArrivee.getX())) {
            return false;
        	
        	/* Verifie que le deplacement se fait bien en ligne (X) ou en colonne (Y) uniquement, et pas en 
        	 * diagonale (si les coordonnees x ou y de la position de depart sont différentes des coordonnees 
        	 * x ou y de la case d'arrivee, c'est que le deplacement ne s'est pas effectue sur la meme ligne/
        	 * la meme colonne */
        }

        // Deplacement vers le haut du plateau
        if(posDepart.getX() - posArrivee.getX() > 0) {
            for(int i = posDepart.getX() - 1; i > posArrivee.getX(); i--) {
            	if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                    
                	/* Verifie que toutes les cases avant la position d'arrivee sont vides et que la tour ne "saute pas" 
                	 * par-dessus d'autres pieces avant d'atteindre sa case d'arrivee */
                }
            }
        }

        // Deplacement vers la gauche du plateau
        if(posDepart.getY() - posArrivee.getY() > 0) {
        	for(int i = posDepart.getY() - 1; i > posArrivee.getY(); i--) {
        		if(plateau.getCase(posDepart.getX(), i).getP() != null) {
                    return false;
                    
                    /* Effectue la meme verification que pour le deplacement vers le haut du plateau */
                }
            }
        }

        // Deplacement vers le bas du plateau
        if(posDepart.getX() - posArrivee.getX() < 0) {
            for(int i = posDepart.getX() + 1; i < posArrivee.getX(); i++) {
                if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                    return false;
                    
                    /* Effectue la meme verification que pour le deplacement vers le haut du plateau */
                }
            }
        }

        // Deplacement vers la droite du plateau
        if(posDepart.getY() - posArrivee.getY() < 0) {
            for(int i = posDepart.getY() + 1; i < posArrivee.getY(); i++) {
                if(plateau.getCase(posDepart.getX(), i).getP() != null) {
                    return false;
                    
                    /* Effectue la meme verification que pour le deplacement vers le haut du plateau */
                }
            }
        }
        
        // Deplacement possible si les conditions ci-dessus ne sont pas verifiees
        return true;
    }
}