/**
 * Classe Case, objets indépendants avec leurs propres coordonnées, qui seront ensuite associés dans la classe Plateau
 */

public class Case {
    // Attribue une abscisse à la case :
    private int x;
    // Attribue une ordonnée à la case :
    private int y;
    // Appel de la pièce à poser sur la case :
    private Piece p;

    // Constructeur :
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Mise en place des getters :
    public int getX() {
        return x;  // pour récupérer la variable "x" depuis les attributs de la classe Case
    }

    public int getY() {
        return y;  // pour récupérer la variable "y" depuis les attributs de la classe Case
    }

    public Piece getP() {
        return p;  // pour récupérer la variable "p" depuis les attributs de la classe Piece
    }

    // Mise en place du setter :
    public void setP(Piece p) {
        this.p = p;  
    /* les cases ne sont pas modifiables, donc pas de setters pour l'abscisse et l'ordonnée 
    => seul l'objet (la pièce qui va être associée à la case) l'est, c'est à lui que l'on va
    associer des coordonnées
    */
    }
}
