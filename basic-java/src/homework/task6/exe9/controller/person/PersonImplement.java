package homework.task6.exe9.controller.person;

import homework.task6.exe9.model.Person;
import java.io.*;
import java.util.ArrayList;

public class PersonImplement implements PersonInterface {
    private final File file;
    private OutputStream outputStream;
    private PrintWriter printWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private final ArrayList<String> personArrayList;
    public PersonImplement() {
        this.file = new File("src/homework/task6/exe9/resources/person.txt");
        this.personArrayList = new ArrayList<>();
    }
    @Override
    public void savePerson(Person person) {
        try {
            if (this.file.isFile()) {
                this.outputStream =  new FileOutputStream(this.file, true);
                this.printWriter = new PrintWriter(outputStream);
                this.printWriter.println(person);
                this.printWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ArrayList<String> findAllPersons() {
        try {
            if (this.file.isFile()) {
                this.fileReader = new FileReader(this.file);
                this.bufferedReader = new BufferedReader(this.fileReader);
                String person = this.bufferedReader.readLine();
                while (person != null) {
                    this.personArrayList.add(person);
                    person = this.bufferedReader.readLine();
                }
                this.fileReader.close();
                this.bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.personArrayList;
    }
}
