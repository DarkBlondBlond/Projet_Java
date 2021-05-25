package shogi;

/**
 * Caract�ristiques de la pi�ce "G�n�ral d'or (aussi appel�e "or")"
 */

public class GeneralOr extends Piece {

    // constructeur
    public GeneralOr(int joueur) {
        super(joueur);
        setNom("GeneralOr");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // D�pacement limit� � une seule case 
        if((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1) && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            if(joueur == 1) { 
                // V�rifie que le d�placement arri�re ne soit pas une diagonale
                if(posDepart.getX() - posArrivee.getX() == 1) {
                    if(posDepart.getY() != posArrivee.getY()) {
                        return false;
                    }
                }
            }

            else if(joueur == 2) { 
                // V�rifie que le d�placement arri�re ne soit pas une diagonale
                if(posDepart.getX() - posArrivee.getX() == -1) {
                    if(posDepart.getY() != posArrivee.getY()) {
                        return false;
                    }
                } 
            }
            
            // v�rifier la pr�sence ou non d'une pi�ce sur la case o� veut se d�placer
            if(posArrivee.getP() != null) {
                // v�rifie que la pi�ce sur laquelle on veut se d�placer ne nous appartient pas, sinon retourne faux :
                if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}