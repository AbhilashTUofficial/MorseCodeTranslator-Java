package com.morsecode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class Screen extends JFrame implements MouseListener,ActionListener, KeyListener {
    JTabbedPane tabs = new JTabbedPane();
    Font font1 = new Font("Arial", Font.BOLD, 20);
    Font font2 = new Font("Arial", Font.PLAIN, 16);
    Icon middleClickImg = new ImageIcon("src/com/morsecode/mouseMiddleClick.jpg");
    Icon rightClickImg = new ImageIcon("src/com/morsecode/mouseRightClick.jpg");
    Icon leftClickImg = new ImageIcon("src/com/morsecode/mouseLeftClick.jpg");
    Hashtable<String,String> morse2English=new Hashtable<String,String>();
    Hashtable<String,String> english2Morse=new Hashtable<String,String>();
    JPanel englishToMorse;
    JPanel morseToEnglish;
    JTextField m2eMorseDisplay;
    JTextArea m2eEnglishDisplay;
    JButton m2eRightClick;
    JButton m2eLeftClick;
    JButton m2eMiddleClick;
    JLabel m2eRightClickLabel;
    JLabel m2eLeftClickLabel;
    JLabel m2eMiddleClickLabel;
    JTextArea e2mMorseDisplay;
    JTextArea e2mEnglishDisplay;
    JLabel e2mEnglishLabel;
    JLabel e2mMorseLabel;

    public void button1Pressed(){
        m2eMorseDisplay.setFont(font1);
        if(m2eMorseDisplay.getText().equals("enter your morse code!")){
            m2eMorseDisplay.setText(".");
        }else{
            m2eMorseDisplay.setText(m2eMorseDisplay.getText()+".");
        }
    }
    public void button2Pressed(){
        m2eMorseDisplay.setFont(font1);
        if(m2eMorseDisplay.getText().equals("enter your morse code!")){
            m2eMorseDisplay.setText("");
        }else{
            m2eMorseDisplay.setText(m2eMorseDisplay.getText()+" ");
        }
        morseCodeTranslate();
    }
    public void button3Pressed(){
        m2eMorseDisplay.setFont(font1);
        if(m2eMorseDisplay.getText().equals("enter your morse code!")){
            m2eMorseDisplay.setText("_");
        }else{
            m2eMorseDisplay.setText(m2eMorseDisplay.getText()+"_");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==m2eRightClick){
            button1Pressed();
        }
        if(e.getSource()==m2eMiddleClick){
            button2Pressed();
        }
        if(e.getSource()==m2eLeftClick){
            button3Pressed();
        }
        morseCodeTranslate();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==1){
            button1Pressed();
        }
        if(e.getButton()==2){
            button2Pressed();
        }
        if(e.getButton()==3){
            button3Pressed();
        }
    }

    private void morseCodeTranslate() {
        String un_en_sms=m2eMorseDisplay.getText();
        int j=un_en_sms.lastIndexOf(" ");
        int i=un_en_sms.trim().lastIndexOf(" ");
        if(i==-1)i=0;
        String code=un_en_sms.substring(i,j).trim();
        if(m2eEnglishDisplay.getText().equals("Result")){
            m2eEnglishDisplay.setText(morse2English.get(code));
        }else{
            m2eEnglishDisplay.append(morse2English.get(code));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    Screen(){
        // Window setups
        setBounds(200, 100, 500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Morse Code Translator");
        setResizable(false);
        setAlwaysOnTop(true);
        setBackground(Color.DARK_GRAY);
        addMouseListener(this);
        add(BorderLayout.CENTER, tabs);
        tabs.addTab("  Morse To English  ", morseToEnglish());
        tabs.addTab("  English To Morse  ", englishToMorse());
        setVisible(true);

        morse2English.put("._","A");
        morse2English.put("_...","B");
        morse2English.put("_._.","C");
        morse2English.put("_..","D");
        morse2English.put(".","E");
        morse2English.put(".._.","F");
        morse2English.put("__.","G");
        morse2English.put("....","H");
        morse2English.put("..","I");
        morse2English.put(".___","J");
        morse2English.put("_._","K");
        morse2English.put("._..","L");
        morse2English.put("__","M");
        morse2English.put("_.","N");
        morse2English.put("___","O");
        morse2English.put(".__.","P");
        morse2English.put("__._","Q");
        morse2English.put("._.","R");
        morse2English.put("...","S");
        morse2English.put("_","T");
        morse2English.put(".._","U");
        morse2English.put("..._","V");
        morse2English.put(".__","W");
        morse2English.put("_.._","X");
        morse2English.put("_.__","Y");
        morse2English.put("__..","Z");

        morse2English.put(".____","1");
        morse2English.put("..___","2");
        morse2English.put("...__","3");
        morse2English.put("...._","4");
        morse2English.put(".....","5");
        morse2English.put("_....","6");
        morse2English.put("__...","7");
        morse2English.put("___..","8");
        morse2English.put("____.","9");
        morse2English.put("_____","0");

        english2Morse.put("A","._");
        english2Morse.put("B","_...");
        english2Morse.put("C","_._.");
        english2Morse.put("D","_..");
        english2Morse.put("E",".");
        english2Morse.put("F",".._.");
        english2Morse.put("G","__.");
        english2Morse.put("H","....");
        english2Morse.put("I","..");
        english2Morse.put("J",".___");
        english2Morse.put("K","_._");
        english2Morse.put("L","._..");
        english2Morse.put("M","__");
        english2Morse.put("N","_.");
        english2Morse.put("O","___");
        english2Morse.put("P",".__.");
        english2Morse.put("Q","__._");
        english2Morse.put("R","._.");
        english2Morse.put("S","...");
        english2Morse.put("T","_");
        english2Morse.put("U",".._");
        english2Morse.put("V","..._");
        english2Morse.put("W",".__");
        english2Morse.put("X","_.._");
        english2Morse.put("Y","_.__");
        english2Morse.put("Z","__..");

        english2Morse.put("1",".____");
        english2Morse.put("2","..___");
        english2Morse.put("3","...__");
        english2Morse.put("4","...._");
        english2Morse.put("5",".....");
        english2Morse.put("6","_....");
        english2Morse.put("7","__...");
        english2Morse.put("8","___..");
        english2Morse.put("9","____.");
        english2Morse.put("0","_____");

    }
    public JPanel morseToEnglish(){
        morseToEnglish=new JPanel();
        JLabel heading = new JLabel();
        m2eMorseDisplay=new JTextField();
        m2eEnglishDisplay=new JTextArea();
        m2eRightClick=new JButton();
        m2eLeftClick=new JButton();
        m2eMiddleClick=new JButton();
        m2eRightClickLabel=new JLabel();
        m2eLeftClickLabel=new JLabel();
        m2eMiddleClickLabel=new JLabel();

        morseToEnglish.setBackground(Color.darkGray);
        morseToEnglish.setForeground(Color.white);
        morseToEnglish.setLayout(null);

        heading.setText("Morse To English Translator");
        heading.setBounds(100, 10, 400, 30);
        heading.setForeground(Color.white);
        heading.setFont(font1);

        m2eMorseDisplay.setText("enter your morse code!");
        m2eMorseDisplay.setBackground(Color.darkGray);
        m2eMorseDisplay.setForeground(Color.lightGray);
        m2eMorseDisplay.setEditable(false);
        m2eMorseDisplay.setBounds(40,60,320,30);
        m2eMorseDisplay.addMouseListener(this);

        m2eEnglishDisplay.setText("Result");
        m2eEnglishDisplay.setBackground(Color.darkGray);
        m2eEnglishDisplay.setForeground(Color.lightGray);
        m2eEnglishDisplay.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        m2eEnglishDisplay.setEditable(false);
        m2eEnglishDisplay.setBounds(40,100,320,200);
        m2eEnglishDisplay.addMouseListener(this);

        m2eRightClick.setBounds(400,60,60,60);
        m2eRightClick.setIcon(rightClickImg);
        m2eRightClick.addActionListener(this);
        m2eRightClickLabel.setText(" Dot ");
        m2eRightClickLabel.setFont(font2);
        m2eRightClickLabel.setForeground(Color.lightGray);
        m2eRightClickLabel.setBounds(410,120,60,20);

        m2eLeftClick.setBounds(400,140,60,60);
        m2eLeftClick.setIcon(leftClickImg);
        m2eLeftClick.addActionListener(this);
        m2eLeftClickLabel.setText("Dash ");
        m2eLeftClickLabel.setFont(font2);
        m2eLeftClickLabel.setForeground(Color.lightGray);
        m2eLeftClickLabel.setBounds(410,200,60,20);

        m2eMiddleClick.setBounds(400,220,60,60);
        m2eMiddleClick.setIcon(middleClickImg);
        m2eMiddleClick.addActionListener(this);
        m2eMiddleClickLabel.setText("Space");
        m2eMiddleClickLabel.setFont(font2);
        m2eMiddleClickLabel.setForeground(Color.lightGray);
        m2eMiddleClickLabel.setBounds(410,280,60,20);


        morseToEnglish.add(heading);
        morseToEnglish.add(m2eMorseDisplay);
        morseToEnglish.add(m2eEnglishDisplay);
        morseToEnglish.add(m2eRightClick);
        morseToEnglish.add(m2eRightClickLabel);
        morseToEnglish.add(m2eLeftClick);
        morseToEnglish.add(m2eLeftClickLabel);
        morseToEnglish.add(m2eMiddleClick);
        morseToEnglish.add(m2eMiddleClickLabel);
        morseToEnglish.addMouseListener(this);
        return morseToEnglish;
    }
    public JPanel englishToMorse(){
        englishToMorse=new JPanel();
        JLabel heading = new JLabel();
        e2mEnglishDisplay=new JTextArea();
        e2mMorseDisplay=new JTextArea();
        e2mEnglishLabel=new JLabel();
        e2mMorseLabel=new JLabel();

        englishToMorse.setBackground(Color.darkGray);
        englishToMorse.setForeground(Color.white);
        englishToMorse.setLayout(null);

        heading.setText("English To Morse Translator");
        heading.setBounds(100, 10, 400, 30);
        heading.setForeground(Color.white);
        heading.setFont(font1);

        e2mEnglishLabel.setText("English");
        e2mEnglishLabel.setForeground(Color.white);
        e2mEnglishLabel.setFont(font2);
        e2mEnglishLabel.setBounds(120,60,100,30);

        e2mMorseLabel.setText("Morse");
        e2mMorseLabel.setForeground(Color.white);
        e2mMorseLabel.setFont(font2);
        e2mMorseLabel.setBounds(320,60,100,30);

        e2mMorseDisplay.setBounds(250,100,205,200);
        e2mMorseDisplay.setBackground(Color.darkGray);
        e2mMorseDisplay.setForeground(Color.white);
        e2mMorseDisplay.setFont(font1);
        e2mMorseDisplay.setLineWrap(true);
        e2mMorseDisplay.setEditable(false);
        e2mMorseDisplay.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        e2mEnglishDisplay.setBounds(40,100,205,200);
        e2mEnglishDisplay.setBackground(Color.darkGray);
        e2mEnglishDisplay.setForeground(Color.white);
        e2mEnglishDisplay.setFont(font2);
        e2mEnglishDisplay.setLineWrap(true);
        e2mEnglishDisplay.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        e2mEnglishDisplay.addKeyListener(this);

        englishToMorse.add(heading);
        englishToMorse.add(e2mEnglishDisplay);
        englishToMorse.add(e2mMorseDisplay);
        englishToMorse.add(e2mEnglishLabel);
        englishToMorse.add(e2mMorseLabel);
        return englishToMorse;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        String str=english2Morse.get(String.valueOf(e.getKeyChar()).toUpperCase());
        e2mMorseDisplay.append(" "+str);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
