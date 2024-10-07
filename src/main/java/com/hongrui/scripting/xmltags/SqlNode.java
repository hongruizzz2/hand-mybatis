package com.hongrui.scripting.xmltags;

/**
 * @author hongrui
 * @description SQL 节点
 * @date 2024-10-08 1:56
 */
public interface SqlNode {
    boolean apply(DynamicContext context);
}
