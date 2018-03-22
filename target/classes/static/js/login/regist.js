/**
 *@Creaded  By: ct
 *@Date: 2018-3-22 ,10:38
 *@Desciption:  登录模块
 *@Param:
 *@ReturnType:
 *
 */
var appRegist = function () {
    var param = 3;
    return {
        init: function () {
            // 注册校验事件
            $("#account").blur(function () {
                appRegist.validateAccount();
            });
            $("#mima").blur(function () {
                appRegist.validateMima();
            });

            $("#mima2").blur(function () {
                appRegist. validateMima2();

            });

            $("#name").blur(function () {
                appRegist.validateName();
            });
            $("#phone").blur(function () {
                appRegist.validatePhone();
            });


            //注册
            $(".regist_start_btn").bind("click", function () {
                if(appRegist.validateAccount()&&appRegist.validateMima()&&appRegist.validateMima2()&&appRegist.validateName()&&appRegist.validatePhone()){
                    alert(3333);
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        data: {},
                        url: "regist_start",
                        success: function (data) {

                        },
                        error: function () {

                        }

                    });
                }

            })


            //重置
            $(".regist_rest_btn").bind("click", function () {
                $(".regist_center input").val("");
                $("div[id*='_error']").text("");
            })
        },
        //校验账号
        validateAccount: function () {
            var account = $("#account").val();
            if (!account) {
                $("#account_error").text("账号不能为空！");
                return false;
            } else {
                $("#account_error").text("");
                return true;
            }
        },
        //校验密码
        validateMima: function () {

            var mima = $("#mima").val();
            if (!mima) {
                $("#mima_error").text("密码不能为空！");
                return false;
            } else {
                $("#mima_error").text("");
                return true;
            }
        },
        //校验确认密码
        validateMima2: function () {
            var mima = $("#mima").val();
            var mima2 = $("#mima2").val();
            if (!mima2 || !mima) {
                $("#mima2_error").text("确认密码不能为空！");
                return false;
            } else {
                if (mima != mima2) {
                    $("#mima2_error").text("两次输入的密码不一致！");
                    return false;
                } else {
                    $("#mima2_error").text("");
                    return true;
                }
            }

        },
        //校验姓名
        validateName: function () {
            var name = $("#name").val();
            if (!name) {
                $("#name_error").text("姓名不能为空！");
                return false;
            } else {
                var re1 = new RegExp("^[0-9a-zA-Z\u4e00-\u9fa5_]{3,16}$");
                if (!re1.test(name)) {
                    $("#name_error").text("");
                    return true;
                } else {
                    $("#name_error").text("姓名格式不正确！");
                    return false;
                }
            }

        },
        //校验手机号
        validatePhone: function () {
            var phone = $("#phone").val();

            if (!phone) {
                $("#phone_error").text("手机号码不能为空！");
                return false;
            } else {
                phone=$.trim(phone);
                var re1 = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
                if (!re1.test(phone)) {
                    alert(33);
                    $("#phone_error").text("手机号码格式不正确！");
                    return false;
                } else {
                    alert(444);
                    $("#phone_error").text("");
                    return true;
                }
            }
        }

    }
}();

$(function () {
    appRegist.init();


});
