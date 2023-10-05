import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;



public class InterpolasiPolinomial {
    public void interpolasipolinomial(Matriks mainmatrix, double X, boolean print){
    // public static void main(String[] args){
        //KAMUS LOKAL
        int i,baris,kolom;

        //ALGORITMA
        


        //mainmatrix.gauss();       -- harusnya bakal return list answer-----------------------------------------
        //for progress sake, i'll use cramer to represent gauss function
        testCramer tes = new testCramer();
        gauss gs = new gauss();
        double[] ans = new double[mainmatrix.getLastIdxCol()];
        mainmatrix.displayMatrix();
        ans = gs.solusiunik(mainmatrix);
        double result=0;
        if(!print){
            System.out.println("---------------------------");
            System.out.print("f(x) = ");
            for (kolom=0;kolom<mainmatrix.getLastIdxCol();kolom++){
                result += ans[kolom]* (Math.pow(X,kolom));
                System.out.print(ans[kolom]);
                if (kolom==1){
                    System.out.print("x");
                }
                else if (kolom!=0){
                    System.out.print("x^" + kolom);
                }
                if (kolom!=mainmatrix.getLastIdxCol()-1){
                    System.out.print(" + ");
                }
            }
            System.out.println("");
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            // Menggunakan format() untuk membulatkan nilai double
            String formattedValue = decimalFormat.format(result);
            // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
            double roundedValue = Double.parseDouble(formattedValue);
            System.out.println("f("+ X +") = " + roundedValue);
        }

        else{
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the file name in test folder without '.txt': ");
            String name = in.next();
            try {
            FileWriter fileWriter = new FileWriter("../test/" + name + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("f(x) = ");
            for (kolom=0;kolom<mainmatrix.getLastIdxCol();kolom++){
                result += ans[kolom]* (Math.pow(X,kolom));
                printWriter.print(ans[kolom]);
                if (kolom==1){
                    printWriter.print("x");
                }
                else if (kolom!=0){
                    printWriter.print("x^" + kolom);
                }
                if (kolom!=mainmatrix.getLastIdxCol()-1){
                    printWriter.print(" + ");
                }
            }
            printWriter.print("\n");
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            // Menggunakan format() untuk membulatkan nilai double
            String formattedValue = decimalFormat.format(result);
            // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
            double roundedValue = Double.parseDouble(formattedValue);
            printWriter.print("f("+ X +") = " + roundedValue);
            printWriter.close();
            } catch (IOException e) {
                    System.out.print("File tidak dapat disimpan pada folder 'test'. ");
                }
        }

    }
}
