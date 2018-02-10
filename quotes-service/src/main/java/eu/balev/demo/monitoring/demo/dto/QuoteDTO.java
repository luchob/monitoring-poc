package eu.balev.demo.monitoring.demo.dto;

public class QuoteDTO {

  private String text, author;
  private long id;

  public long getId() {
    return id;
  }

  public QuoteDTO setId(long id) {
    this.id = id;
    return this;
  }

  public String getText() {
    return text;
  }

  public QuoteDTO setText(String text) {
    this.text = text;
    return this;
  }

  public String getAuthor() {
    return author;
  }

  public QuoteDTO setAuthor(String author) {
    this.author = author;
    return this;
  }
}
