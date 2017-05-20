package cse_423;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
//import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.util.Random;


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
      
      Random rand = new Random();
      int rangeMin = -1;
      int rangeMax = 1;
       	  gl.glBegin (GL2.GL_POINTS);//static field
       	  for(int i = 0; i < 100; i++){
       		  float x = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
       		  float y = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
       		  System.out.println("x: " + x + " " + "y: " + y);
       		  gl.glVertex2d(x, y);
       	  }
//          gl.glVertex2d(0.5f,0.5f);
//          gl.glVertex2d(0.5f,-0.5f);
//          gl.glVertex2d(-0.5f,0.5f);
//          gl.glVertex2d(-0.5f,-0.5f);
          gl.glEnd();
          
      
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
