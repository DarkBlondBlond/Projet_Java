package shogi;

/**
 * Classe Case, objets ind�pendants avec leurs propres coordonn�es, qui seront ensuite associ�s dans la classe Plateau
 */

public class Case {
    // Attribue une abscisse � la case :
    private int x;
    // Attribue une ordonn�e � la case :
    private int y;
    // Appel de la pi�ce � poser sur la case :
    private Piece p;

    // Constructeur :
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Mise en place des getters :
    public int getX() {
        return x;  // pour r�cup�rer la variable "x" depuis les attributs de la classe Case
    }

    public int getY() {
        return y;  // pour r�cup�rer la variable "y" depuis les attributs de la classe Case
    }

    public Piece getP() {
        return p;  // pour r�cup�rer un objet "p" de type Piece pr�sent sur une case
    }

    // Mise en place du setter :
    public void setP(Piece p) {
        this.p = p;  
    /** les cases ne sont pas modifiables, donc pas de setters pour l'abscisse et l'ordonn�e 
     * => seul l'objet (la pi�ce qui va �tre associ�e � la case) l'est, c'est � lui que l'on va
     * associer des coordonn�es
     */
    }
}

