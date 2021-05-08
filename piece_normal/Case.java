/**
 * 
 */
public class Case {
    // Déterminer l'abscisse de la case :
    private int x;
    //l'ordonnée :
    private int y;
    // appel de la pièce à poser sur la case
    private Piece p;

    // constructeur :
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters :
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Piece getP() {
        return p;
    }

    // Setter :
    // les cases ne sont pas modifiables, donc pas de setters pour l'abscisse et
    // l'ordonnée => uniquement pour l'objet que l'on veut créer, une pièce
    public void setP(Piece p) {
        this.p = p;
    }
}
