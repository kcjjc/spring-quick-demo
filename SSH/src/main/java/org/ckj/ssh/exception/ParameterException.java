package org.ckj.ssh.exception;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-08  11:16
 * @Description: TODO
 * @Version: 1.0
 */
public class ParameterException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private Integer code;
    public ParameterException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
