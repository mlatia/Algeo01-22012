// package Algeo01-22012.src;
import java.text.DecimalFormat;
import java.util.*;
import java.util.jar.Manifest;



public class gauss{
    
    double[] splgaus(Matriks mainmatrix0){
        //KAMUS GLOBAL
       // SPL memiliki solusi unik
                // ubah ukuran tempmatrix
                int i,j;
        //Take input from user keyboard
        // Scanner in = new Scanner(System.in);
        // System.out.println("Berapa ukuran baris dan kolom matriks?");
        // System.out.print("Row: ");
        // int row = in.nextInt();
        // System.out.print("Col: ");
        // int col = in.nextInt();
        // Matriks mainmatrix0 = new Matriks(row,col);
        // mainmatrix0.readMatrix();
        
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
                    DecimalFormat decimalFormat = new DecimalFormat("#.####");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(mainmatrix0.mat[i][j]);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[i][j]= roundedValue;
                }
            }
        }else{
           for(i=0;i<mainmatrix0.nRows;i++){
                for(j=0;j<mainmatrix.nCols;j++){
                    DecimalFormat decimalFormat = new DecimalFormat("#.############");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(mainmatrix0.mat[i][j]);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[i][j]= roundedValue;
                }
            }
        }
        mainmatrix.replacingDuplicateRows(mainmatrix);
        
        /*PROSES MENGUBAH MATRIKS DENGAN OBE  */
        double bagi = 0; // hasil bagi
        int bar = 0; // idx baris utama
        int bar2 = 1;
        int kol = 0;
        boolean nol = true; 
    
        for( i = 0; i<mainmatrix.nRows;i++){
            if (mainmatrix.mat[i][0] != 0){
                nol = false;
            }
        };
        
        if(!nol){
        for( i = 0; i<mainmatrix.nCols;i++){
            while(bar2<mainmatrix.nRows){
                // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
                if (Math.abs(mainmatrix.mat[bar][i])<=0.001 && !nol){
                    if (!nolsemua(mainmatrix,bar,i)){
                    tukerbarisnol(mainmatrix,bar,i);
                    }        
                }

                // Mencari hasil bagi dengan baris utama 
                if(!nolsemua(mainmatrix, bar, i)){
                bagi = mainmatrix.mat[bar2][i] / mainmatrix.mat[bar][i];
                }
                else{
                    bagi = 0;
                }
            
                // Membuat kolom dibawah elemen pertama baris utama menjadi nol
                while(kol<mainmatrix.nCols){
                    double sel = mainmatrix.mat[bar2][kol] - ((mainmatrix.mat[bar][kol]*bagi));
                    DecimalFormat decimalFormat = new DecimalFormat("#.############");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(sel);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[bar2][kol] = roundedValue;
                    kol++;
                }
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
            }   

        System.out.println("ESELON1:\n ");
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
                    if(pembagi !=0){
                        break;
                    }
                }
            }
            // Bagi satu baris tersebut dengan pembagi
            for(j=0;j<mainmatrix.nCols;j++){
                // mencari 
                if (pembagi!=0){
                    double bagi2 =  mainmatrix.mat[i][j] / pembagi;
                    DecimalFormat decimalFormat = new DecimalFormat("#.#########");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(bagi2);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[i][j] = roundedValue;
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
        Matriks tempmatrix = new Matriks(mainmatrix0.nRows,mainmatrix0.nCols-1);
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
        int countCol0 =0;
        for (i=0;i<mainmatrix.nRows;i++){
            boolean check = true;
            for (j=0;j<mainmatrix.nCols;j++){
                if(mainmatrix.mat[i][j]!=0){
                    check =false;
                    break;
                }
            }
            if(check){
                countCol0++;
            }
            
        }
        System.out.print("HASIL AKHIR\n");
        mainmatrix.displayMatrix();
        
        double[] array = new double[tempmatrix.nCols];
        /* SOLUSI SPL DENGAN UKURAN MATRIKS ROW = COL-1*/        
        if(countCol0 <=1){

            mainmatrix.displayMatrix();
            tempmatrix = new Matriks(mainmatrix.nRows,mainmatrix.nCols-1);
            for(i=0;i<tempmatrix.nRows;i++){
                for(j=0;j<tempmatrix.nCols;j++){
                    tempmatrix.mat[i][j]=mainmatrix.mat[i][j];
                }
            }
            double det = tempmatrix.determinan(mainmatrix);
            if(det ==0){
                double lastIdx = mainmatrix.mat[mainmatrix.nRows-1][mainmatrix.nCols-1];
                    // SPL TIDAK MEMILIKI SOLUSI
                    if(lastIdx !=0){
                        System.out.println("SPL tidak memiliki solusi.");
                    }else {
                        /* SOLUSI PARAMETRIK DENGAN UKURAN MATRIKS ROW = COL-1*/         
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
                                    pengurangNum += mainmatrix.mat[i][j]*matrixNum.mat[j][0];
                                }
                                matrixNum.mat[i][0] = mainmatrix.mat[i][mainmatrix.nCols-1]-(pengurangNum);
                                pengurangNum =0;
                            }
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
                        
            }else{
                // SPL memiliki solusi unik
                // ubah ukuran tempmatrix
                mainmatrix.displayMatrix();
                tempmatrix = new Matriks(mainmatrix.nRows,mainmatrix.nCols-1);
                for(i=0;i<tempmatrix.nRows;i++){
                    for(j=0;j<tempmatrix.nCols;j++){
                        tempmatrix.mat[i][j]=mainmatrix.mat[i][j];
                    }
                }
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
                return array;
            }
            
        }else {
            /* SOLUSI PARAMETRIK DENGAN UKURAN MATRIKS ROW = COL-1*/
            Matriks matrixNum = new Matriks(mainmatrix.nRows,1);
            for (i=0;i<matrixNum.nRows;i++){
                for (j=0;j<matrixNum.nCols;j++){
                    matrixNum.mat[i][j]= 0;
                }
            }
            Matriks matrixString= new Matriks(mainmatrix.nRows, countCol0);
            for (i=0;i<mainmatrix.nRows;i++){
                for (j=0;j<countCol0;j++){
                    matrixString.mat[i][j]= 0;
                }
            }
            double [] arrOfColNol = new double[countCol0];
            for(i=0;i<countCol0;i++){
                arrOfColNol[i]=0;
            }
            bar = 0;
            kol =0;
            boolean check1 = false;
            int Colstring =0;
            bar =0;
            kol=0;
            while(bar<mainmatrix.nCols-1 && kol<mainmatrix.nCols && Colstring<matrixString.nCols){
                if(mainmatrix.mat[bar][kol]==0){
                    matrixNum.mat[kol][0] = 0;
                    //elemen tidak nol pertama pada bar
                    for(j=kol+1;j<mainmatrix.nCols-1;j++){
                        if(mainmatrix.mat[bar][j]!=0){
                            check1 = true;
                            break;
                        }
                    }
                    for(int k = kol;k<j;k++){
                        if(mainmatrix.mat[bar][k]==0){
                            arrOfColNol[Colstring]=k;
                            Colstring++;
                        }
                    }
                    if(check1){
                        kol =j;
                    }
                }
                kol++;
                bar++;    
            }
            i =0;
            while(i<arrOfColNol.length){
                j = (int)arrOfColNol[i] ;
                i++;
            }
            // update matrix string
            i=0;
            j=0;
            Colstring=0;
            for(i=0;i<arrOfColNol.length ; i++){
                for(j=0;j<mainmatrix.nRows;j++){
                    if(j==arrOfColNol[i]){
                        matrixString.mat[j][Colstring] = 1;
                        Colstring++;
                    }
                }
            }
            for(i= mainmatrix.nRows-countBar0-1 ;i>=0;i--){
                double pengurangStr =0;
                double pengurangNum =0;
                j = 0;
                // setiap ganti baris , cari indeks pertamanya dulu baru tentukan arah loopingnya
                int tempJ =0;
                while(j<mainmatrix.nCols){
                    if(mainmatrix.mat[i][j]!=0){
                        tempJ = j;
                        System.out.println("  ,tempJ:"+tempJ);
                        break;
                    }
                    j++;
                }
                for(int kolstr =0 ; kolstr < matrixString.nCols;kolstr++){
                    // looping string untuk input nilai matrixString
                    for(j=mainmatrix.nCols-2;j>tempJ;j--){
                        // System.out.println("mainmatrix[i][j]: "+mainmatrix.mat[i][j]+"matrixstring("+j+","+kolstr+")="+ matrixString.mat[j][kolstr]);
                        pengurangStr += mainmatrix.mat[i][j]*matrixString.mat[j][kolstr];
                    }
                    matrixString.mat[tempJ][kolstr]= -(pengurangStr);
                    pengurangStr =0;
                }
                for(j=mainmatrix.nCols-2;j>i;j--){
                    pengurangNum += mainmatrix.mat[i][j]*matrixNum.mat[j][0];
                }
                matrixNum.mat[tempJ][0] = mainmatrix.mat[i][mainmatrix.nCols-1]-(pengurangNum);
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
                    if( matrixString.mat[i][j]>0 && matrixNum.mat[i][0]!=0){
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
        return array;
    }

    void tukerbarisnol(Matriks m,int bar,int kol){
        double[] temp  = new double[m.nCols];
        
        for(int i=bar+1;i<m.nRows;i++){
            if(m.mat[i][kol]!=0){
                for(int j=0;j<m.nCols;j++){
                    temp[j] = m.mat[i][j];
                }
                for(int j=0;j<m.nCols;j++){
                    m.mat[i][j] = m.mat[bar][j];
                    m.mat[bar][j] = temp[j];
                }
                break;
            }
        }
    }

    boolean nolsemua(Matriks m,int bar,int kol){
        boolean nol = true;
        for(int i=bar+1;i<m.nRows;i++){
            if(m.mat[i][kol]!=0){
                nol=false;
            }
        }
        return nol;
    }

    double[] solusiunik(Matriks mainmatrix0){
        // SPL memiliki solusi unik
                // ubah ukuran tempmatrix
                int i,j;
        //Take input from user keyboard
        // Scanner in = new Scanner(System.in);
        // System.out.println("Berapa ukuran baris dan kolom matriks?");
        // System.out.print("Row: ");
        // int row = in.nextInt();
        // System.out.print("Col: ");
        // int col = in.nextInt();
        // Matriks mainmatrix0 = new Matriks(row,col);
        // mainmatrix0.readMatrix();
        
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
                    DecimalFormat decimalFormat = new DecimalFormat("#.####");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(mainmatrix0.mat[i][j]);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[i][j]= roundedValue;
                }
            }
        }else{
           for(i=0;i<mainmatrix0.nRows;i++){
                for(j=0;j<mainmatrix.nCols;j++){
                    DecimalFormat decimalFormat = new DecimalFormat("#.############");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(mainmatrix0.mat[i][j]);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[i][j]= roundedValue;
                }
            }
        }
        mainmatrix.replacingDuplicateRows(mainmatrix);
        
        /*PROSES MENGUBAH MATRIKS DENGAN OBE  */
        double bagi = 0; // hasil bagi
        int bar = 0; // idx baris utama
        int bar2 = 1;
        int kol = 0;
        boolean nol = true; 
    
        for( i = 0; i<mainmatrix.nRows;i++){
            if (mainmatrix.mat[i][0] != 0){
                nol = false;
            }
        };
        
        if(!nol){
        for( i = 0; i<mainmatrix.nCols;i++){
            while(bar2<mainmatrix.nRows){
                // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
                if (Math.abs(mainmatrix.mat[bar][i])<=0.001 && !nol){
                    if (!nolsemua(mainmatrix,bar,i)){
                    tukerbarisnol(mainmatrix,bar,i);
                    }        
                }

                // Mencari hasil bagi dengan baris utama 
                if(!nolsemua(mainmatrix, bar, i)){
                bagi = mainmatrix.mat[bar2][i] / mainmatrix.mat[bar][i];
                }
                else{
                    bagi = 0;
                }
            
                // Membuat kolom dibawah elemen pertama baris utama menjadi nol
                while(kol<mainmatrix.nCols){
                    double sel = mainmatrix.mat[bar2][kol] - ((mainmatrix.mat[bar][kol]*bagi));
                    DecimalFormat decimalFormat = new DecimalFormat("#.############");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(sel);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[bar2][kol] = roundedValue;
                    kol++;
                }
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
            }   

        System.out.println("ESELON1:\n ");
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
                    if(pembagi !=0){
                        break;
                    }
                }
            }
            // Bagi satu baris tersebut dengan pembagi
            for(j=0;j<mainmatrix.nCols;j++){
                // mencari 
                if (pembagi!=0){
                    double bagi2 =  mainmatrix.mat[i][j] / pembagi;
                    DecimalFormat decimalFormat = new DecimalFormat("#.#########");
                    // Menggunakan format() untuk membulatkan nilai double
                    String formattedValue = decimalFormat.format(bagi2);
                    // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                    double roundedValue = Double.parseDouble(formattedValue);
                    mainmatrix.mat[i][j] = roundedValue;
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
        Matriks tempmatrix = new Matriks(mainmatrix0.nRows,mainmatrix0.nCols-1);
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
        int countCol0 =0;
        for (i=0;i<mainmatrix.nRows;i++){
            boolean check = true;
            for (j=0;j<mainmatrix.nCols;j++){
                if(mainmatrix.mat[i][j]!=0){
                    check =false;
                    break;
                }
            }
            if(check){
                countCol0++;
            }
            
        }
        System.out.print("HASIL AKHIR\n");
        mainmatrix.displayMatrix();
                
        /* SOLUSI SPL DENGAN UKURAN MATRIKS ROW = COL-1*/        
        double[] array = new double[tempmatrix.nCols];
        if(countCol0 <=1){

           tempmatrix = new Matriks(mainmatrix.nRows,mainmatrix.nCols-1);
                for(i=0;i<tempmatrix.nRows;i++){
                    for(j=0;j<tempmatrix.nCols;j++){
                        tempmatrix.mat[i][j]=mainmatrix.mat[i][j];
                    }
                }

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
            
         
          return array;
        }

 } 



