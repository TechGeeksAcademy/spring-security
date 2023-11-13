package com.delighthomes.ams.security.controller;

import com.delighthomes.ams.security.domain.DelightUser;
import com.delighthomes.ams.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<DelightUser> create(@RequestBody DelightUser user){
        log.info("******** Create API ********");
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DelightUser> update(@RequestBody DelightUser user){
        log.info("******** Update API ********");
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Integer> delete(@PathVariable String userId){
        log.info("******** Delete API ********");
        return new ResponseEntity<>(userService.delete(userId), HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<DelightUser> get(@PathVariable String userId){
        log.info("******** Get API ********");
        return new ResponseEntity<>(userService.get(userId), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DelightUser>> allUsers(){
        log.info("******** All API ********");
        List<DelightUser> list = userService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
