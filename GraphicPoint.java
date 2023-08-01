import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class GraphicPoint {

	private JFrame jf = null;
	private JPanel cp = null;
	private int xStart, yStart, xEnd, yEnd;

	private JFrame getJFrame() {
		if (jf == null) {
			jf = new JFrame();
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setSize(640, 480);
			jf.setLocationRelativeTo(null);
			jf.setContentPane(getJContentPane());
			jf.setTitle("GraphicPoint");
		}
		return jf;
	}

	private JPanel getJContentPane() {
		if (cp == null) {
			cp = new JPanel();
			cp.addMouseListener(new MyMouseInputAdapter());
			cp.addMouseMotionListener(new MyMouseInputAdapter());
		}
		return cp;
	}

	class MyMouseInputAdapter extends MouseInputAdapter {
		public void mousePressed(MouseEvent e) {
			xStart = e.getX();
			yStart = e.getY();
		}

		public void mouseReleased(MouseEvent e) {
			xEnd = e.getX();
			yEnd = e.getY();
		}

		public void mouseDragged(MouseEvent e) {
			xEnd = e.getX();
			yEnd = e.getY();
			// コンテントペーンのグラフィックオブジェクトを取得
			Graphics g = cp.getGraphics();
			// (xStart, yStart)と(xEnd, yEnd)の2点間に直線を引く
			g.drawLine(xStart, yStart, xEnd, yEnd);

			xStart = xEnd;
			yStart = yEnd;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GraphicPoint application = new GraphicPoint();
				application.getJFrame().setVisible(true);
			}
		});
	}
}
