import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class TopArtists {
    private LinkedList<Artist> list; 
    class Artist implements Comparable {
        private int position;
        private String track; 
        private String name;  
        private int streams;  
        private String url;
        public Artist() { // Constructor
            this(0, "", "", 0, "");
        }
        public Artist(int position, String track, String name, 
                      int streams, String url) { // Constructor
            this.position = position;
            this.track = track;
            this.name = name;
            this.streams = streams;
            this.url = url;
        }
        @Override
        public String toString() {
            return position +" "+ track +" "+ name +" "+ streams +" "+ url;
        } 
        @Override
        public int compareTo(Object o) {
            Artist other = (Artist) o;
            int compared = this.name.compareTo(other.name);
            return compared;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Artist) {
                return this.url.equals(((Artist) o).url);
            }
            else {
                return false;
            }
        }
    }
    public TopArtists() { // Constructor
        list = new LinkedList<>();
    }  
    public void removeDuplicates() {
        // Remove duplicates based on unique url (used overriden equals())
        Artist a = new Artist();
        for (int i = 0; i < list.size(); i++) { 
            for (int j = i+1; j < list.size(); j++) { 
                if (list.get(i).equals(list.get(j))) {
                    int index = i;
                    list.remove(index);
                }
            }
        }
    }
    public void sortArtists() {
        // Sort based on artist name (used overriden compareTo()) 
        Collections.sort(list);
    } 
    public LinkedList<Artist> getList() {
        // Getter for list
        return list;
    }
    public void printList() {
        // Printer for list (used overriden toString()) 
        for (Artist a : list) {
            System.out.println(a.toString());
        }
    }
    public void convert(ArrayList<ArrayList<String>> array) {
        // Convert from 2D ArrayList to LinkedList 
        LinkedList<Artist> artists = new LinkedList<>();
        for (ArrayList<String> row : array) {
            int position = Integer.parseInt(row.get(0));  
            String track = row.get(1);
            String name = row.get(2);
            int streams = Integer.parseInt(row.get(3));
            String url = row.get(4);

            Artist a = new Artist(position, track, name, streams, url);
            artists.add(a);
        }
        list = artists;
    }
}
