package project.anemonebot.anemone;

import org.springframework.web.client.RestTemplate;

public class GatewayService {

    /**
     * Method handling requests sent by Github such as Push, Pull request and similiar changes to repository.
     *
     * @param json JSON string sent by github containing information regarding changes.
     */
    public void handleGithubRequest(String json) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:26500/github/receivegithubresponse", json, String.class);
    }
}
