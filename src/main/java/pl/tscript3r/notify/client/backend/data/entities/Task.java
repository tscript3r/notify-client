package pl.tscript3r.notify.client.backend.data.entities;

import org.hibernate.validator.constraints.URL;
import pl.tscript3r.notify.client.backend.data.enums.TaskState;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Task extends AbstractEntity {

    @URL
    @NotEmpty
    @Max(255)
    private String url;

    @NotNull
    @Column(nullable = false)
    private Integer urlHash;

    @OneToOne(cascade = CascadeType.ALL)
    private User owner;

    @Min(60)
    @NotNull
    @Column(nullable = false)
    private Integer refreshInterval;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskState state;

    @PrePersist
    @PreUpdate
    private void prepareData() {
        this.urlHash = url == null ? null : url.toLowerCase().hashCode();
    }

}
