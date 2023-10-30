package ru.mirea.kvbo0422.task15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorGraph {
    JFrame f;
    JTextField tf = new JTextField();
    JButton[] b = new JButton[16];
    String[] button_arr = new String[]
            {       "7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", ".", "=", "+"};
    String s = "";
    CalculatorGraph(){
        prepareGUI();
        addTextField();
        addButtons();
        addActions();
    }
    public void prepareGUI(){
        //Frame
        f = new JFrame("Calculator Example");
        f.setTitle("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setResizable(false);
        f.setVisible(true);
    }
    public void addTextField(){
        //TextField
        tf = new JTextField(20);
        tf.setBounds(25,20,370,40);
        tf.setFont(new Font("Arial", Font.BOLD, 20));
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        f.add("North", tf);
    }
    public void addButtons(){
//Buttons
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(4,4,15,13));
        for (int i=0; i<16; i++){
            b[i] = new JButton(button_arr[i]);
            b[i].setSize(70,30);
            keyboard.add(b[i]);
        }
        f.add("Center", keyboard);
        f.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        f.pack();
    }
    public void addActions(){
        for (int i=0; i<16; i++){
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i=0; i<16; i++) {
                        //if ((e.getSource() == b[13])&&(s.substring(s.length() - 1).equals('.'))){
                            //break;
                        //}
                        if ( e.getSource() == b[14]){
                            doCalculations(s);
                            break;
                        }
                        if ( e.getSource() == b[i]){
                            s = s + button_arr[i];
                        }
                        tf.setText(s);
                    }
                }
            });
        }
    }
    public void doCalculations(String s){
        Pattern pAct = Pattern.compile("[+\\-*/]");
        String[] numbers = s.split("[+\\-*/]");
        Matcher act = pAct.matcher(s);
        for (String num: numbers){
        System.out.println(num);}
        int k = numbers.length-1;
        String[] operations = new String[k];
        k=0;
        while (act.find()){
            operations[k] = act.group();
            k++;
        }
        for (String op: operations)
            System.out.println(op);

        ArrayList<String> numList = new ArrayList<String>(Arrays.asList(numbers));
        ArrayList<String> opList = new ArrayList<String>(Arrays.asList(operations));

        String[] opTable = new String[]{"/", "*", "+", "-"};
        int op_counter = opList.size();
        System.out.println(op_counter);
        Calculator calc = new Calculator();

        for (int j = 0; j<4; j++) {
            System.out.println("j = "+j);
            for (int i = 0; i < op_counter; i++) {
                System.out.println("i ="+  i);
                System.out.println(opList.get(i));
                System.out.println(opTable[j]);
                if (opList.get(i).equals(opTable[j])) {
                    double c = 0;
                    switch (opTable[j]){
                        case "/":
                            c = calc.diviaion(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                            op_counter-=1;
                            break;
                        case "*":
                            c = calc.multiplication(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                            op_counter-=1;
                            break;
                        case "+":
                            c = calc.addition(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                            op_counter-=1;
                            break;
                        case "-":
                            c = calc.subtraction(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                            op_counter-=1;
                            break;
                    }
                    System.out.println(c);
                    opList.remove(i);
                    numList.remove(i + 1);
                    numList.set(i, String.valueOf(c));
                    System.out.println(numList);
                    System.out.println(opList);
                    if (numList.size() == 1)
                    {
                        break;
                    }
                }
            }
        }
        System.out.println(numList);
        tf.setText(numList.get(0));
    }
    public static void main(String[] args) {
        new CalculatorGraph();
    }
}