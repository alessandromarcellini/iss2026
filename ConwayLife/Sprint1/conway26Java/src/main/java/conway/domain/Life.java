package main.java.conway.domain;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Life implements LifeInterface {
    private final int rows;
    private final int cols;

    private boolean[][] gridA;
    private boolean[][] gridB;
    private boolean[][] currentGrid;
    private boolean[][] nextGrid;

    public static LifeInterface CreateGameRules() {
        return new Life(5, 5);
    }

    public Life(boolean[][] initialGrid) {
        this.rows = initialGrid.length;
        this.cols = initialGrid[0].length;
        this.gridA = new boolean[rows][cols];
        this.gridB = new boolean[rows][cols];
        this.gridA = deepCopyJava8(initialGrid);
        this.currentGrid = gridA;
        this.nextGrid    = gridB;
    }

    public Life(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.gridA = new boolean[rows][cols];
        this.gridB = new boolean[rows][cols];
        this.currentGrid = gridA;
        this.nextGrid    = gridB;
    }

    @Override
    public void nextGeneration() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int neighbors = countNeighborsAlive(r, c); // FIX 4: was countNeighborsLive
                boolean isAlive = currentGrid[r][c];
                if (isAlive) {
                    nextGrid[r][c] = (neighbors == 2 || neighbors == 3);
                } else {
                    nextGrid[r][c] = (neighbors == 3);
                }
            }
        }
        boolean[][] temp = currentGrid;
        currentGrid      = nextGrid;
        nextGrid         = temp;
    }

    protected int countNeighborsAlive(int row, int col) {
        int count = 0;
        if (row-1 >= 0)                      { if (currentGrid[row-1][col])   count++; }
        if (row-1 >= 0 && col-1 >= 0)        { if (currentGrid[row-1][col-1]) count++; }
        if (row-1 >= 0 && col+1 < cols)      { if (currentGrid[row-1][col+1]) count++; }
        if (col-1 >= 0)                      { if (currentGrid[row][col-1])   count++; }
        if (col+1 < cols)                    { if (currentGrid[row][col+1])   count++; }
        if (row+1 < rows)                    { if (currentGrid[row+1][col])   count++; }
        if (row+1 < rows && col-1 >= 0)      { if (currentGrid[row+1][col-1]) count++; }
        if (row+1 < rows && col+1 < cols)    { if (currentGrid[row+1][col+1]) count++; }
        return count;
    }

    @Override
    public boolean isAlive(int row, int col) {
        return currentGrid[row][col];
    }

    @Override
    public void setCell(int r, int c, boolean state) {
        currentGrid[r][c] = state;
    }

    @Override
    public ICell getCell(int r, int c) {          // FIX 1: wrap boolean in Cell
        return new Cell(currentGrid[r][c]);
    }

    @Override
    public Grid getGrid() {                        // FIX 2: wrap boolean[][] in Grid
        return new Grid(currentGrid);
    }

    @Override
    public void resetGrids() {                     // FIX 3: now public + @Override
        for (boolean[] row : gridA) Arrays.fill(row, false);
        for (boolean[] row : gridB) Arrays.fill(row, false);
        currentGrid = gridA;
        nextGrid    = gridB;
    }

    // FIX 5: return actual field values
    public int getRows() { return rows; }
    public int getCols() { return cols; }

    private boolean[][] deepCopyJava8(boolean[][] original) {
        return Arrays.stream(original)
                     .map(boolean[]::clone)
                     .toArray(boolean[][]::new);
    }

    public String gridRep() {
        return Arrays.stream(currentGrid)
            .map(row -> {
                StringBuilder sb = new StringBuilder();
                for (boolean cell : row) sb.append(cell ? "O " : ". ");
                return sb.toString();
            })
            .collect(Collectors.joining("\n"));
    }
}