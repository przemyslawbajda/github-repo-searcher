package prj.reposearcher.reposearcher.repository;

import org.springframework.stereotype.Service;
import prj.reposearcher.reposearcher.client.GithubClient;

import java.util.List;

@Service
public class RepositoryService {

    private final GithubClient githubClient;

    public RepositoryService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public List<Repository> getNotForkedRepositoriesByUsername(String username){

        List<Repository> repositoryList = githubClient.getRepositoriesByUsername(username);

        repositoryList.stream()
                .filter(repo -> !repo.isFork())
                .toList()
                .forEach(repo -> repo.setBranchList(
                                githubClient.getBranchesByRepositoryAndUsername(repo.getName(), repo.getOwnerName()))
                );

        return  repositoryList;
    }
}
