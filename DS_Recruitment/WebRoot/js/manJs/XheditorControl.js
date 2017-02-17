jQuery(document).ready(function(){
    //初始化xhEditor编辑器插件
    $(".xheditor").xheditor({
     tools:'simple',
     skin:'default',
     width:$(window).width()*0.6,
     height:200,
     upMultiple:true,
     upImgUrl: '{editorRoot}/upload.jsp',
     upImgExt: "jpg,jpeg,gif,bmp,png",
     onUpload:insertUpload
    });
    //xbhEditor编辑器图片上传回调函数
    function insertUpload(msg) {
     var _msg = msg.toString();
     var _picture_name = _msg.substring(_msg.lastIndexOf("/")+1);
     var _picture_path = Substring(_msg);
     var _str = "<input type='checkbox' name='_pictures' value='"+_picture_path+"' checked='checked' onclick='return false'/><label>"+_picture_name+"</label><br/>";
     $("#helpInfo").append(_msg);
     //$("#uploadList").append(_str);
    }
    //处理服务器返回到回调函数的字符串内容,格式是JSON的数据格式.
    function Substring(s){
     return s.substring(s.substring(0,s.lastIndexOf("/")).lastIndexOf("/"),s.length);
    }
});