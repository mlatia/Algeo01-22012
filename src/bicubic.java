import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class bicubic {
    public double hasilbicubic(Matriks m, double x, double y, boolean print){
        Matriks mx = new Matriks(16,16);
        int bar = 0;
        int kol = 0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int i2=0;i2<4;i2++){
                    for(int j2=0;j2<4;j2++){
                        mx.mat[bar][kol] = Math.pow(i,i2)*Math.pow(j,j2);
                        kol+=1;
                    }
                }
                bar+=1;
                kol=0;
            }
        }

        kol=1;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int i2=0;i2<4;i2++){
                    for(int j2=1;j2<4;j2++){
                        mx.mat[bar][kol] = j2*Math.pow(i,j2-1)*Math.pow(j,i2);
                        kol+=1;
                        if(kol%4==0){
                            kol+=1;
                        }
                    }
                }
                bar+=1;
                kol=1;
            }
        }
        Matriks temp = new Matriks(1,16);
        for(int i=0;i<16;i++){
            temp.mat[0][i] = mx.mat[8][i];
            mx.mat[8][i] =mx.mat[9][i];
            mx.mat[9][i] = temp.mat[0][i];
        }

        kol=4;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int i2=1;i2<4;i2++){
                    for(int j2=0;j2<4;j2++){
                        mx.mat[bar][kol] = i2*Math.pow(i,j2)*Math.pow(j,i2-1);
                        kol+=1;
                    }
                }
                bar+=1;
                kol=4;
            }
        }
        for(int i=0;i<16;i++){
            temp.mat[0][i] = mx.mat[9][i];
            mx.mat[9][i] =mx.mat[10][i];
            mx.mat[10][i] = temp.mat[0][i];
        }

        kol = 0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int i2=0;i2<4;i2++){
                    for(int j2=0;j2<4;j2++){
                        if(i2!=0 && j2!=0){
                            mx.mat[bar][kol] = i2*j2*Math.pow(i,i2-1)*Math.pow(j,j2-1);
                            kol+=1;
                        }
                        else{
                            kol+=1;
                        }
                    }
                }
                bar+=1;
                kol=0;
            }
        }
        
        // ubah matriks input ke bentuk 1x16
        Matriks val2 = new Matriks(16,1);
        int value = 0;
        for (int i=0;i<4;i++){
            for(int j =0;j<4;j++){
                val2.mat[value][0] = m.mat[i][j];
                value++;
            }
        }

        // invers matriks X
        Matriks mx2 = new Matriks(16,16);
        mx2.copyMatrix(mx);
        float det = mx2.determinan(mx2);
        mx.kofaktor();
        mx.transpose();
        mx.multiplyByConst(1/det);
        Matriks a = new Matriks(16,1);

        // perkalian matriks X dan input
        a = a.kalimatriks(mx,val2);

        Matriks a44 = new Matriks(4,4);
        int k = 0;
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                a44.mat[j][i] = a.mat[k][0];
                k++;
            }
        }

       
        double hasil=0;
       
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                hasil += a44.mat[i][j]*Math.pow(x,i)*Math.pow(y,j);
            }
        }

        if(!print){
            System.out.println("f("+x+","+y+") = "+hasil);
        }
        
        else{
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the file name in test folder without '.txt': ");
            String name = in.next();
            try {
            FileWriter fileWriter = new FileWriter("../test/" + name + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(("f("+x+","+y+") = "+hasil));
            
            printWriter.close();
            } catch (IOException e) {
                    System.out.print("File tidak dapat disimpan pada folder 'test'. ");
                }
        }

        return hasil;
    }
}
