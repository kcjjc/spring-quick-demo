package org.ckj.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ckj.springsecurity.pojo.User;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-12  15:28
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
