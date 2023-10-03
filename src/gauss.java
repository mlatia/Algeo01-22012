// package Algeo01-22012.src;
import java.util.*;
import java.util.jar.Manifest;

public class gauss {
    
    public static void main(String [] args){
        //KAMUS GLOBAL
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

/* JIKA MATRIKS ELEMEN 1 NYA TERLETAK DI DIAGONAL SEMUA */        
/* PROSES MENGUBAH MATRIKS KE BENTUK nCols-1 = nRows */

        // Membuat matriks ukuran col -1 = bar;
        Matriks mainmatrix = new Matriks(mainmatrix0.nCols-1, mainmatrix0.nCols);
        if((mainmatrix0.nCols-1) > mainmatrix0.nRows){
            for(i=mainmatrix.nRows-mainmatrix0.nRows;i<mainmatrix.nRows;i++){
                for(j=0;j<mainmatrix.nCols;j++){
                    mainmatrix.mat[i][j]=0;
                }
            }
            // copy matrix 
            for(i=0;i<mainmatrix0.nRows;i++){
                for(j=0;j<mainmatrix.nCols;j++){
                    mainmatrix.mat[i][j]= mainmatrix0.mat[i][j];
                }
            }
            mainmatrix.displayMatrix();
        }else{
            mainmatrix.copyMatrix(mainmatrix0);
        }
        System.out.print("hasil duplikasi");
        mainmatrix.replacingDuplicateRows(mainmatrix);
        mainmatrix.displayMatrix();
        // mainmatrix.replaceDuplicateRows(mainmatrix);    
        

/*PROSES MENGUBAH MATRIKS DENGAN OBE  */
/* Mendapatkan matriks segitiga atas */
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

        // ngitung banyak baris yang mengandung 0
        int countBar0 = 0; 
        for (i=0;i<mainmatrix.nRows;i++){
            boolean check = true;
            for (j=0;j<mainmatrix.nCols;j++){
                if(mainmatrix.mat[i][j]!=0){
                    check =false;
                    break;
                }
            }
            if(check){
                countBar0++;
            }
            
        }
        mainmatrix.displayMatrix();

/* SOLUSI SPL DENGAN UKURAN MATRIKS ROW = COL-1*/        
        if((mainmatrix.nCols-1) == mainmatrix.nRows){
            
            if(countBar0 <=1){
                double det = mainmatrix.determinan(mainmatrix);
                if(det ==0){
                    double lastIdx = mainmatrix.mat[mainmatrix.nRows-1][mainmatrix.nCols-1];
                    // SPL TIDAK MEMILIKI SOLUSI
                    if(lastIdx !=0){
                        System.out.println("SPL tidak memiliki solusi.");
                    }else {
                        /* SOLUSI PARAMETRIK DENGAN UKURAN MATRIKS ROW = COL-1*/         
                        System.out.println("Parametrik :");
                        mainmatrix.displayMatrix();
                        Matriks matrixNum = new Matriks(mainmatrix.nRows,1);
                        for (i=0;i<matrixNum.nRows;i++){
                            for (j=0;j<matrixNum.nCols;j++){
                                matrixNum.mat[i][j]= 0;
                            }
                        }
                        // Membuat matriks yang menyimpan variabel
                        Matriks matrixString= new Matriks(mainmatrix.nRows, countBar0);
                        for (i=0;i<mainmatrix.nRows;i++){
                            for (j=0;j<countBar0;j++){
                                matrixString.mat[i][j]= 0;
                            }
                        }
                        for(i= mainmatrix.nRows-1 ;i>=0;i--){
                            double pengurangStr =0;
                            double pengurangNum =0;
                            if ((mainmatrix.nRows-1-countBar0)<i){ 
                                matrixString.mat[i][i-mainmatrix.nRows+countBar0] =1; // ngisi nilai 1 ke baris index 4,5 atau ke pemisalan variabel baru
                                // matrixString.displayMatrix();
                                matrixNum.mat[i][0] = 0; // ngisi 0 ke variabel pemisalan baru 
                                // matrixNum.displayMatrix();
                            }else {// i = 3,2,1,0 
                                // MATRIKS STRING
                                for(int kolstr =0 ; kolstr < matrixString.nCols;kolstr++){
                                    // looping string untuk input nilai matrixString
                                    for(j=mainmatrix.nCols-2;j>i;j--){
                                        pengurangStr += mainmatrix.mat[i][j]*matrixString.mat[j][kolstr];
                                    }
                                    matrixString.mat[i][kolstr]= -(pengurangStr);
                                    pengurangStr =0;
                                }
                                // MATRIKS NUM
                                for(j=mainmatrix.nCols-2;j>i;j--){
                                    System.out.print("Matriks M Num : ");
                                    pengurangNum += mainmatrix.mat[i][j]*matrixNum.mat[j][0];
                                  
                                    System.out.println(pengurangNum);
                                }
                                matrixNum.mat[i][0] = mainmatrix.mat[i][mainmatrix.nCols-1]-(pengurangNum);
                                pengurangNum =0;
                            }
                            pengurangStr = 0;
                            pengurangNum =0;
                            matrixNum.displayMatrix();
                            matrixString.displayMatrix();
                            // mainmatrix.displayMatrix();
                        }
                        

                        // Solusi SPL 
                        System.out.println("Solusi dari SPL Parametrik :");
                        for (i = 0; i < matrixString.nRows ; i++) {
                            System.out.print("x[" + (i + 1) + "] = " );
                            if(matrixNum.mat[i][0]!=0){
                                System.out.print( matrixNum.mat[i][0]);
                            }
                            nol = true;
                            for(j=0;j<countBar0;j++){
                                if(matrixNum.mat[i][0]>0 && matrixString.mat[i][j]>0){
                                    System.out.print("+");
                                }else {
                                    System.out.print("");
                                }
                                if(matrixString.mat[i][j]!=0){
                                    
                                    if(matrixString.mat[i][j]==1){
                                        System.out.print("t" + (j+1));
                                    }else if(matrixString.mat[i][j]==-1){
                                        System.out.print("-t" + (j+1));
                                    }else{

                                        System.out.print(matrixString.mat[i][j] + "t" + (j+1));
                                    }
                                }
                            }

                            for(j=0;j<matrixString.nCols;j++){
                                if(matrixString.mat[i][j]!=0){
                                    nol = false;
                                    break;
                                }
                            }
                            if(matrixNum.mat[i][0]==0 && nol){
                                System.out.print("0");
                            }
                            System.out.println("");
                        }
                    }
    
                }else{
                    // SPL memiliki solusi unik
                          // ubah ukuran tempmatrix
                    mainmatrix.displayMatrix();
                    Matriks tempmatrix = new Matriks(mainmatrix.nRows,mainmatrix.nCols-1);
                    for(i=0;i<tempmatrix.nRows;i++){
                        for(j=0;j<tempmatrix.nCols;j++){
                            tempmatrix.mat[i][j]=mainmatrix.mat[i][j];
                        }
                    }
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

                }

            }else {

                /* SOLUSI PARAMETRIK DENGAN UKURAN MATRIKS ROW = COL-1*/

                Matriks matrixNum = new Matriks(mainmatrix.nRows,1);
                for (i=0;i<matrixNum.nRows;i++){
                    for (j=0;j<matrixNum.nCols;j++){
                        matrixNum.mat[i][j]= 0;
                    }
                }
                System.out.println("matrixNum :");
                matrixNum.displayMatrix();
                // ngitung 
                int countCol0 =0;
                for (i=0;i<mainmatrix.nCols;i++){
                    boolean check = true;
                    for (j=0;j<mainmatrix.nRows;j++){
                        if(mainmatrix.mat[i][j]!=0){
                            check =false;
                            break;
                        }
                    }
                    if(check){
                        countCol0++;
                    }
                    
                }
                mainmatrix.displayMatrix();
                Matriks matrixString= new Matriks(mainmatrix.nRows, countCol0);
                for (i=0;i<mainmatrix.nRows;i++){
                    for (j=0;j<countCol0;j++){
                        matrixString.mat[i][j]= 0;
                    }
                }
                System.out.println("matrixString :");
                matrixString.displayMatrix();
                
                double [] arrOfColNol = new double[countCol0];
                for(i=0;i<countCol0;i++){
                    arrOfColNol[i]=0;
                }
                bar = 0;
                kol =0;
                boolean check1 = false;
                int Colstring =0;
                while(bar<mainmatrix.nCols-1 && kol<mainmatrix.nCols && Colstring<matrixString.nCols && Colstring<arrOfColNol.length){
                    if(mainmatrix.mat[bar][kol]==0){
                        // cara masukin ke arrayColNol-> masukin arrayNum
                        matrixNum.mat[kol][0] = 0;
                        matrixString.mat[bar][Colstring] =1;
                        // arrOfColNol[Colstring] =Colstring;
                        //elemen tidak nol pertama pada bar
                        for(j=kol;j<mainmatrix.nCols;j++){
                            if(mainmatrix.mat[bar][j]!=0){
                                check1 = true;
                                break;
                            }else{
                                arrOfColNol[Colstring]=j;
                            }
                        }
                        if(check1){
                            kol =j;
                        }
                    }
                    kol++;
                    bar++;
                    Colstring++;
                }

                for(i= mainmatrix.nRows-1 ;i>=0;i--){
                    double pengurangStr =0;
                    double pengurangNum =0;
                    j = 0;
                    // cari indeks pertamanya dulu baru tentukan arah loopingnya
                    int tempJ =0;
                    while(j<mainmatrix.nCols){
                        if(mainmatrix.mat[i][j]!=0){
                            tempJ = j;
                            break;
                        }
                    }
                    for(int kolstr =0 ; kolstr < matrixString.nCols;kolstr++){
                        // looping string untuk input nilai matrixString
                        for(j=mainmatrix.nCols-2;j>tempJ;j--){
                            pengurangStr += mainmatrix.mat[i][j]*matrixString.mat[j][kolstr];
                        }
                        matrixString.mat[i][kolstr]= -(pengurangStr);
                        pengurangStr =0;
                    }
                    // MATRIKS NUM
                    for(j=mainmatrix.nCols-2;j>i;j--){
                        System.out.print("Matriks M Num : ");
                        pengurangNum += mainmatrix.mat[i][j]*matrixNum.mat[j][0];
                    
                        System.out.println(pengurangNum);
                    }
                    matrixNum.mat[i][0] = mainmatrix.mat[i][mainmatrix.nCols-1]-(pengurangNum);
                    pengurangNum =0;
                    pengurangStr = 0;
                    pengurangNum =0;
                    
                }
                // Solusi SPL 
                System.out.println("Solusi dari SPL Parametrik :");
                for (i = 0; i < matrixString.nRows ; i++) {
                    System.out.print("x[" + (i + 1) + "] = " );
                    if(matrixNum.mat[i][0]!=0){
                        System.out.print( matrixNum.mat[i][0]);
                    }
                    nol = true;
                    for(j=0;j<countBar0;j++){
                        if(matrixNum.mat[i][0]>0 && matrixString.mat[i][j]>0){
                            System.out.print("+");
                        }else {
                            System.out.print("");
                        }
                        if(matrixString.mat[i][j]!=0){
                            
                            if(matrixString.mat[i][j]==1){
                                System.out.print("t" + (j+1));
                            }else if(matrixString.mat[i][j]==-1){
                                System.out.print("-t" + (j+1));
                            }else{

                                System.out.print(matrixString.mat[i][j] + "t" + (j+1));
                            }
                        }
                    }

                    for(j=0;j<matrixString.nCols;j++){
                        if(matrixString.mat[i][j]!=0){
                            nol = false;
                            break;
                        }
                    }
                    if(matrixNum.mat[i][0]==0 && nol){
                        System.out.print("0");
                    }
                    System.out.println("");
                }
    
            }
        }
    }
}