/**
 * Created by mahoo on 2015/11/9.
 */

/****************************************************** common start ******************************************/

/**
 * 返回事件
 */
function jsGoBack() {
    window.app.appGoBack();
}

/**
 * 去掉模态框
 *
 */
function closeAlertModule(){
    $.closeModal();
}

/**
 * 校验手机号
 * @param tel
 * @returns {boolean}
 */
function checkTelPhone(tel) {

    var telReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;

    if (telReg.test(tel)) {
        return true;
    }

    return false;
}

/**
 * 校验密码6-20个字母、数字、下划线
 * @param psw
 * @returns {boolean}
 */
function checkPassword(psw) {

    var pswReg = /^(\w){6,20}$/;

    if (pswReg.test(psw)) {
        return true;
    }

    return false;
}

/****************************************************** common end ******************************************/



$(function () {

    'user strict';


    /****************************************************** index page  start ******************************************/

    $(document).on("pageInit", "#index-page", function (e, id, page) {

        var $content = $(page).find('.pull-to-refresh-content').on('refresh', function (e) {
            // 模拟2s的加载过程
            setTimeout(function () {
                var cardNumber = $(e.target).find('.card').length + 1;
                var cardHTML = '<div class="card">' +
                    '<div class="card-header">card' + cardNumber + '</div>' +
                    '<div class="card-content">' +
                    '<div class="card-content-inner">' +
                    '这里是第' + cardNumber + '个card，下拉刷新会出现第' + (cardNumber + 1) + '个card。' + '<a href="#router2">' + '链接' + '</a>'
                '</div>' +
                '</div>' +
                '</div>';

                $(e.target).find('.card-container').prepend(cardHTML);
                // 加载完毕需要重置
                $.pullToRefreshDone($content);
            }, 2000);
        });

        $(page).find(".swiper-container").swiper();


    });


    /****************************************************** index page  end ******************************************/

    /****************************************************** login page  start ******************************************/


    $(document).on("pageInit", "#login-page", function (e, id, page) {

        $(page).on('input', '.login-telephone', function () {
            //获取手机号的输入值
            var telValue = $(this).val();


            //当输入的手机号为空时
            if ($.trim(telValue) != '') {
                $('.button-login').removeClass('button-light');

                //提示框消失
                $('.login-msg').text('');

            } else {

                //提交按钮无法提交
                $('.button-login').addClass('button-light');
            }
        });

        $(page).on('click', '.button-login', function () {
            var isEnable = $(this).attr('class').indexOf('button-light') == -1 ? true : false;

            //1，当提交按钮是不可用状态时，直接返回
            if (!isEnable) {
                return;
            }

            //2，获取手机号的值,校验手机号
            var telValue = $('.login-telephone').val();
            if ($.trim(telValue) == '') {
                //$('.login-msg').text('亲，登录的手机号不能为空哦！');
                $.toast("亲，登录的手机号不能为空哦！");
            }

            if (!checkTelPhone(telValue)) {
                //$('.login-msg').text('亲，您输入的手机号格式不正确哦');
                $.toast("亲，您输入的手机号格式不正确哦");
                return;
            }

            //3，校验密码框不能为空
            var pswValue = $('.login-password').val();
            if ($.trim(pswValue) == '') {
                //$('.login-msg').text('亲，登录密码不能为空哦！');
                $.toast("亲，登录密码不能为空哦！");
                return;
            }

            //4，校验密码格式6-20个字母、数字、下划线
            if (!checkPassword(pswValue)) {
                //$('.login-msg').text('密码格式错误，密码长度6-18位的数字和字母');
                $.toast("密码长度6-18位的数字和字母");
                return;
            }


            //校验成功，ajax传输数据
            $.ajax({
                type: 'GET',
                url: '/app/login/loginByTelephoneAndPsw',
                data: {
                    tel: telValue,
                    psw: pswValue
                },
                timeout: 3000,
                async: true,
                beforeSend: function () {
                    $.showPreloader();
                },
                success: function (resp) {
                    $.hidePreloader();

                    if(resp == null){
                        $.toast("服务异常，稍后再试！");
                        return;
                    }
                    //调用成功
                    if(parseInt(resp.code) == 200){
                        $.toast("登录成功，正在跳转...");
                        setTimeout(function () {
                            $.router.back();
                        }, 2000);
                    }else{
                        $.toast(resp.msg);
                        return;
                    }
                },
                error: function () {
                    $.hidePreloader();
                    $.toast("服务异常，稍后再试！");
                }


            });


        });

    });

    /****************************************************** login page  end ******************************************/

    /****************************************************** me item page start****************************************/

    $(document).on("pageInit", "#me-item-page", function (e, id, page) {
        $(page).on('click', '.button-logout', function () {
            $.confirm('是否要退出当前登录',
                function () {
                    $.alert("退出OK！");
                    $.ajax({
                        type : "GET",
                        url : "/app/login/logout",
                        beforeSend: function () {
                            $.showPreloader();
                        },
                        success: function (resp) {
                            $.hidePreloader();
                            $.toast("成功退出...");
                            setTimeout(function () {
                                $.router.back();
                            }, 500);
                        },
                        error: function () {
                            $.hidePreloader();
                            $.toast("服务异常，稍后再试！");
                        }
                    })
                },
                function () {
                    return;
                }
            );
        });
    });

    /****************************************************** me item page end****************************************/

    /******************************************************register page start****************************************/
    $(document).on("pageInit", "#register-page", function (e, id, page) {

        $(page).on('input', '.register-telephone', function () {
            //获取手机号的输入值
            var telValue = $(this).val();


            //当输入的手机号为空时
            if ($.trim(telValue) != '') {
                $('.verification-message-button').removeClass('button-light');

                //提示框消失
                $('.login-msg').text('');

            } else {

                //提交按钮无法提交
                $('.verification-message-button').addClass('button-light');
            }
        });

        $(page).on('click', '.verification-message-button', function () {
            var isEnable = $(this).attr('class').indexOf('button-light') == -1 ? true : false;

            //1，当提交按钮是不可用状态时，直接返回
            if (!isEnable) {
                return;
            }

            //2，获取手机号的值,校验手机号
            var telValue = $('.register-telephone').val();
            if ($.trim(telValue) == '') {
                $.toast("亲，登录的手机号不能为空哦！");
            }

            if (!checkTelPhone(telValue)) {
                $.toast("亲，您输入的手机号格式不正确哦");
                return;
            }

            //3，校验密码框不能为空
            var pswValue = $('.register-password').val();
            if ($.trim(pswValue) == '') {
                //$('.login-msg').text('亲，登录密码不能为空哦！');
                $.toast("亲，登录密码不能为空哦！");
                return;
            }

            //4，校验密码格式6-20个字母、数字、下划线
            if (!checkPassword(pswValue)) {
                //$('.login-msg').text('密码格式错误，密码长度6-18位的数字和字母');
                $.toast("密码长度6-18位的数字和字母");
                return;
            }

            //校验是否已经注册，并发送短信验证码
            $.ajax({
                type: 'GET',
                url: '/app/register/getTelephoneVerificationCode',
                data: {
                    tel: telValue,
                    psw: pswValue
                },
                timeout: 3000,
                async: true,
                beforeSend: function () {
                    $.showPreloader();
                },
                success: function (resp) {
                    $.hidePreloader();

                    if(resp == null){
                        $.toast("服务异常，稍后再试！");
                        return;
                    }
                    //调用成功
                    if(parseInt(resp.code) == 200){
                        var hrefPage = "/app/register/registerGetVerificationCode?tel=" + telValue + "&psw=" + pswValue;
                        $.router.loadPage(hrefPage);  //加载ajax页面
                    }else{
                        $.hidePreloader();
                        $.toast(resp.msg);
                    }
                },
                error: function () {
                    $.hidePreloader();
                    $.toast("服务异常，稍后再试！");
                }

            });

        });

    });


    /******************************************************register page end****************************************/

    /******************************************************verificationCode page start****************************************/
    $(document).on("pageInit", "#verificationCode-Page", function (e, id, page) {

        var manyTimesButton = $(page).find('.many-times-button');

        var totalTimes = loopTimes =  90;
        var times = setInterval(function(){
            manyTimesButton.text(loopTimes + 's');
            if( -- loopTimes == 0){
                clearInterval(times);
                manyTimesButton.removeClass('button-light').text('再次获取验证码');
            }
        },1000);

        manyTimesButton.on("click",function(){
            var _this = $(this);
            if(_this.hasClass('button-light')){
                return;
            }

            $.ajax({

            });

            _this.addClass('button-light');

            loopTimes = totalTimes;
            times = setInterval(function(){
                manyTimesButton.text(loopTimes + 's');
                if( -- loopTimes == 0){
                    clearInterval(times);
                    manyTimesButton.removeClass('button-light').text('再次获取验证码');
                }
            },1000);

        })


    });



    /******************************************************verificationCode page end****************************************/


    $.init();

});
