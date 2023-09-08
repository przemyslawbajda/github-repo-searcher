package prj.reposearcher.reposearcher.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("api/")
public class RepositoryController {

    private final RepositoryService repositoryService;

    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("repositories/{username}")
    public ResponseEntity<List<Repository>> getRepositoriesByUsername(@PathVariable String username){

        return ResponseEntity.ok(repositoryService.getNotForkedRepositoriesByUsername(username));
    }
}
