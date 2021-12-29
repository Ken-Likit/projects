import java.util.Random;

public class test {
    private static Random rand;


    public static void main(String[] args){
        test b1 = new test();
        System.out.println(b1.randomB());
        System.out.println(b1.randomB());
        System.out.println(b1.randomB());
        System.out.println(b1.randomB());
        System.out.println(b1.randomB());
        System.out.println(b1.randomB());
        System.out.println(b1.randomB());


    }

    public int randomB(){
        int x = (int) (Math.random() * 3);
        return x;
    }
}
