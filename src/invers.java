import java.text.DecimalFormat;

public class invers {
    public void kofaktor(Matriks m1){
        Matriks m = new Matriks(m1.nRows, m1.nCols);
        Matriks temp = new Matriks(m1.nRows-1, m1.nCols-1);
        int kol = 0;
        int bar1 = 0;
        int kol1 = 0; 
        int bar = 0;
        for (int k = 0; k <m1.nRows*m1.nCols; k++) {
            for (int i = 0; i < m1.nRows; i++) {
                for (int j = 0; j < m1.nCols; j++) {
                    if (i!=bar && j!=kol){
                        temp.mat[bar1][kol1] = m1.mat[i][j];
                        kol1+=1;
                        if (kol1==m1.nCols-1){
                            kol1=0;
                            bar1+=1;
                        }
                    }
                }
            }

            m.mat[bar][kol] = temp.determinan(temp);
            if ((bar+kol)%2==1){
                m.mat[bar][kol] =  m.mat[bar][kol] * -1;
            }
            if(kol==m1.nCols-1){
                kol = 0;
                bar+=1;
            }
            else{
                kol+=1;
            }
            bar1 =0;
        }
    for (int i = 0; i < m1.nRows; i++) {
        for (int j = 0; j < m1.nCols; j++) {
           m1.mat[i][j] = m.mat[i][j];
        }

    }
    }

   
    void multiplyByConst(Matriks m, float x){
        for (int i=0; i<m.nRows;i++){
            for(int j=0; j<m.nCols; j++){
                double kali = x * m.mat[i][j];
                double kali2 = Math.round(kali * Math.pow(10, 2)) / Math.pow(10, 2);
                m.mat[i][j] = kali2;
            }
        }
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

    public void transpose(Matriks m){
        Matriks m1 = new Matriks(m.nRows, m.nCols); 
        for (int i = 0; i < m.nRows; i++) {
                for (int j = 0; j < m.nCols; j++) {
                    m1.mat[j][i] = m.mat[i][j];
                }
            }
        for (int i = 0; i < m.nRows; i++) {
            for (int j = 0; j < m.nCols; j++) {
                m.mat[i][j] = m1.mat[i][j];
            }

        }
    } 

    public void inversadj(Matriks m){
        Matriks m2 = new Matriks(m.nRows,m.nCols);
        m2.copyMatrix(m);
        determinan deter = new determinan();
        float det = deter.detgaus(m2);
        if(m.nRows>2){
            kofaktor(m);
            transpose(m);
        }
        else{
            double temp = m.mat[1][1];
            m.mat[1][1] = m.mat[0][0];
            m.mat[0][0] = temp;

            m.mat[1][0] = -m.mat[1][0];
            m.mat[0][1] = -m.mat[0][1];
        }
        multiplyByConst(m,1/det);
    }
    public void inversgauss(Matriks mainmatrix0){
        int i,j;
        Matriks tempmatrix = new Matriks(mainmatrix0.nRows,mainmatrix0.nCols);
        for(i=0;i<mainmatrix0.nRows;i++){
            for(j=0;j<mainmatrix0.nCols;j++){
                DecimalFormat decimalFormat = new DecimalFormat("#.####");
                // Menggunakan format() untuk membulatkan nilai double
                String formattedValue = decimalFormat.format(mainmatrix0.mat[i][j]);
                // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                double roundedValue = Double.parseDouble(formattedValue);
                tempmatrix.mat[i][j]= roundedValue;
            }    
        }
        double det = tempmatrix.determinan(tempmatrix);
        mainmatrix0.displayMatrix();
        if( mainmatrix0.nCols != mainmatrix0.nRows){
            System.out.println("Matriks Singular");
        }else {
            if (det ==0){
                System.out.println("Matriks Singular");
            }else {
                Matriks mainmatrix = new Matriks(mainmatrix0.nRows, 2*mainmatrix0.nCols);
                for(i=0;i<mainmatrix0.nRows;i++){
                    for(j=0;j<mainmatrix0.nCols;j++){
                        DecimalFormat decimalFormat = new DecimalFormat("#.####");
                        // Menggunakan format() untuk membulatkan nilai double
                        String formattedValue = decimalFormat.format(mainmatrix0.mat[i][j]);
                        // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
                        double roundedValue = Double.parseDouble(formattedValue);
                        mainmatrix.mat[i][j]= roundedValue;
                    }    
                }    
                for(i=0;i<mainmatrix.nRows;i++){
                    for(j=mainmatrix0.nCols;j<mainmatrix.nCols;j++){
                        if(i== j-mainmatrix0.nCols){
                            mainmatrix.mat[i][j]=1;
                        }else {
                            mainmatrix.mat[i][j]=0;
                        }
                    }    
                }
                mainmatrix.replacingDuplicateRows(mainmatrix);
                double bagi = 0; // hasil bagi
                int bar = 0; // idx baris utama
                int bar2 = 1;
                int kol = 0;
                boolean nol = false; 
               
               // Mencari determinan dengan membuat diagonal bawah nol
                for( i = 0; i<mainmatrix.nCols;i++){
                        while(bar2<mainmatrix.nRows && bar<mainmatrix.nRows){
                            // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
                        if (mainmatrix.mat[bar][i] == 0){
                            if (mainmatrix.ceknolsemuakolom(mainmatrix, bar2, kol)==false){
                                mainmatrix.tukerbarisnol(mainmatrix,bar,i);  
                            }
                            else{
                                while(mainmatrix.ceknolsemuakolom(mainmatrix,bar,i)==true && i<mainmatrix.nCols-1){
                                    i+=1;
                                }
                            }
                        }
                        // Mencari hasil bagi dengan baris utama 
                        if(mainmatrix.mat[bar][i]==0){
                            break;
                        }else{
                            int tempJ = 0;
                                for(j=0;j<mainmatrix.nCols;j++){
                                    if(mainmatrix.mat[bar][j]!=0){
                                        tempJ = j;
                                        break;
                                    }
                                }
                            bagi = mainmatrix.mat[bar2][tempJ] / mainmatrix.mat[bar][tempJ];
                            //    System.out.println(mainmatrix.mat[bar2][tempJ]+"/"+mainmatrix.mat[bar][tempJ]);
                            //    System.out.println("BAGI "+bagi);
                            // Membuat kolom dibawah elemen pertama baris utama menjadi nol
                            while(kol<mainmatrix.nCols){
                                mainmatrix.mat[bar2][kol] = mainmatrix.mat[bar2][kol] - ((mainmatrix.mat[bar][kol]*bagi));
                                kol++;
                            }
                            kol=0;
                            nol = false;
                            bar2++;
                            // Melakukan loop untuk membuat nol di diagonal bawah di kolom selanjutnya
                        }
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
                            if(pembagi !=0){
                                break;
                            }
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
                // Menghitung banyak baris yang mengandung 0
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
            // MATRIKS ESELON REDUKSI
                bar = mainmatrix.nRows-1-countBar0;
                bar2 =mainmatrix.nRows-countBar0-2;
                for(i=mainmatrix.nRows-countBar0-2;i>=0;i--){
                    // nyari 1 utama, mengenolkan kolom 1 utama
                    int tempJ;
                    tempJ = 0;
                    for(j=0;j<mainmatrix.nCols;j++){
                        if(mainmatrix.mat[bar][j]!=0){
                            tempJ = j;
                            break;
                        }
                    }
                    while(bar2<mainmatrix.nRows && bar2>=0 && bar>=0){
                        bagi = mainmatrix.mat[bar2][tempJ]/ mainmatrix.mat[bar][tempJ];
                        // Membuat kolom diatas elemen pertama baris utama menjadi nol
                        kol =0;
                        while(kol<mainmatrix.nCols && bar2>=0){
                            mainmatrix.mat[bar2][kol] = mainmatrix.mat[bar2][kol] - ((mainmatrix.mat[bar][kol]*bagi));
                            kol++; 
                        }
                        mainmatrix.displayMatrix();
                        kol=0;
                        nol = false;
                        bar2--;
                    }
                    mainmatrix.displayMatrix();
                    kol-=1;
                    bar2 = 0;
                    bar-=1;
                    bar2= bar-1;
                    }
                    // System.out.println("ESELON REDUKSI : ");
                    // mainmatrix.displayMatrix();
                    System.out.println("MATRIKS INVERS GAUSS : ");
                    for(i=0;i<mainmatrix0.nRows;i++){
                        for(j=mainmatrix0.nCols;j<mainmatrix.nCols;j++){
                            System.out.print(mainmatrix.mat[i][j]+" ");
                        }    
                        System.out.print("\n");
                    }
            }

        }
        
    }

}
