package com.jinosoft.restapi.section04.hateoas;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private int no;
  private String id;
  private String pwd;
  private String name;
  private java.util.Date enrollDate;
}
