package com.matus;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
* 
* Klasa tworzaca okno programu kalkulator,ktorym mozemy wykonywac opracje dodawania, odejmowania, mnozenia i dzielenia.
* Po ukonczonej operacji mozliwosc wyczyszczenia pola z dzialaniem i rozpoczecia nowej operacji.
* @author Grzegorz Kapcia 
* @author Mateusz Stanuszek
* @since 20-10-2013
* @version 25-11-2013
* @see java.awt.event.ActionListener
* @see javax.swing.JFrame
*/

 
public class calculator extends JFrame implements ActionListener,KeyListener{ 
	 MenuItem exitItem;
	 TrayIcon trayIcon;
	 
	 MenuItem sItem;
     MenuItem s2Item;
     
     final static String PREF_NAME = "THEME";
	
	private void Ikona()
	{
		 if (!SystemTray.isSupported()) {
	            System.out.println("SystemTray is not supported");
	            return;
	        }
	      final PopupMenu popup = new PopupMenu();
	        
	        BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("res/calc.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        trayIcon =
	                new TrayIcon(myPicture);
	        final SystemTray tray = SystemTray.getSystemTray();
	       
	        // Create a pop-up menu components

	        Menu displayMenu = new Menu("Skórka");
	        sItem = new MenuItem("Domyślna");
	        s2Item = new MenuItem("Śmieszna");
	        sItem.addActionListener(this);
	        s2Item.addActionListener(this);
	        displayMenu.add(s2Item);
	        displayMenu.add(sItem);
	        exitItem = new MenuItem("Exit");
	       
	        exitItem.addActionListener(this);
	        //Add components to pop-up menu
	        popup.add(displayMenu);
	        popup.add(exitItem);
	       
	        trayIcon.setPopupMenu(popup);
	       
	        try {
	            tray.add(trayIcon);
	        } catch (AWTException e) {
	            System.out.println("TrayIcon could not be added.");
	        }
	}

	private static final long serialVersionUID = -4211365542340727420L;
	/** Przycisk cyfra 1 */
	private JButton btn1 = new JButton("1");
	/** Przycisk cyfra 2 */
    private JButton btn2 = new JButton("2");
    /** Przycisk cyfra 3 */
    private JButton btn3 = new JButton("3");
    /** Przycisk dodaj */
    private JButton btn_arti = new JButton("+");
    /** Przycisk cyfra 4 */
    private JButton btn4 = new JButton("4");
    /** Przycisk cyfra 5 */
    private JButton btn5 = new JButton("5");
    /** Przycisk cyfra 6 */
    private JButton btn6 = new JButton("6");
    /** Przycisk odejmij */
    private JButton btn_eksi = new JButton("-");
    /** Przycisk cyfra 7 */
    private JButton btn7 = new JButton("7");
    /** Przycisk cyfra 8 */
    private JButton btn8 = new JButton("8");
    /** Przycisk cyfra 9 */
    private JButton btn9 = new JButton("9");
    /** Przycisk mnozenie */
    private JButton btn_carpi = new JButton("*");
    /** Przycisk cyfra 0 */
    private JButton btn0 = new JButton("0");
    
    /** Przycisk wyczysc */
    private JButton btn_clr = new JButton("CLR");
    private JButton btn_del = new JButton("DEL");
    /** Przycisk dzielenie */
    private JButton btn_bolu = new JButton("/");
    /** Przycisk wyniku */
    private JButton btn_esit = new JButton("=");

    /** Pole tekstowe z dzialaniem */
    private TextField txt=new TextField(15);

    private String str_number = "";
    /** Numer dzialania */
    private int operation = 0;
    /** Pierwsza liczba w dzialaniu */
    private double int_number1 = 0;
    /** Druga liczba w dzialaniu */
    private double int_number2 = 0;
    /** Wynik dzialania */
    private double result = 0;
    
    private JMenuItem fileItem1;
    JFrame frame;
    
    /** Metoda prywatna pozwalajaca konstruktorowi utworzenie nowego okna o podanych wymiarach
     * @param frame Puste okno aplikacji
     * @param width Szerokosc okna aplikacji
     * @param hight Wysokosc okna aplikacji 
     * @return frame Przygotowane okno aplikacji
     */
    private JFrame createFrame(JFrame frame,int width, int hight)
    {

        /*-----*/
        frame.setLocation(440,250);
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("Pomoc");
        filemenu.add(new JSeparator());
        fileItem1 = new JMenuItem("Pomoc           F1");

        fileItem1.addActionListener(this);
        filemenu.add(fileItem1);
        menubar.add(filemenu);
        frame.setJMenuBar(menubar);
        
        /*-----*/
        frame.setSize(width,hight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        return frame;
    }
    
    /**
     * Metoda prywatna wykonujaca operacje dodawania
     * @param txt Pole tekstowe, w ktorym wyswietlany jest wynik operacji dodawania
     */
    private void Dodawanie(TextField txt)
    {
        String[] kelime = null;
        kelime = str_number.split("\\+");
        int_number2=Integer.parseInt(kelime[1].replace("=",""));
        result=int_number1+int_number2;
        txt.setText(str_number+Double.toString(result));
    }
    
    
    /**
     * Metoda prywatna wykonujaca operacje odejmowania
     * @param txt Pole tekstowe, w ktorym wyswietlany jest wynik operacji odejmowania
     */
    private void Odejmowanie(TextField txt)
    {
        String[] kelime = null;
        kelime = str_number.split("\\-");
        int_number2=Integer.parseInt(kelime[1].replace("=",""));
        result=int_number1-int_number2;
        txt.setText(str_number+Double.toString(result));
    }
    
    
    /**
     * Metoda prywatna wykonujaca operacje mnozenia
     * @param txt Pole tekstowe, w ktorym wyswietlany jest wynik operacji mnozenia
     */
    private void Mnozenie(TextField txt)
    {
    	 String[] kelime = null;
         kelime = str_number.split("\\*");
         int_number2=Integer.parseInt(kelime[1].replace("=",""));
         result=int_number1*int_number2;
         txt.setText(str_number+Double.toString(result));
    }
    
    /**
     * Metoda prywatna wykonujaca operacje dzielenia
     * @param txt Pole tekstowe, w ktorym wyswietlany jest wynik operacji dzielenia
     */
    private void Dzielenie(TextField txt)
    {
        String[] kelime = null;
        kelime = str_number.split("\\/");
        int_number2=Integer.parseInt(kelime[1].replace("=",""));
        result=int_number1/int_number2;
        txt.setText(str_number+Double.toString(result));
    }
    
    /**
     * Publiczny kontruktor bezparametrowy 
     */

    public calculator() {
        
    	frame = new JFrame("SIMPLE JAVA CALCULATOR");
        createFrame(frame,320,320);
        frame.addKeyListener(this);

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
        
        Ikona();
    }
    
    public void showNotification(String title, String msg) {
        if (SystemTray.isSupported()) {
            trayIcon.displayMessage(title, msg, TrayIcon.MessageType.INFO);

        }
    }
    
    
    /**
     * Publiczna metoda wykonujaca akcje poszczegolnego przycisku
     * @param e ActionEvent
     */
    
    public void actionPerformed(ActionEvent e) {
        
    if(e.getSource()==btn1) {
           txt.setText("1");
           str_number+=txt.getText();
           txt.setText(str_number); }
    
    else if(e.getSource()==fileItem1)
    {
    	new Pomoc(1);
    }
    
    else if(e.getSource()==exitItem)
    {
    	System.exit(0);
    }
    else if(e.getSource()==s2Item)
    {
    
    	String newValue = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    	 try {
 			UIManager.setLookAndFeel(newValue);
 		} catch (ClassNotFoundException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		} catch (InstantiationException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		} catch (IllegalAccessException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		} catch (UnsupportedLookAndFeelException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
         
         Preferences prefs = Preferences.userNodeForPackage(com.matus.calculator.class);

         

      // Set the value of the preference
      
      prefs.put(PREF_NAME, newValue);
      
      SwingUtilities.updateComponentTreeUI(frame);
      frame.pack();
      
      frame.setSize(320, 320);
    	
    }
    else if(e.getSource()==sItem)
    {
    	
    	String newValue = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    	
    	 try {
  			UIManager.setLookAndFeel(newValue);
  		} catch (ClassNotFoundException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		} catch (InstantiationException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		} catch (IllegalAccessException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		} catch (UnsupportedLookAndFeelException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
          
          Preferences prefs = Preferences.userNodeForPackage(com.matus.calculator.class);

       // Preference key name
 
       // Set the value of the preference
       
       prefs.put(PREF_NAME, newValue);
       
       SwingUtilities.updateComponentTreeUI(frame);
       frame.pack();
       frame.setSize(320, 320);
    	
    }

    
    
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
                  Dodawanie(txt);
                  showNotification("Informacja", "Wykonałeś dodawanie");
                 break;
             }
             case 2: {
            	 Odejmowanie(txt);
            	 showNotification("Informacja", "Wykonałeś odejmowanie");
                 break;
             }
             case 3: {
                   Mnozenie(txt);
                   showNotification("Informacja", "Wykonałeś mnożenie");
                 break;
             }
             case 4: {
            	 Dzielenie(txt);
            	 showNotification("Informacja", "Wykonałeś dzielenie");
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
    
    
    /**
     * Metoda glowna aplikacji, w ktorej tworzone jest okno kalkulatora
     * @param args Parametry wywolania programu 
     */
    
    public static void main(String[] args) {
        
    	 Preferences prefs = Preferences.userNodeForPackage(com.matus.calculator.class);
         String defaultValue = "default string";
         String propertyValue = prefs.get(PREF_NAME, defaultValue);

      	 try {
   			UIManager.setLookAndFeel(propertyValue);
   		} catch (ClassNotFoundException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		} catch (InstantiationException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		} catch (IllegalAccessException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		} catch (UnsupportedLookAndFeelException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
              
        
       

     // Get the value of the preference;
     // default value is returned if the preference does not exist
   
     
     // "a string"
        new calculator();
        
    }

	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_F1)
		{
			new Pomoc(1);
		}
		else if
		(e.getKeyCode()==KeyEvent.VK_F2)
		{
			new Pomoc(2);
		}
		
	}

	public void keyReleased(KeyEvent e) {

		
	}

	public void keyTyped(KeyEvent e) {
	
		
	}
}

class Pomoc extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 594972230163211856L;
	public Pomoc(int i)
	{
		JFrame frame = new JFrame();
		frame.setSize(320,320);
		frame.setLocation(600,100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        JPanel HeadPanel = new JPanel();
        JTextArea HelpPanel = new JTextArea();
        HelpPanel.setMargin( new Insets(10,10,10,10) );
        HeadPanel.add(new JLabel("POMOC"));
        HelpPanel.setLineWrap(true);
        HelpPanel.setWrapStyleWord(true);
        HelpPanel.setEditable(false);
        
        if(i==1)
        {
	        HelpPanel.setText("\nKalkulator może służyć do wykonywania prostych obliczeń,"
	        		+ " takich jak dodawanie, odejmowanie, mnożenie i dzielenie.\n"
	        		+ "Obliczenia można przeprowadzać klikając przyciski kalkulatora.\n\n"
	        		+ "1. Wprowadź pierwszą liczbę klikając na odpowiednie cyfry.\n"
	        		+ "2. Wybierz działanie +,-,* lub /. \n"
	        		+ "3. Wprowadź drugą liczbę klikając na odpowiednie cyfry.\n"
	        		+ "4. Po kliknięciu przycisku = otrzymasz wynik w polu tekstowym.\n"
	        		+ "5. Kliknięcie przycisku CLR powoduje wyczyszczenie ekranu.\n"
	        		);
        }
        else if(i==2)
        {
        	HelpPanel.setText("\n Pomoc F2\n"
	        		);
        }
       // frame.add(HeadPanel,BorderLayout.NORTH);
        JPanel panel=new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        panel.add(HeadPanel,c);
        
        BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("res/kalk.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(HelpPanel,c);
        
        JLabel jl = new JLabel("\n");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(jl,c);
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(picLabel,c);

      JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      frame.add(scrollBar);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}