package club.codedemo.springdatajpasoftdelete;


import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "update `bar` set deleted = 1 where id = ?")
public class Bar implements SoftDelete {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Foo foo;

  private String name;
  private Boolean deleted = false;

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

  @Override
  public Boolean getDeleted() {
    return this.deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }
}
