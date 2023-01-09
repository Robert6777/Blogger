package com.blog.myblog.domain;

import java.util.ConcurrentModificationException;

public interface ConcurrencySafeEntity {

    Short version();

    default void detectConcurrentModification(Short transmittedVersion){
       if(!version().equals(transmittedVersion)){
           throw new ConcurrentModificationException("This entity was modified by another request in the meantime");
       }
    }
}
