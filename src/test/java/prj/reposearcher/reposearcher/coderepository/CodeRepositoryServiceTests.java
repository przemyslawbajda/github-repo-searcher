package prj.reposearcher.reposearcher.coderepository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import prj.reposearcher.reposearcher.client.GithubClient;
import prj.reposearcher.reposearcher.coderepository.dto.CodeRepository;
import prj.reposearcher.reposearcher.exceptions.UserNotFoundException;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CodeRepositoryServiceTests {

    @Mock
    private GithubClient githubClient;

    @InjectMocks
    private CodeRepositoryService codeRepositoryService;

    @Test
    public void givenUsername_whenGetNotForkedRepositoriesByUsername_thenListOfNotForkedRepositories(){
        //given
        CodeRepository repository1 = new CodeRepository("zzz", "abc", false);
        CodeRepository repository2 = new CodeRepository("yyy", "abc", true);
        CodeRepository repository3 = new CodeRepository("vvv", "abc", false);

       BDDMockito.given(githubClient.getRepositoriesByUsername("abc")).willReturn(List.of(repository1,
                                                                                            repository2,
                                                                                            repository3));

        //when
        List<CodeRepository> notForkedRepos = codeRepositoryService.getNotForkedRepositoriesByUsername("abc");

        //then
        Assertions.assertThat(notForkedRepos.size()).isEqualTo(2);

    }

    @Test
    public void givenNotExistingUsername_whenGetNotForkedRepositoriesByUsername_thenThrowUserNotFoundException(){
        //given
        BDDMockito.given(githubClient.getRepositoriesByUsername("aaabbbccc")).willThrow(UserNotFoundException.class);

        //when
        org.junit.jupiter.api.Assertions.assertThrows(UserNotFoundException.class, () -> {
            codeRepositoryService.getNotForkedRepositoriesByUsername("aaabbbccc");
        });

        //then
        BDDMockito.verify(githubClient, Mockito.never()).getBranchesByRepositoryAndUsername(
                "aaabbbccc", "zzz");

    }

    @Test
    public void givenUsernameAndAllForkedRepos_whenGetNotForkedRepositoriesByUsername_thenReturnEmptyList(){
        //given
        CodeRepository repository1 = new CodeRepository("zzz", "abc", true);
        CodeRepository repository2 = new CodeRepository("yyy", "abc", true);
        CodeRepository repository3 = new CodeRepository("vvv", "abc", true);

        BDDMockito.given(githubClient.getRepositoriesByUsername("abc")).willReturn(List.of(repository1,
                repository2,
                repository3));

        //when
        List<CodeRepository> notForkedRepos = codeRepositoryService.getNotForkedRepositoriesByUsername("abc");

        //then
        Assertions.assertThat(notForkedRepos.size()).isEqualTo(0);

    }
}
