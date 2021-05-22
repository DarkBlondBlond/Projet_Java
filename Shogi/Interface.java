package Shogi;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Cr�ation de la fen�tre qui va contenir le jeu
	static JFrame fenetre = new JFrame ();
	
	// Cr�ation d'un panneau comprenant le plateau
	static JPanel UIplateau = new JPanel (new GridLayout(9,9));
	
	// Cr�ation de panneaux comprenant les r�serves des 2 joueurs
	static JPanel[] UIreserve = {null, new JPanel(), new JPanel()};
	
	// Cr�ation d'un bouton pour chaque case du plateau
	static JButton[][] cases = new JButton[9][9];
	
	// Cr�ation du plateau
	static Plateau p = new Plateau();
	
	// Cr�ation d'une varaible pour stocker la case s�lectionn�e par le joueur pour le d�placement
	static Case caseSelectionnee = null;
	
	// Cr�ation d'une variable pour stocker les tours
	public static int tour = 2;
	
	
}
