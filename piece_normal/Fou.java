/**
 * Caractéristiques de la pièce "Fou"
 */

public class Fou extends Piece {

    // constructeur
    public Fou(int joueur) {
        super(joueur);
        setNom("Fou");
    }

    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {

        // vérifier la présence ou non d'une pièce sur la case où veut se déplacer
        if (posArrivee.getP() != null) {
            // vérifie que la pièce sur laquelle on veut se déplacer ne nous appartient pas, sinon retourne faux :
            if (posDepart.getP().getJoueur() == posArrivee.getP().getJoueur()) { 
                return false;
            }
        }

        // Vérifier que les coordonnées X et Y sont égales et le restent tout le déplacement
        if(Math.abs(posDepart.getX() - posArrivee.getX()) == Math.abs(posDepart.getY() - posArrivee.getY())) {

            // Vérifier la direction du déplacement : gauche/droite, haut/bas
            int trajectoireX = posArrivee() > posDepart() ? 1 : -1;
            int trajectoireY = posArrivee() > posDepart() ? 1 : -1;

            // Parcours toutes les cases de la diagonales 
            for(int i = 1; i < Math.abs(posArrivee.getY() - posDepart.getY()); i++) {

                // Vérifier que les cases soient libres
                if(plateau.getCase(posDepart.getX() + i * trajectoireX, posDepart.getY() + i * trajectoireY) != null) {
                    return false;
                }
            }

            return true;
        }

        // Si aucune de ces conditions n'est validée, la pièce ne peut pas se déplacer 
        return false;
}