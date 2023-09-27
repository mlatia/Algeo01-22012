import java.util.*;

// belom penanganan kasus parametrik dan tidak ada solusi
// belom ada penanganan eror salah input
public class Cramer {
    // ini harusnya parameter cramer adalah Matriks mainmatrix, hapus new matriks mainmatrix
    // still consider to return a list instead
    // public float[] cramer(){
    public static void main(String[] args){
        //KAMUS LOKAL
        int baris,kolom,i;

        //ALGORITMA
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
        mainmatrix.readMatrix();
        
        //create and fill a "b" list for Cramer in a Ax=b 
        Matriks hasil = new Matriks(row,1);
        for (baris=0;baris<row;baris++){
            hasil.mat[baris][0] = mainmatrix.mat[baris][col-1];
        }

        Matriks mainmatrixnoresult = new Matriks(row,col-1);
        for (baris=0;baris<row;baris++){
            for (kolom = 0;kolom<col-1;kolom++){
                mainmatrixnoresult.mat[baris][kolom] = mainmatrix.mat[baris][kolom];
            }
        }

        //the determinant for the initial matrix, no switching
        float det = mainmatrixnoresult.determinant();

        // temporary matrix
        Matriks temp = new Matriks(row, col-1);
        temp.copyMatrix(mainmatrixnoresult);
        
        //create an empty list for determinants
        float[] ans = new float[col];
        for (i=0;i<col-1;i++){
            temp.switched(hasil,i);
            ans[i] = temp.determinant()/det;
            temp.copyMatrix(mainmatrixnoresult);
        }

        // printing out end variables
        System.out.println("Answers:");
        for (i=0;i<col-1;i++){
            System.out.print("Variable " + (i+1) + ": ");
            String formattedResult = String.format("%.4f", ans[i]);
            System.out.println(formattedResult + " ");
        }
    // return ans;   
    }
    
}
