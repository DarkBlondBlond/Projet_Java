package shogi;

/**
 * Interface graphique pour le jeu de shogi
 */

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Création de la fenètre qui va contenir le jeu
	static JFrame fenetre = new JFrame ();
	
	// Création d'un panneau comprenant le plateau
	static JPanel UIplateau = new JPanel (new GridLayout(9,9));
	
	// Création de panneaux comprenant les réserves des 2 joueurs
	static JPanel[] UIreserve = {null, new JPanel(), new JPanel()};
	
	// Création d'un bouton pour chaque case du plateau
	static JButton[][] cases = new JButton[9][9];
	
	// Création du plateau
	static Plateau p = new Plateau();
	
	// Création d'une variable pour stocker la case sélectionnée par le joueur pour le déplacement
	static Case caseSelectionnee = null;
	
	// Création d'une variable pour stocker le numéro du tour de jeu
	public static int tour = 2;
	
	
}

