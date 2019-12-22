package com.billy.repository;

import com.billy.domain.User;

import java.util.List;

/**
 * 接口层
 */
public interface UserRepository {

    /**
     * 新增或修改用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUser();
}
