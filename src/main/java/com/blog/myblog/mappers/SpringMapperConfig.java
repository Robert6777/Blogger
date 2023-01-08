package com.blog.myblog.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * A standard configuration intended to be used with value objects (data objects, Entities) like this: {@code @Mapper(config = SpringMapperConfig)}.
 * Configuration:
 * <ul>
 * <li>fail if the not all target fields are matched with the data from the source (and no alternative is provided)</li>
 * <li>it's ok, if the source contains more data than the target</li>
 * <li>it's ok to perform type conversions (e.g. int to String) during mapping, but there's a warning emitted</li>
 * </ul>
 * The generated implementation class receives the {@code Impl} suffix.
 *
 */
@MapperConfig(
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        typeConversionPolicy = ReportingPolicy.WARN)
public interface SpringMapperConfig {
}
