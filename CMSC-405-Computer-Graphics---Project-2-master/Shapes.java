
/**
 * CMSC 405 7980
 * Project 2: JOGL OpenGL 
 * Anthony Borza
 * April 9, 2017
 * Eclipse under Windows 10
 * 
 * Shapes.java: this class is used for defining the 3D shapes specifications, 
 * and the placement of them. A house, door, 2 windows, grass, a sun, and car, 
 * are drawn using libraries offered by OpenGL.
 */

// imports used

import com.jogamp.opengl.GL2;

public class Shapes extends Project2
{
    /**
	 * house method: uses the methods offered by OpenGL "JOGL" to draw
	 * a house that uses methods from glut to help draw the house. The house
	 * consist of the following:
	 * Grass that is around the house 
	 * A solid cube, which is from the glut library, and represents the bottom of the house
	 * A solid cone, which is from the glut library, and represents the roof of the house
	 * A solid cube, which is from the glut library, and represents the chimney on the house
	 * A sun, which calls the sun method, and draw a sun above the house
	 * @param gl
	 */
    
	public static void house(GL2 gl) 
	{
		gl.glBegin(GL2.GL_MODELVIEW);
		gl.glTranslatef(-.5f,0.0f,-6.0f);  	// transformation 1 for Translate
		gl.glPushMatrix();					// sets current matrix on the stack
		
		/** draws grass around the house */
		
		gl.glColor3f(0.137255f,0.556863f, 0.419608f);   // sets the color of the grass    
	    gl.glBegin(GL2.GL_QUADS);	  					// Treats each group of four vertices as an independent quadrilatera
	    gl.glVertex3f(-4.0f,-1.0f,4.0f);                // first 3D vertices                 
	    gl.glVertex3f(4.0f,-1.0f,4.0f);             	// second 3D vertices                              
	    gl.glVertex3f(4.0f,-1.0f,-1.0f);                // third 3D vertices            	             
	   	gl.glVertex3f(-4.0f,-1.0f,-1.0f);               // fourth 3D vertices                         
	   	gl.glEnd();										// done drawling the grass
	    gl.glPopMatrix();								// pops the old matrix without the transformations
	      
       /** draws bottom part of the house */
		
        gl.glPushMatrix();						// sets current matrix on the stack
        gl.glColor3f(0.92f,0.78f,0.62f); 		// sets the color of the bottom of the house  
        glut.glutSolidCube(2);   				// uses GLUT to insert a solid cube 
        gl.glColor3f(0.0f,0.0f,0.0f);    		// sets the color of the cube 
        gl.glEnd();								// done drawling bottom of house
        gl.glPopMatrix();						// pops the old matrix without the transformations
        
        /** draws the roof of the house */
        
        gl.glTranslatef(0.0f,1.0f,0.0f);		// transformation 2 for Translate
        gl.glPushMatrix();                		// sets current matrix on the stack  
        gl.glRotatef(-90.00f,1.0f,0.0f,0.0f);	// transformation 3 for Rotate
        glut.glutSolidCone(1.5,1,16,8);			// uses GLUT to insert a solid cone 
        gl.glEnd();								// done drawling roof of the house
        gl.glPopMatrix();						// pops the old matrix without the transformations

        /** draws the chimney part of the house **/
        
        gl.glTranslatef(.75f,.5f,-.75f);  		// transformation 4 for Translate
        gl.glColor3f(0.52f,0.37f,0.26f);   		// sets the color of the chimney on the house
        gl.glPushMatrix();						// sets current matrix on the stack
        gl.glScalef(1,3,1);						// transformation 5 for scale
        glut.glutSolidCube(.25f);				// uses GLUT to insert a solid cube 
        gl.glEnd();								// done drawling chimney on the house
        gl.glPopMatrix();       				// pops the old matrix without the transformations

        /** draws a sun behind the house **/
        
        gl.glTranslatef(.75f,.5f,-.75f);  		// transformation 6 for Translate
        sun(gl);								// calls the sun method, and draws sun above the house
        
        gl.glTranslatef(0.0f,-.65f,2.0f);     	// transformation 7 for Translate
        gl.glEnd();								// done drawling the sun above the house
        gl.glPopMatrix();						// pops the old matrix without the transformations

	}

	/**
	 * door method: this method draws the door for the house, and centers
	 * it on the house. 
	 * @param gl
	 */
	
    public static void door(GL2 gl)
    {
   	     /** draws the door for the house **/
    	
    	 gl.glTranslatef(-1.9f, -.4f,-.9f); 	// transformation 1 for Translate
         gl.glBegin(GL2.GL_LINE_STRIP);			// draws a connected group of line segments from the first vertex to the last.  
         {
             gl.glVertex3d(0.65,0,0); 			// first 3D vertices 
             gl.glVertex3d(0.30,0,0); 			// second 3D vertices 
             gl.glVertex3d(0.30,0.7,0); 		// third 3D vertices 
             gl.glVertex3d(0.65,0.7,0); 	 	// fourth 3D vertices 
             gl.glVertex3d(0.65,0,0); 			// fifth 3D vertices 
         }
         gl.glEnd();							// done drawling the door for the house
    }
    
