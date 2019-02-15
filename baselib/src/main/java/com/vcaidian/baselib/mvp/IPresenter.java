package com.vcaidian.baselib.mvp;

public interface IPresenter<V extends BaseView> {
    /**
     * 绑定视图
     *
     * @param view
     */
    void attachView(V view);

    /**
     * 解除绑定（每个V记得使用完之后解绑，主要是用于防止内存泄漏问题）
     */
    void dettachView();
}
