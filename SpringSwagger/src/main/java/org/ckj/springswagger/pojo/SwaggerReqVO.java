package org.ckj.springswagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data; /**
 * @Author: ckj
 * @CreateTime: 2024-11-12  16:33
 * @Description: TODO
 * @Version: 1.0
 */

@Data
@ApiModel("创建Swagger请求参数")
public class SwaggerReqVO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Integer gender;
}