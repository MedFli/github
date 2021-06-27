package ma.gemography.github.service;

import ma.gemography.github.controller.RepoController;
import ma.gemography.github.model.ListRepos;
import ma.gemography.github.model.Repos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReposService {
    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(RepoController.class);

    String URL = "https://api.github.com/search/repositories?q=created&sort=star&order=desc";


    public ResponseEntity<ListRepos> importRepositories() {

        logger.info("importing repositories data from github api");

        return restTemplate.exchange(URL, HttpMethod.GET, null, ListRepos.class);
    }

    public ListRepos importRepositoriesBy(String language) {

        logger.info("importing repositories data from github api");

        ResponseEntity<ListRepos> githubRepositories = restTemplate.exchange(URL, HttpMethod.GET, null, ListRepos.class);

        logger.info(" fetching api data done successfully ");

        return filterRepositoriesByLanguage(githubRepositories, language);
    }

    private ListRepos filterRepositoriesByLanguage(ResponseEntity<ListRepos> githubRepositories, String language) {

        ListRepos listRepo = githubRepositories.getBody();
        List<Repos> filteredList = new ArrayList<>();

        logger.info(" starting filtering imported repositories for language " + language);

        if (listRepo != null) {
            try {
                List<Repos> responseItems = listRepo.getItems();
                for (Repos repos : responseItems) {
                    if (repos.getLanguage().equals(language)) {
                        filteredList.add(repos);
                        listRepo.setInfo(" number of repositories using this language " + filteredList.size());
                    }
                    listRepo.setItems(filteredList);
                }
            } catch (Exception e) {
                logger.error(" something goes wrong , cannot filter this imported list" + e);
            }
        }
        return listRepo;
    }
}
