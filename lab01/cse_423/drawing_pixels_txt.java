package cse_423;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
//import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class drawing_pixels_txt implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	   
	      drawing_pixels_txt l = new drawing_pixels_txt();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
      float x = 0;
      float y = 0;
      
      try{
    	  File f = new File("src/file/co-ordinates.txt");
    	  
    	  BufferedReader br = new BufferedReader(new FileReader(f));
    	  
    	  String readLine = "";
    	  
    	  //System.out.println("Reading file using Buffered Reader");
    	  
    	  gl.glBegin (GL2.GL_POINTS);
    	  while((readLine = br.readLine()) != null){
    		  x = Float.parseFloat(readLine);
    		  y = Float.parseFloat(br.readLine());
    		  gl.glVertex2d(x, y);
    		  System.out.println("x: " + x + " " + "y: " + y);    		  
    	  }
    	  gl.glEnd();
    	  br.close();
      }catch(IOException e){
    	  e.printStackTrace();
      }    
      
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;
