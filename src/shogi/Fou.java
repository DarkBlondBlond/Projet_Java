package shogi;

/**
 * Caract�ristiques de la pi�ce "Fou"
 */

public class Fou extends Piece {

    // constructeur
    public Fou(int joueur) {
        super(joueur);
        setNom("Fou");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // v�rifier la pr�sence ou non d'une pi�ce sur la case o� veut se d�placer
        if (posArrivee.getP() != null) {
            // v�rifie que la pi�ce sur laquelle on veut se d�placer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // V�rifier que les coordonn�es X et Y sont �gales et le restent tout le d�placement
        if(Math.abs(posDepart.getX() - posArrivee.getX()) == Math.abs(posDepart.getY() - posArrivee.getY())) {

            // V�rifier la direction du d�placement : gauche/droite, haut/bas
            int trajectoireX = posArrivee() > posDepart() ? 1 : -1;
            int trajectoireY = posArrivee() > posDepart() ? 1 : -1;

            // Parcours toutes les cases de la diagonales 
            for(int i = 1; i < Math.abs(posArrivee.getY() - posDepart.getY()); i++) {

                // V�rifier que les cases soient libres
                if(plateau.getCase(posDepart.getX() + i * trajectoireX, posDepart.getY() + i * trajectoireY) != null) {
                    return false;
                }
            }
        }

        // Si aucune de ces conditions n'est valid�e, la pi�ce peut se d�placer 
        return true;
    }
}
