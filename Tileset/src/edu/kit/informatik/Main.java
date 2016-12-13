package edu.kit.informatik;

public class Main {
	public static void main(String[] args) {

		LineType[] lines = new LineType[] { LineType.RED, LineType.YELLOW, LineType.GREEN, LineType.GREEN, LineType.RED,
				LineType.YELLOW };
		Tile tile = new Tile(lines);

		LineType[] lines2 = new LineType[] { LineType.RED, LineType.NONE, LineType.GREEN, LineType.GREEN,
				LineType.RED, LineType.NONE };
		Tile tile2 = new Tile(lines2);

		tile.canBeRecoloredTo(tile2);
		
		System.out.println(" ---- ");
		
		tile2.canBeRecoloredTo(tile2);
	}
}
