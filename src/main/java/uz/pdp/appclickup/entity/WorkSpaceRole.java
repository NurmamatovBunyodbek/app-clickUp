package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.enums.WorkSpaceName;
import uz.pdp.appclickup.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceRole extends AbsEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkSpace workSpace;
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private WorkSpaceName spaceName;
}
