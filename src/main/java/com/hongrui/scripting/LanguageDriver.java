package com.hongrui.scripting;

import com.hongrui.mapping.SqlSource;
import com.hongrui.session.Configuration;
import org.dom4j.Element;

/**
 * @author hongrui
 * @description 脚本语言驱动
 * @date 2024-10-08 1:52
 */
public interface LanguageDriver {
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);
}
