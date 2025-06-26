package com.zidio.zidioconnect.Controller;


import com.zidio.zidioconnect.DTO.UserInfoResponse;
import com.zidio.zidioconnect.DTO.UserStatusUpdateRequest;
import com.zidio.zidioconnect.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")


public class AdminController{

    @Autowired
    private AdminService adminService;



    @PutMapping("/user/status")

    public UserInfoResponse updateUserStatus(@RequestBody UserStatusUpdateRequest request){
        return adminService.updateUserStatus(request);
    }

    @GetMapping("/users")

    public List<UserInfoResponse> getAllUsers(){
        return adminService.getAllUsers();
    }

    @GetMapping("/users/{role}")
    public List<UserInfoResponse> getUserByRole(@PathVariable String role ){
        return adminService.getUsersByRole(role);
    }
}