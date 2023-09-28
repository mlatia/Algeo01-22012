
public class testCramer {
    public float[] testcramer(Matriks mainmatrix){
        //KAMUS LOKAL
        int baris,kolom,i;

        //ALGORITMA
        //Take input from user keyboard
        
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
        float[] ans = new float[mainmatrix.getLastIdxCol()+1];
        for (i=0;i<mainmatrix.getLastIdxCol();i++){
            temp.switched(hasil,i);
            ans[i] = temp.determinant()/det;
            temp.copyMatrix(mainmatrixnoresult);
        }

        // printing out end variables
        System.out.println("Answers:");
        for (i=0;i<mainmatrix.getLastIdxCol();i++){
            System.out.print("Variable " + (i+1) + ": ");
            String formattedResult = String.format("%.4f", ans[i]);
            System.out.println(formattedResult + " ");
        }
    return ans;   
    }
}
