import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * 
Enter P:
7
Enter q:
3
Enter h:
2
g:4
Enter X:
5
y:2
Enter K value random  Choose a random integer K such that 1 <= K <= q 
2
r:2
kinverse:-1
Enter M:
3
s:2
w:2
u1:0
u2:1
2 2
Signature Verified
 * @author JayGoga
 */
public class DSA {
    public static void main(String[] args) {
//        BigInteger temp=(g.modPow(k, p)).mod(q);
//        System.out.println(temp);
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter P:");
    BigInteger p=sc.nextBigInteger();
    while(isPrime(p)){
        p=sc.nextBigInteger();
    }
        System.out.println("Enter q:");
    BigInteger q=sc.nextBigInteger();
    while(isPrime(q)&&divisorOf(q,p)){
        q=sc.nextBigInteger();
    }
        System.out.println("Enter h:");
    BigInteger h=sc.nextBigInteger();
    BigInteger g1=(p.subtract(BigInteger.ONE)).divide(q);
    BigInteger g=h.modPow(g1, p);
        System.out.println("g:"+g);
System.out.println("Enter X:");
    BigInteger x=sc.nextBigInteger();
    BigInteger y=g.modPow(x, p);
        System.out.println("y:"+y);
//    BigInteger k=sc.nextBigInteger();
System.out.println("Enter K value random  Choose a random integer K such that 1 <= K <= q ");
        BigInteger k=sc.nextBigInteger();
        BigInteger valid=kinverse(q,k,1);
        while(!valid.equals(BigInteger.ONE)){
        System.out.println("Enter K value random  Choose a random integer K such that 1 <= K <= q ");
            System.out.println("Note: gcd(K, q) = 1");
            k=sc.nextBigInteger();
            valid=kinverse(q,k,1);
        }
    BigInteger r=(g.modPow(k, p)).mod(q);
        System.out.println("r:"+r);
    BigInteger km=kinverse(q,k,0);
        System.out.println("kinverse:"+km);
        System.out.println("Enter M:");
    BigInteger m=sc.nextBigInteger();
    BigInteger s=(km.multiply(m.add(x.multiply(r)))).mod(q);
        System.out.println("s:"+s);
    BigInteger w=s.modPow(r, q).multiply(s.modInverse(q));
    BigInteger u1=m.multiply(w).mod(q);
    BigInteger u2=r.multiply(w).mod(q);
        System.out.println("w:"+w+"\nu1:"+u1+"\nu2:"+u2);
    BigInteger v=((g.modPow(u1, p)).multiply(y.modPow(u2, p))).mod(q);
        System.out.println(r+" "+v);
        if(r.equals(v)){
            System.out.println("Signature Verified");
        }
        else{
            System.out.println("Not Verified");
        }
    }
public static boolean divisorOf(BigInteger q,BigInteger p){
    if((q.mod(p.subtract(BigInteger.ONE))).equals(BigInteger.ZERO)){
        return true;
    }
    return false;
}    
public static boolean isPrime(BigInteger p){
    BigInteger one=BigInteger.ONE;
    int flag=0;
    for(BigInteger i=one;i.compareTo(p)<0;i=i.add(one)){
        if((p.mod(i)).equals(BigInteger.ZERO)){
           flag=1;
           break;
        }
    }
    if(flag==1){
        return false;
    }
    return true;
}
    public static BigInteger kinverse(BigInteger m,BigInteger b,int id){
         ArrayList<BigInteger> A=new ArrayList<>();
        A.add(BigInteger.ONE);
        A.add(BigInteger.ZERO);
        A.add(m);
        ArrayList<BigInteger> B=new ArrayList<>();
        B.add(BigInteger.ZERO);
        B.add(BigInteger.ONE);
        B.add(b);
        int flag=0;
        int ni=0;
//        System.out.println(A+" "+B+" ");
        while(flag!=1){
        if(B.get(2).equals(BigInteger.ZERO)){
            flag=1;
            ni=1;
            break;
        }
        if(B.get(2).equals(BigInteger.ONE)){
            flag=1;
            break;
        }
        BigInteger Q;
        Q=A.get(2).divide(B.get(2));
        ArrayList<BigInteger> T=new ArrayList<>();
        T.add(BigInteger.ZERO);
        T.add(BigInteger.ZERO);
        T.add(BigInteger.ZERO);
//            System.out.println(A+" "+B+" "+T);
        for(BigInteger i=BigInteger.ZERO;i.compareTo(new BigInteger(T.size()+""))<0;i=i.add(BigInteger.ONE)){
            T.set(i.intValue(), A.get(i.intValue()).subtract(Q.multiply(B.get(i.intValue()))));
        }
//        T.add(A.get(0).subtract(Q.multiply(B.get(0))));
//        T.add(A.get(1).subtract(Q.multiply(B.get(1))));
//        T.add(A.get(2).subtract(Q.multiply(B.get(2))));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(new BigInteger(A.size()+""))<0;i=i.add(BigInteger.ONE)){
            A.set(i.intValue(), B.get(i.intValue()));
        }
//        A.addAll(B);
        for(BigInteger i=BigInteger.ZERO;i.compareTo(new BigInteger(B.size()+""))<0;i=i.add(BigInteger.ONE)){
            B.set(i.intValue(), T.get(i.intValue()));
        }
//        B.addAll(T);
//        B.replaceAll(T);
//        System.out.println(A+" "+B+" "+T);
        }
        if(id==0){
        return B.get(1);
        }
        else if(id==1&&ni==1){
            return A.get(2);
        }
        else{
          return B.get(2);
          }
    }
}