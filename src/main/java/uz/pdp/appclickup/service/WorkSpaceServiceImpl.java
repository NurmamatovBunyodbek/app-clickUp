package uz.pdp.appclickup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.appclickup.entity.*;
import uz.pdp.appclickup.entity.enums.AddType;
import uz.pdp.appclickup.entity.enums.WorkSpaceName;
import uz.pdp.appclickup.entity.enums.WorkSpacePermissionName;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.MemberDto;
import uz.pdp.appclickup.payload.WorkSpaceDto;
import uz.pdp.appclickup.repository.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class WorkSpaceServiceImpl implements WorkSpaceService {

    @Autowired
    WorkSpaceRepo workSpaceRepo;
    @Autowired
    AttachmentRepo attachmentRepo;
    @Autowired
    WorkSpaceUserRepo workSpaceUserRepo;
    @Autowired
    WorkSpaceRoleRepo workSpaceRoleRepo;

    @Autowired
    WorkSpacePermissionRepo workSpacePermissionRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public ApiResponse addWorkSpace(WorkSpaceDto workSpaceDto, User user) {
        if (workSpaceRepo.existsByOwnerIdAndName(user.getId(), workSpaceDto.getName()))
            return new ApiResponse("Sizda bunday nomli ishxona mavjud", false);
        WorkSpace workSpace = new WorkSpace(
                workSpaceDto.getName(),
                workSpaceDto.getColor(),
                user,
                workSpaceDto.getAvatarId() == null ? null :
                        attachmentRepo.findById(workSpaceDto.getAvatarId()).
                                orElseThrow(() -> new ResourceNotFoundException("Attachment"))

        );
        workSpaceRepo.save(workSpace);

        WorkSpaceRole ownerRole = workSpaceRoleRepo.save(new WorkSpaceRole(
                workSpace,
                WorkSpaceName.ROLE_OWNER.name(),
                null
        ));

        WorkSpaceRole admiinRole = workSpaceRoleRepo.save(new WorkSpaceRole(workSpace, WorkSpaceName.ROLE_ADMIN.name(), null));
        WorkSpaceRole memberRole = workSpaceRoleRepo.save(new WorkSpaceRole(workSpace, WorkSpaceName.ROLE_MEMBER.name(), null));
        WorkSpaceRole guestRole = workSpaceRoleRepo.save(new WorkSpaceRole(workSpace, WorkSpaceName.ROLE_GUEST.name(), null));


        WorkSpacePermissionName[] workSpacePermissionNames = WorkSpacePermissionName.values();
        List<WorkSpacePermission> workSpacePermissions = new ArrayList<>();
        for (WorkSpacePermissionName workSpacePermissionName : workSpacePermissionNames) {
            WorkSpacePermission workSpacePermission = new WorkSpacePermission(
                    ownerRole,
                    workSpacePermissionName);
            workSpacePermissions.add(workSpacePermission);
            if (workSpacePermissionName.getWorkSpaceNames().contains(WorkSpaceName.ROLE_ADMIN)) {
                workSpacePermissions.add(new WorkSpacePermission(
                        admiinRole,
                        workSpacePermissionName
                ));

            }
            if (workSpacePermissionName.getWorkSpaceNames().contains(WorkSpaceName.ROLE_MEMBER)) {
                workSpacePermissions.add(new WorkSpacePermission(
                        memberRole,
                        workSpacePermissionName
                ));
            }
            if (workSpacePermissionName.getWorkSpaceNames().contains(WorkSpaceName.ROLE_GUEST)) {
                workSpacePermissions.add(new WorkSpacePermission(
                        guestRole,
                        workSpacePermissionName
                ));
            }
        }
            workSpacePermissionRepo.saveAll(workSpacePermissions);

            workSpaceUserRepo.save(new WorkSpaceUser(
                    workSpace,
                    user,
                    ownerRole,
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis())
            ));

        return new ApiResponse("Ishxona saqlandi", true);
    }

    @Override
    public ApiResponse editWorkSpace(Long id, WorkSpaceDto workSpaceDto) {
        return null;
    }

    @Override
    public ApiResponse changeOwnerWorkSpace(Long id, WorkSpaceDto workSpaceDto) {
        return null;
    }

    @Override
    public ApiResponse deleteWorkSpace(Long id) {
        try {
            workSpaceRepo.deleteById(id);
            return new ApiResponse("Deleted ", true);
        } catch (Exception e) {
            return new ApiResponse("Exception", false);
        }

    }

    @Override
    public ApiResponse addOrEditOrRemoveWorkSpace(Long id, MemberDto memberDto) {

        if (memberDto.getAddType().equals(AddType.ADD)) {

            WorkSpaceUser workSpaceUser = new WorkSpaceUser(
                    workSpaceRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("id")),
                    userRepo.findById(memberDto.getId()).orElseThrow(() -> new ResourceNotFoundException("id")),
                    workSpaceRoleRepo.findById(memberDto.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("id")),
                    new Timestamp(System.currentTimeMillis())
                    , null
            );
             workSpaceUserRepo.save(workSpaceUser);
        } else if (memberDto.getAddType().equals(AddType.EDIT)) {


            WorkSpaceUser workSpaceUser = workSpaceUserRepo.findByWorkSpaceIdAndUserId(id, memberDto.getId())
                    .orElseGet(WorkSpaceUser::new);
            

        } else if (memberDto.getAddType().equals(AddType.DELETED)) {
              workSpaceUserRepo.deleteByWorkSpaceIdAndUserId(id,memberDto.getId());
        }


        return new ApiResponse("Successfully",true);
    }
}
