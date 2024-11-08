package org.ckj.ssh.repository;

import org.ckj.ssh.pojo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  10:41
 * @Description: TODO
 * @Version: 1.0
 */
public interface SysUserRepository extends  JpaRepository<SysUser,Long>
        , JpaSpecificationExecutor<SysUser> {
}
