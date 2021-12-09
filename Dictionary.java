import java.util.Scanner;
import java.util.Arrays;

public class Dictionary {
    //this class gets the words from the file and stores them in a hashmap
    private String[] wordList;
    private String fileName;
    public int size;
    
    public Dictionary(String FileName) {
        this.fileName = FileName;

        try {
            Scanner file = new Scanner(new java.io.File(fileName));
            size = file.nextInt();
            wordList=new String[size];
            for(int i=0;i<wordList.length;i++){ 
                wordList[i]=file.nextLine();  
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found");
        }

        sortWords();
    }
    public boolean isValidWord(String word) {
        //this method checks if the word is in the hashmap
        // for(int i=0;i<wordList.length;i++){
        //     if(wordList[i].equals(word)){
        //         return true;
        //     }
        // }
        if(Arrays.binarySearch(wordList,word)>=0){
            return true;
        }
        return false;

        
    }
    private void sortWords() {
        //this method sorts the words in the hashmap
        java.util.Arrays.sort(wordList);
    }
    public boolean mayBeComposed(String word, char[] letters) {
        boolean[] isUsed = new boolean[letters.length]; // isUsed is of the same size as letters
        Arrays.fill(isUsed, false); // set  all  elements  to  false
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = -1;
            for (int j = 0; j < letters.length; j++) {
                if (letters[j] == c && !isUsed[j]) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                return false;
            }
            isUsed[index] = true;
        }
        return true;
        // //this method checks if the word can be composed from the letters
        // // if(word.length()==1){
        // //     if(letters.length==1){
        // //         if(word.charAt(0)==letters[0]){
        // //             return true;
        // //         }
        // //     }
        // // }
        // // else{
        // //     for(int i=0;i<word.length();i++){
        // //         if(letters.length==1){
        // //             if(word.charAt(i)==letters[0]){
        // //                 return true;
        // //             }
        // //         }
        // //         else{
        // //             for(int j=0;j<letters.length;j++){
        // //                 if(word.charAt(i)==letters[j]){
        // //                     letters[j]=' ';
        // //                     break;
        // //                 }
        // //             }
        // //         }
        // //     }
        // // }
        // // return false;
        // for(int i=0;i<word.length();i++){
        //     if(letters.length==1){
        //         if(word.charAt(i)==letters[0]){
        //             return true;
        //         }
        //     }
        //     else{
        //         for(int j=0;j<letters.length;j++){
        //             if(word.charAt(i)==letters[j]){
        //                 letters[j]=' ';
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return false;

    }
    public static String replaceFrenchCharacter(String word) {
        //this method replaces the french characters with their english equivalents
        return word
        .toLowerCase()
        .replaceAll("[àâä]" , "a")
        .replaceAll("ç"     , "c")
        .replaceAll("[éèêë]", "e")
        .replaceAll("[îï]"  , "i")
        .replaceAll("[ôö]"  , "o")
        .replaceAll("[ùüû]" , "u")
        .replaceAll("œ"     , "oe")
        .replaceAll("æ"     , "ae");
    }
               
}
