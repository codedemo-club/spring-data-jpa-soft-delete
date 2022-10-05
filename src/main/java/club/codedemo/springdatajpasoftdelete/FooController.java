package club.codedemo.springdatajpasoftdelete;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

  @GetMapping("delete/{id}")
  public String deleteById(@PathVariable Long id) {
    this.fooRepository.deleteById(id);
    return "redirect:/foo";
  }

  @GetMapping("add")
  public String add() {
    return "foo-add";
  }

  @PostMapping
  public String save(@RequestParam Map<String, String> fooMap) {
    Foo foo = new Foo();
    foo.setName(fooMap.get("name"));
    this.fooRepository.save(foo);
    return "redirect:/foo";
  }
}
