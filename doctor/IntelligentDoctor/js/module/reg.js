/**
 * Created by Administrator on 2016/11/13.
 */
(function ($) {

    var CReg = function () {
        // -1.CONST
        this.CONST_COMMAND="注册。";
        //0.index
        this.STATIC_INDEX = 0;
        //1.command
        this.STATIC_WORKFLOW = [
            {StepName: "你叫什么名字?", StepData: "name"},
            {StepName: "年龄多少?", StepData: "age"},
            {StepName: "是男是女?", StepData: "sex"}];
        this.STATIC_SUCCESS = "注册成功";
        //2.data
        this.STATIC_DATA = {};
        //3.init
        this.init = function (strMsg, oDelegateCallBackFunc) {

            if (this.STATIC_INDEX == 0) {
                //log->reg
                $.Record.append(strMsg, true);
                $.Record.append(this.STATIC_WORKFLOW[this.STATIC_INDEX].StepName, false);
                //refresh
                this.STATIC_INDEX++;
                $.Tools.refreshIframe();

            }
            else if (this.STATIC_INDEX == this.STATIC_WORKFLOW.length) {
                this.STATIC_DATA[this.STATIC_WORKFLOW[this.STATIC_INDEX-1].StepData]=strMsg;
                this._reg(strMsg);
                //callback
                if (oDelegateCallBackFunc) {
                    oDelegateCallBackFunc();
                }
            }
            else {
                //log->reg
                $.Record.append(strMsg, true);
                this.STATIC_DATA[this.STATIC_WORKFLOW[this.STATIC_INDEX-1].StepData]=strMsg;
                $.Record.append(this.STATIC_WORKFLOW[this.STATIC_INDEX].StepName, false);
                this.STATIC_INDEX++;
                //refresh
                $.Tools.refreshIframe();
            }

        };
        this._reg = function (strMsg) {
            //0.print record
            $.Record.append(strMsg, true);
            //1.post请求
            //回调中刷新页面
            $.Record.append(this.STATIC_SUCCESS, false);

            this.STATIC_INDEX = 0;
            this.STATIC_DATA={};
            $.Tools.refreshIframe();

        };
    }
    $.Reg = new CReg();
})(jQuery)