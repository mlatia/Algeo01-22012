import java.util.Scanner;

    public class maintemplate {
        public static void main(String[] args){
            //KAMUS GLOBAL
            int baris,i;
            //Take input from user keyboard
            Scanner in = new Scanner(System.in);
            System.out.println("Berapa ukuran baris dan kolom matriks?");
            System.out.print("Row: ");
            int row = in.nextInt();
            System.out.print("Col: ");
            int col = in.nextInt();
            // in.close();
            //main matrix (from user input)
            Matriks mainmatrix = new Matriks(row,col);
            mainmatrix.readMatrix();
            
            //create and fill a "b" list for Cramer in a Ax=b 
            Matriks hasil = new Matriks(row,1);
            for (baris=0;baris<row;baris++){
                hasil.mat[baris][0] = mainmatrix.mat[baris][col-1];
            }
            hasil.displayMatrix();

        }
}
