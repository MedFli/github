package ma.gemography.github.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ListRepos {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @JsonProperty("items")
    @OneToMany(targetEntity = Repos.class)
    private List<Repos> items;
    private String info;
}
