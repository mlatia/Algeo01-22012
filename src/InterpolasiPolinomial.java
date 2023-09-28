import java.util.*;

public class InterpolasiPolinomial {
    // public static void interpolasipolinomial(){
    public static void main(String[] args){
        //KAMUS LOKAL
        int i,baris,kolom;

        //ALGORITMA
        //read the sum of points
        Scanner in = new Scanner(System.in);
        System.out.println("Jumlah titik inputan?");
        System.out.print("--> ");
        int titik = in.nextInt();
        
        //read the points while adjusting the matrix
        Matriks mainmatrix = new Matriks(titik,titik+1);
        System.out.println("Masukkan titik");
        System.out.println("*Format masukan: x + 'space' + y");
        System.out.println("---------------------------");
        for (i=0;i<titik;i++){
            System.out.print("Titik ke-" + (1+i) + ": ");
            float x = in.nextFloat();
            float y = in.nextFloat();
            for (kolom=0;kolom<titik+1;kolom++){
                if (kolom!=titik){  //those Ax columns
                    double res = Math.pow(x,kolom);
                    mainmatrix.mat[i][kolom] = (float) res;
                }
                else{   // is the b column
                    mainmatrix.mat[i][kolom] = y;
                }
            }
        }
        mainmatrix.displayMatrix();


        //mainmatrix.gauss();       -- harusnya bakal return list answer-----------------------------------------
        //for progress sake, i'll use cramer to represent gauss function
        testCramer tes = new testCramer();
        float[] ans = new float[titik];
        ans = tes.testcramer(mainmatrix); 
        
        //Reading input for X value
        System.out.println("");
        System.out.println("Nilai inputan X?");
        System.out.print("--> ");
        double X = in.nextDouble();
        float result=0;
        System.out.print("f(x) = ");
        for (kolom=0;kolom<titik;kolom++){
            result += ans[kolom]* (float) (Math.pow(X,kolom));
            System.out.print(ans[kolom]);
            if (kolom==1){
                System.out.print("x");
            }
            else if (kolom!=0){
                System.out.print("x^" + kolom);
            }
            if (kolom!=titik-1){
                System.out.print(" + ");
            }
        }
        System.out.println("");
        String formattedResult = String.format("%.4f", result);
        System.out.println("f("+ X +") = " + formattedResult);
    }
}
