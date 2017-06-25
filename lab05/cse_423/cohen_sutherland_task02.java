package cse_423;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import java.text.DecimalFormat;
import java.util.Random;

public class cohen_sutherland_task02 implements GLEventListener{
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
          //getting the capabilities object of GL2 profile
             
       
	   cohen_sutherland_task02 l = new cohen_sutherland_task02();
          //creating frame
          glcanvas.addGLEventListener(l);
          glcanvas.setSize(800, 600);
          
          final JFrame frame = new JFrame ("straight Line");
          //adding canvas to frame
          frame.getContentPane().add(glcanvas);
          frame.setSize(frame.getContentPane().getPreferredSize());
          frame.setVisible(true);
          
          
          
       }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      gl.glBegin (GL2.GL_LINES);
      
      //right
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f,1.0f,1.0f); //white
      gl.glVertex3f(0.5f, 1.0f, 0);
      gl.glVertex3f(0.5f, -1.0f, 0);
      gl.glEnd();
      
      //right window
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
      gl.glVertex3f(0.5f, 0.5f, 0);
      gl.glVertex3f(0.5f, -0.5f, 0);
      gl.glEnd();
      
      //left
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f,1.0f,1.0f); //white
      gl.glVertex3f(-0.5f, -1.0f, 0);
      gl.glVertex3f(-0.5f, 1.0f, 0);
      gl.glEnd();
      
      
      //left window
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
      gl.glVertex3f(-0.5f, -0.5f, 0);
      gl.glVertex3f(-0.5f, 0.5f, 0);
      gl.glEnd();
      
      //top 
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f,1.0f,1.0f); //white
      gl.glVertex3f(-1.0f, 0.5f, 0);
      gl.glVertex3f(1.0f, 0.5f, 0);
      gl.glEnd();
      
      //top window
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
      gl.glVertex3f(-0.5f, 0.5f, 0);
      gl.glVertex3f(0.5f, 0.5f, 0);
      gl.glEnd();
      
      //bottom 
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f,1.0f,1.0f); //white
      gl.glVertex3f(-1.0f, -0.5f, 0);
      gl.glVertex3f(1.0f, -0.5f, 0);
      gl.glEnd();
      
      //bottom window
      gl.glBegin (GL2.GL_LINES);
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
      gl.glVertex3f(-0.5f, -0.5f, 0);
      gl.glVertex3f(0.5f, -0.5f, 0);
      
      gl.glEnd();
      
      //calculation
      Random rand = new Random();
      int outCode1, outCode2, rangeMin, rangeMax, i;
      int TOP = 8, BOTTOM = 4, RIGHT = 2, LEFT = 1;
      float x1, y1, x2, y2;
      double x_min, y_min, x_max, y_max;
      DecimalFormat df = new DecimalFormat("#.##");
      x_min = -0.5;
      y_min = -0.5;
      x_max = 0.5;
      y_max = 0.5;
      rangeMin = -1;
      rangeMax = 1;
      i = 0;
      while (i < 1000){
	      x1 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
		  y1 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
		  x2 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
		  y2 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
		  
		  System.out.println("x1: " + df.format(x1) + " " + "y1: " + df.format(y1) );
		  System.out.println("x2: " + df.format(x2) + " " + "y2: " + df.format(y2) );
		  
		  outCode1 = computeOutCode(x1, y1, 0.5, 0.5, -0.5, -0.5);
		  outCode2 = computeOutCode(x2, y2, 0.5, 0.5, -0.5, -0.5);
		  
		  System.out.println("Region outcode1 is: " + outCode1);
		  System.out.println("Region outcode2 is: " + outCode2);
		  
		  boolean accept = true;
		  
	      while(accept){
	    	  if(outCode1 == 0 && outCode2 == 0){
				  /*
				  gl.glBegin (GL2.GL_LINES);
			      //gl.glColor3f( 0.0f, 1.0f, 0.0f ); //fully accept green
			      gl.glVertex3f(x1, y1, 0);
			      gl.glVertex3f(x2, -y2, 0);
			      gl.glEnd();
			      */
			      System.out.println("fully accept");
			      accept = false;
			      
			  }else if(!(outCode1 == 0 || outCode2 == 0)){
				  /*
				  gl.glBegin (GL2.GL_LINES);
			      gl.glColor3f( 1.0f, 0.0f, 0.0f ); //fully rejected red
			      gl.glVertex3f(x1, y1, 0);
			      gl.glVertex3f(x2, -y2, 0);
			      gl.glEnd();
			      */
			      System.out.println("fully rejected");
			      accept = false;
			      
			  }else{
				  
				  gl.glBegin (GL2.GL_LINES);
			      gl.glColor3f( 0.0f, 0.0f, 1.0f ); //partially accept red
			      gl.glVertex3f(x1, y1, 0);
			      gl.glVertex3f(x2, y2, 0);
			      gl.glEnd();
			      
			      
				  double x = 0, y = 0;
				  int code;
				  if(outCode1 != 0){
					  code = outCode1;
				  }else{
					  code = outCode2;
				  }
				  
				  if((code & TOP) != 0){
					  x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
					  y = y_max;
				  }else if((code & BOTTOM) != 0){
					  x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
					  y = y_min;
				  }else if((code & RIGHT) != 0){
					  y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
					  x = x_max;
				  }else if((code & LEFT) != 0){
					  y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
					  x = x_min;
				  }
				  
				  if(code == outCode1){
					  x1 = (float) x;
					  y1 = (float) y;
					  outCode1 = computeOutCode(x1, y1, 0.5, 0.5, -0.5, -0.5);
					  System.out.println("new x1: " + df.format(x1) + " " + "new y1: " + df.format(y1) );
				  }else{
					  x2 = (float) x;
					  y2 = (float) y; 
					  outCode2 = computeOutCode(x2, y2, 0.5, 0.5, -0.5, -0.5);
					  System.out.println("new outCode2: " + outCode2);
					  System.out.println("new x2: " + df.format(x2) + " " + "new y2: " + df.format(y2) );
				  }
				  
				  
				  
				  
			      
			      if(outCode1 == 0 && outCode2 == 0){
			    	  
			    	  gl.glBegin (GL2.GL_LINES);
				      gl.glColor3f( 0.0f, 1.0f, 0.0f ); //partially accept green
				      gl.glVertex3f(x1, y1, 0);
				      gl.glVertex3f(x2, y2, 0);
				      gl.glEnd();
				      System.out.println("partially accept");
				      
			    	  accept = false;
			      }
			  }
	    	  
	      }//while ends
		  
		  i++;
		  System.out.println("--------------------------------");
      }//while ends
	  
  
   }
   
   /*
   public void drawLine(double x1, double y1, double x2, double y2, int outCode1, int outCode2){
	   final GL2 gl = drawable.getGL().getGL2();
	   gl.glBegin (GL2.GL_LINES);
	   
   }
   */
   
   public static int computeOutCode(double x, double y, double x_max, double y_max, double x_min, double y_min){
	   int left, right, bottom, top, code;
	   left = 1; 
	   right = 2; 
	   bottom = 4;
	   top = 8;
	   code = 0;
	   if(x < x_min){
		   code += left;
	   }else if(x > x_max){
		   code += right;
	   }
	   if(y < y_min){
		   code += bottom;
	   }else if(y > y_max){
		   code += top;
	   }
	   return code;
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