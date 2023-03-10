package com.jiuxing.reggie.common;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/1/3  14:17
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

/**
 * 对象映射器：基于jackson将java对象转为json，或者将json转为java对象
 * 将json解析为java对象的过程称为【从json反序列化java对象】
 * 从java对象生成json的过程称为【序列化java对象到json】
 */
public class JacksonObjectMapper extends ObjectMapper {
    public static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME_FORMAT="yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_TIME_FORMAT="HH:mm:ss";
    public JacksonObjectMapper(){
        super();
        //收到未知属性时不报异常
        this.configure(FAIL_ON_UNKNOWN_PROPERTIES,false);

        //反序列化时，属性不存在的兼容处理
        this.getDeserializationConfig().withoutFeatures(FAIL_ON_UNKNOWN_PROPERTIES);
        SimpleModule simpleModule=new SimpleModule()
                 .addDeserializer(LocalDateTime.class , new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)))
                 .addDeserializer(LocalDate.class , new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)))
                 .addDeserializer(LocalTime.class , new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)))
                 .addSerializer(BigInteger.class, ToStringSerializer.instance)
                 .addSerializer(Long.class,ToStringSerializer.instance)
                 .addSerializer(LocalDateTime.class , new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)))
                 .addSerializer(LocalDate.class , new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)))
                 .addSerializer(LocalTime.class , new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));
        //注册功能模块 例如，可以添加自定义序列化器和反序列化器
        this.registerModule(simpleModule);
    }
}