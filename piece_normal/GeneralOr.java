/**
 * Caractéristiques de la pièce "Général d'or (aussi appelée "or")"
 */

public class GeneralOr extends Piece {

    // constructeur
    public GeneralOr(int joueur) {
        super(joueur);
        setNom("GeneralOr");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                return false;
            }
        }
}
