
public class invers {
    public void kofaktor(Matriks m1){
        Matriks m = new Matriks(m1.nRows, m1.nCols);
        Matriks temp = new Matriks(m1.nRows-1, m1.nCols-1);
        int kol = 0;
        int bar1 = 0;
        int kol1 = 0; 
        int bar = 0;
        for (int k = 0; k <m1.nRows*m1.nCols; k++) {
            for (int i = 0; i < m1.nRows; i++) {
                for (int j = 0; j < m1.nCols; j++) {
                    if (i!=bar && j!=kol){
                        temp.mat[bar1][kol1] = m1.mat[i][j];
                        kol1+=1;
                        if (kol1==m1.nCols-1){
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
            if(kol==m1.nCols-1){
                kol = 0;
                bar+=1;
            }
            else{
                kol+=1;
            }
            bar1 =0;
        }
    for (int i = 0; i < m1.nRows; i++) {
        for (int j = 0; j < m1.nCols; j++) {
           m1.mat[i][j] = m.mat[i][j];
        }

    }
    }

   
    void multiplyByConst(Matriks m, float x){
        for (int i=0; i<m.nRows;i++){
            for(int j=0; j<m.nCols; j++){
                double kali = x * m.mat[i][j];
                double kali2 = Math.round(kali * Math.pow(10, 2)) / Math.pow(10, 2);
                m.mat[i][j] = kali2;
            }
        }
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

    public void transpose(Matriks m){
        Matriks m1 = new Matriks(m.nRows, m.nCols); 
        for (int i = 0; i < m.nRows; i++) {
                for (int j = 0; j < m.nCols; j++) {
                    m1.mat[j][i] = m.mat[i][j];
                }
            }
        for (int i = 0; i < m.nRows; i++) {
            for (int j = 0; j < m.nCols; j++) {
                m.mat[i][j] = m1.mat[i][j];
            }

        }
    } 

    public void inversadj(Matriks m){
        Matriks m2 = new Matriks(m.nRows,m.nCols);
        m2.copyMatrix(m);
        determinan deter = new determinan();
        float det = deter.detgaus(m2);
        if(m.nRows>2){
            kofaktor(m);
            transpose(m);
        }
        else{
            double temp = m.mat[1][1];
            m.mat[1][1] = m.mat[0][0];
            m.mat[0][0] = temp;

            m.mat[1][0] = -m.mat[1][0];
            m.mat[0][1] = -m.mat[0][1];
        }
        multiplyByConst(m,1/det);
    }
    public void inversgauss(Matriks m){
        
        
    }

}
