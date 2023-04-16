package uz.pdp.appclickup.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import uz.pdp.appclickup.entity.enums.WorkSpaceName;
import uz.pdp.appclickup.entity.template.AbsEntity;

public class WorkSpacePermission extends AbsEntity {

     @ManyToOne(fetch = FetchType.LAZY)
     private WorkSpaceRole workSpaceRole;
     @Enumerated(value = EnumType.STRING)
     private WorkSpaceName workSpaceName;
}
