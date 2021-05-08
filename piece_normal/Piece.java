/**
 * Classe principale Piece, avec les caractéristiques de bases communes à chaque pièce
 * A extends à chaque pièce.
 */

public class Piece {
    // nom pièce
    private String nom = "";
    // appartenance de la pièce au joueur 1 ou 2
    private int joueur;

    // constructeur :
    public Piece(int j) {
        this.joueur = j;
    }

    // méthodes getters :
    public String getNom() {
        return nom;
    }

    public int getJoueur() {
        return joueur;
    }

    // Méthodes setters
    public void setNom(String n) {
        this.nom = n;
    }

    public void setJoueur(int j) {
        this.joueur = j;
    }

    // Méthode déplacement :
    // return false de base car le mouvement est impossible de base, la pièce
    // n'ayant pas de nom
    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {
        return false;
    }
}