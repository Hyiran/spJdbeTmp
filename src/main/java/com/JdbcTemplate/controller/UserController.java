package com.JdbcTemplate.controller;

import com.JdbcTemplate.bean.JsonResult;
import com.JdbcTemplate.enity.User;
import com.JdbcTemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    //创建线程安全的Map
    static Map<Integer,User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id) {
        JsonResult jr = new JsonResult();
        try {
            User user = userService.getUserById(id);
            jr.setResult(user);
            jr.setStatus("ok");
        } catch (Exception e) {
            jr.setResult(e.getClass().getName() + ":" + e.getMessage());
            jr.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(jr);
    }

    /**
     * c查询用户列表
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList() {
        JsonResult r = new JsonResult();
        try {
            List<User> users = userService.getUserList();
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add(@RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            int orderId = userService.add(user);
            if (orderId < 0) {
                r.setResult(orderId);
                r.setStatus("fail");
            } else {
                r.setResult(orderId);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 根据ID修改用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateUserById(@PathVariable(value = "id") Integer id, @RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            int ret = userService.update(id, user);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/s/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "id") Integer id) {
        JsonResult r = new JsonResult();
        try {
            int ret = userService.delete(id);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
