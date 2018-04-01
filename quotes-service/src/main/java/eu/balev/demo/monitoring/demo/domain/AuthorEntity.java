package eu.balev.demo.monitoring.demo.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents an author of a quote (piece of wisdom). For example:
 *
 *
 * <blockquote>
 *   No alibi will save you from accepting the responsibility.
 *   Napoleon Hill
 * </blockquote>
 *
 * <blockquote>
 *   Happiness is found in doing, not merely possessing.
 *   Napoleon Hill
 * </blockquote>
 *
 * <blockquote>
 *    No snowflake in an avalanche ever feels responsible.
 *    Voltaire
 * </blockquote>
 *
 * An author may have authored many quotes.
 */
@Entity
@Table(name = "author")
public class AuthorEntity {

  private long id;
  private String name;
  private List<QuoteEntity> quotes;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the names(s) of the author.
   *
   * @return the names(s) of the author.
   */
  @Column(name="name", unique=true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns a list with quotes for the given author. Cannot be null.
   *
   * @return
   */
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  public List<QuoteEntity> getQuotes() {
    return quotes;
  }

  public void setQuotes(List<QuoteEntity> quotes) {
    this.quotes = quotes;
  }
}

