import java.util.*;

public class InterpolasiPolinomial {
    public void interpolasipolinomial(Matriks mainmatrix){
    // public static void main(String[] args){
        //KAMUS LOKAL
        int i,baris,kolom;

        //ALGORITMA
        


        //mainmatrix.gauss();       -- harusnya bakal return list answer-----------------------------------------
        //for progress sake, i'll use cramer to represent gauss function
        testCramer tes = new testCramer();
        float[] ans = new float[mainmatrix.getLastIdxCol()];
        ans = tes.testcramer(mainmatrix); 
        
        //Reading input for X value
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Nilai inputan X?");
        System.out.print("--> ");
        double X = in.nextDouble();
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
}
