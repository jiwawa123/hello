public class BC {
    public static void main(String[] args) {
        for (int i = 0; i < 5 ; i++) {
            System.out.println(i);
            for (int j = 0; j < 5 ; j++) {
                System.out.println("j= "+j);
                if( j == 3)
                    break;
            }
        }
    }
}
