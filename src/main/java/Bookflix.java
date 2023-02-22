import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Bookflix {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Book book = new Book("books.txt");
		Person person = new Person("ratings.txt");
		Members members = new Members("ratings.txt");
		System.out.println("Hello and welcome to the Bookflix app where we have all these functions: ");
		int optionSelected = getOptionSelected();
        String name="";
        String newUName="";
		String password = "";
        int age=0;
        String year="";
        String username="";
		boolean isLoggedIn = false;

		scan = new Scanner(System.in);
		while (optionSelected!=8) {
			if (optionSelected==1){
				if(isLoggedIn==false){
					System.out.print("Please enter username: ");
					username = scan.nextLine();
					System.out.print("Please enter password: ");
					password = scan.nextLine();
					boolean ifso = members.isAccountNameExists(username,password);
					if (ifso){
						System.out.println("User logged In");
						isLoggedIn=true;
						optionSelected = getOptionSelected();
					} else {
						System.out.println("User not found, create new account or logIn with correct username and password");
						optionSelected = getOptionSelected();
					}
				} else {
					System.out.println("User already logged In");
					optionSelected = getOptionSelected();
				}
			}else if (optionSelected==2){
				scan = new Scanner(System.in);
				System.out.print("Please enter your name: ");
				name = scan.nextLine();
				System.out.print("Please enter your UserName: ");
				newUName = scan.nextLine();
				System.out.print("Please enter your password: ");
				password = scan.nextLine();
				System.out.print("Please enter your age: ");
				age = scan.nextInt();
				scan = new Scanner(System.in);
				System.out.print("Please enter the year you joined: ");
				year = scan.nextLine();
				person.addPerson(name,age);
				members.addMembers(newUName,password,year);
				if(isLoggedIn==true){
					isLoggedIn=true;
				}
				optionSelected = getOptionSelected();
			}else if (optionSelected==3){
				System.out.print("Please enter the Book title: ");
				String title = scan.nextLine();
				System.out.print("Please enter the ISBN number: ");
				String isbn = scan.nextLine();
				System.out.print("Please enter the author: ");
				String author = scan.nextLine();
				System.out.print("Please enter the creation year: ");
				String bYear = scan.nextLine();
				book.addBook(isbn,author,title,bYear);
				members.addNewBookReviewForEachUser();
				optionSelected = getOptionSelected();
			}else if (optionSelected==4){
				if (isLoggedIn) {
					ArrayList<Integer> booksCanRate = new ArrayList<>();
					ArrayList<String> strBooksCanRate = new ArrayList<>();
					String esUserReviews = "";
					for (int i = 0; i < members.getAccountName().size(); i++) {
						if (username.equals(members.getAccountName().get(i))) {
							esUserReviews = members.getReviews().get(i);
							String[] userReview = esUserReviews.split(" ");
							for (int j = 0; j < userReview.length; j++) {
								if (userReview[j].equals("0")) {
									System.out.println(book.getTitle().get(j));
								}
							}
						}
					}
					System.out.print("Please enter your the Book title (Please spell and use case as seen above): ");
					String rBookTitle = scan.nextLine();
					System.out.print("Please enter the rating you want to add for this book options are (-5,-3,-1,0,1,3,5): ");
					int ratingsFromUser = scan.nextInt();
					Ratings ratings = new Ratings(rBookTitle, username, ratingsFromUser);
					int bookTitleIndex = 0;
					String sUserReviews = "";
					boolean isBookFound = false;
					ArrayList<String> bookRating = new ArrayList<>();
					String updatedReview = "";
					for (int i = 0; i < book.getTitle().size(); i++) {
						if (rBookTitle.equals(book.getTitle().get(i))) {
							bookTitleIndex = i;
							isBookFound = true;
						}
					}
					String currReview = "";
					String newReview = "";
					int rewInt = 0;
					if (isBookFound) {
						for (int i = 0; i < members.getAccountName().size(); i++) {
							if (username.equals(members.getAccountName().get(i))) {
								sUserReviews = members.getReviews().get(i);
								String[] userReview = sUserReviews.split(" ");
								newReview = Integer.toString(ratingsFromUser);
								for (int j = 0; j < userReview.length; j++) {
									currReview = userReview[j];
									if (j == bookTitleIndex) {
										currReview = newReview;
									}
									if (j == 0) {
										updatedReview = currReview;
									} else {
										updatedReview += " " + currReview;
									}
								}
								members.getReviews().set(i, updatedReview);
							}
						}
					} else {
						System.out.println("Please input correct book title to add rating.");
						optionSelected = getOptionSelected();
					}
					isLoggedIn = true;
					optionSelected = getOptionSelected();
				} else {
					System.out.println("Please sign in or create a new account to add a rating");
					optionSelected = getOptionSelected();
				}
			}else if (optionSelected==5){
				isLoggedIn=false;
				optionSelected = 1;
			}else if (optionSelected==6){
				if (isLoggedIn){
					int userInd = 0;
					for(int i =0; i<members.getAccountName().size(); i++){
						if (members.getAccountName().get(i).equals(username)){
							userInd = i;
						}
					}
					String strReview = "";
					ArrayList<String> singleRatings= new ArrayList<>();
					String userReviewList = members.getReviews().get(userInd);
					String [] userReviewArr = userReviewList.split (" ");
					for(int i = 0; i<userReviewArr.length; i++ ) {
						singleRatings.add(userReviewArr[i]);
					}
					for (int i =0; i<singleRatings.size(); i++){
						strReview+=book.getTitle().get(i);
						strReview+= ": ";
						strReview+=singleRatings.get(i);
						strReview+= "\n";
					}
					System.out.println(username+":");
					System.out.println(strReview);
					isLoggedIn=true;
				} else {
					System.out.println("Please sign in or create a new account to add a rating");
				}
				optionSelected = getOptionSelected();
			}else if (optionSelected==7){
				if (isLoggedIn){
					ArrayList<Integer> allUserRatingCount  = new ArrayList<>();
					String currUserReviews = "";
					String otherUserReviews = "";
					int currUserRatingCount = 0;
					int currUserIndex = 0;
					//Get logged in user rating list
					for(int i=0; i<members.getAccountName().size(); i++) {
						if (username.equals(members.getAccountName().get(i))) {
							currUserReviews = members.getReviews().get(i);
							currUserIndex = i;
						}
					}
					//Create arraylist by multiple current user and other user rating and add all rating
					int compareCount = 0;
					for(int i=0; i<members.getReviews().size(); i++) {
						String reviews = members.getReviews().get(i);
						String [] userReview = reviews.split(" ");
						String [] currReview = currUserReviews.split(" ");
						for(int j=0; j<userReview.length; j++) {
							if(j==0){
								compareCount = ((Integer.parseInt(userReview[j])) * (Integer.parseInt(currReview[j])));
							} else {
								compareCount += ((Integer.parseInt(userReview[j])) * (Integer.parseInt(currReview[j])));
							}
						}
						allUserRatingCount.add(compareCount);
					}
					//find the highest rating users compare to current user and ignore current user rating
					int currUserRating = 0;
					int userIndexAtRating = 0;
					for(int i=0; i<allUserRatingCount.size(); i++) {
						if(currUserRating<allUserRatingCount.get(i)){
							if(i!=currUserIndex){
								currUserRating=allUserRatingCount.get(i);
								userIndexAtRating = i;
							}
						}
					}
					//get the highest user rating list
					String highestUserReview = members.getReviews().get(userIndexAtRating);

					//compare logged in user rating list with highest user rating list and identify the book which are rated positively but not rated by logged in user
					ArrayList<Integer> recUserRating  = new ArrayList<>();
					ArrayList<Integer> recUserRatingIndex  = new ArrayList<>();
					String [] userReview = highestUserReview.split(" ");
					String [] currReview = currUserReviews.split(" ");
					for(int j=0; j<currReview.length; j++) {
						if (Integer.parseInt(currReview[j]) == 0) {
							recUserRatingIndex.add(j);
							recUserRating.add(Integer.parseInt(userReview[j]));
						}
					}

					ArrayList<Integer> ratingFive  = new ArrayList<>();
					ArrayList<Integer> ratingThree  = new ArrayList<>();
					ArrayList<Integer> finalBookListIndex  = new ArrayList<>();
					for(int i=0; i<recUserRating.size(); i++) {
						if(recUserRating.get(i)==5){
							ratingFive.add(recUserRatingIndex.get(i));
						}
						if(recUserRating.get(i)==3){
							ratingThree.add(recUserRatingIndex.get(i));
						}
					}
					for (int i = 0; i<ratingFive.size(); i++){
						finalBookListIndex.add(ratingFive.get(i));
					}
					if (finalBookListIndex.size()<3){
						for (int i = 0; i<ratingThree.size(); i++){
							finalBookListIndex.add(ratingThree.get(i));
						}
					}

					//get list of books
					if(finalBookListIndex.size()>0){
						String recBookTitle = "";
						System.out.println("List of recommended books: ");
						for (int i = 0; i<finalBookListIndex.size(); i++){
							System.out.println(book.getTitle().get(finalBookListIndex.get(i)));
						}
					} else {
						System.out.println("The highest recommend books are unavailable due to insufficient amount of book ratings");
					}
					isLoggedIn=true;
					optionSelected = getOptionSelected();
				} else {
					System.out.println("Please sign in or create a new account to get recommended list of books");
					optionSelected = getOptionSelected();
				}
			}
		}
		if (optionSelected==8){
			try(FileWriter file = new FileWriter("ratings.txt", false);
			BufferedWriter writer = new BufferedWriter(file)) {
			for(int k=0; k <person.getName().size(); k++) {
				writer.write(members.getAccountCreation().get(k));
				writer.write(":");
				writer.write(members.getPassword().get(k));
				writer.write(":");
				writer.write(members.getAccountName().get(k));
				writer.write(":");
				writer.write(person.getName().get(k));
				writer.write(":");
				writer.write(person.getAge().get(k).toString());
				writer.write(":");
				String hold = "";
				ArrayList<String> arrRatings = new ArrayList<>();
				String strRatingList = members.getReviews().get(k);
				String[] strRatingArr = strRatingList.split(" ");
				for (int i = 0; i < strRatingArr.length; i++) {
					arrRatings.add(strRatingArr[i]);
				}
				for (int i = 0; i < arrRatings.size(); i++) {
					if(i==0){
						hold = arrRatings.get(i);
					} else {
						hold += " "+arrRatings.get(i);
					}
				}
				writer.write(hold);
				writer.newLine();
			}
			} catch(IOException bad) {
			System.out.println("uh oh");
			}
			try(FileWriter file = new FileWriter("books.txt", false);
				BufferedWriter writer = new BufferedWriter(file)) {
				for(int k=0; k <book.getAuthor().size(); k++) {
					writer.write(book.getISBN().get(k));
					writer.write(",");
					writer.write(book.getAuthor().get(k));
					writer.write(",");
					writer.write(book.getTitle().get(k));
					writer.write(",");
					writer.write(book.getYear().get(k));
					writer.newLine();
				}
			} catch(IOException bad) {
				System.out.println("uh oh");
			}
			System.out.println("Thank you for using the app");
		}
	}

	public static int getOptionSelected(){
		Scanner scan = new Scanner(System.in);
		int optionSelected = 0;
		System.out.println("""
                        1. Sign in
                        2. Create new account
                        3. Add a book
                        4. Add a rating for a book or change a rating
                        5. Switch user
                        6. All of the books you have rated
                        7. Recommended list of books for you
                        8. Quit""");
		System.out.print("Enter Selection: ");
		optionSelected = scan.nextInt();
		scan = new Scanner(System.in);
		return optionSelected;
	}
}