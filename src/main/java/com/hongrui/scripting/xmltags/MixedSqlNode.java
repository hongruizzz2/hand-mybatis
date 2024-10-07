package com.hongrui.scripting.xmltags;

import com.hongrui.builder.SqlSourceBuilder;

import java.util.List;

/**
 * @author hongrui
 * @description 混合SQL节点
 * @date 2024-10-08 1:57
 */
public class MixedSqlNode implements SqlNode {
    //组合模式，拥有一个SqlNode的List
    private List<SqlNode> contents;

    public MixedSqlNode(List<SqlNode> contents) {
        this.contents = contents;
    }

    @Override
    public boolean apply(DynamicContext context) {
        // 依次调用list里每个元素的apply
        contents.forEach(node -> node.apply(context));
        return true;
    }
}
