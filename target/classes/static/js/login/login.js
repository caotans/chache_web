/**
*@Creaded  By: ct
*@Date: 2018-3-22 ,10:38
*@Desciption:  登录模块
*@Param:  
*@ReturnType: 
*
*/
var appLogin = function(){
    return {
        init : function(){
            $(document).keyup(function(event){
                if(event.keyCode ==13){
                    appLogin.login();
                    return false;
                }
            });
           $(".login_btn_regist").bind("click",function(){
              window.location.href="regist";
           });
            $(".login_btn_login").bind("click",function(){
                   appLogin.login();
            });

        },
        login : function(){
            if(!$("#account").val()){
                $(".error_msg").text("*账号不能为空！");
                return;
            }
            if(!$("#mima").val()){
                $(".error_msg").text("*密码不能为空！");
                return;
            }
            $.ajax({
                type: "POST",
                dataType: "text",
                headers : {
                    'Content-Type' : 'application/json;charset=utf-8'
                },
                data: JSON.stringify({"account":$.trim($("#account").val()),"mima":hex_md5($.trim($("#mima").val()))}),
                url: "jumpToMain",
                success: function (data) {
                    if(data=="yes"){
                        util.showDialog("loading");
                        window.location.href=encodeURI(encodeURI("loginToMain?account="+$.trim($("#account").val())));
                    }else if(data=="no"){
                        $(".error_msg").text("*该账号不存在！");

                    }else if(data=="mid"){
                        $(".error_msg").text("*用户名或者密码不正确！");
                    }
                },
                error: function () {

                }

            });
        }

    }
}();

$(function(){
    appLogin.init();
    var temp=document.documentElement.clientWidth;
    console.log(temp);
    if(temp>1200){
        document.documentElement.style.fontSize = 100+"px";
    }else{
        var screenWidth=temp / 6.5 + 'px';//以650设计稿来算
        document.documentElement.style.fontSize = screenWidth;
    }

    $('#full_feature').swipeslider();



});
