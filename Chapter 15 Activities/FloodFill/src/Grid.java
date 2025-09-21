import java.util.Stack;

class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Grid {
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];

    /**
     * Flood fill starting with the given row and column.
     */
    public void floodfill(int startRow, int startCol) {
        int counter = 1;
        Stack<Pair> hold = new Stack<>();
        hold.push(new Pair(startRow, startCol));

        while (hold.size() > 0) {
            Pair temp = hold.pop();
            int r = temp.row;
            int c = temp.col;
        	if (pixels[r][c] == 0) {
                pixels[r][c] = counter++;
                if (r > 0 && pixels[r - 1][c] == 0) {            // north
                    hold.push(new Pair(r - 1, c));
                }
                if (r < SIZE - 1 && pixels[r + 1][c] == 0) {     // south
                    hold.push(new Pair(r + 1, c));
                }
                if (c > 0 && pixels[r][c - 1] == 0) {            // west
                    hold.push(new Pair(r, c - 1));
                }
                if (c < SIZE - 1 && pixels[r][c + 1] == 0) {     // east
                    hold.push(new Pair(r, c + 1));
                }
        	}
    	}
    }
    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
