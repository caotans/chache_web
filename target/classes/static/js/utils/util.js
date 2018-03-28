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
                $(".product_remark").text(param.remark);
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


        }
    }

}();