import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Pendulum implements Drawable {

	public static final double G = 30;

	double theta = 0;
	double thetap = 0;
	double delta = 0.02;
	int ratio = 15;
	int length = 200;
	int x0 = 400;
	int y0 = 300;
	int x1 = (int) (length * Math.sin(theta));
	int y1 = (int) (length * Math.cos(theta));

	public void move(Point p) {
		x1 = p.x;
		y1 = p.y;
		length = (int) Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2));
		theta = Math.asin((double) (x1 - x0) / length);
		thetap = 0;
		if (y1 < y0) {
			if (x1 < x0) {
				theta = -Math.PI - theta;
			} else if (y1 < y0) {
				theta = Math.PI - theta;
			}
		}
	}

	public void update() {
		thetap = thetap - delta * (Math.sin(theta) * G / length);
		theta = theta + delta * thetap;
		x1 = (int) (length * Math.sin(theta)) + x0;
		y1 = (int) (length * Math.cos(theta)) + y0;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.drawLine(x0 - length / 2, y0, x0 + length / 2, y0);
		g2d.drawLine(x0, y0, x1, y1);
		g2d.fillOval(x1 - ratio, y1 - ratio, 2 * ratio, 2 * ratio);
	}
}
