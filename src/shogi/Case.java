package shogi;

/**
 * Classe Case, objets ind�pendants avec des coordonn�es x et y, qui sont ensuite associ�s dans la classe Plateau
 */

public class Case {
    private int x;
    private int y;
    private Piece p;

    /**
     * Definit les attributs de la classe "Case" :
     * 
     * @param x abscisse
     * @param y ordonnee
     * @param p objet de type "Piece" qui va etre affecte a cette case
     */

    // Constructeur :
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
    
    /* Ces getters permettent de recuperer les differents attributs de la classe "Case", pour
     * pouvoir les utiliser en dehors de cette classe (et notamment dans la classe "Plateau") */

    // Setter :
    public void setP(Piece p) {
        this.p = p;  
        
    /* Les coordonnees des objets cases (x, y) ne sont pas modifiables : on ne fait donc pas de setters
     * pour ces attributs.
     * Les coordonnees sont propres � chaque objet case cree. */
    }
}