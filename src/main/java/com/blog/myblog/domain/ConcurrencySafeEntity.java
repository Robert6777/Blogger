package com.blog.myblog.domain;

import java.util.ConcurrentModificationException;

public interface ConcurrencySafeEntity {

    Integer version();

    default void detectConcurrentModification(Integer transmittedVersion){
       if(!version().equals(transmittedVersion)){
           throw new ConcurrentModificationException("This entity was modified by another request in the meantime");
       }
    }
}
