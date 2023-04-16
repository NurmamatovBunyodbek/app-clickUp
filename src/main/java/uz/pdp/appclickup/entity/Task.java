package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task extends AbsLongEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)

    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    private Status statusId;
    @OneToOne(fetch = FetchType.LAZY)
    private Category categoryId;

    private Integer parentTaskId;
    private Timestamp started_date;

    private boolean start_time_has;
    private Timestamp due_time;
    private boolean due_time_has;

    private Long estimate_time;

    private Timestamp actived_date;

}
