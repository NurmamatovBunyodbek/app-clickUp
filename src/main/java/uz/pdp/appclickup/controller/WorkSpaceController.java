package uz.pdp.appclickup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.MemberDto;
import uz.pdp.appclickup.payload.WorkSpaceDto;
import uz.pdp.appclickup.security.CurrentUser;
import uz.pdp.appclickup.service.WorkSpaceService;

import java.util.UUID;

@RestController
@RequestMapping("/api/workspace")
public class WorkSpaceController {

    @Autowired
    WorkSpaceService workSpaceService;


    @PostMapping
    public HttpEntity<?> addWorkSpace(@RequestBody WorkSpaceDto workSpaceDto , @CurrentUser User user) {
        ApiResponse apiResponse = workSpaceService.addWorkSpace(workSpaceDto,user);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editWorkSpace(@PathVariable Long id, @RequestBody WorkSpaceDto workSpaceDto) {
        ApiResponse apiResponse = workSpaceService.editWorkSpace(id, workSpaceDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/changeOwner{id}")
    public HttpEntity<?> changeOwnerWorkSpace(@PathVariable Long id, @RequestBody WorkSpaceDto workSpaceDto) {
        ApiResponse apiResponse = workSpaceService.changeOwnerWorkSpace(id, workSpaceDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
    @DeleteMapping("{id}")
    public HttpEntity<?> deleteWorkSpace(@PathVariable Long id) {
        ApiResponse apiResponse = workSpaceService.deleteWorkSpace(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/addOrEditOrRemove/{id}")
    public  HttpEntity<?> addOrEditOrRemoveWorkSpace(@PathVariable Long id , @RequestBody MemberDto memberDto){
        ApiResponse apiResponse = workSpaceService.addOrEditOrRemoveWorkSpace(id,memberDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }




}
