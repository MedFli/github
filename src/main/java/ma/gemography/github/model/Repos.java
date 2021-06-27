package ma.gemography.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@JsonIgnoreProperties(ignoreUnknown=true)
public class Repos {
    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("language")
    private String language;
    @JsonProperty("description")
    private String description;
    @JsonProperty("owner")
    @OneToOne
    private Owner owner;
}
