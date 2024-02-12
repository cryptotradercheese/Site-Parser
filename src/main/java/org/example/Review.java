package org.example;

import java.time.LocalDateTime;

public class Review {
    private String reviewerName;
    private LocalDateTime date;
    private int likes;
    private int dislikes;
    private String title;
    private String text;

    public String asCsv() {
        return new StringBuilder()
                .append("\"").append(escape(reviewerName)).append("\",")
                .append(date).append(",")
                .append(likes).append(",")
                .append(dislikes).append(",")
                .append("\"").append(escape(title)).append("\",")
                .append("\"").append(escape(text)).append("\"")
                .toString();
    }

    private String escape(String s) {
        return s.replace("\"", "\"\"");
    }

    public static String csvColumnNames() {
        return "reviewer_name,date,likes,dislikes,title,text";
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Review{" +
                "\nreviewerName='" + reviewerName + '\'' +
                ", \ndate=" + date +
                ", \nlikes=" + likes +
                ", \ndislikes=" + dislikes +
                ", \ntitle='" + title + '\'' +
                ", \ntext='" + text + '\'' +
                "\n}\n";
    }
}
