/**
 * Caractéristiques de la pièce "Pion"
 */

public class Pion extends Piece {

    // constructeur
    public Pion(int joueur) {
        super(joueur);
        setNom("Pion");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // Joueur 1 descend le plateau tandis que joueur 2 le remonte (le pion ne peut avancer que d'une case en avant (1 ou -1))
        if(joueur == 1 && posDepart.getX() - posArrivee.getX() == -1 
            || joueur == 2 && posDepart.getX() - posArrivee.getX() == 1) {
                // Le pion doit rester sur la même ligne (ne peut se déplacer que d'une seule case en avant)
                if(posDepart.getY() == posArrivee.getY()) {
                    return true;
                }
        }

        // si les conditions précédentes ne sont pas réalisées, le pion ne peut pas se déplacer
        return false;
    }
}