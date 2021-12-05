import java.util.Scanner;

public class Dictionary {
    //this class gets the words from the file and stores them in a hashmap
    private String[] wordList;

    
    public void Dictionary(String fileName) {
        //this method reads the file and stores the words in the hashmap
        try {
            Scanner file = new Scanner(new java.io.File(fileName));
            wordList=new String[file.nextInt()];
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
        for(int i=0;i<wordList.length;i++){
            if(wordList[i].equals(word)){
                return true;
            }
        }
        return false;
    }
    private void sortWords() {
        //this method sorts the words in the hashmap
        java.util.Arrays.sort(wordList);
    }
}
