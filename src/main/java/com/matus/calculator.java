package com.matus;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *@author Mateusz Stanuszek
 *Dokumentacja techniczna
 *inna wiadomosc
 *cos nowego
 */
 
class calculator extends JFrame implements ActionListener { 
    
    private static final long serialVersionUID = 1L;
    
    JButton btn1111 = new JButton("11111");
    
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn_arti = new JButton("+");
    
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn_eksi = new JButton("-");
    
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btn_carpi = new JButton("*");
    
    JButton btn0 = new JButton("0");
    JButton btn_clr = new JButton("CLR");
    JButton btn_del = new JButton("DEL");
    JButton btn_bolu = new JButton("/");
    JButton btn_esit = new JButton("=");

    TextField txt=new TextField(15);
    
    String str_number = "";
    int operation = 0;
    double int_number1 = 0;
    double int_number2 = 0;
    double result = 0;
    
    private JFrame frame;
    
    public calculator() {
        
        frame = new JFrame("TEST JAVA CALCULATOR");
        frame.setSize(320,320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        frame.setLayout(new BorderLayout());
        
        JPanel HeadPanel = new JPanel();
        JPanel NumberPanel = new JPanel();
        JPanel LabelPanel = new JPanel();
        
        LabelPanel.setBackground(Color.BLACK);
        HeadPanel.setBackground(Color.BLUE);
        
        NumberPanel.setLayout(new GridLayout(4,4));
        LabelPanel.setLayout(new FlowLayout());
        
        NumberPanel.add(btn1);
        btn1.addActionListener(this);
        NumberPanel.add(btn2);
        btn2.addActionListener(this);
        NumberPanel.add(btn3);
        btn3.addActionListener(this);
        NumberPanel.add(btn_arti);
        btn_arti.addActionListener(this);
        
        NumberPanel.add(btn4);
        btn4.addActionListener(this);
        NumberPanel.add(btn5);
        btn5.addActionListener(this);
        NumberPanel.add(btn6);
        btn6.addActionListener(this);
        NumberPanel.add(btn_eksi);
        btn_eksi.addActionListener(this);
        
        NumberPanel.add(btn7);
        btn7.addActionListener(this);
        NumberPanel.add(btn8);
        btn8.addActionListener(this);
        NumberPanel.add(btn9);
        btn9.addActionListener(this);
        NumberPanel.add(btn_carpi);
        btn_carpi.addActionListener(this);
        
        NumberPanel.add(btn0);
        btn0.addActionListener(this);
        NumberPanel.add(btn_clr);
        btn_clr.addActionListener(this);
        NumberPanel.add(btn_del);
        btn_del.addActionListener(this);
        NumberPanel.add(btn_bolu);
        btn_bolu.addActionListener(this);
        
        LabelPanel.add(new JLabel("NUMBER : "));
        LabelPanel.add(txt);
        LabelPanel.add(btn_esit);
        btn_esit.addActionListener(this);
        
        txt.setEditable(false);
        btn_del.setEnabled(false);
             
        HeadPanel.add(new JLabel("^^ SIMPLE JAVA CALCULATOR ^^"));
        frame.add(HeadPanel,BorderLayout.NORTH);
        frame.add(NumberPanel,BorderLayout.CENTER);
        frame.add(LabelPanel,BorderLayout.SOUTH);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
    if(e.getSource()==btn1) {
           txt.setText("1");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn2) {
           txt.setText("2");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn3) {
           txt.setText("3");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn4) {
           txt.setText("4");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn5) {
           txt.setText("5");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn6) {
           txt.setText("6");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn7) {
           txt.setText("7");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn8) {
           txt.setText("8");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn9) {
           txt.setText("9");
           str_number+=txt.getText();
           txt.setText(str_number); }
    else if(e.getSource()==btn0) {
           txt.setText("0");
           str_number+=txt.getText();
           txt.setText(str_number); }
     else if(e.getSource()==btn_arti) {
            if(operation==0 & str_number!="") {
            int_number1=Integer.parseInt(str_number);
            txt.setText("+");
            str_number+=txt.getText();
            txt.setText(str_number);
            operation=1;//TOPLAMA
            }
            else { txt.setText(str_number); }
            }
     else if(e.getSource()==btn_eksi) {
         if(operation==0 & str_number!="") {
            int_number1=Integer.parseInt(str_number);
             txt.setText("-");
             str_number+=txt.getText();
             txt.setText(str_number);
             operation=2;//ÇIKARTMA
             }
             else { txt.setText(str_number); }
             }
     else if(e.getSource()==btn_carpi) {
         if(operation==0 & str_number!="") {
            int_number1=Integer.parseInt(str_number);
             txt.setText("*");
             str_number+=txt.getText();
             txt.setText(str_number);
             operation=3;//ÇARPMA
             }
             else { txt.setText(str_number); }
             }
     else if(e.getSource()==btn_bolu) {
         if(operation==0 & str_number!="") {
            int_number1=Integer.parseInt(str_number);
             txt.setText("/");
             str_number+=txt.getText();
             txt.setText(str_number);
             operation=4;//BÖLME
             }
             else { txt.setText(str_number); }
             }
     else if(e.getSource()==btn_esit) {
         if(operation!=0 & str_number!="") {
             txt.setText("=");
               str_number+=txt.getText();
               txt.setText(str_number);
             switch(operation) {
             case 1: {
                    String[] kelime = null;
                    kelime = str_number.split("\\+");
                    int_number2=Integer.parseInt(kelime[1].replace("=",""));
                 result=int_number1+int_number2;
                 txt.setText(str_number+Double.toString(result));
                 break;
             }
             case 2: {
                    String[] kelime = null;
                    kelime = str_number.split("\\-");
                    int_number2=Integer.parseInt(kelime[1].replace("=",""));
                 result=int_number1-int_number2;
                 txt.setText(str_number+Double.toString(result));
                 break;
             }
             case 3: {
                    String[] kelime = null;
                    kelime = str_number.split("\\*");
                    int_number2=Integer.parseInt(kelime[1].replace("=",""));
                 result=int_number1*int_number2;
                 txt.setText(str_number+Double.toString(result));
                 break;
             }
             case 4: {
                    String[] kelime = null;
                    kelime = str_number.split("\\/");
                    int_number2=Integer.parseInt(kelime[1].replace("=",""));
                    if(int_number2 == 0 ) {
                    	JOptionPane.showMessageDialog(frame, "Pamiętaj cholero, nie dziel przez zero!");
                    }
                 result=int_number1/int_number2;
                 txt.setText(str_number+Double.toString(result));
                 break;
             }
             }
             btn0.setEnabled(false);
             btn1.setEnabled(false);
             btn2.setEnabled(false);
             btn3.setEnabled(false);
             btn4.setEnabled(false);
             btn5.setEnabled(false);
             btn6.setEnabled(false);
             btn7.setEnabled(false);
             btn8.setEnabled(false);
             btn9.setEnabled(false);
             btn_arti.setEnabled(false);
             btn_eksi.setEnabled(false);
             btn_carpi.setEnabled(false);
             btn_bolu.setEnabled(false);
             btn_esit.setEnabled(false);
         }
         else { txt.setText("ERROR!!!"); }
     }
     else if(e.getSource()==btn_clr) {
         txt.setText("");
         str_number = "";
         operation = 0;
         int_number1 = 0;
         int_number2 = 0;
         result = 0;
         btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn_arti.setEnabled(true);
        btn_eksi.setEnabled(true);
        btn_carpi.setEnabled(true);
        btn_bolu.setEnabled(true);
        btn_esit.setEnabled(true);
     }
     //else if(e.getSource()==btn_del) {
     //}
}
    
    public static void main(String[] args) {
        
        new calculator();
        
    }
}
