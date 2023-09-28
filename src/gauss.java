// package Algeo01-22012.src;
import java.util.*;

public class gauss {
    
    public static void main(String[] args){
        // public 
        //KAMUS GLOBAL
        int i,j;
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

/*PROSES MENGUBAH MATRIKS DENGAN OBE  */
/* Mendapatkan matriks segitiga atas */
        double bagi = 0; // hasil bagi
        int bar = 0; // idx baris utama
        int bar2 = 1;
        int kol = 0;
        boolean nol = false; 
        
        
       // Mencari determinan dengan membuat diagonal bawah nol
        for( i = 0; i<mainmatrix.nCols;i++){
            while(bar2<mainmatrix.nRows){
            // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
                if (mainmatrix.mat[bar][i] == 0){
                    mainmatrix.tukerbarisnol(mainmatrix,bar,i);         
                }
                mainmatrix.displayMatrix();

                // Mencari hasil bagi dengan baris utama 
                bagi = mainmatrix.mat[bar2][i] / mainmatrix.mat[bar][i];
                // System.out.print("bagi ",bagi);
                    
                // Membuat kolom dibawah elemen pertama baris utama menjadi nol
                while(kol<mainmatrix.nCols){
                    mainmatrix.mat[bar2][kol] = mainmatrix.mat[bar2][kol] - ((mainmatrix.mat[bar][kol]*bagi));
                    kol++;
                }
                mainmatrix.displayMatrix();
                kol=0;
                nol = false;
                bar2++;
                // Melakukan loop untuk membuat nol di diagonal bawah di kolom selanjutnya
            }
            kol+=1;
            bar2 = 0;
            bar+=1;
            bar2= bar+1;
        }
       
/*  MENGUBAH MATRIKS MENJADI ESELON BARIS */  
        double pembagi;
        pembagi = 0;
        for(i = 0; i<mainmatrix.nRows;i++){
            // Mencari nilai tidak 0 pertama untuk dijadikan Pembagi
            int kol2 =0;
            for (kol2=0;kol2< mainmatrix.nCols;kol2++){
                if(mainmatrix.mat[i][kol2]!=0){
                    pembagi = mainmatrix.mat[i][kol2];
                    System.out.print("pembagi : " );
                    System.out.println( pembagi);

                    break;
                }
            }
            // Bagi satu baris tersebut dengan pembagi
            for(j=0;j<mainmatrix.nCols;j++){
                // mencari 
                if (pembagi!=0){
                    mainmatrix.mat[i][j] /= pembagi;
                }else {
                    i++;// lanjut baris selanjutnya
                }
            }
            mainmatrix.displayMatrix();

            // Ubah -0 menjadi 0
            for(int b=0;b<mainmatrix.nRows;b++){
                for (int k=0;k<mainmatrix.nCols;k++){
                    if(mainmatrix.mat[b][k]==-0){
                        mainmatrix.mat[b][k]=0;
                    }
                }
            }
        }
        
        // ubah ukuran tempmatrix
        Matriks tempmatrix = new Matriks(row,col-1);
        mainmatrix.displayMatrix();
        tempmatrix.copyMatrix(mainmatrix);
        
        if((mainmatrix.nCols-1) == mainmatrix.nRows){
            double lastIdx = tempmatrix.mat[tempmatrix.nRows-1][tempmatrix.nCols-1];
            System.out.print("index pojok : ");
            System.out.println(lastIdx);
            double det = mainmatrix.determinan(mainmatrix);
            System.out.print("Determinant of the matrix is: " );
            System.out.println(det);
            System.out.print("tempmatrix " );
            tempmatrix.displayMatrix();
            
            if(det ==0){
                // solusi param
            }
            else {// mencari solusi setelah didapat matriks eselon baris
                
                System.out.println(lastIdx);

                // SPL tidak memiliki solusi
                if(lastIdx==0){
                    System.out.println("Matriks have no solution.");
                }

                // SPL memiliki solusi unik
                else {
                    // array untuk menyimpan solusi 
                    double[] array = new double[tempmatrix.nCols];
                    System.out.print("banyak solusi : ");
                    System.out.println(array.length);
                    int barSolusi;
                    for(barSolusi=0;barSolusi<tempmatrix.nRows;barSolusi++){
                        array[barSolusi] = tempmatrix.mat[barSolusi][tempmatrix.nCols - 1];
                    }
                    // loopingnya dri bawah membentuk segitiga atas
                    for (i=tempmatrix.nRows -1 ;i>=0;i--){
                        double pembilangSol =0;
                        // i =3,2,1,0
                        for (j = tempmatrix.nCols -1; j>i;j--){
                            // 3,2,1
                            pembilangSol += tempmatrix.mat[i][j]*array[j];
                            System.out.print("pembiangSol : ");
                            System.out.println(pembilangSol);
                        }
                        // System.out.println(Arrays.toString(array));

                        if (i == tempmatrix.nRows -1){
                            array[i] = mainmatrix.mat[mainmatrix.nRows -1][mainmatrix.nCols -1];
                            System.out.println(i);
                            // System.out.println(Arrays.toString(array));
                        }
                        else {
                            array[i] = ((mainmatrix.mat[i][mainmatrix.nCols-1])-pembilangSol);
                        }
                        // refresh niai pembilangSol
                        pembilangSol = 0;
                    }
                    tempmatrix.displayMatrix();
                    // print solusi matriks dengan solusi unik
                    System.out.println("Solusi dari SPL :");
                    for (i = 0; i < array.length ; i++) {
                        System.out.println("x[" + (i + 1) + "] = " + array[i]);
                    }
                    // System.out.println(Arrays.toString(array));

                }
            }
        }
        else {
            System.out.println("test");
        }

    }
}