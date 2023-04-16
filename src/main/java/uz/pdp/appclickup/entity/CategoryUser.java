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
public class CategoryUser extends AbsLongEntity {

    @Column(nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Category categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    @Enumerated(value = EnumType.STRING)
    private TaskPermission taskPermission;

}
