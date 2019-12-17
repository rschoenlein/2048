import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Tile {

	private int value;
	private Color color;

	public int row;
	public int col;
	
	public final int MARGIN = 5;
	public final int SIZE = 64;

	public Tile(int v, int r, int c) {
		this.row = r;
		this.col = c;
		this.value = v;
	}

	public void setValue(int v) {
		this.value = v;
	}

	public int getValue(int x) {
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
		
		g.fillRoundRect(this.MARGIN + (this.col * (this.SIZE + this.MARGIN)), this.MARGIN + (this.row * (this.SIZE + this.MARGIN)), this.SIZE, this.SIZE, 10, 10);
	

		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("SansSerif", Font.BOLD, 32));

		// only draw value if tile is not empty
		if (this.value != 0) {
			g.drawString(Integer.toString(this.value), this.MARGIN + (this.col * (this.SIZE + this.MARGIN)) + (this.SIZE / 2 - 10),
					this.MARGIN + (this.row * (this.SIZE + this.MARGIN)) + (this.SIZE / 2 + 10));
		}
	}

}
