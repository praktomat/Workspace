package edu.kit.informatik;

public class Main {
	public static void main(String[] args) {
		
		LineType[] lines = new LineType[] {LineType.GREEN, LineType.GREEN, LineType.YELLOW, LineType.NONE, LineType.YELLOW, LineType.NONE};
		Tile tile = new Tile(lines);
		
		LineType[] lines2 = new LineType[] {LineType.RED, LineType.GREEN, LineType.RED, LineType.GREEN, LineType.YELLOW, LineType.YELLOW};
		Tile tile2 = new Tile(lines2);
		
		System.out.println(tile);
		System.out.println(tile2);
		
		System.out.println(tile.fitsTo(tile2, 2));
	}
}
