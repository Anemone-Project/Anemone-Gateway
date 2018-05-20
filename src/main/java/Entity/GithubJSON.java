package Entity;

import java.util.Date;
import java.util.Set;

public class GithubJSON {

    private Set<GithubCommit> commits;
    private GithubRepository repository;
    private GithubUser pusher;
    private GithubSender sender;

    public Set<GithubCommit> getCommits() {
        return commits;
    }

    public void setCommits(Set<GithubCommit> commits) {
        this.commits = commits;
    }

    public GithubRepository getRepository() {
        return repository;
    }

    public void setRepository(GithubRepository repository) {
        this.repository = repository;
    }

    public GithubUser getPusher() {
        return pusher;
    }

    public void setPusher(GithubUser pusher) {
        this.pusher = pusher;
    }

    public GithubSender getSender() {
        return sender;
    }

    public void setSender(GithubSender sender) {
        this.sender = sender;
    }
}
