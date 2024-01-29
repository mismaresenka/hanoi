package CipherAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class genCipher extends abstractMethod {
    void cipherMethod() {
        Scanner input = new Scanner(System.in);

        String alphabetRaw = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
        String[] substrings = alphabetRaw.split(",");
        ArrayList <String> alphabet = new ArrayList<String>();

        
        System.out.println("Encrypt a keyword: ");
        String keyword = input.nextLine();

        for (String substring : substrings) {
            alphabet.add(substring);
        }
        System.out.println(alphabet);
    }
}
