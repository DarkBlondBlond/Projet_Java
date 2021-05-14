/**
 * Caractéristiques de la pièce "Général d'argent (aussi appelée "argent")"
 */

public class GeneralArgent extends Piece {

    // constructeur
    public GeneralArgent(int joueur) {
        super(joueur);
        setNom("GeneralArgent");
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
