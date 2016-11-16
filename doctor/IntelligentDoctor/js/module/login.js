/**
 * Created by Administrator on 2016/11/13.
 */
(function ($) {

    var CLogin = function () {
        // -1.CONST
        this.CONST_COMMAND="登录。";
        // 0.data
        this.STATIC_INDEX = 0;
        this.STATIC_SUCCESS = "登录成功";
        this.STATIC_WORKFLOW = ["请说出你的名字"];
        //1.init
        this.init = function (strMsg, oDelegateCallBackFunc) {
            if (this.STATIC_INDEX == 0) {
                //log->登录
                $.Record.append(strMsg, true);
                $.Record.append(this.STATIC_WORKFLOW[this.STATIC_INDEX], false);
                this.STATIC_INDEX++;
                //refresh
                $.Tools.refreshIframe();

            }
            else if (this.STATIC_INDEX == 1) {
                this._login(strMsg);
                this.STATIC_INDEX = 0;
                if (oDelegateCallBackFunc) {
                    oDelegateCallBackFunc();
                }
            }
        };
        this._login = function (strMsg) {
            //0.print record
            $.Record.append(strMsg, true);
            //1.post请求
            //回调中刷新页面
            $.Record.append(this.STATIC_SUCCESS, false);
            $.Tools.refreshIframe();
        };
    }

    $.Login = new CLogin();
})(jQuery)