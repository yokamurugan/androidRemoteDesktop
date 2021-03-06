/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcserver;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author welcome
 */
public class NewJFrame extends javax.swing.JFrame {
boolean server;
private SocketMainServer mServer; 

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() throws UnknownHostException, AWTException, IOException {
        initComponents();
        systeminfo();
       server=false;
       }
    
public void systeminfo() throws UnknownHostException{
                String SName=InetAddress.getLocalHost().getHostName();
		String IP=InetAddress.getLocalHost().getHostAddress();
                sname.setText("System Name:\t"+SName);
                sIP.setText("IP Address:\t"+IP);
}
public void savehistory(String name){
     try {  
                                            String getip=mServer.client.getInetAddress().toString();
                                            System.out.println("hello::::::::::::::::::::::::::"+getip);
					    Class.forName("com.mysql.jdbc.Driver");  
					    String connectionUrl = "jdbc:mysql://localhost:3306/androidrdp?user=root&password=5582758agoY.";  
					    Connection con = DriverManager.getConnection(connectionUrl);  
                                            Calendar c=Calendar.getInstance();
                                            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                                            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
                                            String cdate=df.format(c.getTime());
                                            String ctime=sdf.format(c.getTime());
					    PreparedStatement st=con.prepareStatement("insert into history values ('"+name+"','"+getip+"','"+cdate+"','"+ctime+"')");  
					    st.executeUpdate();  
					  //  JOptionPane.showMessageDialog(null, "Inserted");
					    }  
					    catch (SQLException s) {  
					    System.out.println("SQL Exception: "+ s.toString());  
					    }  
					    catch (ClassNotFoundException cE) {  
					    System.out.println("Class Not Found Exception: "+ cE.toString());  
					    }  
}
		
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sname = new javax.swing.JLabel();
        sIP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(35, 138, 50));

        jPanel1.setBackground(new java.awt.Color(21, 171, 112));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Android PC Server");

        sname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sname.setForeground(new java.awt.Color(255, 255, 0));
        sname.setText("jLabel2");

        sIP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sIP.setForeground(new java.awt.Color(255, 255, 0));
        sIP.setText("jLabel3");

        jButton1.setText("Start Server");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View History");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sIP)
                            .addComponent(sname)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel1))
                        .addGap(110, 110, 110))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(sname)
                .addGap(18, 18, 18)
                .addComponent(sIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        mServer = new SocketMainServer(new SocketMainServer.OnMessageReceived()
				{
					@Override
					// this method declared in the interface from DispatcherServer
					// class is implemented here
					// this method is actually a callback method, because it
					// will run every time when it will be called from
					// DispatcherServer class (at while)
					public void messageReceived(String message) 
					{
                                           
						System.out.println("Msg Recieved");
                                                if(message.contains("!!!")){
                                                    System.out.println("helloooo0oooooooooooooooooooooo"+message);
                                                    String[] name=message.split("!!!");
                                                    String dname=name[1];
                                                    savehistory(dname);
                                                }
                                                if(message.contains("???")){
                                                    try {
                                                        System.out.println("helloooo0oooooooooooooooooooooo"+message);
                                                        String[] name=message.split("???");
                                                        String dname=name[1];
                                                        new Filesharing(dname);
                                                    } catch (IOException ex) {
                                                        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                }
						if(message.contains("cz")){
							try {
								String[] parts=message.split("z");
								String[] pos=parts[1].split("-");
							    Robot robot = new Robot();
							    //robot.mouseMove(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
							    robot.mousePress(InputEvent.BUTTON1_MASK);
							    robot.mouseRelease(InputEvent.BUTTON1_MASK);
							} catch (AWTException ee) {
							}
						}
						if(message.contains("lcl")){
							try {
							    
							    Robot robot = new Robot();
							    robot.mousePress(InputEvent.BUTTON1_MASK);
							    robot.mouseRelease(InputEvent.BUTTON1_MASK);
							    System.out.println("Left Clicked");
							} catch (AWTException ee) {
							}
						}
						if(message.equals("rclick")){
							try {
							    
							    Robot robot = new Robot();
							    robot.mousePress(InputEvent.BUTTON3_MASK);
							    robot.mouseRelease(InputEvent.BUTTON3_MASK);
							    System.out.println("Right Clicked");
							} catch (AWTException ee) {
							}
						}
						if(message.equals("doubleclick")){
							try {
							    
							    Robot robot = new Robot();
							    robot.mousePress(InputEvent.BUTTON1_MASK);
							    robot.mouseRelease(InputEvent.BUTTON1_MASK);
							    robot.mousePress(InputEvent.BUTTON1_MASK);
							    robot.mouseRelease(InputEvent.BUTTON1_MASK);
							    System.out.println("Right Clicked");
							} catch (AWTException ee) {
							}
						}
					    if(message.equals("shutdown")){
							String shutdownCmd = "shutdown -s";
							try {
								Process child = Runtime.getRuntime().exec(shutdownCmd);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(message.equals("restart")){
							String shutdownCmd = "shutdown -r";
							try {
								Process child = Runtime.getRuntime().exec(shutdownCmd);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(message.equals("logoff")){
							String shutdownCmd = "shutdown -l";
							try {
								Process child = Runtime.getRuntime().exec(shutdownCmd);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(message.contains("#")){
							String[] parts=message.split("#");
							float Xs=Float.parseFloat(parts[0]);
							float Ys=Float.parseFloat(parts[1]);
							Toolkit toolkit=Toolkit.getDefaultToolkit();
							int w=toolkit.getScreenSize().width;
							
							int h=toolkit.getScreenSize().height;
							System.out.println(w+""+h);
							float x=Xs*(1.072213500784929f);
							float y=Ys*(1.068150208623088f);
							
							try {
								 System.out.println(Xs+"#"+Ys);
							    Robot robot = new Robot();
							    robot.mouseMove((int)x,(int)y);
							    System.out.println(x+"#"+y);
							} catch (AWTException ee) {
							}
						}
						if(message.contains("j")){
							String[] value=message.split("j");
						if(Integer.parseInt(value[1])>=0&&Integer.parseInt(value[1])<=255&&Integer.parseInt(value[1])!=34){
							Robot robot;
							try {
								robot = new Robot();
							
							 int ch=Integer.parseInt(value[1]);
							
							
					         switch (ch) {
					         case 97: robot.keyPress(KeyEvent.VK_A);robot.keyRelease(KeyEvent.VK_A); break;
					         case 98: robot.keyPress(KeyEvent.VK_B);robot.keyRelease(KeyEvent.VK_B); break;
					         case 99: robot.keyPress(KeyEvent.VK_C);robot.keyRelease(KeyEvent.VK_C); break;
					         case 100: robot.keyPress(KeyEvent.VK_D);robot.keyRelease(KeyEvent.VK_D); break;
					         case 101: robot.keyPress(KeyEvent.VK_E);robot.keyRelease(KeyEvent.VK_E); break;
					         case 102: robot.keyPress(KeyEvent.VK_F);robot.keyRelease(KeyEvent.VK_F); break;
					         case 103: robot.keyPress(KeyEvent.VK_G);robot.keyRelease(KeyEvent.VK_G); break;
					         case 104: robot.keyPress(KeyEvent.VK_H);robot.keyRelease(KeyEvent.VK_H); break;
					         case 105: robot.keyPress(KeyEvent.VK_I);robot.keyRelease(KeyEvent.VK_I); break;
					         case 106: robot.keyPress(KeyEvent.VK_J);robot.keyRelease(KeyEvent.VK_J); break;
					         case 107: robot.keyPress(KeyEvent.VK_K);robot.keyRelease(KeyEvent.VK_K); break;
					         case 108: robot.keyPress(KeyEvent.VK_L);robot.keyRelease(KeyEvent.VK_L); break;
					         case 109: robot.keyPress(KeyEvent.VK_M);robot.keyRelease(KeyEvent.VK_M); break;
					         case 110: robot.keyPress(KeyEvent.VK_N);robot.keyRelease(KeyEvent.VK_N); break;
					         case 111: robot.keyPress(KeyEvent.VK_O);robot.keyRelease(KeyEvent.VK_O); break;
					         case 112: robot.keyPress(KeyEvent.VK_P);robot.keyRelease(KeyEvent.VK_P); break;
					         case 113: robot.keyPress(KeyEvent.VK_Q);robot.keyRelease(KeyEvent.VK_Q); break;
					         case 114: robot.keyPress(KeyEvent.VK_R);robot.keyRelease(KeyEvent.VK_R); break;
					         case 115: robot.keyPress(KeyEvent.VK_S);robot.keyRelease(KeyEvent.VK_S); break;
					         case 116: robot.keyPress(KeyEvent.VK_T);robot.keyRelease(KeyEvent.VK_T); break;
					         case 117: robot.keyPress(KeyEvent.VK_U);robot.keyRelease(KeyEvent.VK_U); break;
					         case 118: robot.keyPress(KeyEvent.VK_V);robot.keyRelease(KeyEvent.VK_V); break;
					         case 119: robot.keyPress(KeyEvent.VK_W);robot.keyRelease(KeyEvent.VK_W); break;
					         case 120: robot.keyPress(KeyEvent.VK_X);robot.keyRelease(KeyEvent.VK_X); break;
					         case 121: robot.keyPress(KeyEvent.VK_Y);robot.keyRelease(KeyEvent.VK_Y); break;
					         case 122: robot.keyPress(KeyEvent.VK_Z);robot.keyRelease(KeyEvent.VK_Z); break;
					         case 65: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_A);robot.keyRelease(KeyEvent.VK_A);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 66: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_B);robot.keyRelease(KeyEvent.VK_B);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 67: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_C);robot.keyRelease(KeyEvent.VK_C);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 68: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_D);robot.keyRelease(KeyEvent.VK_D);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 69: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_E);robot.keyRelease(KeyEvent.VK_E);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 70: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_F);robot.keyRelease(KeyEvent.VK_F);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 71: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_G);robot.keyRelease(KeyEvent.VK_G);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 72: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_H);robot.keyRelease(KeyEvent.VK_H);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 73: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_I);robot.keyRelease(KeyEvent.VK_I);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 74: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_J);robot.keyRelease(KeyEvent.VK_J);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 75: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_K);robot.keyRelease(KeyEvent.VK_K);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 76: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_L);robot.keyRelease(KeyEvent.VK_L);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 77: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_M);robot.keyRelease(KeyEvent.VK_M);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 78: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_N);robot.keyRelease(KeyEvent.VK_N);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 79: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_O);robot.keyRelease(KeyEvent.VK_O);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 80: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_P);robot.keyRelease(KeyEvent.VK_P);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 81: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_Q);robot.keyRelease(KeyEvent.VK_Q);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 82: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_R);robot.keyRelease(KeyEvent.VK_R);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 83: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_S);robot.keyRelease(KeyEvent.VK_S);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 84: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_T);robot.keyRelease(KeyEvent.VK_T);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 85: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_U);robot.keyRelease(KeyEvent.VK_U);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 86: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_V);robot.keyRelease(KeyEvent.VK_V);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 87: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_W);robot.keyRelease(KeyEvent.VK_W);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 88: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_X);robot.keyRelease(KeyEvent.VK_X);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 89: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_Y);robot.keyRelease(KeyEvent.VK_Y);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 90: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_Z);robot.keyRelease(KeyEvent.VK_Z);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 96: robot.keyPress(KeyEvent.VK_BACK_QUOTE);robot.keyRelease(KeyEvent.VK_BACK_QUOTE); break;
					         case 48: robot.keyPress(KeyEvent.VK_0);robot.keyRelease(KeyEvent.VK_0); break;
					         case 49: robot.keyPress(KeyEvent.VK_1);robot.keyRelease(KeyEvent.VK_1); break;
					         case 50: robot.keyPress(KeyEvent.VK_2);robot.keyRelease(KeyEvent.VK_2); break;
					         case 51: robot.keyPress(KeyEvent.VK_3);robot.keyRelease(KeyEvent.VK_3); break;
					         case 52: robot.keyPress(KeyEvent.VK_4);robot.keyRelease(KeyEvent.VK_4); break;
					         case 53: robot.keyPress(KeyEvent.VK_5);robot.keyRelease(KeyEvent.VK_5); break;
					         case 54: robot.keyPress(KeyEvent.VK_6);robot.keyRelease(KeyEvent.VK_6); break;
					         case 55: robot.keyPress(KeyEvent.VK_7);robot.keyRelease(KeyEvent.VK_7); break;
					         case 56: robot.keyPress(KeyEvent.VK_8);robot.keyRelease(KeyEvent.VK_8); break;
					         case 57: robot.keyPress(KeyEvent.VK_9);robot.keyRelease(KeyEvent.VK_9); break;
					         case 45: robot.keyPress(KeyEvent.VK_MINUS);robot.keyRelease(KeyEvent.VK_MINUS); break;
					         case 61: robot.keyPress(KeyEvent.VK_EQUALS);robot.keyRelease(KeyEvent.VK_EQUALS); break;
					         case 126: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_BACK_QUOTE);robot.keyRelease(KeyEvent.VK_BACK_QUOTE);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 33: robot.keyPress(KeyEvent.VK_EXCLAMATION_MARK);robot.keyRelease(KeyEvent.VK_EXCLAMATION_MARK); break;
					         case 64: robot.keyPress(KeyEvent.VK_AT);robot.keyRelease(KeyEvent.VK_AT); break;
					         case 35: robot.keyPress(KeyEvent.VK_NUMBER_SIGN);robot.keyRelease(KeyEvent.VK_NUMBER_SIGN); break;
					         case 36: robot.keyPress(KeyEvent.VK_DOLLAR);robot.keyRelease(KeyEvent.VK_DOLLAR); break;
					         case 37: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyRelease(KeyEvent.VK_5);robot.keyRelease(KeyEvent.VK_5);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 94: robot.keyPress(KeyEvent.VK_CIRCUMFLEX);robot.keyRelease(KeyEvent.VK_CIRCUMFLEX); break;
					         case 38: robot.keyPress(KeyEvent.VK_AMPERSAND);robot.keyRelease(KeyEvent.VK_AMPERSAND); break;
					         case 42: robot.keyPress(KeyEvent.VK_ASTERISK);robot.keyRelease(KeyEvent.VK_ASTERISK); break;
					         case 40: robot.keyPress(KeyEvent.VK_LEFT_PARENTHESIS);robot.keyRelease(KeyEvent.VK_LEFT_PARENTHESIS); break;
					         case 41: robot.keyPress(KeyEvent.VK_RIGHT_PARENTHESIS);robot.keyRelease(KeyEvent.VK_RIGHT_PARENTHESIS); break;
					         case 95: robot.keyPress(KeyEvent.VK_UNDERSCORE);robot.keyRelease(KeyEvent.VK_UNDERSCORE); break;
					         case 43: robot.keyPress(KeyEvent.VK_PLUS);robot.keyRelease(KeyEvent.VK_PLUS); break;
					         case 9: robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB); break;
					         case 10: robot.keyPress(KeyEvent.VK_ENTER);robot.keyRelease(KeyEvent.VK_ENTER); break;
					         case 91: robot.keyPress(KeyEvent.VK_OPEN_BRACKET);robot.keyRelease(KeyEvent.VK_OPEN_BRACKET); break;
					         case 93: robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET); break;
					         case 92: robot.keyPress(KeyEvent.VK_BACK_SLASH);robot.keyRelease(KeyEvent.VK_BACK_SLASH); break;
					         case 123: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_OPEN_BRACKET);robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 125: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 124: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_BACK_SLASH);robot.keyRelease(KeyEvent.VK_BACK_SLASH);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 59: robot.keyPress(KeyEvent.VK_SEMICOLON);robot.keyRelease(KeyEvent.VK_SEMICOLON); break;
					         case 58: robot.keyPress(KeyEvent.VK_COLON);robot.keyRelease(KeyEvent.VK_COLON); break;
					         case 39: robot.keyPress(KeyEvent.VK_QUOTE);robot.keyRelease(KeyEvent.VK_QUOTE); break;
					         case 34: robot.keyPress(KeyEvent.VK_QUOTEDBL);robot.keyRelease(KeyEvent.VK_QUOTEDBL); break;
					         case 44: robot.keyPress(KeyEvent.VK_COMMA);robot.keyRelease(KeyEvent.VK_COMMA); break;
					         case 60: robot.keyPress(KeyEvent.VK_LESS);robot.keyRelease(KeyEvent.VK_LESS); break;
					         case 46: robot.keyPress(KeyEvent.VK_PERIOD);robot.keyRelease(KeyEvent.VK_PERIOD); break;
					         case 62: robot.keyPress(KeyEvent.VK_GREATER);robot.keyRelease(KeyEvent.VK_GREATER); break;
					         case 47: robot.keyPress(KeyEvent.VK_SLASH);robot.keyRelease(KeyEvent.VK_SLASH); break;
					         case 63: robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_SLASH);robot.keyRelease(KeyEvent.VK_SLASH);robot.keyRelease(KeyEvent.VK_SHIFT); break;
					         case 8: robot.keyPress(KeyEvent.VK_SPACE);robot.keyRelease(KeyEvent.VK_A); break;
					         default:
					           
					         }
							} catch (AWTException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						}
						}
					}
				});
				mServer.start();
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        // TODO add your handling code here:
        Imageserver imageserver = new Imageserver();
        imageserver.Image();
    } catch (IOException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    } catch (AWTException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InterruptedException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        History h=new History();
        h.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (        AWTException | IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel sIP;
    private javax.swing.JLabel sname;
    // End of variables declaration//GEN-END:variables
}
