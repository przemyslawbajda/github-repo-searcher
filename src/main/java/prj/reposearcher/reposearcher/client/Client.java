package prj.reposearcher.reposearcher.client;

import org.springframework.web.reactive.function.client.WebClient;
import prj.reposearcher.reposearcher.repository.Branch;
import prj.reposearcher.reposearcher.repository.Repository;

import java.util.List;

public abstract class Client {

    protected WebClient webClient;

    public Client() {
        this.webClient = WebClient.builder().build();
    }

    public abstract List<Repository> getRepositoriesByUsername(String username);
    public abstract List<Branch> getBranchesByRepositoryAndUsername(String repositoryName, String username);


}
