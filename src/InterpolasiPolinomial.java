import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;



public class InterpolasiPolinomial {
    public void interpolasipolinomial(Matriks mainmatrix, double X, boolean print){
    // public static void main(String[] args){
        //KAMUS LOKAL
        int i,baris,kolom;

        //ALGORITMA
        


        //mainmatrix.gauss();       -- harusnya bakal return list answer-----------------------------------------
        //for progress sake, i'll use cramer to represent gauss function
        testCramer tes = new testCramer();
        float[] ans = new float[mainmatrix.getLastIdxCol()];
        mainmatrix.displayMatrix();
        ans = tes.testcramer(mainmatrix); 
        
        if(!print){
            float result=0;
            System.out.println("---------------------------");
            System.out.print("f(x) = ");
            for (kolom=0;kolom<mainmatrix.getLastIdxCol();kolom++){
                result += ans[kolom]* (float) (Math.pow(X,kolom));
                System.out.print(ans[kolom]);
                if (kolom==1){
                    System.out.print("x");
                }
                else if (kolom!=0){
                    System.out.print("x^" + kolom);
                }
                if (kolom!=mainmatrix.getLastIdxCol()-1){
                    System.out.print(" + ");
                }
            }
            System.out.println("");
            String formattedResult = String.format("%.4f", result);
            System.out.println("f("+ X +") = " + formattedResult);
        }

        else{
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the file name in test folder without '.txt': ");
            String name = in.next();
            try {
            FileWriter fileWriter = new FileWriter("../test/" + name + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            float result=0;
            printWriter.print("f(x) = ");
            for (kolom=0;kolom<mainmatrix.getLastIdxCol();kolom++){
                result += ans[kolom]* (float) (Math.pow(X,kolom));
                printWriter.print(ans[kolom]);
                if (kolom==1){
                    printWriter.print("x");
                }
                else if (kolom!=0){
                    printWriter.print("x^" + kolom);
                }
                if (kolom!=mainmatrix.getLastIdxCol()-1){
                    printWriter.print(" + ");
                }
            }
            printWriter.print("");
            String formattedResult = String.format("%.4f", result);
            printWriter.print("\n");
            printWriter.print("f("+ X +") = " + formattedResult);
            printWriter.close();
            } catch (IOException e) {
                    System.out.print("File tidak dapat disimpan pada folder 'test'. ");
                }
        }

    }
}
