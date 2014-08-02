package pcserver;


import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SocketMainServer extends Thread
{
	private int SERVERPORT = 5677;
	private ServerSocket serverSocket;
	public Socket client = null;
	private boolean running = false;
	private PrintWriter mOut;
	private OnMessageReceived messageListener;
	
	
	public SocketMainServer(OnMessageReceived messageListener)
	{
		this.messageListener = messageListener;
	}

	@SuppressWarnings("resource")
	public void sendMessage(String message)
	{
		try
		{
			if (mOut != null && !mOut.checkError())
			{
				System.out.println(message);
				// Here you can connect with database or else you can do what you want with static message
				//mOut.println(message);
				//mOut.flush();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		         Rectangle screenRectangle = new Rectangle(screenSize);
		         Robot robot = new Robot();
		         BufferedImage image = robot.createScreenCapture(screenRectangle);
		         ImageIO.write(image, "png", new File("D:/image.png"));
		         File transferFile = new File ("D:/image.png");
		         System.out.println("Sending Files...");  
		            
		              byte [] bytearray  = new byte [(int)transferFile.length()];
		              FileInputStream fin = new FileInputStream(transferFile);
		              BufferedInputStream bin = new BufferedInputStream(fin);
		              bin.read(bytearray,0,bytearray.length);
		              OutputStream os = client.getOutputStream();
		              System.out.println("Sending Files...");
		              os.write(bytearray,0,bytearray.length);
		              os.flush();
			}
		}
		catch (Exception e)
		{
		}
	}

public void savehistory(){
     try {  
                                            String getip=client.getInetAddress().toString();
                                            System.out.println("hello::::::::::::::::::::::::::"+getip);
					    Class.forName("com.mysql.jdbc.Driver");  
					    String connectionUrl = "jdbc:mysql://localhost:3306/androidrdp?user=root&password=5582758agoY.";  
					    Connection con = DriverManager.getConnection(connectionUrl);  
                                            Calendar c=Calendar.getInstance();
                                            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                                            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
                                            String cdate=df.format(c.getTime());
                                            String ctime=sdf.format(c.getTime());
					    PreparedStatement st=con.prepareStatement("insert into history values ('hi','"+getip+"','"+cdate+"','"+ctime+"')");  
					    st.executeUpdate();  
					    JOptionPane.showMessageDialog(null, "Inserted");
					           }  
					    catch (SQLException s) {  
					    System.out.println("SQL Exception: "+ s.toString());  
					    }  
					    catch (ClassNotFoundException cE) {  
					    System.out.println("Class Not Found Exception: "+ cE.toString());  
					    }  
}
	@Override
	public void run()
	{
		super.run();
		running = true;
		try
		{
			System.out.println("PA: Connecting...");

			// create a server socket. A server socket waits for requests to
			// come in over the network.
			serverSocket = new ServerSocket(SERVERPORT);

			// create client socket... the method accept() listens for a
			// connection to be made to this socket and accepts it.
			try
			{
				client = serverSocket.accept();
				System.out.println("S: Receiving...");
                                //savehistory();
				// sends the message to the client
				mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
				System.out.println("PA: Sent");
				System.out.println("PA: Connecting Done.");
				// read the message received from client
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				sendMessage("Server connected with Android Client now you can chat with socket server.");
				
				// in this while we wait to receive messages from client (it's an infinite loop)
				// this while it's like a listener for messages
				while (running)
				{
					String message = in.readLine();
					if (message != null && messageListener != null)
					{
						// call the method messageReceived from ServerBoard class
						messageListener.messageReceived(message);
					}
				}
			}
			catch (Exception e)
			{
				System.out.println("PA: Error: "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				client.close();
				System.out.println("PA: Done.");
			}
		}
		catch (Exception e)
		{
			System.out.println("PA: Error");
			e.printStackTrace();
		}

	}

	
	public interface OnMessageReceived
	{
		public void messageReceived(String message);
	}

}
