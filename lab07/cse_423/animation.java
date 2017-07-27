package cse_423;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

public class animation implements GLEventListener{
	
	private int degree = 45;
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    public static Animator animator;
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	   
	   animation l = new animation();
      
      GLProfile glp = GLProfile.getDefault();
      
      GLCapabilities caps = new GLCapabilities(glp);
              
      caps.setDoubleBuffered(true);
              
      GLCanvas canvas = new GLCanvas(caps);
              
      canvas.addGLEventListener(l);
              
      JFrame frame = new JFrame("Animating cube");
              
      frame.setSize(600, 600);
              
      frame.add(canvas);
              
      frame.setVisible(true);
            
              
      canvas.addGLEventListener(new animation());
              
      animator = new Animator(canvas);
              
      animator.start();
	      
   }
   
   public void display(GLAutoDrawable drawable) {
      //final GL2 gl = drawable.getGL().getGL2();
	   
	   GL2 gl = drawable.getGL().getGL2();
      
      float x21, x22, x23, x24, y21, y22, y23, y24, d;
      float xp22, xp23, xp24, yp22, yp23, yp24;
      
      //length & width
      d = 0.4f;
      
      //coordinates of square
      x21 = 0;
      y21 = 0;
      x22 = x21+d;
      y22 = y21;
      x23 = x21+d;
      y23 = y21+d;
      x24 = x21;
      y24 = y21+d;
      
      System.out.println(" x22: " + x22 + " x23: " + x23 + " x24: " + x24);
      System.out.println(" y22: " + y22 + " y23: " + y23 + " y24: " + y24);
      
	  	
	  	//cube rotation
	  	degree += 1;
	  	
	  	System.out.println("degree: "+ degree);
	  	
	  	xp22 = (float) ((x22*Math.cos(Math.toRadians(degree))) - (y22*Math.sin(Math.toRadians(degree))));
	  	yp22 = (float) ((x22*Math.sin(Math.toRadians(degree))) + (y22*Math.cos(Math.toRadians(degree))));
	  	
	  	xp23 = (float) (x23*Math.cos(Math.toRadians(degree)) - y23*Math.sin(Math.toRadians(degree)));
	  	yp23 = (float) (x23*Math.sin(Math.toRadians(degree)) + y23*Math.cos(Math.toRadians(degree)));
	  	
	  	xp24 = (float) (x24*Math.cos(Math.toRadians(degree)) - y24*Math.sin(Math.toRadians(degree)));
	  	yp24 = (float) (x24*Math.sin(Math.toRadians(degree)) + y24*Math.cos(Math.toRadians(degree)));
	  	
	  	System.out.println("-----------------------------------------------------");
	  	System.out.println(" xp22: " + xp22 + " xp23: " + xp23 + " xp24: " + xp24);
	  	System.out.println(" yp22: " + yp22 + " yp23: " + yp23 + " yp24: " + yp24);
	  	
	  	gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
	  	
	  	gl.glBegin (GL2.GL_LINES);
	  	gl.glColor3f( 1.0f,0.0f,1.0f); //red
	    
	  	
	  	gl.glVertex3f(x21+0.2f, y21+0.2f, 0);
   	  	gl.glVertex3f(xp22+0.2f, yp22+0.2f, 0);
   	  	
   	  	//top rotation
   	  	gl.glVertex3f(xp23+0.2f, yp23+0.2f, 0);
	  	gl.glVertex3f(xp24+0.2f, yp24+0.2f, 0);
	  	
	  	//right rotation
	  	gl.glVertex3f(xp22+0.2f, yp22+0.2f, 0);
	  	gl.glVertex3f(xp23+0.2f, yp23+0.2f, 0);
	  	
	  	//left rotation
	  	gl.glVertex3f(x21+0.2f, y21+0.2f, 0);
	  	gl.glVertex3f(xp24+0.2f, yp24+0.2f, 0);
	  	
	  	
	  	//Seconds Square
	  	
	  	//bottom rotation
   	  	gl.glVertex3f(x21, y21, 0);
   	  	gl.glVertex3f(xp22, yp22, 0);
   	  	
   	  	//top rotation
   	  	gl.glVertex3f(xp23, yp23, 0);
	  	gl.glVertex3f(xp24, yp24, 0);
	  	
	  	//right rotation
	  	gl.glVertex3f(xp22, yp22, 0);
	  	gl.glVertex3f(xp23, yp23, 0);
	  	
	  	//left rotation
	  	gl.glVertex3f(x21, y21, 0);
	  	gl.glVertex3f(xp24, yp24, 0);
	  	
	  	//connecting lines
	  	
	  	//left bottom
	  	gl.glVertex3f(x21+0.2f, y21+0.2f, 0);
	  	gl.glVertex3f(x21, y21, 0);
	  	
	  	
	  	//right bottom
   	  	gl.glVertex3f(xp22, yp22, 0);
   	  	gl.glVertex3f(xp22+0.2f, yp22+0.2f, 0);
   	  	
   	  	
   	  	//right top
   	  	gl.glVertex3f(xp23, yp23, 0);
	  	gl.glVertex3f(xp23+0.2f, yp23+0.2f, 0);
	  	
	  	//left top
	  	gl.glVertex3f(xp24, yp24, 0);
	  	gl.glVertex3f(xp24+0.2f, yp24+0.2f, 0);
	  	
	  	
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
