package org.ckj.springsecurity.serializer;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.jsonwebtoken.io.SerializationException;
import io.jsonwebtoken.io.Serializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author: ckj
 * @CreateTime: 2024-11-12  14:32
 * @Description: TODO
 * @Version: 1.0
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {


    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private Class<T> clazz;
    static
    {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    public FastJsonRedisSerializer(Class<T> clazz)
    {
        super();
        this.clazz = clazz;
    }
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if(t == null)
            return new byte[0];
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    public T deserialize(byte[] bytes) throws SerializationException {
        if(bytes == null || bytes.length <= 0)
            return null;
        String str = new String(bytes, DEFAULT_CHARSET);
        return JSON.parseObject(str,clazz);
    }
    protected JavaType getJavaType(Class<?> clazz)
    {
        return TypeFactory.defaultInstance().constructType(clazz);
    }


}
