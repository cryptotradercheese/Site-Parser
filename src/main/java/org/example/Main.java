package org.example;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://www.kinopoisk.ru/film/326/reviews/ord/date/status/all/perpage/200/page/";
        ReviewCsvCreator creator = new ReviewCsvCreator("reviews.csv");
        Parser parser = new Parser();
        List<Review> reviews = parser.parseReviews(Jsoup.connect(url + 1).get());
        for (int page = 2; !reviews.isEmpty(); page++) {
            creator.addAll(reviews);
            reviews = parser.parseReviews(Jsoup.connect(url + page).get());
        }
    }
}