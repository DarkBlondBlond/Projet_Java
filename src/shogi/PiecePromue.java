package shogi;

/** 
 * Classe PiecePromue regroupant les caract�ristiques des pi�ces Pion, G�n�ral d'Argent,
 * Cavalier et Lancier lorsqu'elles sont promues (apr�s promotion, toutes ces pi�ces 
 * poss�dent les m�mes caract�ristiques de d�placement que le G�n�ral d'Or)
 */

public class PiecePromue extends Piece {

    // Constructeur
    public PiecePromue (int joueur, String n) {
        super (joueur);
        if (n.equals("Pion")) {
            this.setNom("PionPromu");
        }
        if (n.equals("GeneralArgent")) {
            this.setNom("GeneralArgentPromu");
        }
        if (n.equals("Cavalier")) {
            this.setNom("CavalierPromu");
        }
        if (n.equals("Lancier")) {
            this.setNom("LancierPromu");
        }
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // D�pacement limit� � une seule case
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

}