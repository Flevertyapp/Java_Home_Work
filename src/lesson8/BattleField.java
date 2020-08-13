package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow; //подключаем связь с Game Window

    private static int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit = false; //переменная для проверки готовности данных для прорисовки

    private int cellWidth; //ширина-высота ячеек
    private int cellHeight;
    private int indent = 15; //переменная для коррекции Х и О

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.GRAY); //цвет фона

        addMouseListener(new MouseAdapter() { //обработка кликов мыши
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
                clickBattleField2(e); //нужен?
            }
        });
    }

    public static int modeSetting() {  //отсюда вытигивает mode в Logic
        if (BattleField.mode == SettingWindow.GAME_MODE_H_VS_AI){
            mode = 0;
        } return mode;
    }


    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX() / cellWidth; //вычисляем место куда кликнули по квадратам
        int cellY = e.getY() / cellHeight;

        if (!Logic.isFinished) {
            Logic.humanTurn(cellX, cellY);//передаем координаты в логику
            Logic.human2Turn(cellX, cellY);
            }

        repaint();
    }

    private void clickBattleField2(MouseEvent e) { //для второго игрока нужен? Все равно не передает)
        int cellX = e.getX() / cellWidth; //вычисляем место куда кликнули по квадратам
        int cellY = e.getY() / cellHeight;

        if (!Logic.isFinished) {
            Logic.human2Turn(cellX, cellY);//передаем координаты в логику
        }

        repaint();
    }

    public void startNewGame(int mode, int fieldSize, int winningLength){
        this.mode = mode;                           //сохраняем пришедшие данные
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!isInit){
            return;
        }

        int panelWidth = getWidth(); //узнаем размеры панели/окна
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize; //вычисление размера ячеек
        cellWidth = panelWidth / fieldSize;

        g.setColor(Color.black);

        for (int i = 0; i < fieldSize; i++) { //вертикальные линии
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);

        }

        for (int i = 0; i < fieldSize; i++) { //горизонтальные линии
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize ; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O){
                    drawO(g, j, i);
                }
            }

        }
        for (int i = 0; i < fieldSize; i++) {  //вывод результатов игры, переписать через JPane
            for (int j = 0; j < fieldSize; j++) {
                if(Logic.checkWinLines(Logic.DOT_X)){
                    drawWin("Human win!", g);
                } else if(Logic.checkWinLines(Logic.DOT_O)){
                    drawWin("AI win!", g);
                } else if(Logic.isMapFull()){
                    drawWin("Draw! Nobody wins!", g);
                }
            }
        }


    }

    private void drawX(Graphics g, int x, int y){   //рисуем крест, передаем координаты и графику
        ((Graphics2D) g).setStroke((new BasicStroke(5))); //ширина линии
        g.setColor(Color.red);
        g.drawLine(cellWidth * x + indent, cellHeight * y + indent, cellWidth * (x+1) - indent, cellHeight * (y + 1) - indent);
        g.drawLine(cellWidth * x + indent, cellHeight * (y + 1) - indent, cellWidth * (x + 1) - indent, cellHeight * y + indent);
    }

    private void drawO(Graphics g, int x, int y){   //рисуем крест, передаем координаты и графику
        ((Graphics2D) g).setStroke((new BasicStroke(5)));
        g.setColor(Color.blue);
        g.drawOval(cellWidth * x + indent, cellHeight * y + indent, cellWidth - indent * 2, cellHeight - indent * 2);
    }


    public void drawWin(String message, Graphics g) { //потом переделаю на JPane, а то некрасиво
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(message, 50,GameWindow.WINDOW_HEIGHT / 2);
    }



}



