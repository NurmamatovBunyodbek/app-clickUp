package uz.pdp.appclickup.service;

import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.MemberDto;
import uz.pdp.appclickup.payload.WorkSpaceDto;

import java.util.UUID;


public interface WorkSpaceService {


    ApiResponse addWorkSpace(WorkSpaceDto workSpaceDto, User user);
    ApiResponse editWorkSpace(Long id , WorkSpaceDto workSpaceDto);

    ApiResponse changeOwnerWorkSpace(Long id, WorkSpaceDto workSpaceDto);

    ApiResponse deleteWorkSpace(Long id);

    ApiResponse addOrEditOrRemoveWorkSpace(Long id ,MemberDto memberDto);
}
