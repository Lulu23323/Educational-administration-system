
//表格操作
$(function(){
  //view
  var arrView=[];
  var _thisView = null ;
  $(document).on("click",".viewInf",function(){
      arrMove=[]
      _thisView=$(this).parents("tr")
      $(".viewfade").fadeIn(0)
      $(this).parent().siblings().each(function(){
          arrView.push($(this).text())
      })
      $(this).parents().find('#checkDetail1 input').each(function(i){
          $(this).val(arrView[i]).attr("disabled", "disabled");
      })

  })

  //viewCancel
  $(document).on("click",".addButton_no",function(){
      $(".viewfade").fadeOut(0)
  })

  $(document).on("click",".modal-header i",function(){
      $(".viewfade").fadeOut(0)
  })
})
 
    //单数行和多数行背景色设置
$(document).ready(function(){
    $("tr:odd").css("background-color","#fff");
    $("tr:even").css("background-color","#eef1f8");
});
    //改变tr的背景颜色
$(function () {
    var trEven = $("#tdata tr:even");
    trEven.mouseover(function () {
        $(this).css("background-color", "rgb(194,194,194)");
        $(this).children("td").css("background-color", "rgb(194,194,194)");
    }).mouseout(function () {
        $(this).css("background-color", "#FFFFFF");
        $(this).children("td").css("background-color", "#FFFFFF");
    });
    var trOdd = $("#tdata tr:odd");
    trOdd.mouseover(function () {
        $(this).css("background-color", "rgb(194,194,194)");
        $(this).children("td").css("background-color", "rgb(194,194,194)");
    }).mouseout(function () {
        $(this).css("background-color", "#eef1f8");
        $(this).children("td").css("background-color", "#eef1f8");
    });
});

