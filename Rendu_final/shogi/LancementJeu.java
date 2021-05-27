package shogi;

/**
 * Interface graphique pour proceder au lancement du jeu 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LancementJeu {
	
	// Main necessaire pour le lancement du programme de jeu
    public static void main(String [] args) {
        creationFenetre();
    }

    // Initialisation de la fenetre de lancement 
    public static void creationFenetre(){
        final JFrame fenetreLancement = new JFrame();
        JPanel contenu = new JPanel();
        JButton nouvellePartie = new JButton("Nouvelle partie");
        fenetreLancement.setSize(486, 300);
        fenetreLancement.setTitle("Jeu de shogi");
        contenu.setLayout(new BorderLayout());
        contenu.add(nouvellePartie);
        fenetreLancement.add(contenu);
        fenetreLancement.setVisible(true);
        nouvellePartie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Interface();
                fenetreLancement.dispose();
            }
        });
    }
}