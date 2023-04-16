package uz.pdp.appclickup.entity;

import jakarta.persistence.*;
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
public class Space extends AbsLongEntity {
    @Column(nullable = false)
    private String name;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkSpace workSpace;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment avatarId;

    private String accessType;

    @Column(nullable = false)
    private String initialLetter;
    @OneToOne
    private Icon iconId;


}
