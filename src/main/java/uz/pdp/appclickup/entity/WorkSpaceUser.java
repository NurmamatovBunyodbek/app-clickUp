package uz.pdp.appclickup.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appclickup.entity.template.AbsEntity;
import uz.pdp.appclickup.entity.template.AbsLongEntity;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkSpaceUser extends AbsLongEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkSpace workSpace;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private WorkSpaceRole workSpaceRole;
    @Column(nullable = false)
    private Timestamp dateInvited;
    @Column(nullable = false)
    private Timestamp dateJoined;
}
