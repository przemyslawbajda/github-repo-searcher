package prj.reposearcher.reposearcher.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("github")
public class GithubProperties {

    private Url url;

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public static class Url {

        private String repositories;
        private String branches;

        public String getRepositories() {
            return repositories;
        }

        public String getBranches() {
            return branches;
        }

        public void setRepositories(String repositories) {
            this.repositories = repositories;
        }

        public void setBranches(String branches) {
            this.branches = branches;
        }
    }


}
