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

        },
        changeLi : function(liid,PriceDownload){

        }

    }
}();

$(function(){
    appLogin.init();
    var screenWidth=document.documentElement.clientWidth / 6.5 + 'px';//以650设计稿来算
    console.log(screenWidth);
    document.documentElement.style.fontSize = screenWidth;


});
