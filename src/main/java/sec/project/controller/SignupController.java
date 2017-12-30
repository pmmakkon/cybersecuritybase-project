package sec.project.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;
    private List<Signup> list = new ArrayList<Signup>();

//    @RequestMapping("*")
 //   public String defaultMapping() {
  //      return "redirect:/form";
  //  }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address, @RequestParam String creaditCardNumber) {
        Signup signup = new Signup(name, address,creaditCardNumber);
        signupRepository.save(signup);
        this.list.add(signup);
        return "done";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(Model model, @RequestParam(required = false) String content) {
        model.addAttribute("list", list);
        return "listAllUsers";
    }
}
