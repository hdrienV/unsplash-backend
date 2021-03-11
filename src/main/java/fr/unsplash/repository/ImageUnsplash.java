package fr.unsplash.repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ImageUnsplash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @NonNull
    @JsonProperty("label")
    private String label;

    @JsonProperty("date")
    private LocalDateTime creationDate;

    @JsonProperty("url")
    private String url;

    public ImageUnsplash() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @NonNull
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    @NonNull
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(@NonNull LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageUnsplash that = (ImageUnsplash) o;
        return Objects.equal(id, that.id) && Objects.equal(label, that.label) && Objects.equal(creationDate, that.creationDate) && Objects.equal(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, label, creationDate, url);
    }
}
