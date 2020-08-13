package lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    private GameWindow gameWindow; //подключаем связь с Game Window

    private static final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50; //координаты завязаны на основное окно
    private static final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private static final int WINDOW_HEIGHT = GameWindow.WINDOW_HEIGHT - 100;
    private static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;

    private static final int MIN_FIELD_SIZE = 3; //константы мин и макс размера поля
    private static final int MAX_FIELD_SIZE = 10;

    static final int GAME_MODE_H_VS_AI = 0; //константы для режима игры
    static final int GAME_MODE_H_VS_H = 1;

    private JRadioButton jrbHumanVsAi; //объявление радиокнопок
    private JRadioButton jrbHumanVsHuman;
    private ButtonGroup bgGameMode; // объявление группы радиокнопок

    private JSlider jsFieldSize; //объявление слайдеров
    private JSlider jsWinningLength;

    public SettingWindow(GameWindow gameWindow){ //передаем в окно настроек игровое окно
        this.gameWindow = gameWindow;

        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT); //создаем окно
        setTitle("Settings"); //надпись на окне

        setLayout(new GridLayout(8,1)); //начинаем создавать кнопки
        add(new JLabel("  Choose game mode")); //надпись над кнопкой

        jrbHumanVsAi = new JRadioButton(" Human vs AI", true); //инициализация кнопки и выбор этой по умолчанию
        jrbHumanVsHuman = new JRadioButton(" Human vs Human");
        add(jrbHumanVsAi);
        add(jrbHumanVsHuman);                   //инициализация группы и добавление кнопок в нее
        bgGameMode = new ButtonGroup();
        bgGameMode.add(jrbHumanVsAi);
        bgGameMode.add(jrbHumanVsHuman);

        add(new JLabel("  Choose field size"));

        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE,MIN_FIELD_SIZE); //инициализация слайдера размер поля
        jsFieldSize.setMajorTickSpacing(1);
        jsFieldSize.setPaintTicks(true);
        jsFieldSize.setPaintLabels(true);
        add(jsFieldSize);


        add(new JLabel("  Choose win line length"));

        jsWinningLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE,MIN_FIELD_SIZE); //инициализация слайдера размер линии
        jsWinningLength.setMajorTickSpacing(1);
        jsWinningLength.setPaintTicks(true);
        jsWinningLength.setPaintLabels(true);
        add(jsWinningLength);

        jsFieldSize.addChangeListener(e -> { //обработчик событий, чтоб связать два слайдера по размеру
            jsWinningLength.setMaximum(jsFieldSize.getValue());
        });

        JButton buttonStartGame = new JButton("Start new game"); //кнопка старт
        add(buttonStartGame);

        buttonStartGame.addActionListener(e -> { //выбор режима игры
            int mode;
            if(jrbHumanVsAi.isSelected()){
                mode = GAME_MODE_H_VS_AI;
            } else {
                mode = GAME_MODE_H_VS_H;
            }

            int fieldSize = jsFieldSize.getValue(); //считываем слайдеры
            int winningLength = jsWinningLength.getValue();

            Logic.SIZE = fieldSize;             //передаем в класс с игрой размеры линий и инициализируем карту
            Logic.DOTS_TO_WIN = winningLength;
            Logic.initMap();
            Logic.isFinished = false;

            gameWindow.startNewGame(mode, fieldSize, winningLength); //вызываем метод старта игры и передаем ему значения с кнопок

            setVisible(false);
        });

        setVisible(false);


    }
}
