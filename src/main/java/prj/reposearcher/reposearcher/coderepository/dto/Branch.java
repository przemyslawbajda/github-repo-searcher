package prj.reposearcher.reposearcher.coderepository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Branch {

    String name;
    String commitSha;

    @JsonProperty("commit")
    private void unpackCommitNestedObject(Map<String, String> commit){
        this.commitSha = commit.get("sha");
    }

    public String getName() {
        return name;
    }

    public String getCommitSha() {
        return commitSha;
    }
}
