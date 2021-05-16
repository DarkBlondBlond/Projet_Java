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
        // récupérer les coordonnées d'une pièece et le nom de la pièce
        if (p.getJoueur == 1) {
            // Promotion ne se déclenche que pour les cases 6-7-8
            if (p.getX() >= 6) {
                String n = p.getNom();
                Case pos = p.getCase();
                p = null;
            }
        }

        else if(p.getJoueur == 2) {
            // Promotion ne se déclenche que pour les cases 2-1-0
            if (p.getX() <= 2) {
                String n = p.getNom();
                Case pos = p.getCase();
                p = null;
            }
        }

        // Retourne l'objet obtenu 
        return p;
    }
}