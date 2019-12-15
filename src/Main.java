import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

//TODO draw in this class
public class Main extends JFrame implements KeyListener, ActionListener{
	
	private Panel drawPane;
	
	public Main() {
		
		//setup panel
		drawPane = new Panel();
		
		//set up JFrame
		setTitle("2048");
		add(drawPane);
		setSize(500, 500);
		setVisible(true);	
		
		//add key Listener
		addKeyListener(this);
	}
	
	
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.drawPane.getBoard().moveRight();
		System.out.println("key pressed");
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
