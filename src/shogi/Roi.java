package shogi;

/**
 * Caract�ristiques de la pi�ce "Roi (r�gnant)"
 */

public class Roi extends Piece {

    // constructeur 
    public Roi(int joueur) {
        super(joueur);
        setNom("Roi");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // v�rifier la pr�sence ou non d'une pi�ce sur la case o� veut se d�placer
        if (posArrivee.getP() != null) {  
            // v�rifie que la pi�ce sur laquelle on veut se d�placer ne nous appartient pas, sinon retourne faux
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {  
                return false;
            }
        }  

        // v�rifie que le d�placement ne sera que d'une case maximum, en ordonn�e et en abscisse
        if ((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1) && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
            return true;
        }

        // retourne faux (m�thode-parent) si on ne se trouve pas dans l'un des deux cas pr�c�dents
        return false;
    }
}
