package kpi.iate.instructions_control_system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tutors")
public class Tutor {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "instruction_head_surname")
    private String headSurname;

    @Column(name = "instruction_head_name")
    private String headName;

    @Column(name = "instruction_head_patronymic")
    private String headPatronymic;

    @Column(name = "instruction_head_control_surname")
    private String headControlSurname;

    @Column(name = "instruction_head_control_name")
    private String headControlName;

    @Column(name = "instruction_head_control_patronymic")
    private String headControlPatronymic;

    @Column(name = "position")
    private String position;


}
