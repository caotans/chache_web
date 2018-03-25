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
    var isExist=false;
    return {
        //初始化函数绑定按钮
        init: function () {
            // 注册校验事件
            $("#account").bind('input propertychange', function() {
                appRegist.validateAccount();
            });
            $("#account").blur(function () {
                appRegist.validateAccountIsExist();
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
                    if(isAccount&&isMima&&isMima2&&isExist&&isName,isPhone){
                        var userInfo2={"account":$.trim($("#account").val()),"mima":hex_md5($.trim($("#mima").val())),"name":$.trim($("#name").val()),"phone":$.trim($("#phone").val())};
                        var oo={"userInfo":userInfo2};
                        $.ajax({
                            type: "POST",
                            dataType: "text",
                            headers : {
                                'Content-Type' : 'application/json;charset=utf-8'
                            },
                            data: JSON.stringify(oo),
                            url: "regist_start",
                            success: function (data) {
                                if(data==1){
                                    alert("注册成功");
                                }
                            },
                            error: function () {

                            }

                        });
                    }else{
                        appRegist.validateAccount();
                        appRegist.validateAccountIsExist();
                        appRegist.validateMima();
                        appRegist.validateMima2();
                        appRegist.validateName();
                        appRegist.validatePhone();
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
                isAccount=false;
            } else {
                $("#account_error").text("");
                isAccount=true;
            }

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

        },
        validateAccountIsExist:function(){
            var account=$("#account").val();
            if(account){
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    headers : {
                        'Content-Type' : 'application/json;charset=utf-8'
                    },
                    data: JSON.stringify({"account":$("#account").val()}),
                    url: "accountIsExist",
                    success: function (data) {
                        if(data){
                            $("#account_error").text("账号已存在！");
                            isExist=true;

                        }else{
                            isExist=false;
                            $("#account_error").text("");

                        }
                    },
                    error: function () {

                    }

                });
            }


          }




    }
}();

$(function () {
    appRegist.init();
    var temp=document.documentElement.clientWidth;
    console.log(temp);
    if(temp>1200){
        document.documentElement.style.fontSize = 100+"px";
    }else{
        var screenWidth=temp / 6.5 + 'px';//以650设计稿来算
        document.documentElement.style.fontSize = screenWidth;
    }


});
