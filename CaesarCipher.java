import java.util.Scanner;
import java.util.*;
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        String s=ss.toUpperCase();
        int k=sc.nextInt();
        System.out.println("For Encrypt Write: enc And Decrypt Write: dec");
        String w=sc.next();
//        System.out.println(w);
        StringBuffer str=new StringBuffer(s);
        for(int i=0;i<s.length();i++){
            if(str.charAt(i)!=' '){
                if(w.equalsIgnoreCase("enc")){
                if((((int)str.charAt(i)+k)%91)>64){
//                System.out.println(((int)str.charAt(i)+k)%91);
                str.setCharAt(i,(char)(((int)str.charAt(i)+k)%91));
                }
                else{
                str.setCharAt(i,(char)((((int)str.charAt(i)+k)%91)+65));  
                }
               }
                else if(w.equalsIgnoreCase("dec")){
//                System.out.println(((int)str.charAt(i)-k)%91);
                  if((((int)str.charAt(i)-k)%91)>64){
                str.setCharAt(i,(char)(((int)str.charAt(i)-k)%91));
                }
                else{
                str.setCharAt(i,(char)((((int)str.charAt(i)-k)%91)+26));  
                }  
                }
            }
        }
        for(int i=0;i<ss.length();i++){
//            System.out.println((int) s.charAt(i));
            if((int) ss.charAt(i)>96){
                str.setCharAt(i,(char) ((int)str.charAt(i)+32));
            }
        }
        System.out.println(str);
    }
}