    /**
     * window 1 method: draws the first window on house. The first window 
     * is the one on the right
     * @param gl
     */
    
    public static void window1(GL2 gl)
    {
    	/** draws first window1 on right of house **/
    	
   		gl.glTranslatef(-1f,1.1f,0f); 			// transformation 1 for Translate
        gl.glBegin(GL2.GL_LINE_STRIP);			// draws a connected group of line segments from the first vertex to the last.  
        {
            gl.glVertex3d(0.65,0,0); 			// first 3D vertices 
            gl.glVertex3d(1,0,0); 				// second 3D vertices 
            gl.glVertex3d(1,0.5,0); 			// third 3D vertices 
            gl.glVertex3d(0.65,0.5,0); 			// fourth 3D vertices 
            gl.glVertex3d(0.65,0,0); 			// fifth 3D vertices 
        }
        gl.glEnd();								// done drawling the first window for the house
    }
    
    /**
     * window 2 method: draws second window on house. The second window
     * is the one on the left.
     * @param gl
     */
    
    public static void window2(GL2 gl)
    {
    	/** draws second window2 on left of house **/
    	
     	 gl.glTranslatef(1.1f, 0f, 0f); 		// transformation 1 for Translate
         gl.glBegin(GL2.GL_LINE_STRIP);			// draws a connected group of line segments from the first vertex to the last.  
         {
        	  gl.glVertex3d(0.65,0,0); 			// first 3D vertices 
              gl.glVertex3d(1,0,0); 			// second 3D vertices 
              gl.glVertex3d(1,0.5,0); 			// third 3D vertices 
              gl.glVertex3d(0.65,0.5,0); 		// fourth 3D vertices 
              gl.glVertex3d(0.65,0,0); 			// fifth 3D vertices 
         }
         gl.glEnd();							// done drawling the second window for the house
    }

    /**
     * tree method: draws a tree on the left side of the house. Uses methods offered by GLUT
     * solid cube, which is for the base of the tree
     * solid cone, which is for the top of the tree
     * @param gl
     */
    
    public static void tree(GL2 gl)
    {
    	/** draws the base of the tree **/
    	
        gl.glTranslatef(-1.7f,-.7f,0f);  						// transformation 1 for Translate
        gl.glColor3f(0.52f, 0.37f, 0.26f);   					// sets the color of the base of the tree(trunk)
        gl.glPushMatrix();										// sets current matrix on the stack  
        gl.glScalef(1,3,1);										// transformation 2 for Scale
        glut.glutSolidCube(.20f);								// uses GLUT to insert a solid cube 
        gl.glColor3f(0.184314f, 0.3098040f,  0.184314f); 		// sets the color of the base of the tree(trunk)
        gl.glEnd();												// done drawling the trunk of the tree
        gl.glPopMatrix();										// pops the old matrix without the transformations
        
        /** draws the top of the tree **/
        
        gl.glTranslatef(0.0f,0.0f,0.0f);						// transformation 3 for Translate
        gl.glPushMatrix();                  					// sets current matrix on the stack 
        gl.glRotatef(-90.00f,1.0f,0.0f,0.0f);					// transformation 4 for rotate
        glut.glutSolidCone(.5,1.5,8,8);							// uses GLUT to insert a solid cube 
        gl.glEnd();												// done drawling the top of the tree
        gl.glPopMatrix();										// pops the old matrix without the transformations
    }
    
    /**
     * tree2 method: draws a tree on the right side of house. Uses methods offered by GLUT
     * solid cube, which is for the base of the tree
     * solid cone, which is for the top of the tree
     * @param gl
     */
    
    public static void tree2(GL2 gl)
    {
    	/** draws the base of the tree **/
    	
        gl.glTranslatef(3.7f,0f,0f);  							// transformation 1 for Translate
        gl.glColor3f(0.52f,0.37f,0.26f);   						// sets the color of the base of the tree(trunk)
        gl.glPushMatrix();										// sets current matrix on the stack  
        gl.glScalef(1,3,1);										// transformation 2 for Scale
        glut.glutSolidCube(.20f);								// uses GLUT to insert a solid cube 
        gl.glColor3f(0.184314f,0.3098040f,0.184314f); 			// sets the color of the base of the tree(trunk)
        gl.glEnd();												// done drawling the trunk of the tree
        gl.glPopMatrix();										// pops the old matrix without the transformations
        
        /** draws the top of the tree **/
        
        gl.glTranslatef(0.0f,0.0f,0.0f);						// transformation 3 for Translate
        gl.glPushMatrix();                  					// sets current matrix on the stack 
        gl.glRotatef(-90.00f,1.0f,0.0f,0.0f);					// transformation 4 for rotate
        glut.glutSolidCone(.5,1.5,8,8);							// uses GLUT to insert a solid cube 
        gl.glEnd();												// done drawling the top of the tree
        gl.glPopMatrix();										// pops the old matrix without the transformations
    }
    
