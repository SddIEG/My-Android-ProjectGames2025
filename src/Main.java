

import java.util.Random;
import java.util.Scanner;
import java.util.logging.SocketHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepa = 0;

        
        boolean d;
        int difficult;
        int personazX, personazY;
        int personazaLive = 3;
        int sizeBoard = 5;
        personazX = 1 + sizeBoard / 2;
        personazY = 1 + sizeBoard / 2;
        int kolvoMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        String personazazPlayer = " \uD83E\uDD20 ";
        String monster = " \uD83D\uDC80 ";
        int monsterKolvo = 5;
        String castle = " \uD83C\uDFF0 ";
        int castleY = 1;
        Random r = new Random();
        int castleX = 1 + r.nextInt(sizeBoard);

        String wall = "+ —— + —— + —— + —— + —— +";
        String leftBlock = "|";
        String rightBlock = "|";
        String[][] board = new String[sizeBoard][sizeBoard];

        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String ans = scanner.nextLine();


        if (ans.equals("ДА") || ans.equals("Да") || ans.equals("да")) {
            System.out.println("Начинаем играть)");
            System.out.println("Выберите уровень сложности");
            difficult = scanner.nextInt();
            System.out.println("Ты выбрал уровень сложности:\t" + difficult);
            for (int y = 1; y <= sizeBoard; y++) {
                for (int x = 1; x <= sizeBoard; x++) {
                    board[y - 1][x - 1] = "  ";
                }
            }
            for (int i = 0; i <= monsterKolvo; i++) {
                board[r.nextInt(sizeBoard - 1)][r.nextInt(sizeBoard)] = monster;
            }
            for (int y = 1; y <= sizeBoard; y++) {
                System.out.println(wall);
                for (int x = 1; x <= sizeBoard; x++) {
                    System.out.print(leftBlock);

                    if (personazY == y && personazX == x) {
                        System.out.print(personazazPlayer);
                    } else if (castleY == y && personazX == x) {
                        System.out.print(castle);
                    } else {
                        System.out.print("    ");
                    }
                }
                System.out.println(rightBlock);
            }
            System.out.println(wall);

        }


        System.out.println("Количество жизней:" + personazaLive + "  " + personazazPlayer);

        System.out.println("Куда ходим? Я разрешаю только по вертикали и горизонтали, но на 1 клетку");
        System.out.println("Ты тут - (x: " + personazX + ", y: " + personazY + ")");

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (board[y - 1][x - 1].equals("  ")) {
            board[personazY - 1][personazX - 1] = "  ";
            personazX = x;
            personazY = y;
            stepa++;
            System.out.println("Ход корректный; Новые координаты: " + personazX + ", " + personazY +
                    "\n Ход номер: " + stepa);
        } else if (board[y - 1][x - 1].equals(castle)) {
            System.out.println("Вы прошли игру!");

        } else {
            System.out.println("Реши задачу");
            taskMonstra();
    }
    }
    static void taskMonstra(){
        Random r = new Random();
        int x = r.nextInt(300);
        int y = r.nextInt(300);
        int trueAnswer = x + y;
        System.out.println("Реши пример: " + x+ " + " + y + " = ?");
        Scanner sc = new Scanner(System.in);
        int anm = sc.nextInt();
        if (trueAnswer == anm) {
            System.out.println("Верно! Ты победил монстра");

        }
        System.out.println("Ты проиграл эту битву!");

    }


}










