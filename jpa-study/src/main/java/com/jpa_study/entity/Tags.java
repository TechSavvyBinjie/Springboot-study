package com.jpa_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * tags
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tags implements Serializable {
    private Long sectionId;
    private Long topicId;
    private String sectionTitle;
}