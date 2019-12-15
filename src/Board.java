import java.awt.Graphics2D;

public class Board {

	private Tile[][] tiles;
	private int width;
	private int height;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;

		// populate tiles
		tiles = new Tile[this.width][this.height];

		tiles[0][0] = new Tile(2, 1, 1);

	}
	

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Tile[][] getTiles() {
		return this.tiles;
	}

	public void drawBoard(Graphics2D g) {
		// draw grid

		// draw each tile
		System.out.println(tiles.length + ", " + tiles[0].length);
		for (int i = 0; i < tiles[0].length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				if (tiles[i][j] != null)
					tiles[i][j].drawTile(g);
			}
		}

	}

	// public:
	// moveRight()
	public void moveRight() {
		System.out.println("moving board right");
		this.tiles[0][0].col += this.tiles[0][0].getWidth();
	}
	// moveLeft()
	// moveUp()
	// moveDown()

}
