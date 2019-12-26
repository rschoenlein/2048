import java.awt.Color;
import java.awt.Graphics2D;

//TODO winning and game over conditions
public class Board {

	private Tile[][] tiles;
	private int size;

	public Board(int size) {
		this.size = size;

		tiles = new Tile[this.size][this.size];

		generateNewBoard();

	}

	public int getSize() {
		return this.size;
	}

	public Tile[][] getTiles() {
		return this.tiles;
	}

	// create new board with 2 random tiles
	public void generateNewBoard() {

		// generate empty tiles
		for (int r = 0; r < this.tiles.length; r++) {
			for (int c = 0; c < this.tiles[0].length; c++) {
				this.tiles[r][c] = new Tile(0, r, c);
			}
		}

		// generate random tiles
		int occupiedTiles = this.size / 2;
		for (int i = 0; i < occupiedTiles; i++) {
			generateTile();
		}

	}

	// TODO fix paramaters of randRow and randCol
	// generate tile at a random, unoccupied, row and column
	public void generateTile() {

		int randRow;
		int randCol;

		// check if there is an open tile
		boolean spotAvailable = false;
		for (int i = 0; i < this.tiles[0].length; i++) {
			for (int j = 0; j < this.tiles.length; j++) {
				if (this.tiles[i][j].getValue() == 0) {
					spotAvailable = true;
				}
			}
		}

		// generate a new tile at a random open spot
		if (spotAvailable) {
			do {
				randRow = (int) (Math.random() * this.size);
				randCol = (int) (Math.random() * this.size);
			} while (this.tiles[randRow][randCol].getValue() > 0);

			int randValue = Math.random() > .5 ? 2 : 4;

			this.tiles[randRow][randCol] = new Tile(randValue, randRow, randCol);
		}
	}

	public void drawBoard(Graphics2D g) {
		// draw background
		g.setColor(Color.GRAY);
		g.fillRoundRect(0, 0, this.tiles[0][0].MARGIN + this.size * (this.tiles[0][0].SIZE + this.tiles[0][0].MARGIN),
				this.tiles[0][0].MARGIN + this.size * (this.tiles[0][0].SIZE + this.tiles[0][0].MARGIN), 10, 10);

		// draw each tile
		for (int i = 0; i < this.tiles[0].length; i++) {
			for (int j = 0; j < this.tiles.length; j++) {
				if (this.tiles[i][j] != null) {
					this.tiles[i][j].drawTile(g);
				}
			}
		}
	}

	// go through each row in tiles right to left, find non-empty tiles and move
	// them right by 1
	public void moveRight() {
		for (int r = 0; r < tiles.length; r++) {
			for (int c = tiles[0].length - 1; c >= 0; c--) {
				if (tiles[r][c].getValue() > 0) {
					moveTileRight(r, c);
				}
			}
		}
	}

	public void moveTileRight(int r, int c) {

		if (c == tiles[0].length - 1) {
			return;
		}

		if (tiles[r][c + 1].getValue() != tiles[r][c].getValue() && tiles[r][c + 1].getValue() != 0) {
			return;
		}

		if (tiles[r][c + 1].getValue() == tiles[r][c].getValue()) {
			tiles[r][c + 1] = new Tile(tiles[r][c].getValue() * 2, r, c + 1);
			tiles[r][c] = new Tile(0, r, c);
			return;
		}

		if (tiles[r][c + 1].getValue() == 0) {
			tiles[r][c + 1] = new Tile(tiles[r][c].getValue(), r, c + 1);
			tiles[r][c] = new Tile(0, r, c);
		}

		moveTileRight(r, c + 1);
	}

	public void moveLeft() {
		for (int r = 0; r < tiles.length; r++) {
			for (int c = 0; c < tiles[0].length; c++) {
				if (tiles[r][c].getValue() > 0) {
					moveTileLeft(r, c);
				}
			}
		}
	}

	public void moveTileLeft(int r, int c) {
		if (c == 0) {
			return;
		}

		if (tiles[r][c - 1].getValue() != tiles[r][c].getValue() && tiles[r][c - 1].getValue() != 0) {
			return;
		}

		if (tiles[r][c - 1].getValue() == tiles[r][c].getValue()) {
			tiles[r][c - 1] = new Tile(tiles[r][c].getValue() * 2, r, c - 1);
			tiles[r][c] = new Tile(0, r, c);
			return;
		}

		if (tiles[r][c - 1].getValue() == 0) {
			tiles[r][c - 1] = new Tile(tiles[r][c].getValue(), r, c - 1);
			tiles[r][c] = new Tile(0, r, c);
		}

		moveTileLeft(r, c - 1);
	}

	public void moveUp() {
		for (int r = 0; r < tiles.length; r++) {
			for (int c = 0; c < tiles[0].length; c++) {
				if (tiles[r][c].getValue() > 0) {
					moveTileUp(r, c);
				}
			}
		}
	}

	public void moveTileUp(int r, int c) {
		if (r == 0) {
			return;
		}

		if (tiles[r - 1][c].getValue() != tiles[r][c].getValue() && tiles[r - 1][c].getValue() != 0) {
			return;
		}

		if (tiles[r - 1][c].getValue() == tiles[r][c].getValue()) {
			tiles[r - 1][c] = new Tile(tiles[r][c].getValue() * 2, r - 1, c);
			tiles[r][c] = new Tile(0, r, c);
			return;
		}

		if (tiles[r - 1][c].getValue() == 0) {
			tiles[r - 1][c] = new Tile(tiles[r][c].getValue(), r - 1, c);
			tiles[r][c] = new Tile(0, r, c);
		}

		moveTileUp(r - 1, c);
	}

	public void moveDown() {
		for (int r = tiles.length - 1; r >= 0; r--) {
			for (int c = 0; c < tiles[0].length; c++) {
				if (tiles[r][c].getValue() > 0) {
					moveTileDown(r, c);
				}
			}
		}
	}

	public void moveTileDown(int r, int c) {
		if (r == tiles.length - 1) {
			return;
		}

		if (tiles[r + 1][c].getValue() != tiles[r][c].getValue() && tiles[r + 1][c].getValue() != 0) {
			return;
		}

		if (tiles[r + 1][c].getValue() == tiles[r][c].getValue()) {
			tiles[r + 1][c] = new Tile(tiles[r][c].getValue() * 2, r + 1, c);
			tiles[r][c] = new Tile(0, r, c);
			return;
		}

		if (tiles[r + 1][c].getValue() == 0) {
			tiles[r + 1][c] = new Tile(tiles[r][c].getValue(), r + 1, c);
			tiles[r][c] = new Tile(0, r, c);
		}

		moveTileDown(r + 1, c);
	}
}
