package org.example;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Review> parseReviews(Document data) {
        Elements elements = data.getElementsByClass("reviewItem userReview");
        List<Review> reviews = new ArrayList<>();
        for (Element element : elements) {
            Review review = new Review();
            review.setReviewerName(element.getElementsByClass("profile_name").get(0).text());
            review.setTitle(element.getElementsByClass("sub_title").get(0).text());
            review.setText(element.getElementsByClass("brand_words").get(0).text());
            review.setDate(parseDate(element.getElementsByClass("date").get(0).text()));
            String[] params = element.getElementsByAttributeValueStarting("id", "comment_num_vote_")
                    .get(0).text().split("\\s*/\\s*");
            review.setLikes(Integer.parseInt(params[0]));
            review.setDislikes(Integer.parseInt(params[1]));

            reviews.add(review);
        }

        return reviews;
    }

    private LocalDateTime parseDate(String rawDate) {
        String[] params = rawDate.replace("|", "").split("\\s+");
        int day = Integer.parseInt(params[0]);
        Month month = translateMonth(params[1]);
        int year = Integer.parseInt(params[2]);
        params = params[3].split(":");
        int hours = Integer.parseInt(params[0]);
        int minutes = Integer.parseInt(params[1]);

        return LocalDateTime.of(year, month, day, hours, minutes);
    }

    private Month translateMonth(String russianMonth) {
        if ("января".equals(russianMonth)) {
            return Month.JANUARY;
        } if ("февраля".equals(russianMonth)) {
            return Month.FEBRUARY;
        } else if ("марта".equals(russianMonth)) {
            return Month.MARCH;
        } else if ("апреля".equals(russianMonth)) {
            return Month.APRIL;
        } else if ("мая".equals(russianMonth)) {
            return Month.MAY;
        } else if ("июня".equals(russianMonth)) {
            return Month.JUNE;
        } else if ("июля".equals(russianMonth)) {
            return Month.JULY;
        } else if ("августа".equals(russianMonth)) {
            return Month.AUGUST;
        } else if ("сентября".equals(russianMonth)) {
            return Month.SEPTEMBER;
        } else if ("октября".equals(russianMonth)) {
            return Month.OCTOBER;
        } else if ("ноября".equals(russianMonth)) {
            return Month.NOVEMBER;
        } else if ("декабря".equals(russianMonth)) {
            return Month.DECEMBER;
        }

        throw new IllegalArgumentException("No such month");
    }
}
