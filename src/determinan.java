public class determinan {
    public float detgaus(Matriks m){
        double bagi = 0; // hasil bagi
        int bar = 0; // idx baris utama
        int bar2 = 1;
        int kol = 0;
        boolean nol = true; 
    
        // Mencari determinan dengan membuat diagonal bawah nol
        int tukar = 0;
        float det;
        for(int i = 0; i<m.nRows;i++){
            if (m.mat[i][0] != 0){
                nol = false;
            }
        }
        if (!nol){
            det = 1;
        }
        else{
            det = 0;
        }
        if(!nol){
        for(int i = 0; i<m.nCols;i++){
            while(bar2<m.nRows){
                // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
                if (m.mat[bar][i] == 0 && !nol){
                    tukerbarisnol(m,bar,i);
                    tukar+=1;          
                }

                // Mencari hasil bagi dengan baris utama 
                bagi = m.mat[bar2][i] / m.mat[bar][i];
            
                // Membuat kolom dibawah elemen pertama baris utama menjadi nol
                while(kol<m.nCols){
                    m.mat[bar2][kol] = m.mat[bar2][kol] - ((m.mat[bar][kol]*bagi));
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

        // Mengalikan elemen diagonal
        for (int i=0;i<m.nRows;i++){
            det *= m.mat[i][i];
        }
        for (int i= 0; i<tukar;i++){
            det*=(-1);
        }
        return (det);

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
}
