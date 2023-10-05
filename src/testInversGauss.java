import java.text.DecimalFormat;
import java.util.*;
import java.util.jar.Manifest;

public class testInversGauss {
    Matriks invergauss(Matriks mainmatrix0) {
        //KAMUS GLOBAL
        int i,j;
        //Take input from user keyboard
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
        
       
        Matriks mainmatrix = new Matriks(mainmatrix0.nRows, 2*mainmatrix0.nCols);
        Matriks hasil = new Matriks(mainmatrix0.nRows, mainmatrix0.nCols);
        // Membuat matriks ukuran col -1 = bar;
        double det = tempmatrix.determinan(tempmatrix);
        System.out.println("DETERMINAN : "+det);
        if( mainmatrix0.nCols != mainmatrix0.nRows){
            System.out.println("Matriks Singular");
        }else {
            if (det ==0){
                System.out.println("Matriks Singular");
            }else {
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
                // System.out.print("hasil duplikasi");
                mainmatrix.replacingDuplicateRows(mainmatrix);
    
               /*PROSES MENGUBAH MATRIKS DENGAN OBE  */
               /* Mendapatkan matriks segitiga atas */
               double bagi = 0; // hasil bagi
               int bar = 0; // idx baris utama
               int bar2 = 1;
               int kol = 0;
               boolean nol = false; 
               
               // Mencari determinan dengan membuat diagonal bawah nol
               for( i = 0; i<mainmatrix.nCols;i++){

                    while(bar2<mainmatrix.nRows && bar<mainmatrix.nRows){
                        // System.out.println("bar2:"+bar2);
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
                                    System.out.println("[bar][j]"+mainmatrix.mat[bar][j]);

                                    tempJ = j;
                                    System.out.print(tempJ);
                                    break;
                                }
                            }

                           bagi = mainmatrix.mat[bar2][tempJ] / mainmatrix.mat[bar][tempJ];
                           mainmatrix.displayMatrix();
                               
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
        
        // MATRIKS ESELON REDUKSI
        
               bar = mainmatrix.nRows-1-countBar0;
               bar2 =mainmatrix.nRows-countBar0-2;
               for(i=mainmatrix.nRows-countBar0-2;i>=0;i--){
                   // nyari 1 utama, mengenolkan kolom 1 utama
                  
                   int tempJ;
                   tempJ = 0;
                   for(j=0;j<mainmatrix.nCols;j++){
                       if(mainmatrix.mat[bar][j]!=0){
                           // System.out.println("[bar][j]"+mainmatrix.mat[bar][j]);
                           tempJ = j;
                           break;
                       }
                   }
                   while(bar2<mainmatrix.nRows && bar2>=0 && bar>=0){
                       // bagi =1;
                       bagi = mainmatrix.mat[bar2][tempJ]/ mainmatrix.mat[bar][tempJ];
                     
                       // Membuat kolom diatas elemen pertama baris utama menjadi nol
                       kol =0;
        
                       while(kol<mainmatrix.nCols && bar2>=0){
                           // System.out.println(mainmatrix.mat[bar2][kol]+ "-"+ " "+mainmatrix.mat[bar][kol]+ "*"+ bagi);
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

    
    
                System.out.println("MATRIKS INVERS GAUSS : ");
                for(i=0;i<mainmatrix0.nRows;i++){
                    for(j=mainmatrix0.nCols;j<mainmatrix.nCols;j++){
                        System.out.print(mainmatrix.mat[i][j]+" ");
                    }    
                    System.out.print("\n");
                }

                // menyimpan hasil invers
                int k = 0;
                for(i=0;i<mainmatrix0.nRows;i++){
                    for(j=mainmatrix0.nCols;j<mainmatrix.nCols;j++){
                        hasil.mat[i][k] = mainmatrix.mat[i][j];
                        k+=1;
                    }    
                    k=0;
                }

           }

        }
        return(hasil);

    }
    
}
