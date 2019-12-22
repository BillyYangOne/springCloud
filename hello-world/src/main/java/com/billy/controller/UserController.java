package com.billy.controller;

import com.billy.domain.User;
import com.billy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * user controller
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping
    public List<User> getUsers() {
        return userRepository.listUser();
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.getUserById(id);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/{id}")
    public User createUser(@RequestBody User user) {
        return userRepository.saveOrUpdateUser(user);
    }

    /**
     * 修改用户
     * @param id
     * @param user
     */
    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {

        User oldUser = this.getUser(id);
        if (oldUser != null) {
            user.setId(id);
            userRepository.saveOrUpdateUser(user);
        }
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteUser(id);
    }
}
