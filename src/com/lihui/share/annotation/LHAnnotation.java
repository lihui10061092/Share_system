package com.lihui.share.annotation;

import org.springframework.stereotype.Repository;

@Repository
public @interface LHAnnotation
{
	String value() default "";
}
