package club.codedemo.springdatajpasoftdelete;

import org.springframework.data.repository.CrudRepository;

public interface FooRepository extends CrudRepository<Foo, Long> {
}
