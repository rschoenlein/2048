import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tile {

	private int value;
	private Color color;
	private Rectangle rect;

	public int row;
	public int col;
	
	public final int MARGIN = 5;
	public final int SIZE = 64;
	

	public Tile(int v, int r, int c) {
		this.row = r;
		this.col = c;
		this.value = v;
		
		//create rectangle at proper x and y coordinates based on margin, row, col, and SIZE
		this.rect = new Rectangle(this.MARGIN + (this.col * (this.SIZE + this.MARGIN)), this.MARGIN + (this.row * (this.SIZE + this.MARGIN)), this.SIZE, this.SIZE);
	}

	public void setValue(int v) {
		this.value = v;
	}

	public int getValue() {
		return this.value;
	}

	// return tile color based on value
	public Color getColor() {
		switch (value) {
		case 2:
			return new Color(0xeee4da);
		case 4:
			return new Color(0xede0c8);
		case 8:
			return new Color(0xf2b179);
		case 16:
			return new Color(0xf59563);
		case 32:
			return new Color(0xf67c5f);
		case 64:
			return new Color(0xf65e3b);
		case 128:
			return new Color(0xedcf72);
		case 256:
			return new Color(0xedcc61);
		case 512:
			return new Color(0xedc850);
		case 1024:
			return new Color(0xedc53f);
		case 2048:
			return new Color(0xedc22e);
		}

		// tile is empty(no value)
		return new Color(0xcdc1b4);
	}

	public void drawTile(Graphics2D g) {
		
		g.setColor(this.getColor());
		
		g.fillRoundRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height, 10, 10);
	

	
		if (this.value != 0) {
			g.setColor(Color.DARK_GRAY);
			
			Font tileFont = new Font("SansSerif", Font.BOLD, 32);
			g.setFont(tileFont);
			
			//center value in rect
			FontMetrics metrics = g.getFontMetrics(tileFont);
			int x = this.rect.x + (this.rect.width - metrics.stringWidth(Integer.toString(this.value))) / 2;
			int y = this.rect.y + ((this.rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
			
			g.drawString(Integer.toString(this.value), x, y);
		}
	}

}
