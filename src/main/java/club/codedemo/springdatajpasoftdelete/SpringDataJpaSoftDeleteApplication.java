package club.codedemo.springdatajpasoftdelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequestMapping
public class SpringDataJpaSoftDeleteApplication {

	@Autowired
	BarRepository barRepository;

	@Autowired
	FooRepository fooRepository;

	@GetMapping
	public String home() {
		return "home";
	}

	@GetMapping("header")
	public String header() {
		return "header";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaSoftDeleteApplication.class, args);
	}

	@PostConstruct
	void dataInit() {
		Foo foo = new Foo("foo");
		Foo foo1 = new Foo("foo1");
		this.fooRepository.save(foo);
		this.fooRepository.save(foo1);
		Bar bar = new Bar("bar");
		Bar bar1 = new Bar("bar1");
		bar.setFoo(foo);
		bar1.setFoo(foo1);
		this.barRepository.save(bar);
		this.barRepository.save(bar1);
	}
}
