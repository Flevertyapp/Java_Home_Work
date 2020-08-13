package lesson8;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class GameWindow extends JFrame {

    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 300;
    static final int WINDOW_HEIGHT = 555;
    static final int WINDOW_WIDTH = 505;

    private SettingWindow settingWindow;
    private BattleField battleField;

    public GameWindow() {
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT); //создаем окно
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //закрытие окна по крестику
        setTitle("X-O Game"); //надпись на окне

        settingWindow = new SettingWindow(this); //ссылка на вызов Setting Window
        battleField = new BattleField(this); //аналогично

        add(battleField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1,2)); //создание одной панели с двумя кнопками
        JButton buttonOk = new JButton("Start new game"); // создаем кнопку
        panel.add(buttonOk);                                   // добавляем кнопку
        JButton buttonExit = new JButton("Exit game");
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        buttonExit.addActionListener(e -> { //выход по кнопке Exit
            System.exit(0);
        });
        buttonOk.addActionListener(e -> { //открываем окно настроек по кнопке
            settingWindow.setVisible(true);
        });

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winningLength){
        battleField.startNewGame(mode, fieldSize, winningLength);
    }
}
