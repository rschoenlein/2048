import java.awt.Color;
import java.awt.Graphics2D;

public class Board {

	private Tile[][] tiles;
	private int size;

	public Board(int size) {
		this.size = size;

		tiles = new Tile[this.size][this.size];

		generateNewBoard();
		
		tiles[0][0] = new Tile(2, 1, 1);

	}

	public int getSize() {
		return this.size;
	}

	public Tile[][] getTiles() {
		return this.tiles;
	}

	// create new board with 2 random tiles
	public void generateNewBoard() {
		//generate random tiles
		int occupiedTiles = this.size / 2;
		for (int i = 0; i < occupiedTiles; i++) {
			generateTile();
		}
		
		
		//generate empty tiles
		for (int i = 0; i < this.tiles[0].length; i++) {
			for (int j = 0; j < this.tiles.length; j++) {
				if (this.tiles[i][j] == null) {
					this.tiles[i][j] = new Tile(0, i, j);
				}
			}
		}
		

	}

	// generate tile at a random, unoccupied, row and column
	public void generateTile() {

		int randRow;
		int randCol;
		do {
			randRow = (int) (Math.random() * this.size - 1) + 1;
			randCol = (int) (Math.random() * this.size - 1) + 1;
		} while (this.tiles[randRow][randCol] != null);

		int randValue = Math.random() > .5 ? 2 : 4;

		System.out.println(randRow + " " + randCol);
		this.tiles[randRow][randCol] = new Tile(randValue, randRow, randCol);
	}

	
	public void drawBoard(Graphics2D g) {
		// draw background
		g.setColor(Color.DARK_GRAY);
		g.fillRoundRect(0, 0, this.tiles[0][0].MARGIN + this.size * (this.tiles[0][0].SIZE + this.tiles[0][0].MARGIN), this.tiles[0][0].MARGIN + this.size * (this.tiles[0][0].SIZE + this.tiles[0][0].MARGIN), 10, 10);;
		
		// draw each tile
		for (int i = 0; i < this.tiles[0].length; i++) {
			for (int j = 0; j < this.tiles.length; j++) {
				if (this.tiles[i][j] != null) {
					this.tiles[i][j].drawTile(g);
				}
			}
		}
	}

	// public:
	// moveRight()
	public void moveRight() {
		this.tiles[0][0].col += 1;
	}
	// moveLeft()
	// moveUp()
	// moveDown()

}
