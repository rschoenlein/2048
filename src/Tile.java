import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Tile {

	private int value;
	private int width;
	private int height;
	private Color color;

	public int row;
	public int col;

	public Tile(int v, int r, int c) {
		this.width = 64;
		this.height = 64;
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

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
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
		g.setColor(getColor());
		g.fillRoundRect(this.col + 5, this.row + 5, this.width, this.height, 15, 15);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("SansSerif", Font.BOLD, 32));
		g.drawString(Integer.toString(this.value), this.col + (this.width/2 - 5), this.row + (this.height/2 + 15));
	}

}
