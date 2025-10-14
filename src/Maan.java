import java.util.Random;
import java.util.Scanner;

public class Maan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepa = 0;
        int difficult;
String caslte = "\uD83C\uDFF0";

        int sizeBoard = 5;
        int kolvoMonster = sizeBoard * sizeBoard - sizeBoard - 5;

        Random r = new Random();
        int castleX = r.nextInt(sizeBoard);
        int castleY = 0;
        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }
        Person persona = new Person(sizeBoard);

        board[castleX][castleY] = caslte;
        Monster[] arrayMonster = new Monster[kolvoMonster + 1];
        int count = 0;
        Monster zadanie;
        while (count <= kolvoMonster) {
            if (r.nextBoolean()) {
                zadanie = new Monster(sizeBoard);
            } else {
                zadanie = new BigMonster(sizeBoard);
            }
            if (board[zadanie.getY()][zadanie.getX()].equals("  ")) {
                board[zadanie.getY()][zadanie.getX()] = zadanie.getImage();
                arrayMonster[count] = zadanie;
                count++;
            }

        }

        Main settings = new Main();
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String ans = scanner.nextLine();


        switch (ans) {
            case "ДА" -> {
                settings.configureSettings(scanner);
                difficult = settings.getDifficulty();
                System.out.println("Начинаем играть)");
                System.out.println("Выберите уровень сложности");
                difficult = scanner.nextInt();
                System.out.println("Ты выбрал уровень сложности:\t" + difficult);
                while (true) {
                    board[persona.getY() - 1][persona.getX() - 1] = persona.getImage();
                    outputBoard(board, persona.getLive());
                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                            "\nКоординаты персонажа - (x: " + persona.getX() + ", y: " + persona.getY() + "))");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    if (persona.moveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[persona.getY() - 1][persona.getX() - 1] = "  ";
                            persona.move(x, y);
                            stepa++;
                            System.out.println("Ход корректный; Новые координаты: " + persona.getX() + ", " + persona.getY() +
                                    "\nХод номер: " + stepa);
                        } else if (next.equals(caslte)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        } else {
                            for (Monster monster : arrayMonster) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster(difficult)) {
                                        board[persona.getY() - 1][persona.getX() - 1] = "  ";
                                        persona.move(x, y);

                                    } else {
                                        persona.downLive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Неккоректный ход");
                    }
                }
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }
        static void outputBoard (String[][]board,int live){
            String leftBlock = "| ";
            String rightBlock = "|";
            String wall = "+ —— + —— + —— + —— + —— +";

            for (String[] raw : board) {
                System.out.println(wall);
                for (String col : raw) {
                    System.out.print(leftBlock + col + " ");
                }
                System.out.println(rightBlock);
            }
            System.out.println(wall);


            System.out.println("Количество жизней:\t" + live + "\n");
        }
    }







