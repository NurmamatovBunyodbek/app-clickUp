package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.enums.StatusType;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Status extends AbsLongEntity {
    @Column(nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Space spaceId;
    @OneToOne(fetch = FetchType.LAZY)
    private Project projectId;
    @OneToOne(fetch = FetchType.LAZY)
    private Category categoryId;
    private String color;

    @Enumerated(value = EnumType.STRING)
    private StatusType statusType;
}
