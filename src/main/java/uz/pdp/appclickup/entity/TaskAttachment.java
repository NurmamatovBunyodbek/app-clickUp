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
public class TaskAttachment extends AbsLongEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Task taskId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment attachmentId;
    private boolean pin_cover_image;
}
