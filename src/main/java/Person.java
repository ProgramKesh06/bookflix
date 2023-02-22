import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Person {
    private ArrayList<String> name  = new ArrayList<>();
    private ArrayList<Integer> age  = new ArrayList<>();
    public Person (String fileName){
        try (FileReader in = new FileReader(fileName); BufferedReader read = new BufferedReader(in)) {
            String line;
            while ((line = read.readLine()) != null){
                String[] data = line.split(":");
                name.add(data[3]);
                age.add(Integer.parseInt(data[4]));
            }
        } catch(FileNotFoundException badFile ) {
            System.out.println("could not find file");
        } catch (IOException uhoh) {
            System.out.println("error reading from file");
        }
    }

    public void addPerson(String strName, int intAge){
        this.name.add(strName);
        this.age.add(intAge);
    }

    public Person(String strName, int intAge){
        addPerson(strName,intAge);
    }

    public Person() {
    }

    public void setName (ArrayList<String> names) {
        this.name = names;
    }
    public ArrayList <String> getName(){
        return name;
    }
    public void setAge (ArrayList<Integer> ages) {
        this.age = ages;
    }
    public ArrayList <Integer> getAge(){
        return age;
    }
}