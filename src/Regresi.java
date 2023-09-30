import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
public class Regresi {
    // public void regresi(){
    public static double tempvalue(Matriks mainmatriks,int column1,int column2){
        //return sum of Xcolumn1 * Xcolumn2
        double tempval=0;
        int baris;
        for (baris=0;baris<mainmatriks.getLastIdxRow()+1;baris++){
            tempval+=mainmatriks.mat[baris][column1]*mainmatriks.mat[baris][column2];
            
        }
        return tempval;
    }
    public static void main(String[] args){
        double temp;
        int var,sampel;
        int baris,kolom;
        Scanner in = new Scanner(System.in);
        //input X because it won't let me input it down below:
        System.out.println("");
        System.out.println("Nilai inputan X?");
        System.out.print("--> ");
        double X;
        X = in.nextDouble();

        //input variables and samples
        System.out.println("Jumlah variable peubah x dan hasil y:");
        System.out.print("--> ");
        var = in.nextInt();
        System.out.println("Jumlah sampel:");
        System.out.print("--> ");
        sampel = in.nextInt();

        //input datamain
        System.out.println("Input matrix:");
        System.out.println("*Input format x1 | x2 | x.. | y ");
        Matriks datamain = new Matriks(sampel, var);
        datamain.readMatrix();
        
        //insert first column full of 1's for data processing
        Matriks dataproc = new Matriks(sampel, var+1);
        for (baris=0;baris<sampel;baris++){
            for (kolom=0;kolom<var+1;kolom++){
                if (kolom==0){
                    dataproc.mat[baris][kolom]=1;
                }
                else{
                    dataproc.mat[baris][kolom]=datamain.mat[baris][kolom-1];
                }
            }
        }

        //creating the linear equations w/ 
        //Normal Estimation Equation for Multiple Linear Regression
        Matriks hasil = new Matriks(var, var+1);
        hasil.mat[0][0] = sampel;   //to assign ELMT(0,0) with sum of samples avail


        //finish the first row (idx 0)
        for (kolom=0;kolom<var+1;kolom++){
            temp=0;
            for (baris=0;baris<sampel;baris++){
                temp+=dataproc.mat[baris][kolom];
            }
            hasil.mat[0][kolom]=temp;
        }

        //looping to fill in the first hasil column with sum of each var
        for (baris=1;baris<var;baris++){
            hasil.mat[baris][0] = hasil.mat[0][baris];
        }

        //looping for the rest of the row
        int kol;
        for (kolom=1;kolom<var+1;kolom++){//
            temp=0;
            kol=1;
            for (baris=1;baris<var;baris++){
                hasil.mat[baris][kolom] = tempvalue(dataproc,kol,kolom);
                kol++;
            }
        }
        // hasil.displayMatrix();

        //use gauss to form a 
        testCramer tes = new testCramer();
        float[] ans = new float[datamain.getLastIdxCol()];
        ans = tes.testcramer(hasil); 
        //take the X input
        // System.out.println("");
        // System.out.println("Nilai inputan X?");
        // System.out.print("--> ");
        // double X;
        // X = in.nextDouble();
        double result=0;
        System.out.println("---------------------------");
        System.out.print("f(x) = ");
        for (kolom=0;kolom<hasil.getLastIdxCol();kolom++){
            if (kolom!=0){
                result += ans[kolom]*X;
            }
            else{
                result = ans[kolom];
            }
            BigDecimal roundedValue = new BigDecimal(ans[kolom]).setScale(3, RoundingMode.HALF_UP);
            System.out.print(roundedValue);
            if (kolom==1){
                System.out.print("x");
            }
            else if (kolom!=0){
                System.out.print("x" + kolom);
            }
            if (kolom!=hasil.getLastIdxCol()-1){
                System.out.print(" + ");
            }
        }
        System.out.println("");
        String formattedResult = String.format("%.4f", result);
        System.out.println("f("+ X +") = " + formattedResult);
        // in.close();
    }
}
