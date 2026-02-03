package com.my.springsecurity.query.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class UserListResponse {
  private List<UserDTO> users;
}
