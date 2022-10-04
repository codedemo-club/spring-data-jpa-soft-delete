package club.codedemo.springdatajpasoftdelete;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bar")
public class BarController {
  private final BarRepository barRepository;

  public BarController(BarRepository barRepository) {
    this.barRepository = barRepository;
  }

  @GetMapping
  public String all(Model model) {
    model.addAttribute ("bar", this.barRepository.findAll());
    return "bar";
  }
}
