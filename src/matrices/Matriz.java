/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.awt.Point;

/**
 *
 * @author serom
 */
public class Matriz {
    int [][] matriz;

    public Matriz(int nFilas, int nColumnas)
    {
        matriz = new int [nFilas][nColumnas];
    }
    
    public void multFConst(int nFila, int escalar)
    {
        if (matriz.length > nFila)
            for (int i = 0; i < matriz[nFila].length; i++)
                matriz[nFila][i] = matriz[nFila][i]*escalar;
    }
    
    public void cambioFilas(int nFilaA, int nFilaB)
    {
        if (matriz.length > nFilaA)
        {
            int[] backup = matriz[nFilaA].clone();
            for (int i = 0; i < matriz[nFilaA].length; i++) {
                matriz[nFilaA][i] = matriz[nFilaB][i];
                matriz[nFilaB][i] = backup[i];
            }
        }
    }
    
    public void sumaFila(int nFilaA, int nFilaB, int escalar)
    {
        if (matriz.length > nFilaA)
            for (int i = 0; i < matriz[nFilaA].length; i++)
                matriz[nFilaB][i] += matriz[nFilaA][i]*escalar;
    }
    
    public boolean esIdentidad()
    {
        if (matriz[0].length == matriz.length)
            for (int i = 0; i < matriz.length; i++)
                if (matriz[i][i] != 1)
                    return false;
        return true;       
    }
    public boolean esEscalonReducida()
    {
        Point p = new Point(-1,-1);
        for (int j = 0; j < matriz.length; j++)
            for (int i = 0; i < matriz[j].length; i++) 
                if(matriz[i][j] == 1)
                {
                    if (i < p.y)
                        return false;
                    p.setLocation(j, i);
                    for (int k = 0; k < matriz[j].length; k++)
                        if (i != k && matriz[k][j] != 0)                            
                            return false;
                    
                }
         return true;
    }
    
    public static class operaciones
    {
        
    double determinante(int[][] ma){
        int m[][] = ma.clone();
        for(int k=0; k<ma.length-1; k++)
            for(int i=k+1; i<ma.length; i++)
                for(int j=k+1; j<ma.length; j++)
                    m[i][j]-=m[i][k]*m[k][j]/m[k][k];
        double determinante=1.0;
        for(int i=0; i<ma.length; i++)
            determinante*=m[i][i];
        return determinante;
    }
        
        public static int[][] suma(int[][] m1, int[][] m2)
        {
            int m[][] = m1.clone();
            for (int i = 0; i < m.length; i++)
                for (int j = 0; j < m[0].length; j++)
                    m[i][j] += m2[i][j];
            return m;
        }        
        public static int[][] resta(int[][] m1, int[][] m2)
        {
            int m[][] = m1.clone();
            for (int i = 0; i < m.length; i++)
                for (int j = 0; j < m[0].length; j++)
                    m[i][j] -= m2[i][j];
            return m;
        }
        public static int[][] multConst(int[][] m1, int c)
        {
            int m[][] = m1.clone();
            for (int i = 0; i < m.length; i++)
                for (int j = 0; j < m[0].length; j++)
                    m[i][j] = c*m1[i][j];
            return m;
        }
        public static int[][] multiplicacion(int m1[][], int m2[][])
        {
            int result[][] = new int[m1.length][m2.length];
            for(int i = 0; i < m1.length; i++)
                    for(int j = 0; j < m2.length; j++){
                            int suma = 0;
                            for(int k = 0; k < m2.length; k++)
                                    suma += m1[i][k] * m2[k][j];
                            result[i][j] = suma;
                    }
            return result;
        }
    }

}
