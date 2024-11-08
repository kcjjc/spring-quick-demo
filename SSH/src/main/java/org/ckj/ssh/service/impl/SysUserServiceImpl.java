package org.ckj.ssh.service.impl;

import lombok.RequiredArgsConstructor;
import org.ckj.ssh.exception.ParameterException;
import org.ckj.ssh.pojo.dto.SysUserDTO;
import org.ckj.ssh.pojo.entity.SysUser;
import org.ckj.ssh.repository.SysUserRepository;
import org.ckj.ssh.service.SysUserService;
import org.ckj.ssh.status.HttpStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.Optional;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  10:57
 * @Description: TODO
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {
    private final SysUserRepository sysUserRepository;

    /**
     * @description: 登录操作
     * @author: ckj
     * @date: 2024/11/8 上午11:34
     * @param: [username, password]
     * @return: boolean
    **/
    @Override
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            throw new ParameterException(HttpStatus.PARAMETER_ERROR,"账密不正确");
        }
        if (username.isEmpty() || password.isEmpty()) {
            throw new ParameterException(HttpStatus.PARAMETER_ERROR,"账密不正确");
        }
        Specification<SysUser> spec = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //多条件查询
                Path<Object> userName = root.get("username");
                Path<Object> passWord = root.get("password");
                return criteriaBuilder.and(criteriaBuilder.equal(userName, username), criteriaBuilder.equal(passWord, password));
            }
        };
        Optional<SysUser> sysUserVO = sysUserRepository.findOne(spec);
        if (sysUserVO.isPresent()) {
            return true;
        }
        return false;
    }

    /**
     * @description: 根据Id获取用户信息
     * @author: ckj
     * @date: 2024/11/8 下午1:44
     * @param: [id]
     * @return: org.ckj.ssh.pojo.dto.SysUserDTO
    **/
    @Override
    public SysUserDTO info(Integer id) {
        if (id == null) {
            throw new ParameterException(HttpStatus.PARAMETER_ERROR,"参数不正确");
        }
        Optional<SysUser> sysUserVO = sysUserRepository.findById(Long.valueOf(id));
        if (sysUserVO.isPresent()) {
            SysUser sysUser = sysUserVO.get();
            return SysUserDTO.builder()
                    .userId(sysUser.getUserId())
                    .username(sysUser.getUsername())
                    .password(sysUser.getPassword())
                    .nickname(sysUser.getNickname())
                    .phone(sysUser.getPhone())
                    .roleId(sysUser.getRoleId())
                    .salt(sysUser.getSalt())
                    .avatar(sysUser.getAvatar())
                    .sex(sysUser.getSex())
                    .email(sysUser.getEmail())
                    .deptId(sysUser.getDeptId())
                    .postId(sysUser.getPostId())
                    .reamrk(sysUser.getRemark())
                    .status(sysUser.getStatus())
                    .createBy(sysUser.getCreateBy())
                    .updateBy(sysUser.getUpdateBy())
                    .createdAt(sysUser.getCreatedAt())
                    .updatedAt(sysUser.getUpdatedAt())
                    .deletedAt(sysUser.getDeletedAt())
                    .build();
        }
        return null;
    }
}
