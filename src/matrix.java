import java.util.Scanner;

class matriks {
    int[][] mat;
    int nRows;
    int nCols;

    public matriks(int rows, int cols) {
        nRows = rows;
        nCols = cols;
        mat = new int[nRows][nCols];
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

    public int getElmtDiagonal(int i) {
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
        int[] num = new int[4];
        int bar = 0;
        int kol = 0;
        int arr = 0;
        for (int k = 0; k <3; k++) {
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    if (i!=k && j!=kol){
                        num[arr] = mat[i][j];
                        arr+=1;
                    }
                }
            }
            m.mat[bar][kol] = num[1]*num[3] - num[2]*num[4];
            if(kol==3){
                kol = 0;
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
}