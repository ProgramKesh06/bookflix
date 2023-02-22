import java.util.ArrayList;
public class Ratings {
    private String book;
    private String memUsername;
    private int addRating;
    private ArrayList<Integer> data3= new ArrayList<>();
    // approved to be string
    private int bookInd;
    private int userInd;

    public Ratings (String sBook, String sMemUsername, int sAddRating){
        book=sBook;
        memUsername=sMemUsername;
        addRating=sAddRating;
    }

    public void setBook ( String sBook) {
        this.book = sBook;
    }
    public String getBook(){
        return book;
    }
    public void setMemUsername ( String sMemUsername) {
        this.memUsername = sMemUsername;
    }
    public String getMemUsername(){
        return memUsername;
    }
    public void setAddRating ( int sAddRating) {
        this.addRating = sAddRating;
    }
    public int getAddRating(){
        return addRating;
    }
    public void setBookInd ( int sBookInd) {
        this.bookInd = sBookInd;
    }
    public int getBookInd(){
        return bookInd;
    }
    public void setUserInd ( int sUserInd) {
        this.userInd = sUserInd;
    }
    public int getUserInd(){
        return userInd;
    }
    public void setData3 (ArrayList<Integer> data3s) {
        this.data3 = data3s;
    }
    public ArrayList <Integer> getData3(){
        return data3;
    }

}
