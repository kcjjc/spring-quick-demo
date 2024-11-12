package org.ckj.ssh.service.impl;

import lombok.RequiredArgsConstructor;
import org.ckj.ssh.exception.ParameterException;
import org.ckj.ssh.pojo.dto.SysUserDTO;
import org.ckj.ssh.pojo.entity.SysUser;
import org.ckj.ssh.repository.SysUserRepository;
import org.ckj.ssh.service.SysUserService;
import org.ckj.ssh.status.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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
        Specification<SysUser> spec = (root, query, criteriaBuilder) -> {
            //多条件查询
            Path<Object> userName = root.get("username");
            Path<Object> passWord = root.get("password");
            return criteriaBuilder.and(criteriaBuilder.equal(userName, username), criteriaBuilder.equal(passWord, password));
        };
        Optional<SysUser> sysUserVO = sysUserRepository.findOne(spec);
        return sysUserVO.isPresent();
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
                    .nickName(sysUser.getNickName())
                    .phone(sysUser.getPhone())
                    .roleId(sysUser.getRoleId())
                    .salt(sysUser.getSalt())
                    .avatar(sysUser.getAvatar())
                    .sex(sysUser.getSex())
                    .email(sysUser.getEmail())
                    .deptId(sysUser.getDeptId())
                    .postId(sysUser.getPostId())
                    .remark(sysUser.getRemark())
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

    /**
     * @description: 获取全部用户信息
     * @author: ckj
     * @date: 2024/11/12 上午11:07
     * @param: [pageable]
     * @return: java.util.List<org.ckj.ssh.pojo.dto.SysUserDTO>
    **/
    @Override
    public List<SysUserDTO> getAll(Pageable pageable) {
        Page<SysUser> content = sysUserRepository.findAll(pageable);
        List<SysUser> all = content.getContent();
        List<SysUserDTO> userDTOs = new ArrayList<>();
        for (SysUser user : all) {
            SysUserDTO userDTO = SysUserDTO.builder()
                    .userId(user.getUserId())
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .nickName(user.getNickName())
                    .phone(user.getPhone())
                    .roleId(user.getRoleId())
                    .salt(user.getSalt())
                    .avatar(user.getAvatar())
                    .sex(user.getSex())
                    .email(user.getEmail())
                    .deptId(user.getDeptId())
                    .postId(user.getPostId())
                    .remark(user.getRemark())
                    .status(user.getStatus())
                    .createBy(user.getCreateBy())
                    .updateBy(user.getUpdateBy())
                    .createdAt(user.getCreatedAt())
                    .updatedAt(user.getUpdatedAt())
                    .deletedAt(user.getDeletedAt())
                    .build();
           userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public void register(SysUserDTO sysUserDTO) {
        SysUser sysUser = SysUser
                .builder()
                .username(sysUserDTO.getUsername())
                .password(sysUserDTO.getPassword())
                .nickName(sysUserDTO.getNickName())
                .phone(sysUserDTO.getPhone())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        sysUserRepository.save(sysUser);
    }
}
