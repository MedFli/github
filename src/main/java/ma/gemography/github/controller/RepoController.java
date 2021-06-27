package ma.gemography.github.controller;

import ma.gemography.github.model.ListRepos;
import ma.gemography.github.service.ReposService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController {

    private final ReposService reposService;

    RepoController(ReposService reposService) {
        this.reposService = reposService;
    }

    @GetMapping(value = "/repositories/{language}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<ListRepos> getAllRepositoriesByDate(@PathVariable(value = "language") String language) {
        ListRepos filteredGithubRepositories = reposService.importRepositoriesBy(language);
        return new ResponseEntity<>(filteredGithubRepositories, HttpStatus.OK);
    }

    @GetMapping(value = "/repositories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<ListRepos> getAllRepositories() {
        return reposService.importRepositories();
    }
}
