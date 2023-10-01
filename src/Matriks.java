import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


class Matriks {
    double[][] mat;
    int nRows;
    int nCols;

    public Matriks(int rows, int cols) {
        nRows = rows;
        nCols = cols;
        mat = new double[nRows][nCols];
    }

    public void openMatrix(String name) {   
        int i,j;
        try {
            Scanner checkmat = new Scanner(new BufferedReader(new FileReader("../test/" + name + ".txt")));
            Scanner matrixfile = new Scanner(new BufferedReader(new FileReader("../test/" + name + ".txt")));
            while(checkmat.hasNextLine()){
                if (this.nRows == 0) {
                    this.nCols = (checkmat.nextLine().trim().split(" ")).length;
                } else {
                    checkmat.nextLine();
                }
                this.nRows += 1;
            } 
            this.mat = new double[nRows][nCols];
            while(matrixfile.hasNextLine()) {
                for (i=0; i < this.nRows; i++) {
                   String[] oneRow = matrixfile.nextLine().trim().split(" ");
                   for (j=0; j < oneRow.length; j++) {
                      this.mat[i][j] = Double.parseDouble(oneRow[j]);
                   }
                }
            }
        } catch (FileNotFoundException e) {
            this.nRows = 0;
            this.nCols = 0;
            System.out.println("File tersebut tidak ditemukan di folder 'test'.");
        }
    }

