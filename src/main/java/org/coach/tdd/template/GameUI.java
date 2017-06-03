package org.coach.tdd.template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 41988 on 2017/6/3.
 */
public class GameUI {
    static JSlider width;
    static JSlider length;
    static JPanel chessboard;
    static JButton button[][];
    static JFrame jframe;
    static JPanel setting;
    static ChessBoard chessBoard;
    static int length_x = 4;
    static int width_y = 4;
    static boolean flag = true;

    private static void inite() {
        jframe = new JFrame("LifeGame");
        setting = new JPanel();
        chessboard = new JPanel();
        length = new JSlider(JSlider.HORIZONTAL, 0, 20, 8);
        length.setMajorTickSpacing(10);
        length.setMinorTickSpacing(1);
        length.setPaintTicks(true);
        length.setPaintLabels(true);
        length.setBounds(10, 10, 260, 50);
        width = new JSlider(JSlider.HORIZONTAL, 0, 20, 8);
        width.setMajorTickSpacing(10);
        width.setMinorTickSpacing(1);
        width.setPaintTicks(true);
        width.setPaintLabels(true);
        width.setBounds(10, 10, 260, 50);
        chessBoard = new ChessBoard(length_x, width_y);
    }

    public static void createUI() {
        inite();
        Container contentPane = jframe.getContentPane();
        JButton start = new JButton("start");
        JButton end = new JButton("end");
        JButton add = new JButton("create");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessboard.removeAll();
                length_x = length.getValue();
                width_y = width.getValue();
                chessboard.setLayout(new GridLayout(length_x, width_y));
                button = new JButton[length_x][width_y];
                chessBoard = new ChessBoard(length_x, width_y);
                System.out.println(chessBoard.getLength());
                for (int i = 0; i < length_x; i++) {
                    for (int j = 0; j < width_y; j++) {
                        button[i][j] = new JButton("");
                    }
                }
                creatButton();
                chessboard.updateUI();
            }
        });
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = false;
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                startGame();
            }
        });
        setting.add(start);
        setting.add(end);
        setting.add(add);
        setting.add(length);
        setting.add(width);
        jframe.setSize(900, 900);
        jframe.setLocation(300, 200);
        contentPane.add(setting, BorderLayout.NORTH);
        contentPane.add(chessboard, BorderLayout.CENTER);
        chessboard.setLayout(new GridLayout(length_x, width_y));
        button = new JButton[length_x][width_y];
        for (int i = 0; i < length_x; i++) {
            for (int j = 0; j < width_y; j++) {
                button[i][j] = new JButton("");
            }
        }
        creatButton();
        jframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jframe.setVisible(true);
    }

    private static void startGame() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    try {
                        chessBoard.update();
                        updatePanel();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void updatePanel() {
        for (int i = 0; i < length_x; i++) {
            for (int j = 0; j < width_y; j++) {
                JButton button2 = button[i][j];
                GameCell cell = chessBoard.getCell(i, j);
                if (cell.getStatus()) {
                    button2.setBackground(Color.white);
                } else {
                    button2.setBackground(Color.black);
                }
            }
        }
        chessboard.updateUI();
    }

    private static void creatButton() {
        for (int i = 0; i < length_x; i++) {
            for (int j = 0; j < width_y; j++) {
                chessboard.add(button[i][j]);
                button[i][j].setBackground(Color.black);
                final JButton button2 = button[i][j];
                final GameCell cell = chessBoard.getCell(i, j);
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button2.setBackground(Color.white);
                        cell.setSatus(true);
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        createUI();
    }
}
