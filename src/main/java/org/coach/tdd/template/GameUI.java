package org.coach.tdd.template;

import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by 41988 on 2017/6/3.
 */
public class GameUI {
    private static JSlider width;
    private static JSlider length;
    private static JPanel chessboard;
    private static JButton[][] button;
    private static JFrame jframe;
    private static JPanel setting;
    private static ChessBoard chessBoard;
    private static int lengthx = 4;
    private static int widthy = 4;
    private static boolean flag = true;
    private static JButton start;
    private static JButton end;
    private static JButton add;

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
        chessBoard = new ChessBoard(lengthx, widthy);
        start = new JButton("start");
        end = new JButton("end");
        add = new JButton("create");
    }

    public static void createUI() {
        inite();
        Container contentPane = jframe.getContentPane();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flashChessBoard();
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
        settingAdd();
        contentPaneSetting(contentPane);
        chessboard.setLayout(new GridLayout(lengthx, widthy));
        initeButton();
        creatButton();
        jframeSetting();
    }

    private static void contentPaneSetting(Container contentPane) {
        contentPane.add(setting, BorderLayout.NORTH);
        contentPane.add(chessboard, BorderLayout.CENTER);
    }

    private static void jframeSetting() {
        jframe.setSize(900, 900);
        jframe.setLocation(300, 200);
        jframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jframe.setVisible(true);
    }

    private static void settingAdd() {
        setting.add(start);
        setting.add(end);
        setting.add(add);
        setting.add(length);
        setting.add(width);
    }

    private static void initeButton() {
        button = new JButton[lengthx][widthy];
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < widthy; j++) {
                button[i][j] = new JButton("");
            }
        }
    }

    private static void flashChessBoard() {
        chessboard.removeAll();
        lengthx = length.getValue();
        widthy = width.getValue();
        chessboard.setLayout(new GridLayout(lengthx, widthy));
        button = new JButton[lengthx][widthy];
        chessBoard = new ChessBoard(lengthx, widthy);
        System.out.println(chessBoard.getLength());
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < widthy; j++) {
                button[i][j] = new JButton("");
            }
        }
        creatButton();
        chessboard.updateUI();
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
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < widthy; j++) {
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
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < widthy; j++) {
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
}
