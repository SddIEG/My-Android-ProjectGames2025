import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "\uD83E\uDDB9\u200D♂\uFE0F";
    private int x, y;
    Random r = new Random();

    Monster(int sizeBoard) {
        this.y = r.nextInt(sizeBoard - 1);
        this.x = r.nextInt(sizeBoard);
    }

    public String getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean conflictPerson(int personX, int personY) {
        return personY - 1 == this.y && personX - 1 == this.x;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean taskMonster(int difficult) {
        System.out.println("Вас останавливает Заучка . Он говорит если вы решите его задачу то он пропустит вас.Если ошибетсь то он позовет учителя.");

        int a = r.nextInt(3);
        Scanner s = new Scanner(System.in);
        int ans;
        int aa, b, c, d;
        switch (a) {

            case 0:
                aa = (r.nextInt(20) + difficult) * 10000;
                int[] prochent = {10, 20, 25, 30, 70};
                b = prochent[r.nextInt(5)];
                System.out.println("В городе " + aa + " жителей, причём " + b + "% — это пенсионеры. Сколько пенсионеров в этом городе?");
                int y = aa /100;
                c = y * b;
                ans = s.nextInt();
                if (c == ans) {
                    System.out.println("'Ну ладно в этот раз я тебя не видел'- говорит Заучка и уходит");
                    return true;
                }
                System.out.println("АХААААА Ты бежишь.Минус жизнь");
                return false;
            case 1:
                aa = (r.nextInt(100) + difficult) * 10;
                b = r.nextInt(10) + difficult;
                c = r.nextInt(30) + difficult;
                System.out.println("В университетскую библиотеку привезли новые учебники по геометрии для 2 курсов,\n" +
                        "по " + aa + " штук для каждого курса. Все книги одинаковы по размеру. В книжном шкафу " + b + " полок,\n" +
                        "на каждой полке помещается " + c + " учебников. Сколько шкафов можно полностью заполнить новыми учебниками?");
                int cc = b * c;
                int ac = aa / cc;
                ans = s.nextInt();
                if (ac == ans) {
                    System.out.println("'Ну ладно в этот раз я тебя не видел'- говорит Заучка и уходит");
                    return true;
                }
                System.out.println("АХААААА Ты бежишь.Минус жизнь");
                return false;

            case 2:
                aa = r.nextInt(10) + difficult;
                b = r.nextInt(10);
                c = r.nextInt(10) + difficult;
                d = r.nextInt(10);
                System.out.println("Найдите Сумму чисел: " +aa +"*"+"( 10 *"+b +")" + "+"+ c +"*(10 * "+d+")");
                int f = aa * (10 * b) + c * (10 * d);
                ans = s.nextInt();
                if (f == ans) {
                    System.out.println("'Ну ладно в этот раз я тебя не видел'- говорит Заучка и уходит");
                    return true;
                }
                System.out.println("АХААААА Ты бежишь.Минус жизнь");
                return false;

        }
        return false;


    }
}
