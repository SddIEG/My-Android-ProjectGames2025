import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {

    private String image = "\uD83D\uDC69\u200D\uD83C\uDFEB";

    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }

    
    @Override
    public boolean taskMonster(int difficult) {
        System.out.println("ОпаАААААА Математичка ловит вас за руку.Но раз в год и она может быть чуть добрее.Она согласна вас отпусть если решите задачу.Если нет то к ДИРЕКТОРУ");
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;
        int ans;
        b = r.nextInt(3);
        switch (b) {
            case 0:
                int t = r.nextInt(10)+ difficult;
                System.out.println("Дана функция :\n" +
                        "S(t) = t^4/4    +   t ^3/3     -   20.\n" +
                        "t^4 - > Это t степени 4.Тут я незнаю как написать так что получилось так :D");
                System.out.println("(Подсказка : Сначало найдите производную этой функции)");
                System.out.println("Подставьте  t = " + t + " для выражения v(t).В ответе укажите значение v(t)");
                a = (int) Math.pow(t, 4) + (int) Math.pow(t, 3);
               ans = sc.nextInt();
                if (a == ans) {
                    System.out.println("'Беги уже пока я не передумала'- говорит Математичка и гордо зашагала дальше.");
                    return true;
                }
                System.out.println("НУ ВСЕ ЭТО ЗАЛЕТ. Ну что это минус жизнь");
                return false;
            case 1:
                System.out.println("Ты должен найти СУММУ. А + B + C");
                a = (r.nextInt(10) + difficult) * 1000;
                b = r.nextInt(10) + difficult;
                c = r.nextInt(5);
                System.out.println("lg " + a + " + ((cos x * cos x) + (sin x * sin x))" + "*" + b + "^" + c);
                d = (int) (a /10 + 1 *Math.pow(b,c));
                ans = sc.nextInt();
                if (d == ans) {
                    System.out.println("'Беги уже пока я не передумала'- говорит Математичка и гордо зашагала дальше.");
                    return true;
                }
                System.out.println("НУ ВСЕ ЭТО ЗАЛЕТ. Ну что это минус жизнь");
                return false;


            case 2 :

                int[][] aa = new int[3][3];
                int[][] bb = new int[3][3];
                Random r = new Random();
                System.out.println("Это первая матрица");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        aa[i][j] = r.nextInt(10)+ difficult;
                    }
                }
                for (int i = 0; i < aa.length; i++) {
                    for (int j = 0; j < aa[i].length; j++) {
                        System.out.print(aa[i][j] + "  ");
                    }
                    System.out.println();
                }

                System.out.println("Это вторая матрица");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        bb[i][j] = r.nextInt(10)+ difficult;
                    }
                }
                for (int i = 0; i < bb.length; i++) {
                    for (int j = 0; j < bb[i].length; j++) {
                        System.out.print(bb[i][j] + "  ");
                    }
                    System.out.println();
                }
                System.out.println("Тебе нужно вычислить сумму определителей матриц.");

                int tt = ((aa[0][0] * aa[1][1] * aa[2][2]) + (aa[1][0] * aa[2][1] * aa[0][2]) + (aa[0][1] * aa[1][2] * aa[2][0])) - ((aa[2][0] * aa[1][1] * aa[0][2]) + (aa[1][0] * aa[0][1] * aa[2][2]) + (aa[0][0] * aa[2][1] * aa[1][2]));
                int vv = ((bb[0][0] * bb[1][1] * bb[2][2]) + (bb[1][0] * bb[2][1] * bb[0][2]) + (bb[0][1] * bb[1][2] * bb[2][0])) - ((bb[2][0] * bb[1][1] * bb[0][2]) + (bb[1][0] * bb[0][1] * bb[2][2]) + (bb[0][0] * bb[2][1] * bb[1][2]));
                int symma =tt+vv;
                ans = sc.nextInt();
                if (symma == ans) {
                    System.out.println("'Беги уже пока я не передумала'- говорит Математичка и гордо зашагала дальше.");
                    return true;
                }
                System.out.println("НУ ВСЕ ЭТО ЗАЛЕТ. Ну что это минус жизнь");
                return false;

        }
                System.out.println();

        return false;
    }

    public boolean taskMonster() {
        return super.taskMonster(0);
    }

}
