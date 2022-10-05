package club.codedemo.springdatajpasoftdelete;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("bar")
public class BarController {
  private final BarRepository barRepository;

  public BarController(BarRepository barRepository) {
    this.barRepository = barRepository;
  }

  @GetMapping
  public String all(Model model) {
    model.addAttribute("bars", this.barRepository.findAll());
    return "bar";
  }

  @PostMapping
  public String save(@RequestParam Map<String, String> barMap) {
    Bar bar = new Bar();
    bar.setName(barMap.get("name"));
    Foo foo = new Foo();
    foo.setId(Long.valueOf(barMap.get("foo_id")));
    bar.setFoo(foo);
    this.barRepository.save(bar);
    return "redirect:/bar";
  }

  @GetMapping("add")
  public String add() {
    return "bar-add";
  }

  @GetMapping("delete/{id}")
  public String deleteById(@PathVariable Long id) {
    this.barRepository.deleteById(id);
    return "redirect:/bar";
  }
}
