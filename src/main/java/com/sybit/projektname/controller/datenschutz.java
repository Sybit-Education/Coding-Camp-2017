package projekt.Controller;

/**
 * Created by fzr on 06.03.17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class datenschutz {
    


    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/datenschutz")
    public String welcome(Map<String, Object> model) {
        return "datenschutz";
    }

}