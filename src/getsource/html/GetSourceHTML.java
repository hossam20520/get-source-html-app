/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getsource.html;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hossam
 */
public class GetSourceHTML extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    String s;
     PrintWriter writer;
    JScrollPane scroll;
    FileWriter out;
    JFrame frame;
    JButton btn , btn2;
    JTextField txtf , txtf2;
    JTextArea txta;
    JLabel label;
     ImageIcon ico;
    GetSourceHTML(){
        
        frame = new JFrame();
        
        frame.setSize(1020,700);
        label = new JLabel("Enter URL");
        label.setSize(100,100);
        label.setBounds(40, 30, 100, 100);
         frame.add(label);
         txtf = new JTextField();
         txtf.setSize(100,30);
         txtf.setBounds(100, 72, 200, 20);
       
         btn = new JButton("Get");
         btn.setSize(100, 30);
         btn.setBounds(150, 100, 100, 30);
         frame.add(btn);
        
         txta = new JTextArea();
          txta.setSize(200, 200);
          txta.setBounds(5, 200, 400, 300);
         
          txta.setBackground(Color.WHITE);
         
        scroll = new JScrollPane(txta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setSize(400, 400);
        scroll.setBounds(5, 220, 1000, 400);
        frame.add(scroll);
//        frame.add(txta);
       frame.add(txtf);
        btn.addActionListener(this);
        frame.setResizable(false);
        frame.setLocation(100, 100);
        frame.setTitle("View HTML");
       
        ico = new ImageIcon("research.png");
        frame.setIconImage(ico.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       new  GetSourceHTML();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String str = txtf.getText();
       if(e.getSource() == btn){
           
       
        if(str == null){
            
        }else{
            try {
                URL url = new URL(str);
                URLConnection uco = url.openConnection();
                InputStream is = uco.getInputStream();
                StringBuilder sb = new  StringBuilder();
                int i;
                while((i =is.read()) != -1 ){
                    sb.append((char)i);
                    
                }
                
                s = sb.toString();
               txta.setText(s);
               txtf2.setVisible(true);
               btn2.setVisible(true);
              
            } catch (IOException ex) {
                Logger.getLogger(GetSourceHTML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       } 
       
//        String fileD ="F:\\hoshos\\gg\\hh.txt";
//                File f = new File(fileD);
//                f.mkdir();
//       if(e.getSource()== btn2){
//           
//            try {
//                writer = new PrintWriter("index.html", "UTF-8");
//                
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(GetSourceHTML.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (UnsupportedEncodingException ex) {
//                Logger.getLogger(GetSourceHTML.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//             writer.print(s);
////                writer.println("The second line");
//                 writer.close();
//               
//       }
    }
    
}
