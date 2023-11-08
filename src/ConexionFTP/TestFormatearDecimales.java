/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionFTP;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author admin
 */
public class TestFormatearDecimales {

    public TestFormatearDecimales() {
    }

    public static void main(String args[]) {

//////        TestFormatearDecimales m = new TestFormatearDecimales();
//        DecimalFormat formateador = new DecimalFormat("####.##");
//
//// Esto sale en pantalla con dos decimales, es decir, 3,43
//        System.out.println(formateador.format(3.43242383));
//        
//        double a = 1.2345;
//      double b = 1.2356;
//      
//      DecimalFormat formatter = new DecimalFormat("#.##");
//      
//      System.out.println(formatter.format(a));   // La salida es 1,23
//      System.out.println(formatter.format(b)); 
//        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
//        simbolos.setDecimalSeparator('.');
        DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.GERMANY);
        DecimalFormat formateador = new DecimalFormat("###,###.####", simbolos);
//        DecimalFormat formateador = new DecimalFormat("##.####,##", simbolos);

// Esto sale en pantalla con punto decimal, es decir, 3.4324,
        System.out.println(formateador.format(3432423.83));
    }

}
