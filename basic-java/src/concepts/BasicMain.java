package concepts;

public class BasicMain {
    public static void main(String[] args) {
        // Conditionals
        LoopsAndConditionals loopsAndConditionals = new LoopsAndConditionals();
        loopsAndConditionals.ifElseFunction();
        loopsAndConditionals.forFunction();
        loopsAndConditionals.whileFunction();
        loopsAndConditionals.switchFunction(3);
        // Read and Write XML
        ReadWriteXML readWriteXML = new ReadWriteXML();
        readWriteXML.write("user", "password");
        readWriteXML.read();
        // Read and Write JSON
        ReadWriteJSON readWriteJSON = new ReadWriteJSON();
        readWriteJSON.read();
        readWriteJSON.readByKey();
        readWriteJSON.createJSON();
    }
}
