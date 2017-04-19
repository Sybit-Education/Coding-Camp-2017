package projekt.Controller;

/**
 * Created by fzr on 06.03.17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class QuizCkeckController {
    
    private String quizCheck= "Deine Antwort zu Frage Milchwerk";
    private String locationImg = "https://dl.airtable.com/ddNZDQDSLiyK5Vmkhg76_full_2017-03-03%2021.03.00.jpg";


    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/quiz-check")
    public String welcome(Map<String, Object> model) {
        model.put("quizCheckName",quizCheck);
        model.put("locationImg", locationImg);
        return "quiz-check";
    }

}