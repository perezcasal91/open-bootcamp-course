package structurals.decorator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class ApplicationMain {
    public static void main(String[] args) {
        String fileName = "src/resources/doc/data_file.dat";
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(
                new CompressionDecorator(
                        new DataSourceDecorator(
                                new FileDataSource(fileName))));
        encryptionDecorator.writeData("Using Decorator Patter");
        System.out.println(encryptionDecorator.readData());
    }
}
interface DataSource {
    void writeData(String data);
    String readData();
}
class FileDataSource implements DataSource {
    private final File file;
    public FileDataSource(String fileName) {
        file = new File(fileName);
    }
    @Override
    public void writeData(String data) {
        System.out.println("Writing File");
        try {
            Files.writeString(file.toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String readData() {
        System.out.println("Reading File");
        try {
            return Stream.of(Files.readString(file.toPath()))
                    .reduce("", String::concat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class DataSourceDecorator implements DataSource {
    private final DataSource dataSource;
    public DataSourceDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void writeData(String data) {
        this.dataSource.writeData(data);
    }
    @Override
    public String readData() {
        return this.dataSource.readData();
    }
}
class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    public void writeData(String data) {
        super.writeData(encryptData(data));
    }
    private String encryptData(String data) {
        return "The ( " + data + " ) was encrypt successfully";
    }
    @Override
    public String readData() {
        return desEncryptData(super.readData());
    }
    private String desEncryptData(String data) {
        return "The ( " + data + " ) was des-encrypt successfully";
    }
}
class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    public void writeData(String data) {
        super.writeData(compressData(data));
    }
    private String compressData(String data) {
        return "The ( " + data + " ) was compressed successfully";
    }
    @Override
    public String readData() {
       return decompressData(super.readData());
    }
    private String decompressData(String data) {
        return "The ( " + data + " ) was decompressed successfully";
    }
}