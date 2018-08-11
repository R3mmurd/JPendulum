import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PendulumPanel extends JPanel {

	Pendulum p;
	Thread thread;

	public PendulumPanel() {
		p = new Pendulum();

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				thread.resume();
			}

			@Override
			public void mousePressed(MouseEvent evt) {
				thread.suspend();
				p.move(evt.getPoint());
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent evt) {

			}

			@Override
			public void mouseDragged(MouseEvent evt) {
				p.move(evt.getPoint());
				repaint();
			}
		});

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				while (true) {
					p.update();
					repaint();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread = new Thread(runnable);
		thread.start();
	}

	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		p.draw(g2d);
	}

	@Override
	public void paint(Graphics g) {
		update(g);
	}
}
