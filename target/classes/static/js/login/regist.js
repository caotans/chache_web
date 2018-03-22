/**
 *@Creaded  By: ct
 *@Date: 2018-3-22 ,10:38
 *@Desciption:  登录模块
 *@Param:
 *@ReturnType:
 *
 */
var appRegist = function () {
    var isAccount=false;
    var isName=false;
    var isMima=false;
    var isMima2=false;
    var isPhone=false;
    return {
        //初始化函数绑定按钮
        init: function () {
            // 注册校验事件
            $("#account").bind('input propertychange', function() {
                appRegist.validateAccount();


            });
            $("#mima").bind('input propertychange', function() {
                appRegist.validateMima();
            });

            $("#mima2").bind('input propertychange', function() {
                appRegist. validateMima2();

            });

            $("#name").bind('input propertychange', function() {
                appRegist.validateName();
            });
            $("#phone").bind('input propertychange', function() {
                appRegist.validatePhone();
            });
            //注册
            $(".regist_start_btn").bind("click", function () {
                    var userInfo2={"account":$.trim($("#account").val()),"mima":hex_md5($.trim($("#mima").val())),"name":$.trim($("#name").val()),"phone":$.trim($("#phone").val())};
                    var oo={"userInfo":userInfo2};
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        headers : {
                            'Content-Type' : 'application/json;charset=utf-8'
                        },
                        data: JSON.stringify(oo),
                        url: "regist_start",
                        success: function (data) {

                        },
                        error: function () {

                        }

                    });


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
                isAccount=false;
            } else {
                $("#account_error").text("");
                isAccount=true;
            }
            this.showSubmit();
        },
        //校验密码
        validateMima: function () {
            var mima = $("#mima").val();
            if (!mima) {
                $("#mima_error").text("密码不能为空！");
                isMima=false;
            } else {
                var mima2 = $("#mima2").val();
                if(mima2){
                    if(mima2!=mima){
                        $("#mima2_error").text("两次输入的密码不一致！");
                        isMima=false;
                    }else{
                        $("#mima_error").text("");
                        isMima=true;
                    }
                }else{
                    $("#mima_error").text("");
                    isMima=true;
                }

            }
            this.showSubmit();
        },
        //校验确认密码
        validateMima2: function () {
            var mima = $("#mima").val();
            var mima2 = $("#mima2").val();
            if (!mima2 || !mima) {
                $("#mima2_error").text("确认密码不能为空！");
                isMima2=false;
            } else {
                if (mima != mima2) {
                    $("#mima2_error").text("两次输入的密码不一致！");
                    isMima2=false;
                } else {
                    $("#mima2_error").text("");
                    isMima2=true;
                }
            }
            this.showSubmit();
        },
        //校验姓名
        validateName: function () {
            var name = $("#name").val();
            if (!name) {
                $("#name_error").text("姓名不能为空！");
                isName=false;
            } else {
                var re1 = new RegExp("^[0-9a-zA-Z\u4e00-\u9fa5_]{3,16}$");
                if (!re1.test(name)) {
                    $("#name_error").text("");
                    isName=true;
                } else {
                    $("#name_error").text("姓名格式不正确！");
                    isName=false;
                }
            }
            this.showSubmit();
        },
        //校验手机号
        validatePhone: function () {
            var phone = $("#phone").val();

            if (!phone) {
                $("#phone_error").text("手机号码不能为空！");
                isPhone=false;
            } else {
                phone=$.trim(phone);
                var re1 = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
                if (!re1.test(phone)) {
                    $("#phone_error").text("手机号码格式不正确！");
                    isPhone=false;
                } else {
                    $("#phone_error").text("");
                    isPhone=true;
                }
            }
            this.showSubmit();
        },
        //判断校验是否全部通过，是的话提交按钮就可以用了
        showSubmit:function () {
              if(isAccount&&isMima&&isMima2&&isName&&isPhone){
                $(".regist_start_btn").removeAttr("disabled");
              }else{
                  $(".regist_start_btn").attr("disabled",true);
              }
              return false;

        }




    }
}();

$(function () {
    appRegist.init();


});
