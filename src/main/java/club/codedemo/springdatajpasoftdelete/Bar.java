package club.codedemo.springdatajpasoftdelete;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Bar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Foo foo;

  private String name;

  public Bar() {
  }

  public Bar(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Foo getFoo() {
    return foo;
  }

  public void setFoo(Foo foo) {
    this.foo = foo;
  }
}
