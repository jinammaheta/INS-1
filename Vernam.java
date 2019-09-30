import java.util.Scanner;
/*
PlainText
This Was Me
Key
dasdasdasdd
Encryption:
0	A$S)
Decryption:
This Was Me
*/
public class Vernam {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("PlainText");
        String pt=sc.nextLine();
        System.out.println("Key");
        String key=sc.nextLine();
        String store="";
        int i=0;
        for(char c:pt.toCharArray()){
            store+=(char)(c^key.charAt(i++ %key.length()));
        }
        System.out.println("Encryption:\n"+store);
        i=0;
        String storedec="";
        for(char c:store.toCharArray()){
            storedec+=(char)(c^key.charAt(i++ %key.length()));
        }
        System.out.println("Decryption:\n"+storedec);
    }
}
