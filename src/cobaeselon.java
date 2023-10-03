import java.util.*;
import java.util.jar.Manifest;
public class cobaeselon {
    public static void main(String [] args){
        int i,j;
        //Take input from user keyboard
        Scanner in = new Scanner(System.in);
        System.out.println("Berapa ukuran baris dan kolom matriks?");
        System.out.print("Row: ");
        int row = in.nextInt();
        System.out.print("Col: ");
        int col = in.nextInt();
        Matriks mainmatrix0 = new Matriks(row,col);
        mainmatrix0.readMatrix();

        Matriks mainmatrix = new Matriks( 5, 6);
        mainmatrix.copyMatrix(mainmatrix0);

        double bagi = 0; // hasil bagi
        int bar = 0; // idx baris utama
        int bar2 = 1;
        int kol = 0;
        boolean nol = false; 
        
        
       // Mencari determinan dengan membuat diagonal bawah nol
        for( i = 0; i<mainmatrix.nRows;i++){
            //mambuat fungsi baris utama
            while(bar2<mainmatrix.nRows && bar<mainmatrix.nRows){
                // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
                if (mainmatrix.mat[bar][kol] == 0){
                    mainmatrix.tukerbarisnol(mainmatrix,bar,i);         
                }
                // Mencari hasil bagi dengan baris utama 
                if(mainmatrix.mat[bar][kol]==0){
                    break;
                }else{
                    bagi = mainmatrix.mat[bar2][kol] / mainmatrix.mat[bar][kol];
                    System.out.println("bar2,kol "+mainmatrix.mat[bar2][kol]);
                    System.out.println("bar,kol "+mainmatrix.mat[bar][kol]);
                    System.out.println("bagi "+bagi);
                    
                    // Membuat kolom dibawah elemen pertama baris utama menjadi nol
                    while(kol<mainmatrix.nCols){
                        mainmatrix.mat[bar2][kol] = mainmatrix.mat[bar2][kol] - ((mainmatrix.mat[bar][kol]*bagi));
                        System.out.println("bar,kol  v2 :  "+mainmatrix.mat[bar][kol]);

                        kol++;
                    }
                    kol=0;
                    nol = false;
                    bar2++;
                }
                    // Melakukan loop untuk membuat nol di diagonal bawah di kolom selanjutnya
                // }
            }
            kol+=1;
            bar2 = 0;
            bar+=1;
            bar2 = bar;
            if(bar2<mainmatrix.nRows){
                mainmatrix.tukerbarisnol(mainmatrix, bar2, kol);
                if(mainmatrix.mat[bar2][kol]==0 && kol<mainmatrix.nCols && bar2<mainmatrix.nRows){
                    // mainmatrix.IdxUtamabar2();
                    for(j=0;j<mainmatrix.nCols;j++){
                        i=bar2;
                        if(mainmatrix.mat[i][j]!=0){
                            kol = j;
                            System.out.println(" IdxColUtama2 :"+ kol);
                            break;
                        }
                    }
                }else {
                    bar2= bar+1;
                }
            }
            System.out.print("uji coba eselon : ");
            mainmatrix.displayMatrix();
            
        }
        // mainmatrix.replaceDuplicateRows(mainmatrix);    
        System.out.print("mainmatrixeselon");
        mainmatrix.displayMatrix();
       
/*  MENGUBAH MATRIKS MENJADI ESELON BARIS */  
        double pembagi;
        pembagi = 0;
        for(i = 0; i<mainmatrix.nRows;i++){
            // Mencari nilai tidak 0 pertama untuk dijadikan Pembagi
            int kol2 =0;
            for (kol2=0;kol2< mainmatrix.nCols;kol2++){
                if(mainmatrix.mat[i][kol2]!=0){
                    pembagi = mainmatrix.mat[i][kol2];
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

            // Ubah -0 menjadi 0
            for(int b=0;b<mainmatrix.nRows;b++){
                for (int k=0;k<mainmatrix.nCols;k++){
                    if(mainmatrix.mat[b][k]==-0){
                        mainmatrix.mat[b][k]=0;
                    }
                }
            }
        }       


    }

    
}
