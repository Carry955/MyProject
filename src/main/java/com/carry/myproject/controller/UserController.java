package com.carry.myproject.controller;

import com.carry.myproject.service.UserService;
import com.carry.myproject.utils.Result;
import com.carry.myproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public Result<?> add(@RequestBody UserVO userVO) {
        userService.addUser(userVO);
        return Result.ok();
    }

    @PutMapping
    public Result<?> update(@RequestBody UserVO userVO) {
        userService.updateUser(userVO);
        return Result.ok();
    }

    @DeleteMapping
    public Result<?> delete(Integer id) {
        userService.deleteUser(id);
        return Result.ok();
    }

    @GetMapping
    public Result<?> get(Integer id) {
        UserVO vo = userService.getUser(id);
        return Result.ok(vo);
    }
}
