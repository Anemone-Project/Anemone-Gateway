package project.anemonebot.anemone;

import Entity.GithubJSON;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;


/**
 * Controller-class for incoming HTTP-calls to Anemone endpoints.
 */

@RestController()
@RequestMapping(value = "/anemone")
public class GatewayController {

    Logger logger = LogManager.getLogger(getClass());
    GatewayService service = new GatewayService();

    /**
     * Endpoint for testing connection to micro-service.
     * @return new Greeting object.
     */
    @RequestMapping(value = "/anemonetest", method = RequestMethod.GET, produces = "text/plain")
    public String anemoneConnectionTest() {

        return "Connection OK!";
    }


    /**
     * Endpoint for Github Webhook
     * @param json
     */
    @RequestMapping(value = "/github", method = RequestMethod.POST)
    public void receiveGithubJSON(@RequestBody String json ){
            service.receiveGithub(json);

    }


    /**
     * Endpoint for testing connection between micro-services.
     * @param word Used to gauge whether or not request reached end point.
     * @return
     */
    @RequestMapping(value = "/anemoneintergrationtest/{word}", method = RequestMethod.GET)
    public String anemoneIntergrationTest(@PathVariable ("word") String word){
        return word + " Gateway";
    }


}
