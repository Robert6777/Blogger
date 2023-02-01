package com.blog.myblog.domain.alerts;

import com.blog.myblog.enums.AlertEnums;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(AlertEnums.Types.TEST_ALERT)
@Getter
@Setter
public class TestAlert extends Alert {

    private Long testId;

}
