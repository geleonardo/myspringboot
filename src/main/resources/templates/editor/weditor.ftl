<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor demo list</title>
    <style type="text/css">
        .body {
            width: 800px;
            margin: 0 auto 0 auto;
        }
    </style>
</head>
<script src="http://assets.zhihuishu.com/jquery/1.8.3/jquery.min.js"></script>
<link type="text/css" rel="stylesheet"
      href="http://base1.zhihuishu.com/able-commons/resources/cdn/letvuploader/0.1/fineuploader-4.1.0.css">
<link type="text/css" rel="stylesheet"
      href="http://base1.zhihuishu.com/able-commons/resources/uploader/test/aspupload/css/aspupload/aspupload.css" />
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/cdn/ableuploader/0.2/jquery.fineuploader-4.1.0.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/cdn/ableuploader/0.2/ableuploader.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/cdn/ableuploader/0.2/jquery-ui-1.9.1.custom.min.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/uploader/client/fineuploader.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/cdn/letvuploader/0.1/swfupload.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/uploader/client/swfupload/swfupload.queue.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/uploader/client/swfupload/swfupload.speed.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/cdn/ableuploader/0.2/handlers_01.js"></script>
<script type="text/javascript"
        src="http://base1.zhihuishu.com/able-commons/resources/cdn/ableuploader/0.2/html5upload2.js"></script>
<body>
<div class="body">
    <p>可访问 <a href="http://www.wangeditor.com/" target="_blank">wangEditor 官网</a> 了解更多内容</p>
    <div id="div1">
        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
    </div>

</div>

<!-- 引用js -->
<script type="text/javascript" src="../js/editor/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#div1')
    editor.create()
</script>
<script>

    $(document).ready(function(){


        var id ="uploadfile";
        $('#' + id).Ableuploader({
            videoConvert : "true",// 是否购买转码服务，购买需谨慎
            appName : "aidedteaching", // 对应应用名称
            modelName : "COURSE_FOLDER", // 应该板块模块名称
            userId : $("#userId").val(), // 填写用户ID
            userName : $("#userName").val(),// 用户名
            smallImgSize : "100:100", // 图片或者视频的三种裁图大小
            bigImgSize : "966:488",
            middleImgSize : "360:250",
            autoConvert : "true", // true为自动转换，false或者不配置为不自动转换(上传里需要自带文档转换,Flex上传不需要自带转换.)
            targetId : id, // 为按钮目标标签ID
            showProgress : "true", // 是否显示任务栏进度条
            buttonText : "",
            buttonClass : '',
            allowSuffix : "",// 自定义限制后缀
            buttonWidth : "60",
            buttonTextTopPadding : "1",
            host : "http://base1.zhihuishu.com/able-commons/",
            callbacks : {
                onFileDialogStart : function(tid) {

                },
                onError : function(id, fileName, reason) {
                },
                onUpload : function(id, fileName) {

                },
                onComplete : function(id, fileName, responseJSON) {
                    if (responseJSON != '') {
                        var data = responseJSON.data;
                        console.dir(data);
                        $('#' + linkUrlId).val('1111111111');
                    }
                },
                onDelete : function(id) {
                },
                onDeleteComplete : function(id, xhrOrXdr, isError) {
                }
            }
        });
    });

</script>
</body>
</html>