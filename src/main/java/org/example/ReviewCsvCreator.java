package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReviewCsvCreator {
    private String fileName;

    public ReviewCsvCreator(String fileName) throws IOException {
        this.fileName = fileName;
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(Review.csvColumnNames());
        }
    }

    public void addAll(List<Review> reviews) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            for (Review review : reviews) {
                writer.println(review.asCsv());
            }
        }
    }
}
