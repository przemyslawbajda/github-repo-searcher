package prj.reposearcher.reposearcher.client;

import org.springframework.web.reactive.function.client.WebClient;
import prj.reposearcher.reposearcher.coderepository.dto.Branch;
import prj.reposearcher.reposearcher.coderepository.dto.CodeRepository;

import java.util.List;

public abstract class Client {

    protected WebClient webClient;

    public Client() {
        this.webClient = WebClient.builder().build();
    }

    public abstract List<CodeRepository> getRepositoriesByUsername(String username);
    public abstract List<Branch> getBranchesByRepositoryAndUsername(String repositoryName, String username);


}
