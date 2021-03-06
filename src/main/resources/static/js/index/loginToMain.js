/**
*@Creaded  By: ct
*@Date: 2018-3-22 ,10:38
*@Desciption:  登录模块
*@Param:  
*@ReturnType: 
*
*/
var appMain = function(){
    return {
        init: function () {
            //我的首页
              $(".bottomBar_index").bind("click",function () {
                  appMain.changePage("myIndex");
              });
              //我的购物车
            $(".bottomBar_shopCar").bind("click",function () {
                appMain.changePage("myShopCar");
            });
            //我的订单
            $(".bottomBar_order").bind("click",function () {
                appMain.changePage("myOrder");
            });



        },
        //切换页面
        changePage:function (type) {
            if(type=="myIndex"){//首页
                $("#mainContent").load(type);
            }else if(type=="myShopCar"){//我的购物车
                $("#mainContent").load(type);
            }else if(type=="myOrder"){//我的订单
                $("#mainContent").load(type);
            }
        }
    }
}();

$(function(){
    appMain.init();
    util.initHtml();

});
