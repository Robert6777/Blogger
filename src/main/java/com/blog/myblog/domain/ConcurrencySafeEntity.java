package com.blog.myblog.domain;

import java.util.ConcurrentModificationException;

public interface ConcurrencySafeEntity {

    Short version();

    default public void detectConcurrentModification(ConcurrencySafeEntity entity, Short transmittedVersion){
       if(entity.version()!=transmittedVersion){
           throw new ConcurrentModificationException("This entity was modified by another request in the meantime");
       }
    }
}
