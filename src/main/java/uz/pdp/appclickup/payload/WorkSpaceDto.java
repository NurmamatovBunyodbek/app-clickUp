package uz.pdp.appclickup.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
public class WorkSpaceDto {

    @NotNull
    private String name;
    @NotNull
    private String color;
    @NotNull
    private UUID avatarId;

}