	/**
	 * car method: draws a car next to the house. Uses methods offered by GLUT
	 * solid cube, to draw the body of the car
	 * solid torus, to draw the first wheel of the car
	 * solid torus, to draw the second wheel of the car
	 * solid torus, to draw the third wheel of the car
	 * solid torus, to draw the fourth wheel of the car
	 * @param gl
	 */
	
	public static void car(GL2 gl)
	{
		gl.glBegin(GL2.GL_MODELVIEW);			// applies subsequent matrix operations to the model view matrix stack.
		gl.glTranslatef(0f,-2.0f,1.5f);			// transformation 1 for Translate
	
		/** draws the body of the car **/
		
		gl.glColor3f(1.0f,1.0f,1.0f);   		// sets the color of the body of the car to white
		gl.glPushMatrix();						// sets current matrix on the stack 
		gl.glPushMatrix();            			// sets current matrix on the stack      
		gl.glScalef(2f,.5f,1f);					// transformation 2 for Scale
		glut.glutSolidCube(.5f);				// uses GLUT to insert a solid cube 
		gl.glPopMatrix();						// pops the old matrix without the transformations
		gl.glTranslatef(0f,0f,.25f);			// transformation 3 for Translate
		gl.glPushMatrix();						// sets current matrix on the stack      
		gl.glTranslatef(-.4f,-.2f,0f);			// transformation 4 for Translate
			
		/** draws the four wheels on the car **/
		
		gl.glColor3f(0.0f,0.0f,0.0f);   		// sets the color of the first wheel of the car to black
		glut.glutSolidTorus(.05,.1,8,8);        // uses GLUT to insert a solid Torus or wheel one
		gl.glTranslatef(.8f,0f,0f);				// transformation 5 for Translate		
		gl.glColor3f(0.0f, 0.0f, 0.0f);  		// sets the color of the second wheel of the car to black
		glut.glutSolidTorus(.05,.1,8,8);        // uses GLUT to insert a solid Torus or wheel two
		gl.glColor3f(0.0f,0.0f,0.0f);   		// sets the color of the second wheel of the car to black
		gl.glPopMatrix();						// pops the old matrix without the transformations
		
		gl.glTranslatef(0f,0f,-.5f);			// transformation 6 for Translate	
		gl. glPushMatrix();						// sets current matrix on the stack 
		gl.glTranslatef(-.4f,-.2f,0f);			// transformation 7 for Translate	
		glut.glutSolidTorus(.05,.1,8,8);        // uses GLUT to insert a solid Torus or wheel three
		gl.glColor3f(0.0f, 0.0f, 0.0f);   		// sets the color of the third wheel of the car to black
		gl.glTranslatef(.8f,0f,0f);				// transformation 8 for Translate	
		gl.glColor3f(0.0f,0.0f,0.0f);   		// sets the color of the fourth wheel of the car to black
		glut.glutSolidTorus(.05,.1,8,8);        // uses GLUT to insert a solid Torus or wheel four
		gl.glColor3f(0.0f,0.0f, 0.0f);   		// sets the color of the fourth wheel of the car to black
		
		gl.glPopMatrix();						// pops the old matrix without the transformations
		gl.glPopMatrix();						// pops the old matrix without the transformations
		gl.glEnd();								// done drawling car
		gl.glPopMatrix();						// pops the old matrix without the transformations
	}

	/**
	 * sun method: draws the sun rays, and calls the sphere method
	 * to create the complete sun. 
	 * @param gl2
	 */
	
    public static void sun(GL2 gl2) 
    {
        gl2.glColor3f(1,1,0);						// sets the color of the sun to yellow
        for (int i = 0; i < 13; i++) 				// Draw 13 rays, with different rotations.
        { 
            gl2.glRotatef( 360f / 13, 0, 0, 1 ); 	// transformation 1 for rotate
            gl2.glBegin(GL2.GL_LINES);				// used to draw 3d lines
            gl2.glVertex3f(0, 0, 0);				// first 3D vertices 
            gl2.glVertex3f(1f, 0, 0);				// first 3D vertices 
            gl2.glEnd();							// done drawling rays for the sun
        }
        sphere(gl2, 0.5);							// calls the sphere method to draw sphere around the rays
        gl2.glColor3f(0,0,0);						// sets the color
    }   

    /**
     * sphere method: draws the sphere piece for the sun
     * @param gl2
     * @param radius
     */
    
    public static void sphere(GL2 gl2, double radius) 
    {
    	glut.glutSolidSphere(.5, 16, 16);			// uses GLUT to insert a solid sphere for sun
    }

}
