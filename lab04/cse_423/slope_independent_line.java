package cse_423;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
//import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;


public class slope_independent_line implements GLEventListener{
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
          //getting the capabilities object of GL2 profile
             
       
	   	  slope_independent_line l = new slope_independent_line();
          //creating frame
          glcanvas.addGLEventListener(l);
          glcanvas.setSize(600, 400);
          
          final JFrame frame = new JFrame ("straight Line");
          //adding canvas to frame
          frame.getContentPane().add(glcanvas);
          frame.setSize(frame.getContentPane().getPreferredSize());
          frame.setVisible(true);
          
       }
   
   
   public void generate_coord(){
	   
   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
	   double x, y, x0, x1, y0, y1, dx, dy, temp, d_init, dNE, dE;
	   int zone;
	      //coordinate for line AB
	      x0 = 10;
	      x1 = 30;
	      y0 = 10;
	      y1 = 40;
	      dx = x1- x0;
		  dy = y1 - y0;
	      
	      zone = det_zone(x0, y0, x1, y1);
	      System.out.println("zone: " + zone);
	      if(zone == -1){
	    	  System.out.println("Belongs to no zone");
	    	  
	      }
	      
	      if(zone == 1 || zone == 2 || zone == 5 || zone == 6){
	    	  
	    	  //swapping x0 & y0
	    	  temp = x0;
	    	  x0 = y0;
	    	  y0 = temp;
	    	  
	    	  //swapping x1 & y1
	    	  temp = x1;
	    	  x1 = y1;
	    	  y1 = temp;
	    	  
	    	  System.out.println("Belongs to zone 1, 2, 5 or 6");
	      }else{
	    	  System.out.println("Doesn't belongs to zone 1, 2, 5 or 6");  
	      }
	      
	      d_init = (2*dy)-dx;
		  dE = 2*dy;
		  dNE = 2*(dy - dx);
		  x = x0;
		  y = y0;
		  System.out.println("Entering loop");
		  while(x < x1){
			  if(d_init < 0){
				  d_init += dE;
			  }else{
				  d_init += dNE;
				  y++;
			  }
			  x++;
			  
			  //convBack(x, y, zone);
			  System.out.println("x: "+x +" "+"y: "+y);
			  //convBack & draw
			  gl.glBegin (GL2.GL_POINTS);
			  if(zone == 0){
				  gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
				  gl.glVertex2d(x, y);
                  gl.glEnd();
			   }else if(zone == 1){
				   gl.glColor3f( 0.0f,1.0f,0.0f); //green
				   gl.glVertex2d(x, y);
				   gl.glEnd(); 
			   }else if(zone == 2){
				   gl.glColor3f( 0.0f,0.0f,1.0f ); //red
				   gl.glVertex2d(x, y);
	               gl.glEnd();
			   }else if(zone == 3){
				   gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
				   gl.glVertex2d(x, y);
	               gl.glEnd();
			   }else if(zone == 4){
				   gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
				   gl.glVertex2d(x, y);
	               gl.glEnd();
			   }else if(zone == 5){
				   gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
				   gl.glVertex2d(x, y);
	               gl.glEnd();
			   }else if(zone == 6){
				   gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
				   gl.glVertex2d(x, y);
	               gl.glEnd();
			   }else if(zone == 7){
				   gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red
				   gl.glVertex2d(x, y);
	               gl.glEnd();
			   }
		  }//end while

      //gl.glBegin (GL2.GL_POINTS);//static field
 
   }
   
   
   //Convert back to correct zones
   /*
   public void convBack(int x, int y, int get_zone){
	   if(get_zone == 0){
		   drawPixel(x, y);
	   }else if(get_zone == 1){
		   
	   }else if(get_zone == 2){
		   
	   }else if(get_zone == 3){
		   
	   }else if(get_zone == 4){
		   
	   }else if(get_zone == 5){
		   
	   }else if(get_zone == 6){
		   
	   }else if(get_zone == 7){
		   
	   }
   }
 
   
   
   //drawPixel
   public void drawPixel(int x, int y){
	   //gl.glBegin (GL2.GL_POINTS);
	   
   }
     */
   
   //zone determination
   public int det_zone(double x0, double y0, double x1, double y1){
	   double dx, dy;
	   dx = x1- x0;
	   dy = y1 - y0;
	   if(Math.abs(dx) > Math.abs(dy)){
	    	if(dx >= 0 && dy >= 0){
	    		return 0;
	    	}
	    	else if (dx >= 0 && dy < 0){
	    		return 7;
	    	}
	    	else if (dx < 0 && dy >= 0){
	    		return 3;
	    	}
	    	else if (dx < 0 && dy < 0){
	    		return 4;
	    	}
	    }else{
	    	if(dx >= 0 && dy >= 0){
	    		return 1;
	    	}
	    	else if (dx >= 0 && dy < 0){
	    		return 6;
	    	}
	    	else if (dx < 0 && dy >= 0){
	    		return 2;
	    	}
	    	else if (dx < 0 && dy < 0){
	    		return 5;
	    	}    	  
	      }
	   return -1;
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