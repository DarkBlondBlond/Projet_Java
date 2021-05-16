/**
 * Classe principale Piece, avec les caractéristiques de bases communes à chaque pièce
 * A extends à chaque pièce.
 */

public class Piece {
    // Attribue un nom à la pièce :
    private String nom = "";
    // Détermine l'appartenance d'une pièce au joueur 1 ou 2 :
    protected int joueur;

    // Constructeur :
    public Piece(int j) {
        this.joueur = j;
    }

    // Mise en place des getters :
    public String getNom() {
        return nom;  // pour récupérer la variable "nom" depuis les attributs de la classe Piece
    }

    public int getJoueur() {
        return joueur;  // pour récupérer la variable "nom" depuis les attributs de la classe Piece
    }

    // Mise en place des setters :
    public void setNom(String n) {
        this.nom = n;  // permet de modifier la variable "nom"
    }

    public void setJoueur(int j) {
        this.joueur = j;  // permet de modifier la variable "joueur"
    }

    // Mise en place de la méthode peutSeDeplacer :
    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {
        return false;  /**
                        * va retourner "false" de base car le mouvement est considéré comme impossible de 
                        * base, la pièce n'ayant pas encore de nom pour le moment 
                        */
    }

    public PiecePromue estPromue(Piece p) {
        String n = p.getNom();
        int x = p.getX();
        int y = p.getY();
        int j = p.getJoueur();

        if(n == "Pion"){
            plateau[x][y].setP(new PionPromu(j))
        }
        if(n == "Tour"){
            plateau[x][y].setP(new TourPromu(j))
        }
        if(n == "Fou"){
            plateau[x][y].setP(new FouPromu(j))
        }
        if(n == "GeneralArgent"){
            plateau[x][y].setP(new GeneralArgentPromu(j))
        }
        if(n == "Cavalier"){
            plateau[x][y].setP(new CavalierPromu(j))
        }
        if(n == "Lancier"){
            plateau[x][y].setP(new LancierPromu(j))
        }
    }
}