package com.example.demo.message;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNullApi;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("tb_user")
public class Student {
    @Id(keyType = KeyType.Auto)
    private Long id;
    private String userName;
    private String password;
    private Date created_time;
}
