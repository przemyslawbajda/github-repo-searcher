package prj.reposearcher.reposearcher.coderepository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class CodeRepository {

    private String name;
    private String ownerName;
    private List<Branch> branchList;
    private Boolean fork;

    @JsonProperty("owner")
    private void unpackOwnerNestedObject(Map<String, String> owner){
        this.ownerName = owner.get("login");
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public Boolean isFork() {
        return fork;
    }
}
