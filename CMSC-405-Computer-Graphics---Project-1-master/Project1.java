
/**
 * CMSC 405 7980
 * Project 1: Java 2D Graphics
 * Anthony Borza
 * March 26, 2017
 * Eclipse under Windows 10
 * 
 * Project1.java class: the purpose of this class is to create 3 simple, 
 * binary 25 X 25 images of our choice and used Java 2D graphic methods to
 * translate, rotate and scale each of the images. 
 */

// imports used

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project1 extends JPanel implements ActionListener  
{
	// Graphics2D variables used within the methods of the program. Graphics2D
	// is a fundamental class that is used for rendering 2-dimensional shapes,
	// text and images.
	
	private Graphics2D graphicOne;							// graphicOne is declared as private and uses Graphic2D
	private Graphics2D graphicTwo;							// graphicTwo is declared as private and uses Graphic2D
	private Graphics2D graphicThree;						// graphicThree is declared as private and uses Graphic2D
	
	// variables created to be used to develop the GUI, and components within the GUI
	
	private JFrame frame = new JFrame("Project1");			// titles JFrame Project1
	private JLabel label = new JLabel("3 Graphics");		// labels the inside of the Frame 3 Graphics
	private JButton button = new JButton("Next Graphic");	// labels the button Next Graphic	
	
	
	private int index = 0;		// index declared as a data type integer and is private
	private int x = 25;			// x declared as a data type integer and is private
	private int y = 25;			// y declared as a data type integer and is private
	
	// creates three buffered images with the variables canvas 1,2,3 and a size of 25 by 25 pixels
	// it also implements one of the buffered image features, TYPE_INIT_ARGB, which represents 
	// an image with 8-bit RGBA color components packed into integer pixels. This feature is used
	// on all images.
	
	private BufferedImage canvas1 = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);		// creates a buffered image for first graphic
	private BufferedImage canvas2 = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);		// creates a buffered image for second graphic
	private BufferedImage canvas3 = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);		// creates a buffered image for third graphic
	
	
	
	/**
	 * Constructor: creates the GUI frame, and window to display the graphics.
	 * The constructor includes the following:
	 	* Container pane for this frame
	 	* the size of the frame
	 	* the three methods to create the images:
	 		* drawArray1
	 		* drawArray2
	 		* drayArray3
	 	* adds a label to the frame of the GUI in the north position
	 	* adds a button to the frame of the GUI in the south position
	 	* closes the frame using DefaultCloseOperation
	 	* sets the visibility of the frame to true
	 	* adds functionality to the button implementing the ActionListener method 
	 */
	
	public Project1()
	{
        frame.getContentPane().add(this);						// returns and gets the content pane
        frame.setSize(250, 250);								// sets size of frame to a width and height of 250
        drawArray1();											// calls the drawArray1 method
        drawArray2();											// calls the drawArray2 method
        drawArray3();											// calls the drawArray3 method
        frame.add(label, BorderLayout.NORTH);					// adds label to the top of GUI frame
        frame.add(button, BorderLayout.SOUTH);					// adds button to bottom of the GUI frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// closes frame after execution
        frame.setVisible(true);									// sets the visibility to true
        button.addActionListener((ActionListener) this);		// adds an action listener to the button
	}
	
	/**
	 * paint method: this methods supports Graphics, and its purpose is to 
	 * hold the instructions to paint the components. In our program, the components
	 * that are being painted are the 3 graphics that were created. They are labeled 
	 * as the following: graphicOne, graphicTwo, and graphicThree. All three labeled
	 * variables implement the translate, rotate, and scale methods. This method is
	 * constructed around a switch statement. I used java oracle to help with the 
	 * development of this switch statement. The link for the switch statement can
	 * be found here: https://docs.oracle.com/javase/tutorial/2d/advanced/transforming.html
	 * The switch statement includes 15 cases that are used to transition through the graphics 
	 * smoothly. Each image is first displayed in its original state, it then is displayed
	 * in its translate state, then its rotate state, and lastly its scale state. 
	 * @param g
	 */
	
	public void paint(Graphics g)
	{
	    graphicOne = (Graphics2D) g;		// graphicOne extends off of the Graphics class 
	    graphicOne.translate(100, 50);		// centers the images, so they all display in the center of the GUI for readability purposes
		graphicTwo = (Graphics2D) g;		// graphicTwo extends off of the Graphics class 
		graphicThree = (Graphics2D) g;		// graphicThree extends off of the Graphics class 
		
		switch(index)	// start of switch statement uses index to keep count of the conditions
		{
			case 0: 	
				graphicOne.drawImage(canvas1, 0, 0, this);	// draws the image graphicOne on the GUI in its original state
				break;	// break									
			case 1:
				graphicOne.translate(-5,7);					// translates the origin of the Graphics2D image GraphicOne to the point (-5, 7) in the current coordinate system. 
				graphicOne.drawImage(canvas1, 0, 0, this);	// draws the image after the translate method has been called
				break;	// break
			case 2:
				graphicOne.rotate(-45);						// rotates the image graphicOne 45 degrees counter clockwise, or -45 degrees
				graphicOne.drawImage(canvas1, 0, 0, this);	// draws the image after the rotation method has been called
				break;	// break
			case 3:
				graphicOne.rotate(90);						// rotates the image graphicOne 90 degrees  clockwise
				graphicOne.drawImage(canvas1, 0, 0, this);	// draws the image after the rotation method has been called
				break;	// break
			case 4:
				graphicOne.scale(2, 0.5);					// scales the image graphicOne 2 times for the x component, and 0.5 for the y component
				graphicOne.drawImage(canvas1, 0, 0, this);	// draws the image after the scale method has been called
				break;	// break
			case 5: 
				graphicTwo.drawImage(canvas2, 0, 0, this);	// draws the image graphicTwo on the GUI in its original state
				break;	// break
			case 6:
				graphicTwo.translate(-5,7);					// translates the origin of the Graphics2D image GraphicTwo to the point (-5, 7) in the current coordinate system. 
				graphicTwo.drawImage(canvas2, 0, 0, this);	// draws the image after the translate method has been called
				break;	// break
			case 7:
				graphicTwo.rotate(-45);						// rotates the image graphicTwo 45 degrees counter clockwise, or -45 degrees
				graphicTwo.drawImage(canvas2, 0, 0, this);	// draws the image after the rotation method has been called
				break;	// break
			case 8:
				graphicTwo.rotate(90);						// rotates the image graphicTwo 90 degrees clockwise
				graphicTwo.drawImage(canvas2, 0, 0, this);	// draws the image after the rotation method has been called
				break;	// break
			case 9: 
				graphicTwo.scale(2, 0.5);					// scales the image graphicTwo 2 times for the x component, and 0.5 for the y component
				graphicTwo.drawImage(canvas2, 0, 0, this);	// draws the image after the scale method has been called
				break;	// break
			case 10: 
				graphicThree.drawImage(canvas3, 0, 0, this); 	// draws the image graphicThree on the GUI in its original state	
				break;	// break
			case 11:
				graphicThree.translate(-5, 7);					// translates the origin of the Graphics2D image GraphicThree to the point (-5, 7) in the current coordinate system. 
				graphicThree.drawImage(canvas3, 0, 0, this);	// draws the image after the translate method has been called
				break;	// break
			case 12:
				graphicThree.rotate(-45);						// rotates the image graphicThree 45 degrees counter clockwise, or -45 degrees
				graphicThree.drawImage(canvas3, 0, 0, this);	// draws the image after the rotation method has been called
				break;	// break
			case 13:
				graphicThree.rotate(90);						// rotates the image graphicThree 90 degrees clockwise
				graphicThree.drawImage(canvas3, 0, 0, this);	// draws the image after the rotation method has been called
				break;	// break
			case 14: 
				graphicThree.scale(2, 0.5);						// scales the image graphicThree 2 times for the x component, and 0.5 for the y component
				graphicThree.drawImage(canvas3, 0, 0, this);	// draws the image after the scale method has been called
				break;	// break
			case 15:
				System.exit(0);		// closes the GUI after it has gone through all of the images, and their transitions
		}
	}
	
	/**
	 * doArray method: creates a smiley face image in a square 25 x 25 using binary
	 * consisting of  0's and 1's. Uses a for loop to iterate through the array
	 * assigning each 1 that is met to the color black, and each 0 that is met
	 * to the color white. 
	 */
	
	private void drawArray1()
	{
		// creates a 2 dimensional byte array named array1 that consists of 0's and 1's
		
		byte[][] array1 = {
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 } 
		};
		
		for(int i = 0; i < array1.length; i++)		// for i is equal to 1, and i is less than the length of array1, increment i
		{
			for(int j = 0; j < array1[i].length; j++)	// for j is equal to 0, and j is less than the length of the array1, increment j
			{
				if(array1[i][j] == 1) // if the items in the array are 1's
				{
					canvas1.setRGB(i, j, Color.BLACK.getRGB());	// set the background color of cavas1 to black where ever there is a 1
				}
				else	// else
				{
					canvas1.setRGB(i, j, Color.WHITE.getRGB());	// set it to white where ever there is a 0 
				}
			}
        }
		repaint();	// calls the component paint method to repaint the graphic or image
	}  
	
	/**
	 * doArray2 method: creates a triangle with a 90 degree angle in a square 25 x 25 
	 * using binary consisting of  0's and 1's. Uses a for loop to iterate through the array
	 * assigning each 1 that is met to the color black, and each 0 that is met
	 * to the color white. 
	 */
	
	private void drawArray2()
	{
		// creates a 2 dimensional byte array named array2 that consists of 0's and 1's
		
		byte[][] array2 = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
         };
		
		for(int i = 0; i < array2.length; i++)		// for i is equal to 1, and i is less than the length of array2, increment i
		{
			for(int j = 0; j < array2[i].length; j++)	// for j is equal to 0, and j is less than the length of the array2, increment j
			{
				if(array2[i][j] == 1) 	// if the items in the array are 1's
				{
					canvas2.setRGB(i, j, Color.BLACK.getRGB());	// set the background color of cavas1 to black where ever there is a 1
				}
				else	// else
				{
					canvas2.setRGB(i, j, Color.WHITE.getRGB());	// set it to white where ever there is a 0 
				}
			}
        }
		repaint();	// calls the component paint method to repaint the graphic or image
	}  
	
	/**
	 * doArray3 method: creates a the letter 'A' in a square 25 x 25 using binary
	 * consisting of  0's and 1's. Uses a for loop to iterate through the array
	 * assigning each 1 that is met to the color black, and each 0 that is met
	 * to the color white. 
	 */
	
	private void drawArray3()
	{
		// creates a 2 dimensional byte array named array3 that consists of 0's and 1's
		
		 byte array3[][] = {
	        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		  };

		for(int i = 0; i < array3.length; i++)	// for i is equal to 1, and i is less than the length of array3, increment i
		{
			for(int j = 0; j < array3[i].length; j++)	// for j is equal to 0, and j is less than the length of the array3, increment j
			{
				if(array3[i][j] == 1) 	// if the items in the array are 1's
				{
					canvas3.setRGB(i, j, Color.BLACK.getRGB());		// set the background color of cavas1 to black where ever there is a 1
				}
				else	// else
				{
					canvas3.setRGB(i, j, Color.WHITE.getRGB());		// set it to white where ever there is a 0 
				}
			}
        }
		repaint();	// calls the component paint method to repaint the graphic or image
	}  
	/**
	 * Action performed method: provides functionality to the
	 * button, so when you click the button, it transitions to
	 * the next image smoothly. 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		index++;			// increment index 
		frame.repaint();	// implements the paint method to repaint the graphic or image
	}
	
	/**
	 * Main method: used to execute program
	 * @param args
	 */
	
	public static void main(String args[])
	{
		Project1 p1 = new Project1();		// calls the Project1 class, and assigns it the variable p1 
	}
}
