import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Members extends Person {
    private ArrayList<String> accountName  = new ArrayList<>();
    private ArrayList<String> accountCreation  = new ArrayList<>();
    private ArrayList<String> reviews  = new ArrayList<>();
    private ArrayList<String> password  = new ArrayList<>();

    public Members(String filename){
        super();
        readFile (filename);
    }

    public void addMembers(String strAccName, String strPassword, String strCreation){
        boolean ifso = ifAccountExists(strAccName);
        if (ifso==true){
            System.out.println("That username is already taken please enter another username (Account was not created)");
        } else{
            accountName.add(strAccName);
            password.add(strPassword);
            accountCreation.add(strCreation);
            String reviewList = getReviews().get(0);
            String userDefaultRating = "";
            String [] arrReviews = reviewList.split (" ");
            for (int i = 0; i<arrReviews.length;i++) {
                if(i==0){
                    userDefaultRating = "0";
                } else {
                    userDefaultRating += " " +"0";
                }
            }
            reviews.add(userDefaultRating);
        }
    }

    public void addNewBookReviewForEachUser() {
        ArrayList<String> updateUserReviews = new ArrayList<>();;
        ArrayList<String> eachUserReviews = getReviews();
        for (int i = 0; i < eachUserReviews.size(); i++) {
            String userReview = eachUserReviews.get(i);
            userReview += " 0";
            updateUserReviews.add(userReview);
        }
        reviews = updateUserReviews;
    }

    public Members(String strAccName, String strPassword, String strCreation) {
        addMembers(strAccName, strPassword, strCreation);
    }

    public void readFile(String filename){
        try (FileReader in = new FileReader(filename); BufferedReader read = new BufferedReader(in)) {
            String line;
            while ((line = read.readLine()) != null){
                String [] var = line.split (":");
                accountCreation.add(var[0]);
                password.add(var[1]);
                accountName.add(var[2]);
                reviews.add(var[5]);
            }
        } catch(FileNotFoundException badFile ) {
            System.out.println("could not find file");
        } catch (IOException uhoh) {
            System.out.println("error reading from file");
        }
    }
    public boolean ifAccountExists(String strAccName){
        boolean isUnique = false;
        ArrayList<String> accountName = getAccountName();
        for(int i = 0; i<accountName.size(); i++ ) {
            if(accountName.get(i).equals(strAccName)) {
                isUnique = true;
            }
        }
        return isUnique;
    }

    public boolean isAccountNameExists(String strAccName,String strPassword){
        boolean isUnique = false;
        ArrayList<String> accountName = getAccountName();
        for(int i = 0; i<accountName.size(); i++ ) {
            if((accountName.get(i).equals(strAccName)) && (password.get(i).equals(strPassword))) {
                isUnique = true;
            }
        }
        return isUnique;
    }


    public ArrayList<String> getAccountName() {
        return accountName;
    }

    public void setAccountName(ArrayList<String> accName) {
        this.accountName = accName;
    }

    public ArrayList<String> getAccountCreation() {
        return accountCreation;
    }

    public void setAccCreation(ArrayList<String> accCreation) {
        this.accountCreation = accCreation;
    }
    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> sReviews) {
        this.reviews = sReviews;
    }

    public ArrayList<String> getPassword() {
        return password;
    }
    public void setPassword(ArrayList<String> password) {
        this.password = password;
    }
}