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
           $(".login_btn_regist").bind("click",function(){
              window.location.href="regist";
           });
            $(".login_btn_login").bind("click",function(){
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
                            $(".msg_container").show();
                            $(".msg_window").show();
                           window.location.href="loginToMain?account="+$.trim($("#account").val());
                        }else if(data=="no"){
                            $(".error_msg").text("*该账号不存在！");

                        }else if(data=="mid"){
                            $(".error_msg").text("*用户名或者密码不正确！");
                        }
                    },
                    error: function () {

                    }

                });
            });

        },
        changeLi : function(liid,PriceDownload){

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
