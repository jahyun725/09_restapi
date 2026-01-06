package org.ho.restapi.section03.valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

  @GetMapping("/users/{userNo}")
  public ResponseEntity<?> findUserByNo() throws UserNotFoundException {

    boolean check = true;
    if(check) {
      throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
    }

    return ResponseEntity.ok().build();
    // ok() => 200(과정에 문제가 없었다) 현호 개발자의 문제였다.

  }
  @PostMapping("/users")
  public ResponseEntity<?> registUser(@Validated @RequestBody UserDTO user) {

    System.out.println(user);

    return ResponseEntity
        .created(URI.create("/valid/users/" + "userNo"))
        .build();

  }
}
