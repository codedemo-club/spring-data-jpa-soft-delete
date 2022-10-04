package club.codedemo.springdatajpasoftdelete;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("foo")
public class FooController {
  private final FooRepository fooRepository;

  public FooController(FooRepository fooRepository) {
    this.fooRepository = fooRepository;
  }

  @GetMapping
  public String all(Model model) {
    model.addAttribute("foos", this.fooRepository.findAll());
    return "foo";
  }
}
