package whalley.tm.annotation;

import java.lang.annotation.*;

/**
 * Created by Whalley on 2018/7/30.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Transactional {
}
