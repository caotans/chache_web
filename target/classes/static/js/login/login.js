/**
*@Creaded  By: ct
*@Date: 2018-3-22 ,10:38
*@Desciption:  登录模块
*@Param:  
*@ReturnType: 
*
*/
var appLogin = function(){
    var param=3;
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



});
