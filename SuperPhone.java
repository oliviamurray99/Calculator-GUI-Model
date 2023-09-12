import com.sun.security.auth.NTDomainPrincipal;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;



public class SuperPhone extends JFrame implements ActionListener {

    JButton[] num = new JButton[10];
    JButton bStar,bPound,bCall,bBack,b0;
    JLabel lPhoneName;
    JLabel lStatus;
    JLabel lBlank;
    JTextField tfPhoneNum;
    JPanel n,c,s;

    String data;



    SuperPhone(){
        Font buttonFont = new Font("Lucida Console",Font.PLAIN,32);
        Font ctrlButtonFont = new Font("Lucida Console",Font.PLAIN,35);

        setTitle("Fatima's SuperPhone");
        setSize(400,600);
        setLayout(new BorderLayout());


        for(int i = 0; i<10; ++i){
            num[i] = new JButton(""+i);
            num[i].setFont(buttonFont);
            num [i].addActionListener(this);
            num[i].setForeground(new Color((int)(Math.random()*236),(int)(Math.random()*236),(int)(Math.random()*236)));
        }//end for


        lPhoneName = new JLabel("Olivia's Phone");
        lPhoneName.setFont(new Font("Vladimir Script",Font.BOLD,32));
        lPhoneName.setHorizontalAlignment(SwingConstants.CENTER);

        tfPhoneNum = new JTextField("");
        tfPhoneNum.setFont(new Font("Lucida Console",Font.BOLD,40));
        tfPhoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
        tfPhoneNum.setEditable(false);

        lStatus = new JLabel("Ready");

        lBlank = new JLabel(" ");
        lBlank.setFont(buttonFont);

        bStar=new JButton("*");
        bStar.setFont(buttonFont);
        bStar.addActionListener(this);

        bPound=new JButton("#");
        bPound.setFont(buttonFont);
        bPound.addActionListener(this);


        b0=new JButton("0");
        b0.setFont(buttonFont);
        b0.addActionListener(this);

        bCall = new JButton("Dial");
        bCall.setFont(ctrlButtonFont);
        bCall.setHorizontalAlignment(SwingConstants.CENTER);
        bCall.addActionListener(this);


        bBack = new JButton("Back");
        bBack.setFont(ctrlButtonFont);
        bBack.setHorizontalAlignment(SwingConstants.CENTER);
        bBack.addActionListener(this);

//North panel, which divides phone name, dial area, and status bar
        n = new JPanel();
        n.setLayout(new GridLayout(4,1));

        n.add(lPhoneName);
        n.add(tfPhoneNum);
        n.add(lStatus);


//Center panel which has dial and call buttons
        c = new JPanel();
        c.setLayout(new BorderLayout());

        c.add("West",bCall);
        c.add("East",bBack);
        c.add("South",lBlank);

//South Panel for number from 1 to n
        s = new JPanel();
        s.setLayout(new GridLayout(4,3,20,10));
        for(int i =1; i<10;i++) {
            s.add(num[i]);
        }
        s.add(bStar);
        s.add(b0);
        s.add(bPound);


        add("North",n);
        add("Center",c);
        add("South",s);

        bCall.setEnabled(false);

        setVisible(true);











    }

    public void actionPerformed(ActionEvent e){

        for (int i =0; i<10; ++i){

         if (e.getSource()==num[i]){
           //add that digit to tdPhoneNum
           tfPhoneNum.setText(tfPhoneNum.getText()+i);
            }
            if (tfPhoneNum.getText().equals("")){
                bCall.setEnabled(true);
            }
        }//end for

        if (e.getSource()==bStar){
            tfPhoneNum.setText(tfPhoneNum.getText()+"*");
        }

        else if (e.getSource()==bPound){
            tfPhoneNum.setText(tfPhoneNum.getText()+"#");
        }

        else if (e.getSource()==b0){
            tfPhoneNum.setText(tfPhoneNum.getText()+"0");
        }

        else if (e.getSource()==bCall && bCall.getText().contains("Dial")){
            lStatus.setText("Dailing...");
            bCall.setText("End");
        }

        else if (e.getSource()==bCall && bCall.getText().contains("End")){
            lStatus.setText("Ready");
            bCall.setText("Dial");
            tfPhoneNum.setText((""));


        }





        else if(e.getSource()==bBack){

            String data = tfPhoneNum.getText();
            if (data.length()>0){
                data=data.substring(0,data.length()-1);
                tfPhoneNum.setText(data);



            }//end if
            if (data.equals("")){
                bCall.setEnabled(false);
            }
        }



    }//end if


    public static void main(String[] args) {
        new SuperPhone();
    }
}