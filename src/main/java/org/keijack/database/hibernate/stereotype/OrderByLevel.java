package org.keijack.database.hibernate.stereotype;

public enum OrderByLevel {
    /**
     * 第一级
     */
    level1(1),
    /**
     * 第二级
     */
    level2(2),
    /**
     * 第三级
     */
    level3(3),
    /**
     * 第四级
     */
    level4(4),
    /**
     * 第五级
     */
    level5(5);

    /**
     * @param index
     *            序号
     */
    private OrderByLevel(int lv) {
	this.lv = lv;
    }

    /**
     * 序号
     */
    private final int lv;

    public int getLv() {
	return lv;
    }

}
