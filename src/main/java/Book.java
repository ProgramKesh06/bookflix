import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Book {
    private ArrayList<String> ISBN  = new ArrayList<>();
    private ArrayList<String> title  = new ArrayList<>();
    private ArrayList<String> year  = new ArrayList<>();
    private ArrayList<String> author  = new ArrayList<>();
    public Book (String fileName){
        try (FileReader in = new FileReader(fileName); BufferedReader read = new BufferedReader(in)) {
            String line;
            while ((line = read.readLine()) != null){
                String[] data = line.split(",");
//                for (int i =0; data.length > i;i++){
                    ISBN.add(data[0]);
                    author.add(data[1]);
                    title.add(data[2]);
                    year.add(data[3]);

//                }
            }
        } catch(FileNotFoundException badFile ) {
            System.out.println("could not find file");
        } catch (IOException uhoh) {
            System.out.println("error reading from file");
        }
    }
    public void setISBN (ArrayList<String> ISBNs) {
        this.ISBN = ISBNs;
    }
    public ArrayList <String> getISBN(){
        return ISBN;
    }
    public void setAuthor (ArrayList<String> authors) {
        this.author = authors;
    }
    public ArrayList <String> getAuthor(){
        return author;
    }
    public void setTitle (ArrayList<String> titles) {
        this.title = titles;
    }
    public ArrayList <String> getTitle(){
        return title;
    }
    public void setYear (ArrayList<String> years) {
        this.year = years;
    }
    public ArrayList <String> getYear(){
        return year;
    }
    public void addBook(String isbn, String authors, String titles, String years){
        if (ISBN.contains(isbn)){
            System.out.println("ISBN number already exists did not add book");
        }
        ISBN.add(isbn);
        author.add(authors);
        title.add(titles);
        year.add(years);

            // write book to file
            //same add user
            //changes rating new rating in file
    }
}
