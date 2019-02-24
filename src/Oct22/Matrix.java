package Oct22;


public class Matrix {
    public static void main(String[] args) {
        int array[][] = {{0,1,1,1,0},{0,1,0,1,0},{0,1,1,1,0},{0,0,1,1,0}};
        Node node = new Matrix().findNode(array);
        System.out.println(node.h+"  "+node.v);
    }
    public Node findNode(int array[][]){
        int m = array.length;
        int n = array[0].length;
        int count = 0;
        Node result = new Node(0);
        Node arr[][] = new Node[m][n];
        if(array[0][0]!=0){
            Node temp = new Node(1);
            temp.v = 1;
            temp.h = 1;
            arr[0][0] = temp;
        }else{
            Node temp = new Node(0);
            temp.v = 0;
            temp.h = 0;
            arr[0][0] = temp;
        }
        for (int i = 1; i <m ; i++) {
            if(array[i][0]==0){
                Node temp = new Node(0);
                temp.v = 0;
                temp.h = 0;
                arr[i][0] = temp;
            }else{
                Node temp = new Node(1);
                Node t = arr[i-1][0];
                temp.h = 1;
                temp.v = t.v+1;
                if(count<temp.h+temp.v){
                    count = temp.h+temp.v;
                    result = temp;
                }
                arr[i][0] = temp;
            }
        }
        for (int i = 1; i <n; i++) {
            if(array[0][i]==0){
                Node temp = new Node(0);
                temp.v = 0;
                temp.h = 0;
                arr[0][i] = temp;
            }else{
                Node temp = new Node(1);
                Node t = arr[0][i-1];
                temp.v = 1;
                temp.h = t.h+1;
                if(count<temp.h+temp.v){
                    count = temp.h+temp.v;
                    result = temp;
                }
                arr[0][i] = temp;
            }
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if(array[i][j]==0){
                    Node temp = new Node(0);
                    temp.v = 0;
                    temp.h = 0;
                    arr[i][j] = temp;
                }else{
                    Node temp = new Node(1);
                    Node t = arr[i][j-1];
                    temp.h = t.h+1;
                    Node tt = arr[i-1][j];
                    temp.v = tt.v+1;
                    if(count<temp.h+temp.v){
                        count = temp.h+temp.v;
                        result = temp;
                    }
                    arr[i][j] = temp;
                }
            }
        }

        return result;
    }
}
