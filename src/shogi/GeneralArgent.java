package shogi;

/**
 * Caract�ristiques de la pi�ce "G�n�ral d'argent (aussi appel�e "argent")"
 */

public class GeneralArgent extends Piece {

    // constructeur
    public GeneralArgent(int joueur) {
        super(joueur);
        setNom("GeneralArgent");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // D�pacement limit� � une seule case 
        if((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1) && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            if(joueur == 1) {
                // V�rifie qu'il y ait un changement de ligne pour le d�placement
                if(posDepart.getX() - posArrivee.getX() == 1) {
                    // V�rifie que le G�n�ral d'Argent ne se d�place pas d'une case en arri�re dans la m�me colonne
                    if(posDepart.getY() == posArrivee.getY()) {
                        return false;
                    }
                }
            }
            else if(joueur == 2) {
                if(posDepart.getX() - posArrivee.getX() == -1) {
                    if(posDepart.getY() == posArrivee.getY()) {
                        return false;
                    }
                }
            }

            // V�rifie que la pi�ce ne se d�place pas lat�ralement et qu'elle change de ligne
            if(posDepart.getX() == posArrivee.getX()) {
                return false;
            }
            
            // v�rifier la pr�sence ou non d'une pi�ce sur la case o� veut se d�placer
            if (posArrivee.getP() != null) {
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