package shogi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LancementJeu{
    public static void main(String [] args){
        creationFenetre();
    }

    public static void creationFenetre(){
        final JFrame fenetreLancement = new JFrame();
        JPanel content = new JPanel();
        JButton nouvellePartie = new JButton("Nouvelle partie");
        fenetreLancement.setSize(486, 300);
        fenetreLancement.setTitle("Shogi");
        content.setLayout(new BorderLayout());
        content.add(nouvellePartie);
        fenetreLancement.add(content);
        fenetreLancement.setVisible(true);
        nouvellePartie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Interface();
                fenetreLancement.dispose();
            }
        });
    }
}