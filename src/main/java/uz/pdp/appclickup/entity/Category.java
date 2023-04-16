package uz.pdp.appclickup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category  extends AbsLongEntity {

    @Column(nullable = false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Project projectId;
    @Column(nullable = false)
    private String accessType;
    private String archived;
    private String color;
}
