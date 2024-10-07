package com.hongrui.scripting.xmltags;

import com.hongrui.mapping.SqlSource;
import com.hongrui.scripting.LanguageDriver;
import com.hongrui.session.Configuration;
import org.dom4j.Element;

/**
 * @author hongrui
 * @description XML语言驱动器
 * @date 2024-10-08 1:58
 */
public class XMLLanguageDriver implements LanguageDriver {
    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }
}
