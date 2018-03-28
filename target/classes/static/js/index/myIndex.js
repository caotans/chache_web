/**
*@Creaded  By: ct
*@Date: 2018-3-22 ,10:38
*@Desciption:  登录模块
*@Param:  
*@ReturnType: 
*
*/
var myIndex = function(){
    return {
        init: function () {
            //给产品分类绑定toggle切换事件
            $(".classify").bind("click",function () {
                 $(this).next().find(".productItem").toggle(500);
            });
        },showProduct:function (id) {
             $.ajax({
                 url:"findOneProduct",
                 type:"POST",
                 dataType:"json",
                 data:{"productId":id},
                 success:function (data) {
                     console.log(data);
                     //调用模态化窗口
                     util.showDialog("product",data);
                     $('#full_feature').swipeslider();
                 }
             });
        }

    }
}();

$(function(){
    myIndex.init();
    util.initHtml();

});
