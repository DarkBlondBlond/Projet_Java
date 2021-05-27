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
            }
        }

        // Verifie que le deplacement soit bien une diagonale et que le joueur ne saute pas par-dessus une piece
        if(Math.abs(posDepart.getX() - posArrivee.getX()) == Math.abs(posDepart.getY() - posArrivee.getY())) {
            int trajectoireX = posArrivee.getX() > posDepart.getX() ? 1 : -1;
            int trajectoireY = posArrivee.getY() > posDepart.getY() ? 1 : -1;
            for(int i = 1; i < Math.abs(posArrivee.getY() - posDepart.getY()); i++) {
                if(plateau.getCase(posDepart.getX() + i * trajectoireX, posDepart.getY() + i * trajectoireY).getP() != null) {
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
            
            // Deplacement possible si les conditions ci-dessus ne sont pas verifiees
            return true;
        }
        
        // Deplacement interdit si la condition ci-dessus n'est pas verifiee
        return false;
    }
}