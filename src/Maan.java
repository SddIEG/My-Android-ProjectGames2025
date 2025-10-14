import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepa = 0;
        int difficult;
        String caslte = "\uD83C\uDFF0";

        int sizeBoard = 5;
        int kolvoMonster = sizeBoard * sizeBoard - sizeBoard - 5;

        Random r = new Random();
        int castleX = 0;
        int castleY = r.nextInt(sizeBoard);
        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }
        Person persona = new Person(sizeBoard);
        BigBigBoss boss = new BigBigBoss(sizeBoard);
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

        System.out.println("Приветствую тебя!.Ты готов ?(Напиши Да/Нет)");
        String ans = scanner.nextLine();


        switch (ans) {
            case "Да" -> {
                System.out.println("Начинаем играть)");
                System.out.println("Выберите уровень сложности");
                difficult = scanner.nextInt();
                if (difficult != 5) {
                    System.out.println("Ты выбрал уровень сложности:\t" + difficult);

                } else {
                    System.out.println("你选择了难度级别吗:\t" + difficult);
                }

                while (true) {
                    board[boss.getY()-1][boss.getX()-1] = boss.getImg();
                    board[persona.getY() - 1][persona.getX() - 1] = persona.getImage();
                    outputBoard(board, persona.getLive());
                    if (difficult != 5) {
                        System.out.println("Жду твоего хода\n" +
                                "(Разрешаю ходить только по вертикали и горизонтали и только один раз)" +
                                "\nТы тут - (x: " + persona.getX() + ", y: " + persona.getY() + "))");
                    } else {
                        System.out.println("等待你的移动\n" +
                                "（我允许你只走垂直和水平，只有一次）" +
                                "\n你在这儿 - (x: " + persona.getX() + ", y: " + persona.getY() + "))");
                    }

                    System.out.print("X ");
                    int x = scanner.nextInt();
                    System.out.print("Y ");
                    int y = scanner.nextInt();
                    int xx = r.nextInt(5);
                    int yy = r.nextInt(5);
                    if (boss.moveCorrect(xx, yy)) {
                        String next = board[yy - 1][xx - 1];
                        if (next.equals("  ")) {
                            board[boss.getY() - 1][boss.getX() - 1] = "  ";
                            persona.move(xx, yy);
                        }
                    }

                    if (persona.moveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[persona.getY() - 1][persona.getX() - 1] = "  ";
                            persona.move(x, y);
                            stepa++;
                            if (difficult != 5) {
                                System.out.println("Я арзрешаю тебе туда ходить .Теперь ты тут: " + persona.getX() + ", " + persona.getY() +
                                        "\nХод номер: " + stepa);
                            } else {
                                System.out.println("我禁止你去那里。你现在在这里: " + persona.getX() + ", " + persona.getY() +
                                        "\n移动号码: " + stepa);
                            }

                        } else if (next.equals(caslte)) {
                            if (difficult != 5) {
                                System.out.println("Крассавчик");
                                break;
                            } else {
                                System.out.println("哈哈傻瓜");
                                break;
                            }


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
                        if (difficult != 5) {
                            System.out.println("Низя");
                        } else {
                            System.out.println("不得");
                        }


                    }
                }
            }
            case "Нет" -> System.out.println("Ну и УХОДИ:((");
            default -> System.out.println("Не понимаю @_@");
        }

    }

    static void outputBoard(String[][] board, int live) {
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
        String health = "\uD83D\uDC96";

        System.out.println(health + live + "\n");
    }
}






