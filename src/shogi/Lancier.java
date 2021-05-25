package shogi;

/**
 * Caract�ristiques de la pi�ce "Lancier"
 */

public class Lancier extends Piece {

    // constructeur
    public Lancier(int joueur) {
        super(joueur);
        setNom("Lancier");
        setIcon();
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {

        // En haut car derniere déclaration de la méthode = return ... 
        if(promu){
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
    

        // Verifie que la pi�ce reste sur la m�me colone
        if(posDepart.getY() == posArrivee.getY()) {
            // V�rifie si sa trajectoire est vide si c'est le joueur 1
            if(joueur == 1) {
                // V�rifie qu'il tente bien de descendre le tableau
                if(posDepart.getX() - posArrivee.getX() < 0) {
                    // Parcours la colonne
                    for(int i = posDepart.getX() + 1; i < posArrivee.getX(); i++) {
                        // V�rifie que la case est vide
                        if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                            return false;
                        }
                    }
                }
                else {
                    return false;
                }
            
            }

            if(joueur == 2) {
                if(posDepart.getX() - posArrivee.getX() > 0) {
                    for(int i = posDepart.getX() - 1; i > posArrivee.getX(); i--) {
                        if(plateau.getCase(i, posDepart.getY()).getP() != null) {
                            return false;
                        }
                    }
                }
                else {
                    return false;
                }
            }
            
        // v�rifier la pr�sence ou non d'une pi�ce sur la case o� veut se d�placer
            if (posArrivee.getP() != null) {
                // v�rifie que la pi�ce sur laquelle on veut se d�placer ne nous appartient pas, sinon retourne faux :
                if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                    return false;
                }
            }

            // D�placement possible 
            return true;
        }
        // D�placement par d�faut
        return false;
    }
}
