package shogi;

import javax.swing.ImageIcon;

/**
 * Classe principale Piece, avec les caractéristiques de bases communes à chaque pièce
 * A extends à chaque pièce.
 */

public class Piece {
    // Attribue un nom à la pièce :
    private String nom = "";
    // Détermine l'appartenance d'une pièce au joueur 1 ou 2 :
    protected int joueur;
    ImageIcon icon;

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
    
    //
    public ImageIcon getIcone() {
    	return this.icon;
    }

    // Mise en place des setters :
    public void setNom (String n) {
        this.nom = n;  // permet de modifier la variable "nom"
    }

    public void setJoueur (int j) {
        this.joueur = j;  // permet de modifier la variable "joueur"
    }
    
    public void setIcon() {
        String nom = this.getNom();
        String j = String.valueOf(this.getJoueur());
        this.icon = new ImageIcon("../../drops/"+ nom + j +".svg", nom);
    }

    // Mise en place de la méthode peutSeDeplacer :
    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau p) {
        return false;  
        /* va retourner "false" de base car le mouvement est considéré comme impossible de base, 
         * la pièce n'ayant pas encore de nom pour le moment */
    }

    public PiecePromue estPromue() {
        String n = this.getNom();
        int x = this.getX();
        int y = this.getY();
        int j = this.getJoueur();
        // p = null;

        if(n.equals("Tour")){
            plateau[x][y].setP(new TourPromue(j));
        }
        if(n.equals("Fou")){
            plateau[x][y].setP(new FouPromu(j));
        }
        
        else {
            plateau[x][y].setP(new PiecePromue(j, n));
        }
    }

}
