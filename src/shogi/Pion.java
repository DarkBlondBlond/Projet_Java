package shogi;

/**
 * Caract�ristiques de la pi�ce "Pion"
 */

public class Pion extends Piece {

    // constructeur
    public Pion(int joueur) {	
        super(joueur);
        setNom("Pion");
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

        // Joueur 1 descend le plateau tandis que joueur 2 le remonte (le pion ne peut avancer que d'une case en avant (1 ou -1))
        if (joueur == 1 && posDepart.getX() - posArrivee.getX() == -1 
            || joueur == 2 && posDepart.getX() - posArrivee.getX() == 1) {
                // Le pion doit rester sur la m�me ligne (ne peut se d�placer que d'une seule case en avant)
                if (posDepart.getY() == posArrivee.getY()) {
                    return true;
                }
        }

        // si les conditions pr�c�dentes ne sont pas r�alis�es, le pion ne peut pas se d�placer
        return false;
    }
}