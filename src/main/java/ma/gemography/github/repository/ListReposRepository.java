package ma.gemography.github.repository;

import ma.gemography.github.model.ListRepos;
import ma.gemography.github.model.Repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface ListReposRepository extends JpaRepository<ListRepos,Long> {
}
