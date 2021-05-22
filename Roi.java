/**
 * Caractéristiques de la pièce "Roi (régnant)"
 */

public class Roi extends Piece {

    // constructeur 
    public Roi(int joueur) {
        super(joueur);
        setNom("Roi");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {  
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {  
                return false;
            }
        }  

        // vérifie que le déplacement ne sera que d'une case maximum, en ordonnée et en abscisse
        if ((Math.abs(posDepart.getY() - posArrivee.getY()) <= 1) && (Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)) {
            return true;
        }

        // retourne faux (méthode-parent) si on ne se trouve pas dans l'un des deux cas précédents
        return false;
    }
}