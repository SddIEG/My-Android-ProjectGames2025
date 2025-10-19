import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepa = 0;
        int difficult;
        String Lestnica = "\uD83C\uDFF0";

        int sizeBoard = 5;
        Random r = new Random();
        int lestnicaX = r.nextInt(sizeBoard);
        int lestnicaY = 0;
        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }
        int kolvoMonster = sizeBoard * sizeBoard - sizeBoard - 5;


        Person persona = new Person(sizeBoard);
        BigBigBoss boss = new BigBigBoss(sizeBoard);
        board[lestnicaY][lestnicaX] = Lestnica;
        Monster[] arrayMonster = new Monster[kolvoMonster];
        int count = 0;


        System.out.println("Ты решил прогулять уроки.Когда ты вышел из класса как бы в туалет ты раздумываешь.Бежим? (Напиши Да/Нет)");
        String ans = scanner.nextLine();


        switch (ans) {
            case "Да":
                System.out.println("Бежим!");
                System.out.println("На каком вы этаже? \n" +
                        "(Это тоже самое что и уровень сложности.Выше этаж сложнее из него выбраться)");
                difficult = scanner.nextInt();

                do {
                    boss = new BigBigBoss(1);
                } while (!board[boss.getY()-1][boss.getX()-1].equals("  "));
                board[boss.getY()-1][boss.getX()-1] = boss.getImg();

                while (difficult > 5 || difficult < 1) {

                    System.out.println("Повторяю выберите уровень сложности");

                    difficult = scanner.nextInt();
                }
                int kolvoBonys = difficult / 2;


                while (count < kolvoMonster) {
                    Monster zadanie;

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
                Bonys[] arrayBonys = new Bonys[kolvoBonys];
                for (int i = 0; i < kolvoBonys; i++) {
                    Bonys bonus;
                    do {
                        bonus = new Bonys(sizeBoard);
                    } while (!board[bonus.getY()-1][bonus.getX()-1].equals("  "));
                    board[bonus.getY()-1][bonus.getX()-1] = bonus.getImg();
                    arrayBonys[i] = bonus;
                }

                while (true) {
                    board[persona.getY() - 1][persona.getX() - 1] = persona.getImage();
                    outputBoard(board, persona.getLive());
                    System.out.println("Ты размышляешь над следующим своим шагом.Твоя школа похожа на какой-то лабиринт.\n" +
                            "(За один ход ты можешь идти только на одну клетку)" +
                            "\nСейчас ты здесь - (x: " + persona.getX() + ", y: " + persona.getY() + "))");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    if (persona.moveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[persona.getY() - 1][persona.getX() - 1] = "  ";
                            persona.move(x, y);
                            stepa++;
                            System.out.println("Я могу туда бежать. Теперь я здесь: " + persona.getX() + ", " + persona.getY() +
                                    "\nStepa: " + stepa);
                        } else if (next.equals(Lestnica)) {
                            System.out.println("Вы добегаете до лестницы и с свистом вылетаете из двеги в школьный двор.Там до дома рукой подать.");
                            break;
                        } else {
                            boolean monsterFound = false;
                            for (Monster monster : arrayMonster) {
                                if (monster.conflictPerson(x, y)) {
                                    monsterFound = true;
                                    if (monster.taskMonster(difficult)) {
                                        board[persona.getY() - 1][persona.getX() - 1] = "  ";
                                        persona.move(x, y);
                                    } else {
                                        persona.endLive();
                                    }
                                    break;
                                }
                            }

                            if (!monsterFound) {
                                for (int i = 0; i < arrayBonys.length; i++) {
                                    Bonys bonus = arrayBonys[i];
                                    if (bonus != null && bonus.conflictPerson(x, y)) {

                                        bonus.kasino(difficult);
                                        int c = bonus.c();

                                        if (c == 0) {
                                            persona.endLive();
                                        } else if (c==1) {
                                            persona.upLive();

                                        }

                                        board[bonus.getY()-1][bonus.getX()-1] = "  ";
                                        arrayBonys[i] = null;
                                        board[persona.getY() - 1][persona.getX() - 1] = "  ";
                                        persona.move(x, y);
                                        break;
                                    }
                                }

                            }
                        }
                        int bossX = boss.getX();
                        int bossY = boss.getY();
                        boss.Step();

                        if (board[boss.getY()-1][boss.getX()-1].equals("  ")) {
                            board[bossY-1][bossX-1] = "  ";
                            board[boss.getY()-1][boss.getX()-1] = boss.getImg();
                        }

                        if (boss.movePlayer(persona.getX(), persona.getY())) {
                            System.out.println("Директор догнал вас!");
                            boss.attackPlayer(persona);
                        }
                    } else {
                        System.out.println("Я не умею телепортироваться");
                    }

                    if (persona.getLive() <= 0) {
                        System.out.println("Вас поймали и отвели к Директору.Это не самое страшное , ведь в школу едут РОДИТЕЛИ. Жизни закончились(");
                        break;
                    }
                }
                break;


            case "Нет":
                System.out.println("Вы сходили в туалет и вернусь в класс дальше тухнуть на парте.");
                break;

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
        String heart = "\uD83D\uDC96";
        System.out.println(heart + live + "\n");
    }
}
