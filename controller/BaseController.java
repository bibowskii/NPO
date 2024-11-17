package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseController<T> {
    private final String filePath;

    public BaseController(String filePath) {
        this.filePath = filePath;
    }

    public void create(T item, String line) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            writer.newLine();
        }
    }

    public List<T> readAll(ItemMapper<T> mapper) throws IOException {
        List<T> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(mapper.map(line));
            }
        }
        return items;
    }

    public void update(String identifier, T updatedItem, String updatedLine, ItemMapper<T> mapper) throws IOException {
        List<T> items = readAll(mapper);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (T item : items) {
                String line = item.toString();
                if (line.contains(identifier)) {
                    writer.write(updatedLine);
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        }
    }

    public void delete(String identifier) throws IOException {
        List<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(identifier)) {
                    items.add(line);
                }
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : items) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public interface ItemMapper<T> {
        T map(String line);
    }
}
