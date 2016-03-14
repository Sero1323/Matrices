/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import matrices.Matriz.operaciones;

/**
 *
 * @author serom
 */
public class Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz m = new Matriz (5,5);
        int ma[][] =   {{1,0,0,0},
                        {0,1,0,0},
                        {0,0,1,0},
                        {0,0,0,1}};
        m.matriz = ma;
        m.matriz = operaciones.suma(m.matriz,m.matriz);
        m.multFConst(0,5);
        for (int i = 0; i <  m.matriz.length; i++) {
            for (int j = 0; j <  m.matriz[0].length; j++)
                System.out.print( m.matriz[i][j] + " ");
   
            System.out.print("\n");
        operaciones.suma(m.matriz,m.matriz);
        }
    }
    
}
