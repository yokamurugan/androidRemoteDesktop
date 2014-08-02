package pcserver;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
public class Imageserver {
 
     public void Image() throws IOException, AWTException, InterruptedException {
    	 while(true){
    	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Rectangle screenRectangle = new Rectangle(screenSize);
         Robot robot = new Robot();
         BufferedImage image = robot.createScreenCapture(screenRectangle);
         ImageIO.write(image, "png", new File("D:/image.png"));
         File transferFile = new File ("D:/image.png");
            ServerSocket serverSocket = new ServerSocket(15123);
              Socket socket = serverSocket.accept();
              System.out.println("Accepted connection : " + socket);
            
              byte [] bytearray  = new byte [(int)transferFile.length()];
              FileInputStream fin = new FileInputStream(transferFile);
              BufferedInputStream bin = new BufferedInputStream(fin);
              bin.read(bytearray,0,bytearray.length);
              OutputStream os = socket.getOutputStream();
              System.out.println("Sending Files...");
              os.write(bytearray,0,bytearray.length);
              os.flush();
              socket.close();
              System.out.println("File transfer complete");
              
            }
    	
     }
}


