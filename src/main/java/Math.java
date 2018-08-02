
public class Math {

    public static int add (int x, int y){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x+y;
    }

    public static int div (int x, int y){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x/y;
    }
}
