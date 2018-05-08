package project.anemonebot.anemone;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller-class for incoming HTTP-calls to Anemone endpoints.
 */

@RestController(value = "anemone/")
public class AnemoneController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    /**
     * Simple Endpoint for testing connection to micro-service.
     * @param name Optional Request Parameter to be sent through URL.
     * @return new Greeting object.
     */
    @RequestMapping(value = "greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    /**
     * Unfinished endpoint awaiting proper URL for connection to github.
     * @param jsonString
     */
    @RequestMapping(value = "github", method = RequestMethod.POST)
    public void receiveGithubJSON(@RequestBody String jsonString){
        System.out.println(jsonString);

    }


}
