package io.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.example.demo.repository.DataRepository;
import io.example.demo.repository.details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private DataRepository dataRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView welcome(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
    @PostMapping(path="/") // Map ONLY POST Requests
    public @ResponseBody ModelAndView addNewUser (Model model,@RequestParam String Name
            , @RequestParam String EmailID, @RequestParam String Password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ModelAndView modelAndView = new ModelAndView();
        details n = new details();
        n.setName(Name);
        n.setEmailID(EmailID);
        n.setPassword(Password);
        dataRepository.save(n);
        model.addAttribute("name",Name);

        modelAndView.setViewName("showDetails");
        return modelAndView;
    }
    @GetMapping(path="/show")
    public @ResponseBody Iterable<details> getAllUsers(ModelMap model) {
        // This returns a JSON or XML with the user


        return dataRepository.findAll();
    }
//    @RequestMapping(value="/", method = RequestMethod.POST)
//    public ModelAndView showWelcomePage(ModelMap model,Map<String, String> body ){
//        ModelAndView modelAndView = new ModelAndView();
//        String EmailID = body.get("EmailID");
//        String Name = body.get("Name");
//        String Password = body.get("Password");
//        dataRepository.save(new details(Name,EmailID,Password));
//        modelAndView.setViewName("showDetails");
//        return modelAndView;
//'
//    }

//    public String index(){
//        return "Login";
//    }
}