    public void simpanMatrix (String name, Matriks m){
        try {
            FileWriter fileWriter = new FileWriter("../test/" + name + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("Matriks invers:\n");
            for (int i=0;i<m.nRows;i++) {
                for (int j=0;j<m.nCols;j++) {
                    printWriter.printf("%f ",m.mat[i][j]);
                }
                printWriter.print("\n");
            }
            printWriter.close();
        } catch (IOException e) {
                System.out.print("File tidak dapat disimpan pada folder 'test'. ");
            }
    }

    public void simpanDeter (String name, float det){
        try {
            FileWriter fileWriter = new FileWriter("../test/" + name + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("Determinan matriks = %f", det);
            printWriter.close();
        } catch (IOException e) {
            System.out.print("File tidak dapat disimpan pada folder 'test'. ");
        }
    }

    public void simpanSPL (String name, Matriks m){
        try {
            FileWriter fileWriter = new FileWriter("../test/" + name + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("The result of the variables:\n");
            for (int i=0;i<(m.nRows); i++) {
                printWriter.printf(("Variable " + (i+1) + ": "));
                // Membuat objek DecimalFormat dengan pola dua desimal
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                // Menggunakan format() untuk membulatkan nilai double
                String formattedValue = decimalFormat.format(m.mat[i][0]);
                // Mengubah hasil yang sudah diformat kembali menjadi double 
                double roundedValue = Double.parseDouble(formattedValue);
                printWriter.printf(roundedValue + " \n");
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.print("File tidak dapat disimpan pada folder 'test'. ");
        }
    }

    public int getLastIdxRow() {
        // Get the last index available for the matrix mat row
        return (nRows - 1);
    }

    public int getLastIdxCol() {
        // Get the last index available for the matrix mat col
        return (nCols - 1);
    }

    public boolean isIdxEff(int i, int j) {
        // Check if the index is valid for a matrix mat size nRows x nCols
        return ((i < nRows && i >= 0) && (j < nCols && j >= 0));
    }

    public double getElmtDiagonal(int i) {
        // Return matrix mat[i][i]
        return this.mat[i][i];
    }

    public void copyMatrix(Matriks mat2) {
        // Copy matrix mat to a new matrix
        this.nRows = mat2.nRows;
        this.nCols = mat2.nCols;
        for (int i = 0; i < mat2.nRows; i++) {
            for (int j = 0; j < mat2.nCols; j++) {
                this.mat[i][j] = mat2.mat[i][j];
            }
        }
    }

   public void readMatrix() {
        // Accepting user input for a matrix
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix elements:");

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                mat[i][j] = in.nextDouble();
            }
        }
        in.nextLine();
    }

    public void displayMatrix() {
        // Printing out the matrix
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void kofaktor(){
        Matriks m = new Matriks(nRows, nCols);
        Matriks temp = new Matriks(nRows-1, nCols-1);
        int kol = 0;
        int bar1 = 0;
        int kol1 = 0; 
        int bar = 0;
        for (int k = 0; k <nRows*nCols; k++) {
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    if (i!=bar && j!=kol){
                        temp.mat[bar1][kol1] = mat[i][j];
                        kol1+=1;
                        if (kol1==nCols-1){
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
            if(kol==nCols-1){
                kol = 0;
                bar+=1;
            }
            else{
                kol+=1;
            }
            bar1 =0;
        }
    for (int i = 0; i < nRows; i++) {
        for (int j = 0; j < nCols; j++) {
           mat[i][j] = m.mat[i][j];
        }

    }
    }

    public void switched(Matriks M1,int coltoswitch){
        // inserted a matrix M1 sized 1xM to the desired column coltoswitch in a matrix sized NxM
        int baris;
        for (baris=0;baris<nRows;baris++){
            this.mat[baris][coltoswitch] = M1.mat[baris][0];
        }
    }

    public float cofactorxdeter (int bar, int col){
        float cofac;
        int baris,kolom;
        Matriks mn = new Matriks(nRows-1, nCols-1);

        int in = 0;
        for (baris=0;baris<nRows;baris++){
            int jn = 0;
            for (kolom=0;kolom<nCols;kolom++){
                if (baris==bar){
                    in = baris-1;
                }
                else if (kolom==col){
                    jn = kolom-1;
                }
                else{
                    mn.mat[in][jn] = mat[baris][kolom];
                }
                jn++;
            }
            in++;
        }
        if ((bar + col)%2==0){
            cofac = mn.determinant();
        }
        else{
            cofac = mn.determinant()*(-1);
        }
        return cofac;
    }
    public float determinant(){
        // Determinant for cramer, already included cofactor
        int kolom;
        float deter=0;
        // if there's only 1 element avail
        if (nRows*nCols == 1) { 
            deter = (float) mat[0][0];
        } else {
            int i = 0;
            for (kolom=0;kolom<nCols;kolom++) {
                deter+=((float) mat[i][kolom])*cofactorxdeter(i, kolom);
            }
        }
        return deter;
    }

    
    public float determinan(Matriks m){
        double bagi = 0; // hasil bagi
        int bar = 0; // idx baris utama
        int bar2 = 1;
        int kol = 0;
        boolean nol = true; 
    
    
        // Mencari determinan dengan membuat diagonal bawah nol
        int tukar = 0;
        float det;
        for(int i = 0; i<nRows;i++){
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
        for(int i = 0; i<nCols;i++){
            while(bar2<nRows){
                // Memeriksa apakah elemen dibawah elemen pertama baris utama sudah bernilai nol
                if (m.mat[bar][i] == 0 && !nol){
                    tukerbarisnol(m,bar,i);
                    tukar+=1;          
                }

                // Mencari hasil bagi dengan baris utama 
                bagi = m.mat[bar2][i] / m.mat[bar][i];
            
                // Membuat kolom dibawah elemen pertama baris utama menjadi nol
                while(kol<nCols){
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
        for (int i=0;i<nRows;i++){
            det *= m.mat[i][i];
        }
        for (int i= 0; i<tukar;i++){
            det*=(-1);
        }
        return (det);

    }

    public void transpose(){
        Matriks m = new Matriks(nRows, nCols); 
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

    Matriks kalimatriks(Matriks m1, Matriks m2){
        Matriks m3 = new Matriks(m1.nRows, 1);
        double jum = 0;
        for (int i=0; i<m1.nRows;i++){
            for(int j=0; j<m2.nCols; j++){
                for(int k=0; k<m2.nRows; k++){ 
                    jum += m1.mat[i][k]*m2.mat[k][j];
                }
                double roundedNumber = Math.round(jum * Math.pow(10, 2)) / Math.pow(10, 2);
                m3.mat[i][j] = roundedNumber;;
                jum=0;
            }
    }
    return m3;
    }

    void multiplyByConst(float x){
        for (int i=0; i<nRows;i++){
            for(int j=0; j<nCols; j++){
                double kali = x * mat[i][j];
                double kali2 = Math.round(kali * Math.pow(10, 2)) / Math.pow(10, 2);
                mat[i][j] = kali2;
            }
        }
    }

    void tukerbarisnol(Matriks m,int bar,int kol){
        double[] temp  = new double[m.nCols];
   
        for(int i=bar+1;i<nRows;i++){
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
