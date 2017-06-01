package cse_423;

//import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
//import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;
 
 
public class scan_conversion_line implements GLEventListener{
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
          //getting the capabilities object of GL2 profile
             
       
       scan_conversion_line l = new scan_conversion_line();
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
      
      //Random rand = new Random();
      //int rangeMin = -1;
      //int rangeMax = 1;
      float m, dy, dx, d, x0, x1, y0, y1, x, y;
      //int x0, x1, y0, y1, x, y;
 
             //gl.glBegin (GL2.GL_POINTS);//static field
             for(int i = 0; i < 1; i++){
                 //random float between -1 & 1
                 /*
                 float x1 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
                 float y1 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
                 float x2 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
                 float y2 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
                 */
                 x0 = 4;
                 x1 = 9;
                 y0 = 8;
                 y1 = 12;
                 dy = (float)(y1-y0);
                 dx = (float)(x1-x0);
                 m = (float)(dy/dx); //slope
                 
                 System.out.println("dy: " + dy + " " + " dx: " + dx + " " + "m: " + m);
                 gl.glBegin (GL2.GL_POINTS);
                 
                 if(Math.abs(m) < 1){
                     d = dy-(dx/2);
                     System.out.println(d);
                     x = x0;
                     y = y0;
                    
                     gl.glVertex2d(x, y);
                     gl.glEnd();
                    
                     while(x < x1){
                         x = x + 1;
                         if(d < 0){
                             d = d + dy;
                         }else{
                             d = d + (dy-dx);
                             y = y + 1;
                         }
                         System.out.println("x: " + x + " " + " y: " + y);
                         gl.glVertex2d(x, y);
                         gl.glEnd();
                     }
                 }else if(Math.abs(m) > 1){
                     d = dy-(dx/2);
                     System.out.println(d);
                     x = x0;
                     y = y0;
                    
                     gl.glVertex2d(x, y);
                     gl.glEnd();
                    
                     while(y < y1){
                         y = y + 1;
                         if(d < 0){
                             d = d + dx;
                         }else{
                             d = d + (dx-dy);
                             x = x + 1;
                         }
                        System.out.println("x: " + x + " " + " y: " + y);
                         gl.glVertex2d(x, y);
                         gl.glEnd();
                     }
                 }
                 
                 
                 /*
                 if(x1 > x2){
                     System.out.println("x1 is greater");
                 }else{
                     System.out.println("x2 is greater");
                 }
               
                 
                 
                 if(x1 > x2){
                       float temp = x1;
                       x1 = x2;
                       x2 = temp;
                       //temp = 0.0;
                       temp = y1;
                       y1 = y2;
                       y2 = temp;
                       
                       //calculate slope
                       m = ((y2-y1)/(x2-x1));
                       System.out.println("x1 is greater " + m);
                   }else{
                      //m = (y2-y1)/(x2-x1);
                       m = ((y2-y1)/(x2-x1));
                       System.out.println("x2 is greater " + m);
                   }
                   System.out.println("end of for");
                   
                   if(m > -1 && m < 1){
                      //x_init = x1;
                       while(x1 < x2){
                           
                           x_next = (float) (x1 + (1* 0.0001)) ;
                           y_next = (float) (y1 + (m * 0.0001)) ;
                           System.out.println("loop1 m: " + m + " " + "x: " + x_next + " " + "y: " + y_next);
                          gl.glBegin (GL2.GL_POINTS);
                          gl.glVertex2d(x_next, y_next);
                          gl.glEnd();
                          x1 = x_next;
                          y1 = y_next;
                          
                       }
                   }else{
                      //x_init = x1;
                      while(y1 < y2){
                          
                          x_next = (float) (x1 + ((1/m) * 0.0001));
                          y_next = (float) (y1 + (1 * 0.0001)) ;
                          System.out.println("loop2 m: " + m + " " + "x: " + x_next + " " + "y: " + y_next);
                          gl.glBegin (GL2.GL_POINTS);
                         gl.glVertex2d(x_next, y_next);
                         gl.glEnd();
                         x1 = x_next;
                         y1 = y_next;
                         
                      }
                   }
                   */
               
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
