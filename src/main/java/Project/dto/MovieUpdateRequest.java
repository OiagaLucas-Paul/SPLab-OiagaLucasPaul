package Project.dto;

public class MovieUpdateRequest {
    private String title;
    private Integer year;

    public MovieUpdateRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}
