package uz.pdp.appclickup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskHistory  extends AbsLongEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Task taskId;

    @Column(nullable = false)
    private String change_field_name;
    @Column(nullable = false)
    private String before;
    @Column(nullable = false)
    private String after;
    private UUID data;
}
