package org.coach.tdd.template;

/**
 * Created by 41988 on 2017/6/3.
 */
public class ChessBoard {
    private GameCell[][] chessBoard;
    private int length = 0;
    private int width = 0;

    public ChessBoard(int length, int width) {
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
}
