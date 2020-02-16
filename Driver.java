import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Driver {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<String>> list = new ArrayList<>(); // make 2D ArrayList
        try (Scanner sc1 = new Scanner(new File("output.csv"))) {
            while (sc1.hasNextLine()) { // read data from file (PART I)
                list.add(toTokens(sc1.nextLine())); // add data to 2D ArrayList
            }
        }
        TopArtists arts = new TopArtists(); // instantiate LinkedList

        arts.convert(list); // Call to convert from 2D ArrayList to LinkedList
        arts.sortArtists(); // Call to sort LinkedList
        arts.removeDuplicates(); // Call to remove duplicates from LinkedList 
        
        /** Developer's test functions 
        arts.printList();
        System.out.println("List size: " + arts.getList().size()); */
        
        File file = new File("input.txt"); // make a file
        if (file.exists()) { // check if file already exists
            System.err.println("File already exists");
            System.exit(1);
        }
        try (PrintWriter pw = new PrintWriter(file)) { // write data to file
            LinkedList<TopArtists.Artist> tsil = arts.getList();            
            for (int i = 0; i < tsil.size(); i++) {
                pw.println(tsil.get(i));
            }
        } 
    }
    public static ArrayList<String> toTokens(String line) {
        ArrayList<String> list = new ArrayList<>(); // read data from file (PART II)
        try (Scanner sc2 = new Scanner(line)) {
            sc2.useDelimiter(",");
            while (sc2.hasNext()) {
                list.add(sc2.next());
            }
        }
        return list;
    }
}     
