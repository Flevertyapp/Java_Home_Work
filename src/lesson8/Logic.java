package lesson8;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZE;
    static int DOTS_TO_WIN;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static char[][] map;

    public static Random rand = new Random();

    static boolean isFinished;

    public static void go() {
        isFinished = true;
        printMap();

            if (BattleField.modeSetting() == SettingWindow.GAME_MODE_H_VS_AI) {  //игра с ИИ
                if (checkWinLines(DOT_X)) {
                    return;
                }
                if (isMapFull()) {
                    return;
                }
                aiTurn();
                printMap();
                if (checkWinLines(DOT_O)) {
                    return;
                }
                if (isMapFull()) {
                    return;
                }

                isFinished = false;
            } /*else {                      //человек против человека. Вроде идея рабочая, встает посде первого хода, но дальше мозгов не хватило
                if (checkWinLines(DOT_X)) {
                    return;
                }
                if (isMapFull()) {
                    return;
                }
                human2Turn(); //не принимает координаты!!!
                printMap();
                if (checkWinLines(DOT_O)) {
                    return;
                }
                if (isMapFull()) {
                    return;
                }

                isFinished = false;
                }*/
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        //попытка победить самому
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        //сбить победную линию противника, если остался 1 ход до победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        //сбить ход противника, если осталось 2 хода до победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN - 1) && Math.random() < 0.5) {// вход в перегруженный метод+ рандом для случайности действий компа
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }


        //ход в рандомную точку, сюда поидее не должен дойти
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static void humanTurn(int x, int y) {  //срабатывает по клику, если координаты валидные, вызывает метод go
        if(isCellValid(y, x)){
            map[y][x] = DOT_X;
            go();
        }
    }

    public static void human2Turn(int x, int y) {//для второго игрока
        if(isCellValid(y, x)){
            map[y][x] = DOT_O;
            go();
        }
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) { //check line method from HW
        return checkLine(cy, cx, vy, vx, dot, DOTS_TO_WIN);
    }

    static boolean checkWinLines(char dot) { //win method from HW
        return checkWinLines(dot, DOTS_TO_WIN);
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot, int dotsToWin) { //overload check line method from HW
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) < 0) {
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot, int dotsToWin) { //overload win method from HW
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin) || checkLine(i, j, 1, 0, dot, dotsToWin) || checkLine(i, j, 1, 1, dot, dotsToWin) || checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }


}
