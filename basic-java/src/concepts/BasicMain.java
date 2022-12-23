package concepts;

/**
 * Class Main to test code others class.
 */
public class BasicMain {
    public static void main(String[] args) {
        // Conditionals
        LoopsAndConditionals cLoopsAndConditionals = new LoopsAndConditionals();
        cLoopsAndConditionals.ifElseFunction(4);
        cLoopsAndConditionals.forFunction();
        cLoopsAndConditionals.whileFunction();
        cLoopsAndConditionals.switchFunction(3);
        // Read and Write XML
        ReadWriteXML cReadWriteXML = new ReadWriteXML();
        cReadWriteXML.write("komyk", "config");
        cReadWriteXML.read();
        // Read and Write JSON
        ReadWriteJSON cReadWriteJSON = new ReadWriteJSON();
        cReadWriteJSON.read();
        cReadWriteJSON.readByKey();
        cReadWriteJSON.createJSON();
    }
}
