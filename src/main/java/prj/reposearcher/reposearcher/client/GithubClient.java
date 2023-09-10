package prj.reposearcher.reposearcher.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import prj.reposearcher.reposearcher.coderepository.dto.Branch;
import prj.reposearcher.reposearcher.coderepository.dto.CodeRepository;

import java.util.List;

@Component
public class GithubClient extends Client {

    private final GithubProperties githubProperties;


    public GithubClient(GithubProperties githubProperties) {
        super();
        this.githubProperties = githubProperties;
    }

    @Override
    public List<CodeRepository> getRepositoriesByUsername(String username) {

        String url = githubProperties
                        .getUrl()
                        .getRepositories();

        ParameterizedTypeReference<List<CodeRepository>> responseType =
                new ParameterizedTypeReference<>() {};

        return makeGetRequest(url, responseType, username);
    }

    @Override
    public List<Branch> getBranchesByRepositoryAndUsername(String repositoryName, String username) {

        String url = githubProperties
                            .getUrl()
                            .getBranches();

        ParameterizedTypeReference<List<Branch>> responseType =
                new ParameterizedTypeReference<>() {};

        return makeGetRequest(url, responseType,
                username, repositoryName);
    }

    private <T> List<T> makeGetRequest(String url, ParameterizedTypeReference<List<T>> responseType, String... args){

        return webClient.get()
                .uri(url, args)
                .retrieve()
                .bodyToMono(responseType)
                .block();
    }
}
