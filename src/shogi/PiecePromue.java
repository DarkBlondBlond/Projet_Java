package shogi;

/** 
 * Classe PiecePromue regroupant les caractéristiques des pièces Pion, Général d'Argent,
 * Cavalier et Lancier lorsqu'elles sont promues (après promotion, toutes ces pièces 
 * possèdent les mêmes caractéristiques de déplacement que le Général d'Or)
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
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) {
                return false;
            }
        }

        // Dépacement limité à une seule case
        if ((Math.abs(posDepart.getX() - posArrivee.getX()) <= 1)
                && (Math.abs(posDepart.getY() - posArrivee.getY()) <= 1)) {
            if (joueur == 1) {
                // Vérifie que le déplacement arrière ne soit pas une diagonale
                if (posDepart.getX() - posArrivee.getX() == 1) {
                    if (posDepart.getY() != posArrivee.getY()) {
                        return false;
                    }
                }
            }

            else if (joueur == 2) {
                // Vérifie que le déplacement arrière ne soit pas une diagonale
                if (posDepart.getX() - posArrivee.getX() == -1) {
                    if (posDepart.getY() != posArrivee.getY()) {
                        return false;
                    }
                }
            }
        }

        // Déplacement possible si les conditions du déplacement limité à 1 case sont remplies
        return true;
    }

}