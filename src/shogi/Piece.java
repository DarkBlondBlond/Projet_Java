package shogi;

import javax.swing.ImageIcon;

/**
<<<<<<< HEAD
 * Classe principale Piece, avec les caractï¿½ristiques de bases communes ï¿½ chaque piï¿½ce
 * A extends ï¿½ chaque piï¿½ce.
=======
 * Classe principale Piece, avec les caractéristiques de bases communes à chaque pièce
 * à étendre à chaque pièce.
>>>>>>> refs/remotes/origin/master
 */

public class Piece {
    // Attribue un nom ï¿½ la piï¿½ce :
    private String nom = "";
    // Dï¿½termine l'appartenance d'une piï¿½ce au joueur 1 ou 2 :
    protected int joueur;
    ImageIcon icon;

    // Constructeur :
    public Piece(int j) {
        this.joueur = j;
    }

    // Mise en place des getters :
    public String getNom() {
        return nom;  // pour rï¿½cupï¿½rer la variable "nom" depuis les attributs de la classe Piece
    }

    public int getJoueur() {
        return joueur;  // pour rï¿½cupï¿½rer la variable "nom" depuis les attributs de la classe Piece
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

    // Mise en place de la mï¿½thode peutSeDeplacer :
    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {
        return false;  
        /* va retourner "false" de base car le mouvement est considï¿½rï¿½ comme impossible de base, 
         * la piï¿½ce n'ayant pas encore de nom pour le moment */
    }

    public void estPromue(Case c, Case[][] plateau) {
        String n = this.getNom();
        int x = c.getX();
        int y = c.getY();
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