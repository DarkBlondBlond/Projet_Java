package shogi;

/**
 * Caractéristiques de la pièce "Cavalier"
 */

public class Cavalier extends Piece {

    // constructeur
    public Cavalier(int joueur) {
        super(joueur);
        setNom("Cavalier");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // Déplacement joueur 1
        if(joueur == 1) {
            // Vérifie que le cavalier ne se déplace bien que de 2 cases en avant et qu'il ne se déplace bien que d'une case latéralement 
            if(posDepart.getX() - posArrivee.getX() != -2 || Math.abs(posDepart.getY() - posArrivee.getY()) != 1 ) {
                return false;
            }
        }

        // Déplacement joueur 2
        else if (joueur == 2) {
            // Vérifie que le cavalier ne se déplace bien que de 2 cases en avant et qu'il ne se déplace bien que d'une case latéralement
            if (posDepart.getX() - posArrivee.getX() != 2 || Math.abs(posDepart.getY() - posArrivee.getY()) != 1) {
                return false;
            }
        }

        // Déplacement possible si les conditions dessu ne sont pas vérifiées
        return true;
    }
}
