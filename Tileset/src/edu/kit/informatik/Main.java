package edu.kit.informatik;

public class Main {
	public static void main(String[] args) {

		LineType[] lines = new LineType[] { LineType.NONE, LineType.GREEN, LineType.GREEN, LineType.NONE, LineType.NONE,
				LineType.NONE };
		Tile tile = new Tile(lines);

		LineType[] lines2 = new LineType[] { LineType.NONE, LineType.NONE, LineType.NONE, LineType.GREEN,
				LineType.GREEN, LineType.NONE };
		Tile tile2 = new Tile(lines2);

		System.out.println(new int[]{1, 2, 3}.equals(new int[]{1, 2, 3}));
	}

	private static boolean connectsTo(Tile first, Tile second, int position) {

		// Where this Tile is attached to from otherTile's point of reference
		int oppositePosition = (position + 3) % 6;

		return first.getLineTypeAtIndex(position) == second.getLineTypeAtIndex(oppositePosition);
	}
}
