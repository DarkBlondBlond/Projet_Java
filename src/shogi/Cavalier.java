package shogi;

/**
 * Caract�ristiques de la pi�ce "Cavalier"
 */

public class Cavalier extends Piece {

    // constructeur
    public Cavalier(int joueur) {
        super(joueur);
        setNom("Cavalier");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        if(promu){
            if ((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)
                    && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
                if (joueur == 1) {
                    // V�rifie que le d�placement arri�re ne soit pas une diagonale
                    if (posDepart.getX() - posArrivee.getX() == 1) {
                        if (posDepart.getY() != posArrivee.getY()) {
                            return false;
                        }
                    }
                }

                else if (joueur == 2) {
                    // V�rifie que le d�placement arri�re ne soit pas une diagonale
                    if (posDepart.getX() - posArrivee.getX() == -1) {
                        if (posDepart.getY() != posArrivee.getY()) {
                            return false;
                        }
                    }
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

        // v�rifier la pr�sence ou non d'une pi�ce sur la case o� veut se d�placer
        if (posArrivee.getP() != null) {
            // v�rifie que la pi�ce sur laquelle on veut se d�placer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // D�placement joueur 1
        if(joueur == 1) {
            // V�rifie que le cavalier ne se d�place bien que de 2 cases en avant et qu'il ne se d�place bien que d'une case lat�ralement 
            if(posDepart.getX() - posArrivee.getX() != -2 || Math.abs(posDepart.getY() - posArrivee.getY()) != 1 ) {
                return false;
            }
        }

        // D�placement joueur 2
        else if (joueur == 2) {
            // V�rifie que le cavalier ne se d�place bien que de 2 cases en avant et qu'il ne se d�place bien que d'une case lat�ralement
            if (posDepart.getX() - posArrivee.getX() != 2 || Math.abs(posDepart.getY() - posArrivee.getY()) != 1) {
                return false;
            }
        }

        // D�placement possible si les conditions dessu ne sont pas v�rifi�es
        return true;
    }
}