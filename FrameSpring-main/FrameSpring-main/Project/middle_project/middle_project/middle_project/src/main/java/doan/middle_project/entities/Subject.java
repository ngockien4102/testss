package doan.middle_project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "subject_code", columnDefinition = "longtext")
    private String subjectCode;

    @Column(name = "subject_name", columnDefinition = "longtext")
    private String subjectName;

    @Column(name = "subject_note", columnDefinition = "longtext")
    private String subjectNote;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "prerequisite")
    private Integer preRequisite;

    @ManyToOne
    @JoinColumn(name = "curriculum_id", referencedColumnName = "curriculum_id", nullable = false)
    private Curriculum curriculum;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subject_PLO", joinColumns = @JoinColumn(name = "subjectId"),
            inverseJoinColumns = @JoinColumn(name = "ploId"))
    private List<PLO> ploId;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Material> material;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CLO> clo;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sessions> sessions;

    @OneToMany( mappedBy = "subject",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Assessment> assessment;
}
