package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.enums.TaskPermission;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectUser extends AbsLongEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private Project projectId;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    @Enumerated(value = EnumType.STRING)
    private TaskPermission taskPermission;


}
