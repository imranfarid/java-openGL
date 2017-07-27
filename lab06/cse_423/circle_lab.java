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


public class circle_lab implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	   
		  circle_lab l = new circle_lab();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 600);
	      
	      final JFrame frame = new JFrame ("Circle");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
   }
   
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();      
      int xc, yc, x, y, d_in, R, zero;
      double x_conv , y_conv;
      
   	  gl.glBegin (GL2.GL_POINTS);//static field
   	  

   	  xc = 0;
   	  yc = 0;
	  R = 600;
	  System.out.println("xc: " + xc + " " + "yc: " + yc + " R: " + R);
       	  
      zero = 0;
      x = 0;
      y = R;

      //d_in = 5-(4*R);
      d_in = 1 - R;
      
      while(x < y){
    	  System.out.println("x: " + x + " y: " + y + " dinit: " + d_in);
    	  System.out.println("------------------------------------------");
	    	if(d_in < zero){
	    		System.out.println("d less than 0");
	    		d_in = d_in + ((8*x)+3);
	    		x++;
	    	}else if(d_in > zero){
	    		System.out.println("d more than 0");
	    		d_in = d_in + ((8*x)-(8*y)+20);
	    		x++;
	    		y--;
	    	}
	    	
	    	System.out.println(x +" "+y);
	    	x_conv = x*0.001;
	    	y_conv = y*0.001;
	    	System.out.println( x_conv +" "+ y_conv);
	    	
	    	
	    	
	    	gl.glVertex2d(x_conv, y_conv);
	    	gl.glVertex2d(-x_conv, y_conv);
	    	gl.glVertex2d(x_conv, -y_conv);
	    	gl.glVertex2d(-x_conv, -y_conv);
	    	gl.glVertex2d(y_conv, x_conv);
	    	gl.glVertex2d(-y_conv, x_conv);
	    	gl.glVertex2d(y_conv, -x_conv);
	    	gl.glVertex2d(-y_conv, -x_conv);
	    }
      
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
