package web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class Presenter {

    private static final List<String> THEMES = Arrays.asList("jsp", "bootstrap", "thymeleaf");

    @Autowired
    private UserService userService;

    private String theme = THEMES.get(0);

    public Presenter() {
    }

    @ModelAttribute("now")
    public String now() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("themes", THEMES);
        return theme + "/home";
    }

    @RequestMapping("/create-theme")
    public ModelAndView theme(@RequestParam String theme) {
        this.theme = theme;
        return new ModelAndView(theme + "/home", "themes", THEMES);
    }

    @RequestMapping(value = "/greeting")
    public String greeting(@CookieValue("JSESSIONID") Cookie cookie, HttpServletRequest request, Model model) {
        model.addAttribute("stringList", Arrays.asList("uno", "dos", "tres"));
        model.addAttribute("cookie", cookie.getName());
        model.addAttribute("ip", request.getRemoteAddr());
        return theme + "/greeting";
    }

    @RequestMapping("/user-list")
    public ModelAndView listUsers() {
        ModelAndView modelAndView = new ModelAndView(theme + "/userList");
        modelAndView.addObject("userList", userService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = {"/delete-user/{id}"})
    public String deleteUser(@PathVariable int id, Model model) {
        userService.delete(id);
        model.addAttribute("userList", userService.findAll());
        return theme + "/userList";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User(userService.generateId()));
        return theme + "/createUser";
    }


}
