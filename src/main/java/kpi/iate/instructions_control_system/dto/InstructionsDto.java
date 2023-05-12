package kpi.iate.instructions_control_system.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructionsDto {

    private String title;

    private String headSurname;

    private String headName;

    private String headPatronymic;

    private String shortDescription;

    private String fullDescription;

    private String text;

    private Date startTime;

    private Date expTime;
}