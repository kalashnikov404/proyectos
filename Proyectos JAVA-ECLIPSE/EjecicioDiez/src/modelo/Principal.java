package modelo;
import java.util.Scanner;

public class Principal {

	   public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           System.out.println("Ingresa el numero: ");
           int num=sc.nextInt();

           while(!(esPalindromo(num) && esPrimo(num))){
                   num++;
           }
           System.out.println(num);
   }

   private static boolean esPrimo(int num) {
           return divisoresMenores(num)==1;
   }

   private static int divisoresMenores(int num) {
           int cantDivisores=0;
           for (int i=1;i<num;i++){
                   if (num%i==0) cantDivisores++;
           }
           return cantDivisores;
   }

   private static boolean esPalindromo(int num) {
           String s = String.valueOf(num);
           return (s.equals((reversa(s))));

   }

   private static String reversa(String s) {
           String reversa="";
           for (int i=s.length()-1;i>=0;i--){
                   reversa+=String.valueOf(s.charAt(i));
           }
           return reversa;
   }
	}
