package vn.edu.tdtu.lab10.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDTO {
    private Long id;
    private String email;
    private String password;
    private String username;
}