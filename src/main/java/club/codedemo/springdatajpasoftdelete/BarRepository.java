package club.codedemo.springdatajpasoftdelete;

import org.springframework.data.repository.CrudRepository;

public interface BarRepository extends CrudRepository<Bar, Long> {
}
