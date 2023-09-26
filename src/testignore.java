// import java.util.*;

// class test {
//     int[][] mat;
//     int nRows;
//     int nCols;

//     public Matriks(int rows, int cols) {
//         // Create an empty matrix named mat
//         nRows = rows;
//         nCols = cols;
//         mat = new int[nRows][nCols];
//     }

//     public int getLastIdxRow() {
//         // Get the last index available for the matrix mat row
//         return (nRows - 1);
//     }

//     public int getLastIdxCol() {
//         // Get the last index available for the matrix mat col
//         return (nCols - 1);
//     }

//     public boolean isIdxEff(int i, int j) {
//         // Check if the index is valid for a matrix mat size nRows x nCols
//         return ((i < nRows && i >= 0) && (j < nCols && j >= 0));
//     }

//     public int getElmtDiagonal(int i) {
//         // Return matrix mat[i][i]
//         return this.mat[i][i];
//     }

//     public void copyMatrix(Matriks mat2) {
//         // Copy matrix mat to a new matrix
//         for (int i = 0; i < nRows; i++) {
//             for (int j = 0; j < nCols; j++) {
//                 this.mat[i][j] = mat2.mat[i][j];
//             }
//         }
//     }

//    public void readMatrix() {
//         // Accepting user input for a matrix
//         Scanner in = new Scanner(System.in);
//         System.out.println("Enter matrix elements:");

//         for (int i = 0; i < nRows; i++) {
//             for (int j = 0; j < nCols; j++) {
//                 this.mat[i][j] = in.nextInt();
//             }
//         }
//         in.close();
//     }

//     public void displayMatrix() {
//         // Printing out the matrix
//         System.out.println("Matrix:");
//         for (int i = 0; i < nRows; i++) {
//             for (int j = 0; j < nCols; j++) {
//                 System.out.print(mat[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public void kofaktor(){
//         Matriks m = new Matriks(nRows, nCols);
//         int[] num = new int[4];
//         int bar = 0;
//         int kol = 0;
//         int arr = 0;
//         for (int k = 0; k <3; k++) {
//             for (int i = 0; i < nRows; i++) {
//                 for (int j = 0; j < nCols; j++) {
//                     if (i!=k && j!=kol){
//                         num[arr] = mat[i][j];
//                         arr+=1;
//                     }
//                 }
//             }
//             m.mat[bar][kol] = num[1]*num[3] - num[2]*num[4];
//             if(kol==3){
//                 kol = 0;
//             }
//             else{
//                 kol+=1;
//             }
//             arr =0;
//         }
//     for (int i = 0; i < nRows; i++) {
//         for (int j = 0; j < nCols; j++) {
//            mat[i][j] = m.mat[i][j];
//         }

//     }
//     }

//     public void switched(Matriks M1,int coltoswitch){
//         // inserted a matrix M1 sized 1xM to the desired column coltoswitch in a matrix sized NxM
//         int baris;
//         for (baris=0;baris<nRows;baris++){
//             this.mat[baris][coltoswitch] = M1.mat[baris][0];
//         }
//     }
//     public float cofactorxdeter (int bar, int col){
//         float cofac;
//         int baris,kolom;
//         Matriks mn = new Matriks(nRows-1, nCols-1);

//         int in = 0;
//         for (baris=0;baris<nRows;baris++){
//             int jn = 0;
//             for (kolom=0;kolom<nCols;kolom++){
//                 if (baris==bar){
//                     in = baris-1;
//                 }
//                 else if (kolom==col){
//                     jn = kolom-1;
//                 }
//                 else{
//                     mn.mat[in][jn] = mat[baris][kolom];
//                 }
//                 jn++;
//             }
//             in++;
//         }
//         if ((bar + col)%2==0){
//             cofac = mn.determinant();
//         }
//         else{
//             cofac = mn.determinant()*(-1);
//         }
//         return cofac;
//     }
//     public float determinant(){
//         int kolom;
//         float deter=0;
//         // if there's only 1 element avail
//         if (nRows*nCols == 1) { 
//             deter = (float) mat[0][0];
//         } else {
//             int i = 0;
//             for (kolom=0;kolom<nCols;kolom++) {
//                 deter+=((float) mat[i][kolom])*cofactorxdeter(i, kolom);
//             }
//         }
//         return deter;
//     }
// }