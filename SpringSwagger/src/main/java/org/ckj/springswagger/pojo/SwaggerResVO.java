package org.ckj.springswagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-12  16:34
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ApiModel(value = "SwaggerResVO", description = "swagger返回值")
public class SwaggerResVO {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("啥啥")
    private String what;
}
