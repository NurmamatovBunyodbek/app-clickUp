package uz.pdp.appclickup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
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
public class SpaceView extends AbsLongEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Space spaceId;
    @ManyToOne(fetch = FetchType.LAZY)
    private View viewId;

}

