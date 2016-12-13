package edu.kit.informatik;

public class Main {
	public static void main(String[] args) {

		LineType[] lines = new LineType[] { LineType.RED, LineType.NONE, LineType.GREEN, LineType.GREEN, LineType.RED,
				LineType.NONE };
		Tile tile = new Tile(lines);

		LineType[] lines2 = new LineType[] { LineType.NONE, LineType.NONE, LineType.NONE, LineType.GREEN,
				LineType.GREEN, LineType.NONE };
		Tile tile2 = new Tile(lines2);

		tile2.canBeRecoloredTo(tile);
	}
}
