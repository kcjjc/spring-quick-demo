package org.ckj.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ckj.ssm.pojo.entity.SysUser;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  14:22
 * @Description: SysUser 的 mapper层
 * @Version: 1.0
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
