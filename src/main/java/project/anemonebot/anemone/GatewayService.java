package project.anemonebot.anemone;

import Entity.GithubJSON;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GatewayService {
    Gson gson = new Gson();

    public void receiveGithub(String json){
        json = json.trim();
        GithubJSON message = gson.fromJson(json, GithubJSON.class);
        String formattedMessage = formatGithub(message);
        sendGithubResponse(formattedMessage);
    }

    public String formatGithub(GithubJSON message){
        DateFormat format = new SimpleDateFormat("yy/MM/dd - HH:mm");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Commits:");
        stringBuilder.append("\n");
        stringBuilder.append("{");
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("ID: ");
        message.getCommits().iterator().forEachRemaining(githubCommit -> stringBuilder.append(githubCommit.getId().trim()).append("\n")
                .append("\t\t")
                .append("Tree id: ")
                .append(githubCommit.getTree_id()).append("\n")
                .append("\t\t")
                .append("Distinct: ")
                .append(githubCommit.getDistinct()).append("\n")
                .append("\t\t")
                .append("Message: ")
                .append(githubCommit.getMessage()).append("\n")
                .append("\t\t")
                .append("Timestamp: ")
                .append(githubCommit.getTimestamp()).append("\n")
                .append("\t\t")
                .append("URL: ").append("<").append(githubCommit.getUrl()).append(">").append("\n")
                .append("\n\n")
                .append("\t\t")
                .append("Author:")
                .append("\n")
                .append("\t\t")
                .append("{")
                .append("\n")
                .append("\t\t\t")
                .append("Name: ")
                .append(githubCommit.getAuthor().getName()).append("\n")
                .append("\t\t\t")
                .append("Email: ")
                .append(githubCommit.getAuthor().getEmail()).append("\n")
                .append("\t\t\t")
                .append("Username: ")
                .append(githubCommit.getAuthor().getUsername()).append("\n")
                .append("\t\t")
                .append("}")
                .append("\n\n")
                .append("\t\t")
                .append("Committer: \n")
                .append("\t\t")
                .append("{")
                .append("\n")
                .append("\t\t\t")
                .append("Name: ")
                .append(githubCommit.getCommitter().getName()).append("\n")
                .append("\t\t\t")
                .append("Email: ")
                .append(githubCommit.getCommitter().getEmail()).append("\n")
                .append("\t\t\t")
                .append("Username: ")
                .append(githubCommit.getCommitter().getUsername()).append("\n")
                .append("\t\t")
                .append("}")
                .append("\n\n")
                .append("\t\t")
                .append("Modified Files:")
                .append("\n")
                .append("\t\t")
                .append("{")
                .append("\n")
                .append("\t\t\t")
                .append(githubCommit.getModifiedStrings())
                .append("\t\t")
                .append("}")
                .append("\n")
                .append("}"));
        stringBuilder.append("\n\n");
        stringBuilder.append("Repository: ");
        stringBuilder.append("\n");
        stringBuilder.append("{");
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("ID: ");
        stringBuilder.append(message.getRepository().getId());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("Name: ");
        stringBuilder.append(message.getRepository().getName());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("Full Name: ");
        stringBuilder.append(message.getRepository().getFullname());
        stringBuilder.append("\n\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("Owner:");
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("{");
        stringBuilder.append("\n");
        stringBuilder.append("\t\t\t");
        stringBuilder.append("Name: ");
        stringBuilder.append(message.getRepository().getOwner().getName());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t\t");
        stringBuilder.append("Email: ");
        stringBuilder.append(message.getRepository().getOwner().getEmail());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("}");
        stringBuilder.append("\n\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("HTML URL: ");
        stringBuilder.append("<").append(message.getRepository().getHtml_url()).append(">");
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("Master Branch: ");
        stringBuilder.append(message.getRepository().getMaster_branch());
        stringBuilder.append("\n");
        stringBuilder.append("}");
        stringBuilder.append("\n\n");
        stringBuilder.append("Pusher: ");
        stringBuilder.append("\n");
        stringBuilder.append("{");
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("Name: ");
        stringBuilder.append(message.getPusher().getName());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("Email: ");
        stringBuilder.append(message.getPusher().getEmail());
        stringBuilder.append("\n");
        stringBuilder.append("}");
        stringBuilder.append("\n\n");
        stringBuilder.append("Sender: ");
        stringBuilder.append("\n");
        stringBuilder.append("{");
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("Login: ");
        stringBuilder.append(message.getSender().getLogin());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("ID: ");
        stringBuilder.append(message.getSender().getId());
        stringBuilder.append("\n");
        stringBuilder.append("\t\t");
        stringBuilder.append("URL: ");
        stringBuilder.append("<").append(message.getSender().getUrl()).append(">");
        stringBuilder.append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void sendGithubResponse(String message){
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForEntity("http://localhost:26500/anemone/receivegithubresponse", message, String.class);

    }
}
