/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ling.springboot.tk.mybatis.web;


import com.github.pagehelper.PageInfo;
import org.ling.springboot.tk.mybatis.domain.Page;
import org.ling.springboot.tk.mybatis.domain.User;
import org.ling.springboot.tk.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

   @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public User helloWorld(@PathVariable String id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/queryPage")
    @Transactional(readOnly = true)
    public PageInfo<User> queryPage(@RequestBody Page page) {
        return this.userService.queryPage(page);
    }

    @PostMapping("/add")
    @Transactional
    public void insertOne(@RequestBody User user) {
        try {
            this.userService.insertOne(user);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }
}

