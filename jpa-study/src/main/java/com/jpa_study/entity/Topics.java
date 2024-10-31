package com.jpa_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * topics
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topics implements Serializable {
    private Long id;

    private String title;

    private Long viewCount;

    private Integer followersCount;

    private Boolean isFollowing;

    private String banner;

    private Date updated;

    private String introduction;

    private List tagess;
}