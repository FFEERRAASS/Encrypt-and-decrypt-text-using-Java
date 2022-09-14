

import java.util.Scanner;

public class PUB {
    public static void encryptingMethod(String str, String key) {
        //to remove spaces
        str = str.replaceAll("\\s", "");
        key = key.replaceAll("\\s", "");
        //to make the key repeated at the whole text in correct way.
        key=key.toLowerCase().repeat(str.length()/key.length()+1);
        key=key.substring(0,str.length());
        String alphabet = "abcdefghijzlmnopqrstuvwxyz";
        String[][] ar = new String [26][1];//we initialized 2D array .
        //creating the array
        for(int i=0 ; i <26 ; i++) {
            ar[i][0]=alphabet.substring(i)+alphabet.substring(0,i);
        }

        String encryptedWord="";
        for(int i=0; i<str.length(); i++)
        {
            //key_index will contain the row index word_index will contain the column index .
            int word_index=0 , key_index=0;
            char ltr =str.charAt(i);
            char key_l=key.charAt(i);

            for(int j=0 ; j<26 ; j++)
            {

                if(ltr==ar[0][0].charAt(j)) {
                    word_index =j ; break;
                }
            }
            for(int t=0 ; t<26 ; t++)
            {
                if(key_l==ar[0][0].charAt(t)) {
                    key_index =t ;break;
                }
            }
            encryptedWord+=(ar[key_index][0].charAt(word_index));
        }
        System.out.println(encryptedWord);
    }

    public static void repetitionsCounter(String word)
    {
        // this method counts the character repetitions

        char[] splitedWord = word.toCharArray();

        for(int i=0 ;i<splitedWord.length ;i++)
        {
            int c=0 ;
            char l = splitedWord[i];
            if(l != ' ')
            {
                for(int j=0; j <splitedWord.length ;j++)
                {
                    if(splitedWord[j]==l )
                    {
                        splitedWord[j]=' ';c++;
                    }
                    else {continue;}
                }
                {System.out.print(l + " "+c+"\n");}
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("HELLO USER ");
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE WORD YOU WANT TO ENCRYPT : ");
        String str = scan.nextLine();
        str=str.toLowerCase();
        System.out.println("-----------------------------");

        System.out.println("ENTER THE KEY YOU WANT TO ENCRYPT WITH  : ");
        String key = scan.nextLine();
        System.out.println("-----------------------------");

        //call encrypter method to encrypt the text
        System.out.println("RESULT : ");
        encryptingMethod(str, key);
        System.out.println("-----------------------------");

        //input a word and call the frequencies method
        System.out.println("ENTER A WORD TO FIND ITS FREQUENCY :");
        String freq = scan.nextLine();
        repetitionsCounter(freq);
        System.out.println("End Program");
    }
}
