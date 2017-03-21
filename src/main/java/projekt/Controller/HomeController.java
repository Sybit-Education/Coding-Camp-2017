package projekt.Controller;

/**
 * Created by fzr on 06.03.17.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {

    //TODO Wanted or unnecessary?
    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}