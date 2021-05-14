/**
 * Caractéristiques de la pièce "Tour (aussi appelée "chariot")"
 */

public class Tour extends Piece {

    // constructeur
    public Tour(int joueur) {
        super(joueur);
        setNom("Tour");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { // vérifie que la pièce sur laquelle on
                                                                                 // veut se déplacer ne nous appartient
                                                                                 // pas, sinon retourne faux
                return false;
            }
        }

        // vérifie que le déplacement ne sera que d'une case maximum, en ordonnée et en
        // abscisse
        if ((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)
                && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
            return true;
        }

        // retourne faux (méthode-parent) si on ne se trouve pas dans l'un des deux cas
        // précédents
        return false;
    }
}
