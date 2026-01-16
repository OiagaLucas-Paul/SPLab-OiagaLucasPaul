package Project.dto;

public class MovieCreateRequest {
    private String title;
    private Integer year;

    public MovieCreateRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}
