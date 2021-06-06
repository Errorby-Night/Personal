//Update 1.1
//Fixing rando
mport java.util.*;
public class I2048 {
    public static int i, j;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a[][]=new int [5][5];
        int f=1;
        while(f==1){
            assign(a);
            display(a);
            System.out.println("To play enter WASD");
            int ch=sc.nextInt();
            if(ch=='W')
                moveW(a);
            if(ch=='A')
                moveA(a);
            if(ch=='S')
                moveS(a);
            if(ch=='D')
                moveD(a);
            else{
                System.out.println("Wrong Input!! Action Terminated");
                f=-1;
            }
        }
    }
    public static int rando(){                                     //                2 OR 4         *Tested* 
        int r = (int)(Math.random()*10);
        while(r!=2 || r!=4){
            if(r==2 || r==4)
                break;
            r = (int)(Math.random()*100);
        }
        return r;
    }
    public static void display(int a[][]){                      // SIMPLE DISPLAY               *Tested*
        for(int k=0; k<5; k++){
            for(int l=0; l<5; l++)
                System.out.print(a[k][l] + " ");
            System.out.println();
        }
    }
    public static void assignval(){                              // GENERATING i AND j          *Tested*
        i = (int)(Math.random()*5);
        j = (int)(Math.random()*5);
        }
    }
    public static void assign(int a[][]){                     //ASSIGNING TO EMPTY PLACE         *Tested*
        int f=-1;
        while(f==-1){
            if(a[i][j]==0){
                f=1;
                break;
            }
            assignval();
        }
        if(f==1)
            a[i][j] = rando();
    }
    //MOVES
    public static void moveW(int a[][]){
       int k=0,c=0;
       while(k<5){
           c=0;
           for(int j=0;j<4;){
                if(a[k][j]==a[k][j+1]){
                    ++c;
                    j+=2;
                }
                else
                    j++;
                    
                if(c!=0){
                    a[k][j]+ = a[k][j+1];
                    continue;
                }
           }
           k++;
       } 
    }
    public static void moveA(int a[][]){

    }
    public static void moveS(int a[][]){

    }    
    public static void moveD(int a[][]){

    }
}
