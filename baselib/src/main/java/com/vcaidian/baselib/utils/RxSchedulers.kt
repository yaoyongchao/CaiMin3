package com.vcaidian.utilslib.utils


import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.vcaidian.baselib.R
import com.vcaidian.baselib.utils.L
import com.vcaidian.baselib.utils.NetWorkUtils
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author: Page
 * @time: 17-8-4
 * @description: The thread scheduling and request preprocessing tools.
 */

class RxSchedulers {
    companion object {

        private val dialog: ProgressDialog? = null

        /**
         * @param: [context]
         * @return: io.reactivex.ObservableTransformer<T></T>,T>
         * @description: Thread Scheduling. The default is show dialog.
         */
        public fun <T> ioMain(context: Context): ObservableTransformer<T, T> {
            return ioMain(context, true)
        }

        /**
         * @param: [context, isShow] [context，Whether or not show dialog.]
         * @return: io.reactivex.ObservableTransformer<T></T>,T>
         * @description: Thread Scheduling.
         */
        public fun <T> ioMain(context: Context, isShow: Boolean): ObservableTransformer<T, T> {
            return ObservableTransformer { observable ->
                //                if (isShow && dialog == null) {
                //                    dialog = new ProgressDialog(context);
                //                    dialog.setCancelable(true);
                //                    dialog.setMessage("加载中...");
                //                }
                observable
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe { disposable ->
                            L.d("doOnSubscribe -- Determine if there is a network and dialog.")

                            if (!NetWorkUtils.isConnectedByState(context)) {
                                disposable.dispose()
                                L.d("doOnSubscribe -- There's no network link.")
                                Toast.makeText(context, R.string.toast_network_error, Toast.LENGTH_SHORT).show()
                            } else {
                                L.d("doOnSubscribe -- There's a network link.")
                                //                                    if (isShow && dialog != null && !dialog.isShowing()) {
                                //                                        dialog.show();
                                //                                        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                //                                            @Override
                                //                                            public void onCancel(DialogInterface dialog) {
                                //                                                LogHttpLibUtil.i("Dialog Cancel and interrupt network request!");
                                //                                                disposable.dispose();
                                //                                            }
                                //                                        });
                                //                                    }

                            }
                        }
                        .doFinally {
                            //                                if (dialog != null && dialog.isShowing()){
                            //                                    dialog.dismiss();
                            //                                    dialog = null;
                            //                                }
                        }
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

    }

}
