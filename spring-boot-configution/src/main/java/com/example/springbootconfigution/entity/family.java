package com.example.springbootconfigution.entity;

import com.example.springbootconfigution.loader.YamlPropertyLoader;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@ConfigurationProperties(prefix = "family")
//@PropertySource(value = {"classpath:family.properties"})
@PropertySource(value = {"classpath:family.yml"},factory = YamlPropertyLoader.class)
@Validated
public class family {
    @Length(min = 5,max = 10,message = "家庭名称必须在五到十位之间")
    private String familyName;
    private String father;
    private String mother;
    private String child;
    @Range(min = 3,message = "家庭年限必须大于3")
    private Integer age;
}
