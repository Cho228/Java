package Lab2;

import java.io.*;
public class TxtSerializer<T> implements Serializer<T> {

    @Override
    public void serialize(T object, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T deserialize(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void writeToFile(T object, File file) {
        serialize(object, file);
    }

    @Override
    public T readFromFile(File file) {
        return deserialize(file);
    }
}
