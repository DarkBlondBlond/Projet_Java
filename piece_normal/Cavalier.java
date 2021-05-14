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
}