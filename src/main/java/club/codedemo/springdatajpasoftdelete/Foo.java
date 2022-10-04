package club.codedemo.springdatajpasoftdelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Foo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "foo")
  private List<Bar> bars = new ArrayList<>();

  public Foo() {
  }

  public Foo(String name) {
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

  public List<Bar> getBars() {
    return bars;
  }

  public void setBars(List<Bar> bars) {
    this.bars = bars;
  }
}
