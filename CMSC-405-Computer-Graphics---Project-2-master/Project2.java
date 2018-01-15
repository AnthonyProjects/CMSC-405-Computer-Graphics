/**
 * CMSC 405 7980
 * Project 2: JOGL OpenGL 
 * Anthony Borza
 * April 9, 2017
 * Eclipse under Windows 10
 * 
 * Project2.java class: The purpose of this class is to create a unique
 * 3D scene composed of OpenGL graphic components using at least 6
 * different shapes, and 6 different transformation methods. The size of
 * this application should be 640 X 480. 
 */

// imports used

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.gl2.GLUT;


public class Project2 extends GLJPanel implements GLEventListener
{	
	/** variables and methods used throughout program **/
	
	protected static float rotationSpeed = 0.0f;	// rotationSpeed is declared as protected, is static, and of data type float
	protected static GLUT glut = new GLUT();		// glut declared as protected, is static, and implements the library utilities of OpenGL
	private Camera camera;							// camera declared as private, and calls the Camera.java class
	private GLJPanel draw;							// GLJPanel is declared as private, and named draw
	private Timer time;								// Timer declared as private, and named time
	private JCheckBox select;						// JCheckBox declared as private, and named select
	private int frameNumber; 						// frameNumber declared as private, and is of data type integer
		
	/**
	 * Constructor: defines the layout of the 3D scene. Creates a 
	 * JCheckBox button, and implements the Timer class, and creates
	 * a action listener for the check box, as well as, a action performed
	 * method, so when the check box is selected, the animation of the 3D
	 * scene starts, and when it is not selected it stops. Lastly, it 
	 * implements the Camera.java, and TrackBall.java classes, which is used
	 * for viewing transform and the projection for the OpenGL 3D scene.
	 */
	
	public Project2()
	{
		draw = new GLJPanel();									// creates a new GLJPanel named draw
		draw.setPreferredSize(new Dimension(640,480));			// sets the size of the canvas to 640 x 480
		draw.addGLEventListener((GLEventListener) this);		// adds an event handler to the content in the canvas
		setLayout(new BorderLayout());							// sets layout of canvas to BorderLayout
		add(draw, BorderLayout.CENTER);							// centers the content in the canvas
		select = new JCheckBox("Animate In 3D");				// creates a check box and names it, "Animate in 3D"
		
		select.addActionListener(new ActionListener() 			// adds and action listener to the check box
		{
			public void actionPerformed(ActionEvent evt)		// invoked when an action occurs when checking the check box
			{
				if(select.isSelected())		// if the check box is selected
				{
					time.start();			// start the animation 
				}	
				else						// else
				{
					time.stop();			// stop the animation
				}
			}
		});
		
		JPanel bottom = new JPanel();							// creates a new JPanel named bottom
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER));	// sets the layout to FlowLayout, and centers it
		bottom.add(select);										// adds the button 
		add(bottom, BorderLayout.SOUTH);						// centers the button using the South position
		
		time = new Timer(30, new ActionListener() 				// creates a timer action listener
		{
			public void actionPerformed(ActionEvent evt)		// invoked when an action occurs 
			{
				frameNumber++;				// increments frameNumber
				draw.repaint();				// repaints the components
			}
		});		
		camera = new Camera();				// creates new camera constructor without parameters from Camera.java class
		camera.setScale(5); 				// sets the scale of the camera to 5
		new TrackBall(draw,camera);  		// Implements the TrackBall.java class, and takes the parameters draw, and camera.
	}

	/**
	 * display method:to be used when OpenGL needs to be redrawn.
	 * @param draw
	 */

	public void display(GLAutoDrawable draw) 
	{
	
		final GL2 gl = draw.getGL().getGL2();		// gets GL, and GL2
		
		// indicates the buffers currently enabled for color writing, or indicates the depth buffer
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
		
		camera.apply(gl);					 // applies the camera.java class to the content in the canvas
	    gl.glRotated(frameNumber, 0, 1, 0);	 // sets rotation for all content in the canvas (transformation 1)
	    gl.glTranslatef(0f,-2f,4f); 		 // translates all content in the canvas (transformation 2)
        gl.glEnable(GL2.GL_LIGHTING);        // Enable lighting.
        gl.glEnable(GL2.GL_LIGHT0);          // Turn on a light.  By default, shines from direction of viewer.
        gl.glEnable(GL2.GL_NORMALIZE);       // OpenGL will make all normal vectors into unit normals
        gl.glEnable(GL2.GL_COLOR_MATERIAL);  // Material ambient and diffuse colors can be set by glColor*
	    
        /** builds house by calling the Shapes class, and the house method*/
        
        Shapes.house(gl);
        gl.glPopMatrix();	// pops the old matrix without the transformations
        
        /** builds car by calling the Shapes class, and the car method */
        
        Shapes.car(gl);
        gl.glPopMatrix();	// pops the old matrix without the transformations
                
        /** builds door for house by calling the Shapes class, and the door method */
        
        Shapes.door(gl);
        gl.glPopMatrix();	// pops the old matrix without the transformations
        
        /** builds first window for house by calling the Shapes class, and the window1 method */
        
        Shapes.window1(gl);
        gl.glPopMatrix();	// pops the old matrix without the transformations
        
        /** builds second window for house by calling the Shapes class, and the window2 method */
        
        Shapes.window2(gl);
        gl.glPopMatrix();	// pops the old matrix without the transformations
        
        /** builds tree for the house by calling the Shapes class, and the tree method */
        
        Shapes.tree(gl);
        gl.glPopMatrix();	// pops the old matrix without the transformations
        
        /** builds a second tree for the house by calling the Shapes class, and the tree2 method */
        
        Shapes.tree2(gl);
        gl.glPopMatrix();	// pops the old matrix without the transformations
 
	}

	/**
	 * init method: is used when the GLJpanel is first created.
	 * It initializes the OpenGL drawling context.
	 * @param draw
	 */
	
	public void init(GLAutoDrawable draw)
	{
        GL2 gl2 = draw.getGL().getGL2();				// gets GL, and GL2
        gl2.glMatrixMode(GL2.GL_PROJECTION);			// applies subsequent matrix operations to the projection matrix stack.
        gl2.glOrtho(-4, 4, -2, 2, -2, 2);  				// applies, and describes a transformation that produces a parallel projection. 
        gl2.glMatrixMode(GL2.GL_MODELVIEW);				// applies subsequent matrix operations to the model view matrix stack.
        gl2.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);		// applies the color of the matrix to a gray color
        gl2.glEnable(GL2.GL_DEPTH_TEST);				// does depth comparisons and updates the depth buffer 
	}
	
	
	/**
	 * reshape method: is used when the size of the GLJPanel changes. 
	 */
	
	public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {
	}
	
	/**
	 * dispose method: this method is used before the GLJPanel is
	 * destroyed. Also is used to release OpenGL resources.
	 * @param draw
	 */
	
	public void dispose(GLAutoDrawable draw) {	
	}
	

	/**
	 * Main method: used to execute program
	 * @param args
	 */
	
	public static void main(String args[])
	{
		JFrame window = new JFrame("Project 2: (Move your Mouse to View Shapes in 3D or, Check the Animate in 3D Button)");		// names the JFrame
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// closes gracefully
		window.setContentPane(new Project2());		// sets the contentPane
		window.pack();								// causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
		window.setVisible(true);					// sets the visibility to true
	    
	}

}
