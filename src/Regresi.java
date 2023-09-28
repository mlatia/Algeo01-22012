import java.util.*;

public class Regresi {
    // public void regresi(){
    public static void main(String[] args){
        int var,sampel;
        int baris,kolom;
        Scanner in = new Scanner(System.in);
        System.out.println("Jumlah variable peubah x:");
        System.out.print("--> ");
        var = in.nextInt();
        System.out.println("Jumlah sampel:");
        System.out.print("--> ");
        sampel = in.nextInt();

        //input matrix
        System.out.println("Input matrix:");
        Matriks mainmatrix = new Matriks(sampel, var+1);
        for (baris=0;baris<sampel;baris++){
            mainmatrix.mat[baris][0] = 1;
        }
        for (baris=0;baris<sampel;baris++){
            for (kolom=1;kolom<var+1;kolom++){
                double input = in.nextDouble();
                
                mainmatrix.mat[baris][kolom] = input;
            }
        }

        // mainmatrix.displayMatrix();

        //use gauss to form a 
        
        //take the X input
        System.out.println("");
        System.out.println("Nilai inputan X?");
        System.out.print("--> ");
        double X = in.nextDouble();

    }
}
