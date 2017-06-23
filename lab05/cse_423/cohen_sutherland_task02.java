package cse_423;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

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
          glcanvas.setSize(600, 400);
          
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
      gl.glColor3f( 1.0f,0.0f,0.0f); //white
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