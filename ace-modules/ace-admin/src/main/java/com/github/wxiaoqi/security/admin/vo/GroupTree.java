/*





 */

package com.github.wxiaoqi.security.admin.vo;

import com.github.wxiaoqi.security.common.vo.TreeNodeVO;

/**
 * ${DESCRIPTION}
 *
 * @author woozoom
 * @version 2017-06-17 15:21
 */
public class GroupTree extends TreeNodeVO<GroupTree> {
    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
