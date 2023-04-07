import java.util.Scanner;
import java.util.Arrays;

@SuppressWarnings("Unchecked")
@FunctionalInterface
interface Assign {
    void assignmentOfValues();
}
@FunctionalInterface
interface convert {
    void convertToTwoDimensional();
}
@FunctionalInterface
interface sequenceEntry {
    void sequence();
}
@FunctionalInterface
interface Duplication {
    void Duplicate();
}
class message extends Exception {
    public message(String str) { super(str);}
}
public class Project extends Thread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of machine: ");
        //Please do consider as machine
        int works = sc.nextInt();
        System.out.println("Enter no of Jobs: ");
        //Please do consider as Job
        int machine = sc.nextInt();
        //Project pr = new Project();
        int[][] arr = new int[works][machine];
        System.out.println("Enter the machines Time corresponding to its Jobs: ");
        Assign ass = () -> {
                for (int i = 0; i < works; i++) {
                    for (int j = 0; j < machine; j++) {
                        arr[i][j] = sc.nextInt();
                    }
                }
        };
        ass.assignmentOfValues();
        convert con = () -> {
            if(works < 2){
                try{
                    throw new message("OOPS! Minimum number of Jobs are required to apply the Algorithm");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }else if(works > 2) {
                for (int i = 0; i < machine; i++) {
                    for (int j = 1; j < works - 1; j++)
                        arr[0][i] += arr[j][i];
                    for(int j=2;j<works;j++)
                        arr[1][i] += arr[j][i];
                }
            }

        };
        con.convertToTwoDimensional();
        int[] sequenceMaker = new int[machine];
        for(int i=0;i<machine;i++) {
            if(Math.min(arr[0][i],arr[1][i]) == arr[1][i]) sequenceMaker[i] = arr[1][i];
            else sequenceMaker[i] = arr[0][i];
        }
        Arrays.sort(sequenceMaker);
        int[][] Dupl = new int[2][machine];
        Duplication du = () -> {
            for(int i=0;i<machine;i++){
                Dupl[0][i] = arr[0][i];
                Dupl[1][i] = arr[1][i];
            }
        };
        du.Duplicate();

        int[] sequenceNumber = new int[machine];
        sequenceEntry se = ()-> {
            int z=0,w=machine-1;
            for(int x : sequenceMaker){
                for(int i=0;i<machine;i++) {
                    if(x == Dupl[0][i]) {
                        sequenceNumber[z++] = i+1;
                        Dupl[0][i] = Dupl[1][i] = Integer.MAX_VALUE;
                        break;
                    }else if(x == Dupl[1][i]) {
                        sequenceNumber[w--] = i+1;
                        Dupl[0][i] = Dupl[1][i] = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
        };
        se.sequence();
        for(int i=0;i<machine;i++)
            System.out.print(sequenceNumber[i]+" ");

        
    }
}