/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Shwartskopff
 */
public class DoubleInterval {
    private static final double accur = 100;
     
     public static double meth(Function function, double a, double b, double c, double d, double accur) {
       while(a < b || c < d) {
            double l = (b - a)/100;
            double m = (d - c)/100;
            double sumS = 0;
            double r = a;
            
            for(int i=0; i<accur; i++) {  
                 r += l;
                 double t =c;
                for(int j=0; j<accur; j++) {
                    t += m;
                    double S = l*m*function.f(r - l/2 , t - m/2);
                    sumS += S;
             } 
           }return sumS;
        } return 0;
     }

     
     private static class Duble implements Function {
        @Override
        public double f(double x, double y) {
           return (x*x +x)*(2*y+1);
        }
    }
      
      public  static double s(double x, double y) {
             return Math.sin(x*y)*x*y;
         }
      
      public static double exp(double x, double y) {
             return Math.exp(-x*y);
         }
     
     
     public static void main(String[] args) {
       Function f1 = new Function() {
        @Override
        public double f(double x, double y) {
                return x*y;
            }
        };
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью анонимного класса: ");
        System.out.println(meth(f1, 1, 3, 1, 3, accur));
        
        
        Function f2 = (double x, double y) -> x*x+y*y*y;
        System.out.println("");
        System.out.println("Реализация интерфейса с помощью лямбда выражения: ");
        System.out.println(meth(f2, 1, 3, 1, 2, accur));
       
        
        Function f3 = new Duble();
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью вложенного класса: ");
        System.out.println(meth(f3, 3, 4, 7, 10, accur));
        
        
        
        Function f4 = DoubleInterval::exp;  
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью ссылки на на статический метод: ");
        System.out.println(meth(f4, 0.01, 2, 0.5, 4, accur));
        
        
       
        Function f5 = DoubleInterval::s; 
        System.out.println("");
        System.out.println("Реализация интерфеса с помощью ссылки на метод экземпляра: ");
        System.out.println(meth(f5, 0, 1, 0, 1, accur));
        
       
        
     }
}
