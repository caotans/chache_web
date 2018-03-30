// $(window).resize(function() {
//    window.location.reload();
// });
var util=function () {
    return {
        showDialog:function (type,param) {
            $(".msg_container").show();
            if(type=="info"){
                $(".msg_window").show();
                $(".msg_content").text(param);
            }else if(type=="product"){
                $(".msg_window2").show();
                var html="";
                  for(var i=0;i<param.imgList.length;i++){
                        html+="<li class='sw-slide'>";
                        html+="<img src='"+param.imgList[i]+"' />";
                        html+="</li>";
                  }
                $(".sw-slides").html(html);
                $(".product_name").text(param.productName);
                $(".product_remark2").text(param.remark);
                //数量
                $("#product_account_obj").val(0);
                $("#product_account_obj").next().text(param.productUnit);
                $("#product_account_rep").text(param.productCount);
                $("#product_account_rep").next().text(param.productUnit);
                $("#product_range_account").attr("max",param.productCount);
                //库存
                $("#product_assembly_obj").val(0);
                $("#product_assembly_obj").next().text(param.productUnit2);
                $("#product_assembly_rep").text(param.productCount2);
                $("#product_assembly_rep").next().text(param.productUnit2);
                $("#product_assembly_rep").next().text(param.productUnit2);
                $("#product_assembly_account").attr("max",param.productCount2);

                $("#productId").val(param.productId);
            }else if(type=="loading"){
                $(".msg_window3").show();
            }
        },
        hideDialog:function (type) {
            $(".msg_container").hide();
            if(type=="info"){
                $(".msg_window").hide();
            }else if(type=="product"){
                $(".msg_window2").hide();
            }else if(type=="loading"){
                $(".msg_window3").hide();
            }
        },initHtml:function () {
            var temp=document.documentElement.clientWidth;
            console.log(temp);
            if(temp>1200){
                document.documentElement.style.fontSize = 100+"px";
            }else{
                var screenWidth=temp / 6.5 + 'px';//以650设计稿来算
                document.documentElement.style.fontSize = screenWidth;
            }


        },
        //滑块事件
        addCount:function (obj,thisObj) {
            var min=$(thisObj).attr("min");
            var max=$(thisObj).attr("max");
            var value=$(thisObj).val();
            if(obj=="product_account"){
                var origin=$("#product_assembly_account").attr("max");
                $("#product_assembly_obj").val("0");
                $("#product_assembly_account").val("0");
                $("#product_assembly_rep").text(origin);
            }
            if(obj=="product_assembly"){
                var origin=$("#product_range_account").attr("max");
                $("#product_account_obj").val("0");
                $("#product_range_account").val("0");
                $("#product_account_rep").text(origin);
            }
            $("#"+obj+"_obj").val(value);
            $("#"+obj+"_rep").text(max-value);
        },
        //取消订单
        cancel:function () {
            this.hideDialog("product");
            //重置
            $(".sw-slides").html("");
            $(".product_name").text("");
            $(".product_remark2").text("");
            //数量
            $("#product_account_obj").val(0);
            $("#product_account_obj").next().text("");
            $("#product_account_rep").text("");
            $("#product_account_rep").next().text("");
            $("#product_range_account").attr("max","0");
            //库存
            $("#product_assembly_obj").val(0);
            $("#product_assembly_obj").next().text("");
            $("#product_assembly_rep").text("");
            $("#product_assembly_rep").next().text("");
            $("#product_assembly_rep").next().text("");
            $("#product_assembly_account").attr("max","0");
            $("#productId").val("");
        },
        //加入购物车
        addShopCar:function () {
            var productId=$("#productId").val();
            var json={"productId":productId};
            //如果有拼单,按拼单
            var count= $("#product_account_obj").val();
            var count2= $("#product_assembly_obj").val();
            if(count=="0"&&count2=="0"){
                alert("您暂未选购任何商品！");
                return;
            }
            json["productCount"]=count;
            json["productCount2"]=  count2;
            var local=window.localStorage;
           var productDetail= local.getItem("productDetail");
               if(!productDetail){
                   productDetail=[];
               }else{
                   productDetail=JSON.parse(productDetail);
               }
               productDetail.push(json);
               productDetail=JSON.stringify(productDetail);
               local.setItem("productDetail",productDetail);
               alert("该商品已经成功添加至购物车！");
               util.hideDialog("product");


        }
    }

}();