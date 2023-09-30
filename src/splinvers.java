import java.text.DecimalFormat;

public class splinvers {
    public Matriks hasilsplinvers(Matriks m){
        Matriks hasil = new Matriks(m.getLastIdxRow()+1,1);
        for (int i=0;i<m.getLastIdxRow()+1;i++){
            hasil.mat[i][0] = m.mat[i][m.getLastIdxCol()];
        }
        Matriks mainmatrix = new Matriks(m.getLastIdxRow()+1,m.getLastIdxCol());
        for (int i=0;i<m.getLastIdxRow()+1;i++){
            for (int j = 0;j<m.getLastIdxCol();j++){
                mainmatrix.mat[i][j] = m.mat[i][j];
            }
        }

        invers inv = new invers();
        Matriks var = new Matriks(m.nRows, 1);
        inv.inversadj(mainmatrix);
        var = kalimatriks(mainmatrix, hasil);
        System.out.println("The result of the variables:");
        for (int i=0;i<m.nRows;i++){
            System.out.print("Variable " + (i+1) + ": ");
            // Membuat objek DecimalFormat dengan pola dua desimal
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            // Menggunakan format() untuk membulatkan nilai double
            String formattedValue = decimalFormat.format(var.mat[i][0]);
            // Mengubah hasil yang sudah diformat kembali menjadi double (jika diperlukan)
            double roundedValue = Double.parseDouble(formattedValue);
            System.out.println(roundedValue + " ");
        }
        return var;
       
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
}
