package prj.reposearcher.reposearcher.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import prj.reposearcher.reposearcher.repository.Branch;
import prj.reposearcher.reposearcher.repository.Repository;

import java.util.List;

@Component
public class GithubClient extends Client {

    private final GithubProperties githubProperties;


    public GithubClient(GithubProperties githubProperties) {
        super();
        this.githubProperties = githubProperties;
    }

    @Override
    public List<Repository> getRepositoriesByUsername(String username) {

        String url = githubProperties
                        .getUrl()
                        .getRepositories();

        List<Repository> response = webClient.get()
                .uri(url, username)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Repository>>() {
                }).block();
        
        return response;
    }

    @Override
    public List<Branch> getBranchesByRepositoryAndUsername(String repositoryName, String username) {

        String url = githubProperties
                            .getUrl()
                            .getBranches();


        return webClient.get()
                .uri(url, username, repositoryName)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Branch>>() {
                }).block();
    }
}
