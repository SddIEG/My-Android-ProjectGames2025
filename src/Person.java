import java.util.Random;

public class Person {
    protected int x, y;
    private String image = "\uD83D\uDC66";
    private int live = 3;
    Random r = new Random();

    Person(int sizeBoard) {
        y = sizeBoard;
        x = 3;
    }

    Person(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLive() {
        return live;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean moveCorrect(int x, int y){
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }

    void move(int x, int y){
        this.x = x;
        this.y = y;
    }



    public void upLive() {
        live++;
        System.out.println("Получена дополнительная жизнь! Теперь у вас: " + live + " жизней");
    }
    public void endLive() {
        live--;
       
    }
}
