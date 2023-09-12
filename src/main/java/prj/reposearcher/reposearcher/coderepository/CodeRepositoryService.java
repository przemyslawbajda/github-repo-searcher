package prj.reposearcher.reposearcher.coderepository;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import prj.reposearcher.reposearcher.client.GithubClient;
import prj.reposearcher.reposearcher.coderepository.dto.Branch;
import prj.reposearcher.reposearcher.coderepository.dto.CodeRepository;
import prj.reposearcher.reposearcher.exceptions.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CodeRepositoryService {

    private final GithubClient githubClient;

    CodeRepositoryService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    List<CodeRepository> getNotForkedRepositoriesByUsername(String username) {

        List<CodeRepository> codeRepositories;
        codeRepositories = getRepositoriesByUsername(username);
        codeRepositories = getNotForkedRepositories(codeRepositories);

        codeRepositories.forEach(repo -> {
            List<Branch> branches = githubClient.getBranchesByRepositoryAndUsername(repo.getName(), repo.getOwnerName());
            repo.setBranchList(branches);
        });

        return codeRepositories;
    }

    private List<CodeRepository> getRepositoriesByUsername(String username) {

        try {
            return githubClient.getRepositoriesByUsername(username);
        } catch (WebClientResponseException.NotFound ex) {
            throw new UserNotFoundException("Failed to download repositories info: user does not exists",ex);
        }
    }

    private static List<CodeRepository> getNotForkedRepositories(List<CodeRepository> codeRepositories) {
        return codeRepositories.stream()
                .filter(repo -> !repo.isFork())
                .collect(Collectors.toList());
    }

}
