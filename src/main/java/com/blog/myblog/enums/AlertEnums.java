package com.blog.myblog.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public enum AlertEnums {

    PROFILE_UPDATED (Types.PROFILE_UPDATED),
    ARTICLE_COMMENTED (Types.ARTICLE_COMMENTED),
    TEST_ALERT (Types.TEST_ALERT);

    AlertEnums(String type){
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Types {

        public static final String PROFILE_UPDATED = "PROFILE_UPDATED";
        public static final String ARTICLE_COMMENTED = "ARTICLE_COMMENTED";
        public static final String TEST_ALERT = "TEST_ALERT";
    }

}
