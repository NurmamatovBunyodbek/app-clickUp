package uz.pdp.appclickup.entity.enums;

import uz.pdp.appclickup.entity.WorkSpaceRole;

import java.util.Arrays;
import java.util.List;

import static uz.pdp.appclickup.entity.enums.WorkSpaceName.ROLE_GUEST;
import static uz.pdp.appclickup.entity.enums.WorkSpaceName.ROLE_OWNER;


public enum WorkSpacePermissionName {

    CAN_ADD_OR_MEMBER("Add/Remove Members","Gives user permission to add  or remove member",
            Arrays.asList(ROLE_OWNER, WorkSpaceName.ROLE_ADMIN)),
    CAN_MANAGE_STATUS("Edit status ","Gives user permission..",
            Arrays.asList(ROLE_OWNER, ROLE_GUEST));

    private String name;
    private String description;
    private List<WorkSpaceName> workSpaceNames;

    WorkSpacePermissionName(String name, String description, List<WorkSpaceName> workSpaceNames) {
        this.name = name;
        this.description = description;
        this.workSpaceNames=workSpaceNames;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<WorkSpaceName> getWorkSpaceNames() {
        return workSpaceNames;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWorkSpaceNames(List<WorkSpaceName> workSpaceNames) {
        this.workSpaceNames = workSpaceNames;
    }

    WorkSpacePermissionName(String name, List<WorkSpaceName> workSpaceNames) {
        this.name = name;
        this.workSpaceNames = workSpaceNames;
    }
}
