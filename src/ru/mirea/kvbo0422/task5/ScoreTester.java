package ru.mirea.kvbo0422.task5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreTester {
    private JFrame frame = new JFrame("Score counter GUI");

    public static void main(String[] args) {
        FootballTeam AcMilan = new FootballTeam(0);
        FootballTeam RealMadrid = new FootballTeam(0);
        //Frame
        JFrame frame = new JFrame("Score counter GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //Adding components
        JPanel button_panel = new JPanel();
        button_panel.setBackground(Color.GRAY);
        button_panel.setPreferredSize( new Dimension(200,100));
        JButton button1 = new JButton("AC Milan");
        JButton button2 = new JButton("Real Madrid");
        button_panel.add(button1);
        button_panel.add(button2);

        JPanel score_panel = new JPanel();
        score_panel.setLayout(new BoxLayout(score_panel,3));
        score_panel.setBackground(Color.GRAY);
        score_panel.setPreferredSize( new Dimension(200,100));
        JLabel label1 = new JLabel("Result: 0 X 0");
        JLabel label2 = new JLabel("Last Scorer:N/A");
        JLabel label3 = new JLabel("Winner: DRAW");
        score_panel.add(label1);
        score_panel.add(label2);
        score_panel.add(label3);

        //Button listeners
        ActionListener Alistener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcMilan.setScore();
                label1.setText("Result: "+AcMilan.getScore()+" X "+RealMadrid.getScore());
                label2.setText("Last Scorer:AC Milan");
                if (AcMilan.getScore()>RealMadrid.getScore()){
                    label3.setText("Winner: AC Milan");
                } else if (AcMilan.getScore() == RealMadrid.getScore()) {
                    label3.setText("Winner: DRAW");
                }
            }
        };
        button1.addActionListener(Alistener1);
        ActionListener Alistener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RealMadrid.setScore();
                label1.setText("Result: "+AcMilan.getScore()+" X "+RealMadrid.getScore());
                label2.setText("Last Scorer:Real Madrid");
                if (AcMilan.getScore()<RealMadrid.getScore()){
                    label3.setText("Winner: Real Madrid");
                } else if (AcMilan.getScore() == RealMadrid.getScore()) {
                    label3.setText("Winner: DRAW");
                }
            }
        };
        button2.addActionListener(Alistener2);
        //FlowLayout panel
        JPanel cards = new JPanel(new FlowLayout());
        cards.add(button_panel);
        cards.add(score_panel);
        frame.getContentPane().add(cards);
        frame.pack();
        frame.setVisible(true);
    }
}

