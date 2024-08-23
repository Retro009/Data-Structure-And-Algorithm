package BitWiseProblems;

public class Swapbit {
    public static void main(String[] args) {
        System.out.println(swapIthBit(45,4));
    }

    private static int swapIthBit(int num, int i){
        return num ^ (1<<i);
    }
}
