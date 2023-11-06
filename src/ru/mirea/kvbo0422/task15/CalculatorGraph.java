package ru.mirea.kvbo0422.task15;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorGraph {
    JFrame f;
    JTextField tf = new JTextField();
    JButton[] b = new JButton[20];
    String[] button_arr = new String[]
            {       "C", "<", "^", "!",
                    "7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", ".", "=", "+"};
    public String s = "";
    public  String prevOp = "";
    CalculatorGraph(){
        prepareGUI();
        addTextField();
        addButtons();
        addActions();
    }
    public void prepareGUI(){
        //Frame
        f = new JFrame();
        f.setBackground(Color.BLACK);
        f.setTitle("Goofy ass calculator 0.3v");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
        f.setResizable(false);
        f.setVisible(true);
    }
    public void addTextField(){
        //TextField
        tf = new JTextField(20);
        tf.setBounds(25,20,350,100);
        tf.setFont(new Font("Arial", Font.BOLD, 28));
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setBorder(new LineBorder(Color.GRAY, 5));
        tf.setBackground(new Color(137,158,139));

        f.add("North", tf);
    }
    public void addButtons(){
        //Buttons
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(5,4,15,13));
        for (int i=0; i<20; i++){
            b[i] = new JButton(button_arr[i]);
            b[i].setFont(new Font("Arial", Font.BOLD, 25));
            b[i].setSize(70,50);
            keyboard.add(b[i]);
        }
        //Add colors
        b[0].setBackground(new Color(218, 116, 44));
        b[1].setBackground(new Color(218, 116, 44));
        b[2].setBackground(Color.BLACK);
        b[3].setBackground(Color.BLACK);
        b[4].setBackground(Color.GRAY);
        b[5].setBackground(Color.GRAY);
        b[6].setBackground(Color.GRAY);
        b[7].setBackground(Color.BLACK);
        b[8].setBackground(Color.GRAY);
        b[9].setBackground(Color.GRAY);
        b[10].setBackground(Color.GRAY);
        b[11].setBackground(Color.BLACK);
        b[12].setBackground(Color.GRAY);
        b[13].setBackground(Color.GRAY);
        b[14].setBackground(Color.GRAY);
        b[15].setBackground(Color.BLACK);
        b[16].setBackground(Color.GRAY);
        b[17].setBackground(Color.GRAY);
        b[18].setBackground(Color.BLACK);
        b[19].setBackground(Color.BLACK);

        for (int i=0; i<20; i++){
            b[i].setBorder(new LineBorder(Color.WHITE, 2));
            b[i].setForeground(Color.WHITE);
        }
        keyboard.setBackground(Color.BLACK);
        f.add("Center", keyboard);
        f.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        f.pack();
    }
    public void addActions(){
        for (int i=0; i<20; i++){
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {//clear TextField
                    for (int i=0; i<20; i++) {
                        if ( e.getSource() == b[0]){
                            s = "";
                            tf.setText("");
                            break;
                        }
                        if (( e.getSource() == b[1])&&(!s.isEmpty())){//delete one symbol
                            s = s.substring(0,s.length()-1);
                            tf.setText(s);
                            break;
                        }
                        if ( e.getSource() == b[18]){//do calculations if "=" is pressed
                            doCalculations();
                            break;
                        }
                        if ((e.getSource() == b[i])&&
                                !((((Objects.equals(prevOp, button_arr[1]))||
                                        (Objects.equals(prevOp, button_arr[2]))||
                                        (Objects.equals(prevOp, button_arr[7]))||
                                        (Objects.equals(prevOp, button_arr[11]))||
                                        (Objects.equals(prevOp, button_arr[15]))||
                                        (Objects.equals(prevOp, button_arr[17]))||
                                        (Objects.equals(prevOp, button_arr[18]))||
                                        (Objects.equals(prevOp, button_arr[19])))&&
                                        ((i == 1)
                                                ||(i == 2)
                                                ||(i == 7)
                                                ||(i == 11)
                                                |(i == 15)
                                                ||(i == 17)
                                                ||(i == 18)
                                                ||(i == 19)))
                                        ||((prevOp == button_arr[3])&&(i == 3)))) {//add symbols
                            s = s + button_arr[i];
                            prevOp = button_arr[i];
                            if (s.length()>16){
                                s = "";
                            }
                        }
                        tf.setText(s);
                    }
                }
            });
        }
    }
    public void doCalculations() {
        boolean state = true;
        while (state) {
            Pattern pAct = Pattern.compile("[+\\-*/!^]");
            String[] numbers = this.s.split("[+\\-*/!^]");
            Matcher act = pAct.matcher(this.s);

            for (String num : numbers) {
                System.out.println(num);
            }
            int length = numbers.length;
            System.out.println("length = "+length);
            if ((length <= 0)){
                state = false;
                this.s = "";
                tf.setText("Error");
                continue;
            }
            String[] operations = new String[length];
            try {
            int k = 0;
                while (act.find()) {
                    operations[k] = act.group();
                    k++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                tf.setText("Error");
                this.s = "";
                state = false;
                continue;
            }
            for (String op : operations)
                System.out.println(op);

            ArrayList<String> numList = new ArrayList<String>(Arrays.asList(numbers));
            ArrayList<String> opList = new ArrayList<String>(Arrays.asList(operations));
            boolean errorState = false;
            for (int i = 0; i<numList.size(); i++){
                if (numList.get(i).contains(".")){
                    System.out.println("Yes");
                    int index = numList.get(i).indexOf(".");
                    if ((index == 0)||(index == numList.get(i).length())){
                        errorState = true;
                    }
                }
            }
            if (errorState){
                tf.setText("Error");
                this.s = "";
                state = false;
                continue;
            }

            String[] opTable = new String[]{"!", "^", "/", "*", "+", "-"};


            for (int i = numList.size()-1; i >= 0; i--) {
                if (Objects.equals(numList.get(i), ""))
                    numList.remove(i);
            }

            for (int i = opList.size()-1; i >= 0; i--) {
                if (Objects.equals(opList.get(i), null))
                    opList.remove(i);
            }

            System.out.println("numList.size = "+numList.size());
            System.out.println("opList.size = "+opList.size());//<----- stopped here
            if ((numList.size() == 1 )&&(opList.size() == 1 )&&(!Objects.equals(opList.get(0), "-"))&&(!Objects.equals(opList.get(0), "!"))){
                this.s = "";
                tf.setText("Error");
                state = false;
                continue;
            }

            System.out.println(numList);
            System.out.println(opList);
            if(opList.size()>=2) {
                for (int i = 0; i < opList.size() - 1; i++) {
                    if ((Objects.equals(opList.get(i), "-"))&&(Objects.equals(opList.get(i + 1), "!"))) {
                        Calculator calc = new Calculator();
                        if(numList.size() == 1) {
                            double change = calc.factorial(Double.parseDouble(numList.get(i)));
                            opList.remove(i + 1);
                            numList.set(i, String.valueOf(change));
                        }
                        else{
                            double change = calc.factorial(Double.parseDouble(numList.get(i)));
                            opList.remove(i + 1);
                            numList.set(i, String.valueOf(change));
                        }
                    }
                }
            }
            System.out.println("numList = " +numList);
            System.out.println("opList = " +opList);


            System.out.println("numList = " +numList);
            System.out.println("opList = " +opList);

             errorState = false;
            int singleOp = 0;
            int counter = -1;
            Character prevS = ' ';
            for (int i = 0; i < this.s.length(); i++) {
                if ((this.s.charAt(i) == '-') ||
                        (this.s.charAt(i) == '+') ||
                        (this.s.charAt(i) == '/') ||
                        (this.s.charAt(i) == '*') ||
                        (this.s.charAt(i) == '!') ||
                        (this.s.charAt(i) == '^')){
                    singleOp++;
                    counter++;
                    if (((singleOp == 2) && (this.s.charAt(i) != '-'))||(((singleOp == 2)&&(prevS == '-') && (this.s.charAt(i) == '-')))){
                        errorState = true;// -6!+3 - problem
                        break;
                    }
                    if ((singleOp == 2) && (prevS != ' ') && (this.s.charAt(i) == '-')) { // -3*-3 - problem
                        System.out.println("counter =" + counter);
                        System.out.println(numList.get(counter ));
                        double change = -Double.parseDouble(numList.get(counter));
                        numList.set(counter , String.valueOf(change));
                        opList.remove(counter);
                    }

                    prevS = this.s.charAt(i);
                    System.out.println("singleOp = " + singleOp);
                    System.out.println("preS = " + prevS);
                } else {
                    prevS = ' ';
                    singleOp = 0;
                }
                System.out.println("numList" + numList);
                System.out.println("errorstate = " + errorState);
            }

            if((s.charAt(0) == '-')){
                double change = -Double.parseDouble(numList.get(0));
                numList.set(0, String.valueOf(change));
                opList.remove(0);
            }

            if (errorState) {
                tf.setText("Error");
                this.s = "";
                state = false;
                continue;
            }

            if ((opList.size() == 1 )&&(numList.size() == 1)&&(opList.get(0).equals("-")) ){
                this.s = "";
                double change = -Double.parseDouble(numList.get(0));
                tf.setText(String.valueOf(change));
                state = false;
                continue;
            }

            System.out.println("errorstate = " + errorState);

            System.out.println(numList);
            System.out.println(opList);
            Calculator calc = new Calculator();
            int op_counter = opList.size();
            System.out.println(op_counter);
            try {
                String prevOp = " ";
                for (int j = 0; j < 6; j++) {
                    System.out.println("j = " + j);
                    for (int i = 0; i < op_counter; i++) {
                        System.out.println("i =" + i);
                        System.out.println(opList.get(i));
                        System.out.println(opTable[j]);
                        if (opList.get(i).equals(opTable[j])) {

                            double c = 0;
                            switch (opTable[j]) {
                                case "/" -> {
                                    c = calc.division(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                                    op_counter--;
                                    System.out.println(c);
                                    opList.remove(i);
                                    numList.remove(i + 1);
                                    numList.set(i, String.valueOf(c));
                                    System.out.println(numList);
                                    System.out.println(opList);
                                    if (i == 0){
                                        i--;
                                    }
                                }
                                case "*" -> {
                                    c = calc.multiplication(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                                    op_counter--;
                                    System.out.println(c);
                                    opList.remove(i);
                                    numList.remove(i + 1);
                                    numList.set(i, String.valueOf(c));
                                    System.out.println(numList);
                                    System.out.println(opList);
                                    if (i == 0){
                                        i--;
                                    }
                                }
                                case "+" -> {
                                    c = calc.addition(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                                    op_counter--;
                                    System.out.println(c);
                                    opList.remove(i);
                                    numList.remove(i + 1);
                                    numList.set(i, String.valueOf(c));
                                    System.out.println(numList);
                                    System.out.println(opList);
                                    if (i == 0){
                                        i--;
                                    }
                                }
                                case "-" -> {
                                    c = calc.subtraction(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                                    op_counter--;
                                    System.out.println(c);
                                    opList.remove(i);
                                    numList.remove(i + 1);
                                    numList.set(i, String.valueOf(c));
                                    System.out.println(numList);
                                    System.out.println(opList);
                                    if (i == 0){
                                        i--;
                                    }
                                }
                                case "!" -> {
                                    c = calc.factorial(Double.parseDouble(numList.get(i)));
                                    op_counter--;
                                    System.out.println(c);
                                    opList.remove(i);
                                    numList.set(i, String.valueOf(c));
                                    System.out.println(numList);
                                    System.out.println(opList);
                                    if (i == 0){
                                        i--;
                                    }
                                }
                                case "^" -> {
                                    c = calc.exponentiation(Double.parseDouble(numList.get(i)), Double.parseDouble(numList.get(i + 1)));
                                    op_counter--;
                                    System.out.println(c);
                                    opList.remove(i);
                                    numList.remove(i + 1);
                                    numList.set(i, String.valueOf(c));
                                    System.out.println(numList);
                                    System.out.println(opList);
                                    if (i == 0){
                                        i--;
                                    }
                                }
                            }

                            if ((numList.size() == 1)&&(opList.isEmpty())) {
                                break;
                            }

                            }
                        }
                    }
                System.out.println(numList);
                tf.setText(numList.get(0));
                this.s = "";
                state = false;
            } catch (NumberFormatException e) {
                tf.setText("Error");
                this.s = "";
                state = false;
            }

        }
    }

    public static void main(String[] args) {
        new CalculatorGraph();
    }
}