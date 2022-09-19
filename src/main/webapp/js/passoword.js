function setCookie(name, value, hours, path) {
    var name = escape(name);
    var value = escape(value);
    var expires = new Date();
    expires.setTime(expires.getTime() + hours * 3600000);
    path = path == "" ? "" : ";path=" + path;
    _expires = (typeof hours) == "string" ? "" : ";expires=" + expires.toUTCString();
    document.cookie = name + "=" + value + _expires + path;
}

function passwordStu(){
    var account = document.getElementById("account").value;
    var password = document.getElementById("password").value;
    $.ajax({
        type:"POST",
        url:"/2009/stLogInServlet", //提交的网址
        data:{"Account":account,"Password":password},//提交的数据
        success:function(res){
            console.log("Data transfer succeeded");
            console.log(res);
            if(res == '0'){
				if(subm()){
					setCookie("account_tran",account,3600,"/");
					location.href = '../menu/stMenu.html';
				}else{
					alert("The verification code is incorrect");
				}
			}else if(res=='1'){
				alert("Account or password is wrong");
			}else if(res=='2'){
				alert("Account is not exist");
			}
            
        },
        error:function(){
            alert("Error transferring data to background");
        }
    })   

};

function passwordAd(){
    var account = document.getElementById("account").value;
    var password = document.getElementById("password").value;
    if(account=='20220401'&&password=='123456'){
		if(subm()){
			location.href = '../menu/adMenu.html';
		}else{
			alert("The verification code is incorrect");
		}
	}else{
		alert("The account or password is incorrect");
	}
	
}    


function subm(){
    var val = document.getElementById("text").value;
    var num = show_num.join("");
    if(val ==''){
        alert('Please enter the verification code');
        return false;
    }else if(val == num){
        return true;
    }else{
        alert('Verification code error');
        document.getElementById("text").value='';
        draw(show_num);
        return false;
    }  //yes
}