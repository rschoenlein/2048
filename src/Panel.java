import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private Board board;

	public Panel() {
		board = new Board(4, 4);
		setLayout(new GridLayout());
	}
	
	 @Override
     public void paintComponent(Graphics g){
		 System.out.println(board.getTiles()[0][0].row);
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D)g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         
         board.drawBoard(g2);
     }
	 
	 public Board getBoard() {
		 return this.board;
	 }
}
