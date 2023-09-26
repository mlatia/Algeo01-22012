import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class matriks {
    float[][] mat;
    int nRows;
    int nCols;

    public matriks(int rows, int cols) {
        nRows = rows;
        nCols = cols;
        mat = new float[nRows][nCols];
    }


    public boolean isMatrixIdxValid(int i, int j) {
        return (i >= 0 && i < nRows && j >= 0 && j < nCols);
    }

    public int getLastIdxRow() {
        return (nRows - 1);
    }

    public int getLastIdxCol() {
        return (nCols - 1);
    }

    public boolean isIdxEff(int i, int j) {
        return ((i < nRows && i >= 0) && (j < nCols && j >= 0));
    }

    public float getElmtDiagonal(int i) {
        return this.mat[i][i];
    }

    public void copyMatrix(int mat2[][]) {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                this.mat[i][j] = mat2[i][j];
            }
        }
    }

   public void readMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix elements:");

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                mat[i][j] = in.nextInt();
            }
        }
    }

    public void displayMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void kofaktor(){
        matriks m = new matriks(nRows, nCols);
        float[] num = new float[4];
        int kol = 0;
        int arr = 0;
        int bar = 0;
        for (int k = 0; k <9; k++) {
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    if (i!=bar && j!=kol){
                        num[arr] = mat[i][j];
                        arr+=1;
                    }
                }
            }

            m.mat[bar][kol] = num[0]*num[3] - num[1]*num[2];
            if ((bar+kol)%2==1){
                m.mat[bar][kol] =  m.mat[bar][kol] * -1;
            }
            if(kol==2){
                kol = 0;
                bar+=1;
            }
            else{
                kol+=1;
            }
            arr =0;
        }
    for (int i = 0; i < nRows; i++) {
        for (int j = 0; j < nCols; j++) {
           mat[i][j] = m.mat[i][j];
        }

    }
    }

    public void transpose(){
        matriks m = new matriks(nRows, nCols); 
        for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    m.mat[j][i] = mat[i][j];
                }
            }
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                mat[i][j] = m.mat[i][j];
            }

        }
    } 

    public float determinan2(matriks m){
        float [][] floatMatrix = new float[m.nRows][m.nCols];
         // Mengubah element matriks menjadi float
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                floatMatrix[i][j] = m.mat[i][j];
            }
        }

        float[][] det = new float[2][2];
        int kol2 = m.nCols;
        int row2 = m.nRows;
        while (kol2>2 && row2>2){
            float [][] temp = new float[row2-2][kol2-2];
            if (kol2>3 && row2>3){
            for (int i = 1; i < nRows-1; i++) {
                for (int j = 1; j < nCols-1; j++) {
                        temp[i-1][j-1] = floatMatrix[i][j];
                    }
                }
            }
            // for (int i = 0; i < nRows-2; i++) {
            //     for (int j = 0; j < nCols-2; j++) {
            //         System.out.println(temp[i][j]);
            //     }
            // }
           
            int row3 = m.nCols-1;
            int kol3 = m.nRows-1;
            float[] num = new float[4];
            int arr = 0;
            float [][] temp2 = new float[row3][kol3];
            while(row3>=row2 && kol3>=row2){
                for (int i=0; i< (row3) ; i++){
                    for (int j=0;j<(kol3);j++){
                        for (int k=i; k< i+2 ; k++){
                            for (int l=j; l<j+2; l++){
                                num[arr] = m.mat[k][l];
                                System.out.println(num[arr]);
                                arr+=1;
                            }
                        }
                        temp2[i][j] = num[0]*num[3] - num[1]*num[2];
                        arr = 0;
                    }
                }
                row3-=1;
                kol3-=1;
            }

            if(row3>3){
            for (int i=0; i< (row2) ; i++){
                for (int j=0;j<(kol2);j++){
                    temp2[i][j] = temp2[i][j] / temp[i][j];
                    }
                }
            }

            if (row2==3){
                for (int i=0; i< 2 ; i++){
                for (int j=0;j<2;j++){
                    det[i][j] = temp2[i][j];
                }
            }
            }
            row2-=2;
            row2-=2;

        }

        if (m.nCols==2){
            for (int i=0; i< 2 ; i++){
                for (int j=0;j<2;j++){
                    det[i][j] = m.mat[i][j];
                }
            }
        }

        float hasil = det[0][0]*det[1][1] - det[0][1]*det[1][0];
        return hasil;

    }
    
    public float determinan(matriks m){
        float bagi = 0; // hasil bagi
        int bar = 0; // idx baris utama
        int bar2 = 1;
        int kol = 0;
        boolean nol = false; 
        float [][] floatMatrix = new float[nRows][nCols];

    // Mengubah element matriks menjadi float
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                floatMatrix[i][j] = m.mat[i][j];
            }
        }
        
    // Mencari determinan dengan membuat diagonal bawah nol
    float det = floatMatrix[0][0];
    for(int i = 0; i<nCols;i++){
        while(bar2<nRows){
            // Mencari hasil bagi dengan baris utama 
            bagi = floatMatrix[bar2][i] / floatMatrix[bar][i];
            // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
            if (floatMatrix[bar][i] == 0){
                nol = true;            
            }
            if(!nol){
            // Membuat kolom dibawah elemen pertama baris utama menjadi nol
            while(kol<nCols){
                floatMatrix[bar2][kol] = floatMatrix[bar2][kol] - ((floatMatrix[bar][kol]*bagi));
                kol++;
            }
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
    // Mengalikan elemen diagonal
    for (int i=1;i<nRows;i++){
        det *= floatMatrix[i][i];
    }
    return (det);

    }

    matriks kalimatriks(matriks m1, matriks m2){
        matriks m3 = new matriks(m1.nRows, 1);
        int jum = 0;
        for (int i=0; i<m1.nRows;i++){
            for(int j=0; j<m2.nCols; j++){
                for(int k=0; k<m2.nRows; k++){ 
                    jum += m1.mat[i][k]*m2.mat[k][j];
                }
                m3.mat[i][j] = jum;
                System.out.println(m3.mat[i][j]);
                jum = 0;
            }
    }
    return m3;
    }

    void multiplyByConst(float x){
        for (int i=0; i<nRows;i++){
            for(int j=0; j<nCols; j++){
                mat[i][j] = x * mat[i][j];
            }
        }
    }

    public void readMatrixFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            int row = 0;

            while ((line = bufferedReader.readLine()) != null && row < mat.length) {
                String[] values = line.split(" ");
                for (int col = 0; col < mat[row].length && col < values.length; col++) {
                    mat[row][col] = Float.parseFloat(values[col]);
                }
                row++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
