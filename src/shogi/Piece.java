package shogi;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Classe principale Piece. Definit les caracteristiques de base communes à tout type de piece,
 * et dont toutes les pieces heriteront par la suite.
 */

public class Piece {
    
    private String nom = "";
    protected int joueur;
    ImageIcon i;
    ImageIcon icon;
    protected boolean promu = false;
    
    /**
     * Definit les attributs de la classe "Piece" :
	 *  
	 * @param nom attribue une chaine de carateres comme nom de la piece
	 * @param joueur determine si la piece appartient au joueur 1 ou 2
	 * @param i associe une icone à la piece
	 * @param icon
	 * @param promu attribut booleen indiquant si la piece est promue ou non
     */

    // Constructeur
    public Piece(int j) {
        this.joueur = j;
    }

    // Getters
    public String getNom() {
        return nom;  
    }

    public int getJoueur() {
        return joueur;  
    }
    
    public ImageIcon getIcon() {
    	return this.icon;
    }

    // Setters
    public void setNom (String n) {
        this.nom = n;  
    }

    public void setJoueur (int j) {
        this.joueur = j;  
    }
    
    public void setIcon() {
        String nom = this.getNom();
        String j = String.valueOf(this.getJoueur());
        i = new ImageIcon("drops/"+ nom + j +".png");
        Image image = i.getImage();
        Image nvelleimage = image.getScaledInstance(56, 60, java.awt.Image.SCALE_SMOOTH);
        this.icon = new ImageIcon(nvelleimage);
        
        /* Recupere le fichier png comportant le nom de la piece + 1 ou 2 (pour le joueur 1 ou
         * le joueur 2) et en fait un objet ImageIcon que l'on pourra associer par la suite avec
         * chaque piece */
    }

    public void setIcon(String nomPiece){
        String j = String.valueOf(this.getJoueur());
        i = new ImageIcon("drops/" + nomPiece + "Promu" + j + ".png");
        Image image = i.getImage();
        Image nvelleimage = image.getScaledInstance(56, 60, java.awt.Image.SCALE_SMOOTH);
        this.icon = new ImageIcon(nvelleimage);
        
        /* Surcharge la methode precedente pour l'appliquer aux pieces promues */
    }

    // Methode pour verifier si un deplacement est possible
    public boolean peutSeDeplacer(Case posDepart, Case posArrivee, Plateau plateau) {
        return false;  
        
        /* Retourne "false" par defaut, la piece et la case d'arrivee n'ayant pas ete selectionnees.
         * Est redefinie dans les differentes classes de pieces, avec des conditions specifiques aux
         * differents mouvement de chaque piece */
    }

    // Methode pour promouvoir une piece
    public void estPromue(){
        promu = true;
        setIcon(this.getNom());
        
        /* Passe le booleen a "true" (piece promue maintenant) et lui affecte egalement une 
         * nouvelle icone */
    }
    
    public void retrograde(){
        promu = false;
        setIcon();
        
        /* Passe le booleen a "false" (piece retrogradee maintenant) et lui reaffecte son 
         * icone de base */
    }
}