package org.ckj.ssh.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  10:36
 * @Description: TODO
 * @Version: 1.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserDTO implements Serializable {
    private Long userId;
    private String username;
    private String password;
    private String nickName;
    private String phone;
    private Long roleId;
    private String salt;
    private String avatar;
    private String sex;
    private String email;
    private Long deptId;
    private Long postId;
    private String remark;
    private String status;
    private String createBy;
    private String updateBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deletedAt;
}
