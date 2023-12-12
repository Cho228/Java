package Lab2;

import java.io.File;
public interface Serializer<T> {

    void serialize(T object, File file);

    T deserialize(File file);

    void writeToFile(T object, File file);

    T readFromFile(File file);
}