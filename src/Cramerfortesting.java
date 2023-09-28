// package Algeo01-22012.src;
import java.util.*;

// belom penanganan kasus parametrik dan tidak ada solusi
// belom ada penanganan eror salah input
public class Cramerfortesting {
    // ini harusnya parameter cramer adalah Matriks mainmatrix, hapus new matriks mainmatrix
    // still consider to return a list instead
    // public float[] cramer(){
    public static void main(String[] args){
        //KAMUS GLOBAL
        int baris,kolom,i;
        //Take input from user keyboard
        Scanner in = new Scanner(System.in);
        System.out.println("Berapa ukuran baris dan kolom matriks?");
        System.out.print("Row: ");
        int row = in.nextInt();
        System.out.print("Col: ");
        int col = in.nextInt();
        // in.close();
        //main matrix (from user input)
        Matriks mainmatrix = new Matriks(row,col);
        float[] ans = new float[mainmatrix.getLastIdxCol()+1];
        mainmatrix.readMatrix();
        
        if (mainmatrix.getLastIdxCol()-1 != mainmatrix.getLastIdxRow()){
            System.out.println("Tidak bisa diselesaikan dengan Cramer, matriks tidak persegi");
            for (i=0;i<mainmatrix.getLastIdxCol()+1;i++){
                System.out.println(ans[i]);
            }
        }
        else{
            //create and fill a "b" list for Cramer in a Ax=b 
            Matriks hasil = new Matriks(mainmatrix.getLastIdxRow()+1,1);
            for (baris=0;baris<mainmatrix.getLastIdxRow()+1;baris++){
                hasil.mat[baris][0] = mainmatrix.mat[baris][mainmatrix.getLastIdxCol()];
            }
    
            Matriks mainmatrixnoresult = new Matriks(mainmatrix.getLastIdxRow()+1,mainmatrix.getLastIdxCol());
            for (baris=0;baris<mainmatrix.getLastIdxRow()+1;baris++){
                for (kolom = 0;kolom<mainmatrix.getLastIdxCol();kolom++){
                    mainmatrixnoresult.mat[baris][kolom] = mainmatrix.mat[baris][kolom];
                }
            }
    
            //the determinant for the initial matrix, no switching
            float det = mainmatrixnoresult.determinant();
    
            // temporary matrix
            Matriks temp = new Matriks(mainmatrix.getLastIdxRow()+1, mainmatrix.getLastIdxCol());
            temp.copyMatrix(mainmatrixnoresult);
            
            //create an empty list for determinants
            for (i=0;i<mainmatrix.getLastIdxCol();i++){
                temp.switched(hasil,i);
                ans[i] = temp.determinant()/det;
                temp.copyMatrix(mainmatrixnoresult);
            }
    
            // printing out end variables
            System.out.println("The result of the variables:");
            for (i=0;i<mainmatrix.getLastIdxCol();i++){
                System.out.print("Variable " + (i+1) + ": ");
                String formattedResult = String.format("%.4f", ans[i]);
                System.out.println(formattedResult + " ");
            }   

        }

    }
    
}
