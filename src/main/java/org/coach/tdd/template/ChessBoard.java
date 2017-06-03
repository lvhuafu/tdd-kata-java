package org.coach.tdd.template;

/**
 * Created by 41988 on 2017/6/3.
 */
public class ChessBoard {
    private GameCell[][] chessBoard;
    private int length = 0;
    private int width = 0;

    public ChessBoard(int length, int width) {
        this.length = length;
        this.width = width;
        chessBoard = new GameCell[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                chessBoard[i][j] = new GameCell(i, j);
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    private boolean inChessBoard(int x, int y) {
        return x >= 0 && x < length && y >= 0 && y < width;
    }

    public int getAroundAliveCount(GameCell cell) {
        int result = 0, x = cell.getX(), y = cell.getY();

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i == x && j == y)) {
                    if (inChessBoard(i, j) && chessBoard[i][j].getStatus()) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public GameCell getCell(int i, int j) {
        return chessBoard[i][j];
    }

    public void update() {
        boolean[][] buffer = new boolean[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int aroundAlives = caluteAlives(chessBoard[i][j]);
                buffer[i][j] = nextStatus(aroundAlives, chessBoard[i][j]);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                chessBoard[i][j].setSatus(buffer[i][j]);
            }
        }
    }

    private int caluteAlives(GameCell gameCell) {
        return getAroundAliveCount(gameCell);
    }

    public boolean nextStatus(int aroundAliveCount, GameCell cell) {
        boolean result = false;
        if (aroundAliveCount == 3) {
            result = true;
        }
        if (aroundAliveCount == 2) {
            result = cell.getStatus();
        }
        return result;
    }
}
