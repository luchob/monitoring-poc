package eu.balev.demo.monitoring.demo.init;

import java.util.Objects;

/**
 * A quotes POJO, used to read the source of wisdom.
 */
class Quote {

  private String quoteText, quoteAuthor;

  String getQuoteAuthor() {
    return quoteAuthor;
  }

  Quote setQuoteAuthor(String quoteAuthor) {
    this.quoteAuthor = quoteAuthor;
    return this;
  }

  String getQuoteText() {
    return quoteText;
  }

  Quote setQuoteText(String quoteText) {
    Objects.requireNonNull(quoteText, "Quote text cannot be null!");

    this.quoteText = quoteText;
    return this;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(getQuoteText());
    sb.append(" [");
    sb.append(getQuoteAuthor() != null ? getQuoteAuthor() : "Unknown");
    sb.append("]");

    return sb.toString();
  }
}
