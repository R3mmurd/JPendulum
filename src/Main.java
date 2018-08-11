import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Main extends JFrame {
	public Main() {
		PendulumPanel p = new PendulumPanel();
		setLayout(new BorderLayout());
	    add(p, BorderLayout.CENTER);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(800, 600);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
