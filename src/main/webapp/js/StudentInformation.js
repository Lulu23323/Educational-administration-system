/*全选功能*/
$('table th input:checkbox').on('click', function(){
    var that = this;
    $(this).closest('table').find('tr > td:first-child input:checkbox')
        .each(function(){
            this.checked = that.checked;
            $(this).closest('tr').toggleClass('selected');
        });
});
/*end*/
//表格操作
$(function(){
 
    //Add
    var arrAdd=[]
    $(document).on("click",".addButton",function(){
        $(".addfade").fadeIn(0)
    })
    //addArray
    $(document).on("click",".addButton_ok",function(){
        $(".addfade").fadeOut(0)
        arrAdd=[]
        $('#addmodal').find("input").each(function(){
            arrAdd.push($(this).val())
        });
       
    
        var str='<tr class="trHover">' +
            '<td><input type="checkbox"></td>' +
            '<td class="stuId">'+arrAdd[0]+'</td>' +
            '<td class="stuName">'+arrAdd[1]+'</td>' +
            '<td class="stuAcademy">'+arrAdd[2]+'</td>' +
            '<td class="stuMajor">'+arrAdd[3]+'</td>' +
            '<td class="stuClass">'+arrAdd[4]+'</td>' +
            '<td>' + '<a class="viewInf ">View Details</a> <a class="updateInf ">Modify</a></td>' +
            '</tr>'
        $("tdata").append(str)
        //奇偶行的颜色不同
        $("tr:odd").css("background-color","#fff");
        $("tr:even").css("background-color","#eef1f8");
        //end
        //颜色选择变化
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
        //end
        $('#addmodal').find("input").val('')
    })
 
    $(document).on("click",".addButton_no",function(){
        $(".addfade").fadeOut(0)
    })
 
    $(document).on("click",".modal-header i",function(){
        $(".addfade").fadeOut(0)
    })
 
 
 
    //delete
    var del=[]
    $(document).on("click",".delbtn",function(){
        del=[]
        if(confirm("Are you sure to delete?")){
            $(this).parents("tr").fadeOut(0)
        }
    })
 
 
    //updateShow
    var arrMove=[];
    var _this = null ;
    $(document).on("click",".updateInf",function(){
 
        arrMove=[]
        _this=$(this).parents("tr")
        $(".movefade").fadeIn(0)
        $(this).parent().siblings().each(function(){
            arrMove.push($(this).next().text())
        })
 
        $(this).parents().find('.movemodal input').each(function(i){
            $(this).val(arrMove[i])
        })
 
 
    })
 
 
 
 
    //updateBtn
    $(document).on("click",".updatabtn_ok",function(){
        arrMove=[]
        $(this).parent().siblings().find('input').each(function(){
            arrMove.push($(this).val())
            console.log($(this))
        })
        console.log(arrMove)
        $(this).parents().find('.movemodal input').each(function(i){
            $(this).val(arrMove[i+1])
        })
        _this.find("td").next().each(function(i){
            $(this).text(arrMove[i])
        })
 
        $(".movefade").fadeOut(0)
        $.ajax({
                 type:"POST",
                 url:"/2009/updateStudentServlet", //提交修改学生的网址
                 data:{
                  "ChangeStuID":arrMove[0],
                  "ChangeStuName":arrMove[1],
                  "ChangeStuAcademy":arrMove[2],
                  "ChangeStuMajor":arrMove[3],
                  "ChangeStuClass":arrMove[4],
                  
                 },//提交的数据
                 success:function(res){
                     console.log("传送修改学生数据成功");
                     console.log(res);
                 },
                 error:function(){
                     alert("向后台传输修改学生数据出错");
                 }
         })   
        
    })
    //updateCancel
    $(document).on("click",".updatabtn_no",function(){
        $(".movefade").fadeOut(0)
    })
 
    $(document).on("click",".modal-header i",function(){
        $(".movefade").fadeOut(0)
    })
 
    //view
    var arrView=[];
    var _thisView = null ;
    $(document).on("click",".viewInf",function(){
 
        arrMove=[]
        _thisView=$(this).parents("tr")
        $(".viewfade").fadeIn(0)
        $(this).parent().siblings().each(function(){
            arrView.push($(this).next().text())
        })
        $(this).parents().find('#viewmodal input').each(function(i){
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
    //end
    //多选框删除
    $(function(){
        // var cit= $("#containerTable");
        // if(cit.size()>0) {
        //     cit.find("tr:not(:first)").remove();
        //
        // }
        $("#deleteButton").click(function() {
			var delStuID = [];
            $("input:checked").each(function() { // 遍历选中的checkbox
            	var delP =$(this).parents("tr");
            	delStuID.push(delP.find(".stuId").text());            	
                n = delP.index();  // 获取checkbox所在行的顺序
                $("table#containerTable").find(".trHover:eq("+n+")").remove();
                
            });
            $.ajax({
	                type:"POST",
	                url:"/2009/deleteStudentServlet", //提交删除学生的网址
	                data:{
	                	"delStuID":delStuID.join(",")
	                },//提交的数据
	                success:function(res){
	                    console.log("传送删除课程id成功");
	                    console.log(res);
	                },
	                error:function(){
	                    alert("向后台传输删除课程id出错");
	                }
	            })   
            
        });
    });
    //end
    //翻页功能
 

//table分页
var pageSize=10;  //每页显示的记录条数
var curPage=0;   //显示第curPage页
var len;         //总行数
var page;        //总页数
function page(){
    len =$("#containerTable tr").length-1;   //去掉表头
    page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
    console.log("len:"+len+"page:"+page);
    document.getElementById("page").value=page;
    curPage=1;
    displayPage();//显示第一页
    $("#nextPageButton").click(function(){//下一页
        if(curPage<page){
            curPage+=1;
        }
        else{
            alert("It's the last page")
        }
        displayPage();
    });
    $("#prePageButton").click(function(){//上一页
        if(curPage>1){
            curPage-=1;
        }
        else{
            alert("It's already page one");
        }
        displayPage();
    });
};
function displayPage(){
    var begin=(curPage-1)*pageSize;//起始记录号
    var end = begin + pageSize;
    console.log("  begin:"+len+"   end:"+end);
    if(end > len ) end=len;
    $("#tdata tr").hide();
    $("#containerTable tr").each(function(i){
        if(i-1>=begin && i-1<end)//显示第page页的记录
        {
            $("#containerTable_one").show();
            $(this).show();
            document.getElementById("curPage").innerHTML=curPage;
            document.getElementById("countPage").innerHTML = len;
        }
    });
}
function pageSize2(){
    curPage=0;   //显示第curPage页
    pageSize=parseInt(document.getElementById("pageSize").value);
    len =$("#containerTable tr").length-1;   //去掉表头
    page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
    console.log("len:"+len+"   page:"+page);
    document.getElementById("page").value=page;
    curPage=1;
    displayPage();//显示第一页
}
 
 