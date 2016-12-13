package edu.kit.informatik;

public class Board {

  public static final int BOARD_SIZE = 12;

  private Tile[] tiles;
  private int MAX_TILE_EDGES = 6;
  
  public Board() {

    tiles = new Tile[BOARD_SIZE];

    for (int i = 0; i < tiles.length; i++) {
      tiles[i] = new Tile();
    }

  }

  /**
   * Returns tile at given position
   * 
   * @param position
   *          of Tile
   * @return the Tile
   */
  public Tile getTile(int position) {
    return tiles[position];
  }

  /**
   * Changes the Tile at the given position
   * 
   * @param position
   *          which Tile to change
   * @param newTile
   *          replacement of old Tile
   */
  public void setTile(int position, Tile newTile) {
    tiles[position] = newTile;
  }

  /**
   * Replaces Tile with an empty Tile
   * 
   * @param position
   *          which Tile to change
   */
  public void removeTile(int position) {
    tiles[position] = new Tile();
  }

  /**
   * Returns whether all Tiles are empty
   * 
   * @return true if all Tiles are empty
   */
  public boolean isEmpty() {
    for (Tile tile : tiles) {
      if (!tile.isEmpty())
        return false;
    }
    return true;
  }

  /**
   * Rotates Tile at position clockwise
   * 
   * @param position
   *          what Tile to rotate
   */
  public void rotateTileClockwise(int position) {
    tiles[position].rotateClockwise();
  }

  /**
   * Rotates Tile at position counter-clockwise
   * 
   * @param position
   *          what Tile to rotate
   */
  public void rotateTileCounterClockwise(int position) {
    tiles[position].rotateCounterClockwise();
  }

  /**
   * Returns the amount of colors on the board
   * 
   * @return
   */
  public int getNumberOfColors() {

    String allTilesStringed = "";
    int amount = 0;

    for (Tile tile : tiles) {
      allTilesStringed += tile.toString();
    }

    if (allTilesStringed.contains("R"))
      amount++;

    if (allTilesStringed.contains("G"))
      amount++;

    if (allTilesStringed.contains("Y"))
      amount++;

    return amount;
  }

  /**
   * Returns whether all Tiles on the board fit correctly
   * 
   * @return true if board is valid
   */
  public boolean isValid() {

    // Iterate through all Tiles
    for (int tileId = 0; tileId < tiles.length; tileId++) {

      int[] neighbour = getNeighbours(tileId);

      // Iterate through all neighbours of tile
      for (int position = 0; position < MAX_TILE_EDGES; position++) {

        // If there exists a neighbour, check if it fits
        if (neighbour[position] != -1) {

          if (!tiles[tileId].fitsTo(tiles[neighbour[position]], (position + 3) % 6))
            return false;

        }
      }
    }

    return true;
  }

  private int[] getNeighbours(int tileId) {

    int[] neighbours = new int[6];

    // Make them all invalid
    for (int i = 0; i < 6; i++) {
      neighbours[i] = -1;
    }

    // TODO: how do you explain this
    neighbours[0] = tileId - 1; // top
    neighbours[1] = tileId + 2; // top right
    neighbours[2] = tileId + 3; // bottom right
    neighbours[3] = tileId + 1; // bottom
    neighbours[4] = tileId - 2; // bottom left
    neighbours[5] = tileId - 3; // top left

    // no upper neighbour for 3, 6, 9...
    if (tileId % 3 == 0) {
      neighbours[0] = -1;
      neighbours[1] = -1;
    }

    // no lower neighbour for 2, 5, 8, 11
    if ((tileId - 2) % 3 == 0) {
      neighbours[3] = -1;
      neighbours[4] = -1;
    }

    // remove out of bounds entries
    for (int i = 0; i < 6; i++) {
      if (neighbours[i] > 11 || neighbours[i] < 0)
        neighbours[i] = -1;
    }

    return neighbours;
  }

  /**
   * 
   * @param positions
   * @return
   */
  public LineType getConnectedPathColor(int[] positions) {

    Tile firstTile = tiles[positions[0]];
    Tile neighbourTile = tiles[positions[1]];

    for (int i = 0; i < positions.length - 1; i++) {

      boolean fits = firstTile.fitsTo(neighbourTile, neighbourPosition(positions[i], positions[i + 1]));

      if (!fits)
        return LineType.NONE;

    }
    return firstTile.getLineTypeAtIndex(neighbourPosition(positions[0], positions[1]));
  }

  private int neighbourPosition(int tileId, int neighbourId) {

    // bottom right
    if (neighbourId - tileId == 3)
      return 2;

    // top
    if (neighbourId - tileId == -1)
      return 0;

    // top left
    if (neighbourId - tileId == -3)
      return 5;

    // bottom left
    if (neighbourId - tileId == -2)
      return 4; // TODO something like 4 is "BOTTOM_LEFT_POSITION" final
                // variable

    // top right
    if (neighbourId - tileId == 2)
      return 1;

    // top
    if (neighbourId - tileId == 1)
      return 0;

    return Integer.MIN_VALUE;
  }

  @Override
  public String toString() {

    String word = "";

    for (int tileId = 0; tileId < BOARD_SIZE; tileId++) {
      word += tiles[tileId].toString() + ";";

      if ((tileId + 1) % 3 == 0 && tileId != 0)
        word += "\n";
    }
    return word;
  }

}
