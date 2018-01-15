

import java.awt.Component;
import java.awt.event.*;

/**
 * This class enables using the mouse to rotate the view in an OpenGL context.
 * A TrackBall requires an OpenGL display and a Camera.  It registers a mouse
 * listener on the display.  When the user drags the mouse, the Camera's view
 * is adjusted and the display is redrawn.  The action is supposed to be similar
 * to rolling a track ball to change the view.  Note that to use a Trackball
 * on a GLJPanel or GLCanvas, drawable, that uses a Camera, camera, for setting
 * its projection and view, it should only be necessary to say
 * "new TrackBall(drawable,camera);".  You don't have to do anything else with
 * the trackball.
 */
public class TrackBall{

	private final Component gldrawable;
	private final Camera camera;

	/**
	 * Create a trackball for rotating a given component, which is probably
	 * a GLJPanel or GLCanvas.  A new Camera is created.  This camera can
	 * be retrieved by calling getCamera.  To implement the trackball, this
	 * camera should be used for setting the projection/view in the drawable.
	 */
	public TrackBall(Component gldrawable) {
		this(gldrawable, new Camera());
	}

	/**
	 * Create a trackball for rotating a given component, which is probably
	 * a GLJPanel or GLCanvas.  The camera that is passed to this constructor
	 * should be the one that is used for setting the projection/view in the drawable.
	 */
	public TrackBall(Component gldrawable, Camera camera) {
		this.gldrawable = gldrawable;
		this.camera = camera;
		gldrawable.addMouseListener(new Mouser());
	}
	
	/**
	 * Return the camera whose view is rotated by this trackball.
	 */
	public Camera getCamera() {
		return camera;
	}

	private class Mouser implements MouseListener, MouseMotionListener {

		private boolean dragging;
		private double[] prevRay;
		
		public void mousePressed(MouseEvent e) {
			if (dragging)
				return;
			dragging = true;
			prevRay = mousePointToRay(e.getX(), e.getY());
			gldrawable.addMouseMotionListener(this);
		}

		public void mouseReleased(MouseEvent e) {
			if (!dragging)
				return;
			dragging = false;
			gldrawable.removeMouseMotionListener(this);
		}

		public void mouseDragged(MouseEvent e) {
			if (!dragging)
				return;
			double[] thisRay = mousePointToRay(e.getX(), e.getY());
			camera.applyTransvection(prevRay, thisRay);
			prevRay = thisRay;
			gldrawable.repaint();
		}
		
		private double[] mousePointToRay(int x, int y) {
			double dx, dy, dz, norm;
			int centerX = gldrawable.getWidth()/2;
			int centerY = gldrawable.getHeight()/2;
			double scale = 0.8*Math.min(centerX, centerY);
			dx = (x - centerX);
			dy = (centerY - y);
			norm = Math.sqrt(dx*dx + dy*dy);
			if (norm >= scale)
				dz = 0;
			else
				dz = Math.sqrt( scale*scale - dx*dx -dy*dy );
			double length = Math.sqrt(dx*dx + dy*dy + dz*dz);
			return new double[] { dx/length, dy/length, dz/length };
		}

		public void mouseClicked(MouseEvent e) { }

		public void mouseEntered(MouseEvent e) { }

		public void mouseExited(MouseEvent e) { }

		public void mouseMoved(MouseEvent e) { }

	}
}