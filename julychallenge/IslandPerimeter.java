/*
Island Perimeter

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:


*/
package julychallenge;

public class IslandPerimeter {
	static int gridData[][];

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(islandPerimeter(grid));
	}

	public static int islandPerimeter(int[][] grid) {
		int i, j, contri = 0;
		gridData = grid;
		for (i = 0; i < grid.length; i++) {
			for (j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					contri = contri + calculateContri(i, j);
				}
			}
		}
		return contri;
	}

	public static int calculateContri(int i, int j) {
		int contri = 4;
		if (isValidIndex(i + 1, j) && gridData[i + 1][j] == 1)
			contri--;
		if (isValidIndex(i - 1, j) && gridData[i - 1][j] == 1)
			contri--;
		if (isValidIndex(i, j + 1) && gridData[i][j + 1] == 1)
			contri--;
		if (isValidIndex(i, j - 1) && gridData[i][j - 1] == 1)
			contri--;
		return contri;
	}

	public static boolean isValidIndex(int i, int j) {
		if (i >= 0 && i < gridData.length && j >= 0 && j < gridData[0].length)
			return true;
		else
			return false;
	}

}
