package ma.gemography.github.repository;

import ma.gemography.github.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
