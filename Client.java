package chatting.application;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.net.ServerSocket;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
  //  static JFrame f1 = new JFrame();
   Client(){
   // f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0, 0, 450, 70);
        
        add(p1);
       
        ImageIcon I1= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
        Image I2=I1.getImage().getScaledInstance(15, 30, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel l1= new JLabel(I3);
        l1.setBounds(5,17,30,30);
        p1.add(l1);

        l1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });

        ImageIcon I4= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/2.png"));
        Image I5=I4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon I6=new ImageIcon(I5);
        JLabel l2= new JLabel(I6);
        l2.setBounds(40,5,60,60);
        p1.add(l2);

        ImageIcon I7= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
        Image I8=I7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon I9=new ImageIcon(I8);
        JLabel l5= new JLabel(I9);
        l5.setBounds(290,20,30,30);
        p1.add(l5);

        ImageIcon I11= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
        Image I12=I11.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon I13=new ImageIcon(I12);
        JLabel l6= new JLabel(I13);
        l6.setBounds(350,20,30,30);
        p1.add(l6);

        ImageIcon I14= new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
        Image I15=I14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
        ImageIcon I16=new ImageIcon(I15);
        JLabel l7= new JLabel(I16);
        l7.setBounds(410,20,25,30);
        p1.add(l7);

        JLabel l3=new JLabel("Asha");
        l3.setBounds(110, 15, 100, 18);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        l3.setForeground(Color.WHITE);
        p1.add(l3);

        JLabel l4=new JLabel("Active now");
        l4.setBounds(110, 35, 100, 20);
        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        l4.setForeground(Color.WHITE);
        p1.add(l4);

        a1= new JTextArea();
        a1.setBounds(5, 75, 440, 474);
        //a1.setBackground(Color.BLUE);
        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);

        t1=new JTextField();
        t1.setBounds(5, 555, 340, 30);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);
      
        b1= new JButton("Send");
        b1.setBounds(350, 555, 93, 30);
        b1.setBackground(new Color(7, 94, 84));
       b1.setForeground(Color.WHITE);
       b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
       b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(450,600);
        setLocation(800, 120);
       
        setUndecorated(true);
        setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
        try{
            String out = t1.getText();
            a1.setText(a1.getText()+"\n\t\t"+out);
            dout.writeUTF(out);
            t1.setText(" ");
        }catch(Exception e){}
            

   }
   public static void main(String[] args)
   {
       new Client().setVisible(true);
       String msginput="";
       try{
            s=new Socket("127.0.0.1",6001);
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            while(true){
            msginput= din.readUTF();
            a1.setText(a1.getText()+"\n"+msginput);
            }
       }catch(Exception e){}
   }
}