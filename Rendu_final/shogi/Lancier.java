package shogi;

/**
 * Caracteristiques de la piece "Lancier"
 */

public class Lancier extends Piece {

    // Constructeur
    public Lancier(int joueur) {
        super(joueur);
        setNom("Lancier");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {

    	// Deplacement de "Lancier" apres sa promotion
        if(promu){
            if ((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)
                    && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            	
            	// Verifie que le joueur 1 n'effectue pas un deplacement arriere en diagonale
                if (joueur == 1) {
                    if (posDepart.getX() - posArrivee.getX() == 1) {
                        if (posDepart.getY() != posArrivee.getY()) {
                            return false;
                        }
                    }
                }

                // Verifie que le joueur 2 n'effectue pas un deplacement arriere en diagonale
                else if (joueur == 2) {
                    if (posDepart.getX() - posArrivee.getX() == -1) {
                        if (posDepart.getY() != posArrivee.getY()) {
                            return false;
                        }
                    }
                }
                
                // Deplacement interdit si la case d'arrivee est deja occupee par une piece appartenant au joueur actif
                if (posArrivee.getP() != null) {
                    if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                        return false;
                    }
                }
                
                // Deplacement possible pour un lancier promu si les conditions ci-dessus ne sont pas verifiees
                return true;
            }
            
            // Deplacement impossible si l'une des conditions ci-dessus est verifiee
            return false;
        }
    

        // Verifie que la case d'arrivee est bien dans la meme colonne que la case de depart
        if(posDepart.getY() == posArrivee.getY()) {
        	
            // Verifie que le joueur 1 ne saute pas au-dessus d'une piece
            if(joueur == 1) {
                if(posDepart.getX() - posArrivee.getX() < 0) {
                    for(int i = posDepart.getX() + 1; i < posArrivee.getX(); i++) {
                        if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                            return false;
                        }
                    }
                }
                else {
                    return false;
                }
            }

            // Verifie que le joueur 2 ne saute pas au-dessus d'une piece
            if(joueur == 2) {
                if(posDepart.getX() - posArrivee.getX() > 0) {
                    for(int i = posDepart.getX() - 1; i > posArrivee.getX(); i--) {
                        if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                            return false;
                        }
                    }
                }
                else {
                    return false;
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
