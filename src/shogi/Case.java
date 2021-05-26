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
     * Les coordonnees sont propres à chaque objet case cree */
    }
}