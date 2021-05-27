package shogi;

/**
 * Classe Case, objets independants avec des coordonnees x et y, qui sont ensuite associes dans la classe Plateau
 */

public class Case {
    private int x;
    private int y;
    private Piece p;

    /**
     * Definit les attributs de la classe "Case" :
     * 
     * @param x abscisse de l'objet 
     * @param y ordonnee de l'objet
     * @param p objet de type "Piece" qui va etre affecte a cette case
     */

    // Constructeur
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x; 
    }

    public int getY() {
        return y;
    }

    public Piece getP() {
        return p;
    }

    // Setter
    public void setP(Piece p) {
        this.p = p;  
    }
}