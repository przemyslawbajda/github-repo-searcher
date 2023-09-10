package prj.reposearcher.reposearcher.coderepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.reposearcher.reposearcher.coderepository.dto.CodeRepository;


import java.util.List;

@RestController
@RequestMapping("api/")
public class CodeRepositoryController {

    private final CodeRepositoryService codeRepositoryService;

    public CodeRepositoryController(CodeRepositoryService codeRepositoryService) {
        this.codeRepositoryService = codeRepositoryService;
    }

    @GetMapping("repositories/{username}")
    public ResponseEntity<List<CodeRepository>> getRepositoriesByUsername(@PathVariable String username) {

        return ResponseEntity.ok(codeRepositoryService.getNotForkedRepositoriesByUsername(username));
    }
}
