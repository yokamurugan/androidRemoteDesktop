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
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author welcome
 */
public class Filesharing {
    public Filesharing(String path) throws IOException{
     
         
            File transferFile = new File (path);
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
