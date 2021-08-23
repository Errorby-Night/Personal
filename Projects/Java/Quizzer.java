import java.io.*;
import java.util.*;
class Quizzer{
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
            System.out.println("----------------------Welcome to Quizzer-----------------");
            System.out.printf("You will be given a number of questions.%nEach of which has one marks.%nYou can answer until you give a wrong answer.%n");
            System.out.println("----------------------------------------------------------------");
            System.out.println("----------------------Start----------------------");
            ArrayList<String> que = new ArrayList<String>();
            ArrayList<String> ans = new ArrayList<String>();
            que = storeq();
            ans = storea();
            int marks=0;
            int f=0,i=randomly(que.size());
            while(f==0){
                System.out.println(que.get(i));
                System.out.print("Your Answer: ");
                String s=sc.nextLine();
                if(s.equalsIgnoreCase(ans.get(i))){
                    System.out.println("Correct Answer");
                    marks+=1;
                    i=randomly(que.size());
                }
                else{
                    System.out.println("Wrong Answer");
                    System.out.println("Correct Answer is: "+ans.get(i));
                    System.out.println("Your score:" + marks);//"Correct Answer is: "+ans[i] != null
                    f=1;
                }
            }
            System.out.println("----------------------End----------------------");
            System.out.println("Do you want to continue?(1/0)");
        sc.close();
    }
    /*public static int size(String filename)throws NoSuchElementException,IllegalArgumentException,FileNotFoundException{
        FileReader fr = new FileReader(filename);
        Scanner sc = new Scanner(fr);
        int c=0;
        while(sc.hasNext()){
            c++;
        }
            sc.close();
        return c;
    }*/
    public static ArrayList<String> storeq()throws FileNotFoundException{
        ArrayList<String> s = new ArrayList<String>();
        FileReader fr = new FileReader("D:/Program/Projects/Java/Questions.txt");
        Scanner sc = new Scanner(fr);
        while(sc.hasNext()){
            s.add(sc.nextLine());
        }
        sc.close();
        return s;
    }
    public static ArrayList<String> storea()throws FileNotFoundException{
        ArrayList<String> s = new ArrayList<String>();
        FileReader fr = new FileReader("D:/Program/Projects/Java/Answer.txt");
        Scanner sc = new Scanner(fr);
        while(sc.hasNext()){
            s.add(sc.nextLine());
        }
        sc.close();
        return s;
    }
    public static int randomly(int c){
        c=c-1;
        return ((int)(Math.random()*(c-1)+1));
    }
}
