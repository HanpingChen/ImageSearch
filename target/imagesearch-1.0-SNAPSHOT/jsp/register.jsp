<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <meta name="keywords" content="jQuery背景全屏轮播,JS背景全屏轮播切换,注册登录页面,注册登录模板页面,注册登录HTML页面,注册登录HTML" />
    <meta name="description" content="JS代码网提供带全屏背景图片轮播切换的注册登录页面下载" />
    <meta charset="utf-8">
    <link href="css/home.css?v=2" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<style>
    .container p{
        text-align: center;
        font-size: 20px;
        color: greenyellow;
    }
</style>
<body>
<div class="wrap">
    <div class="banner-show" id="js_ban_content">
        <div class="cell bns-01">
            <div class="con"> </div>
        </div>
        <div class="cell bns-02" style="display:none;">
            <div class="con"> <a href="#" target="_blank" class="banner-link"> <i>开放平台</i></a> </div>
        </div>
        <div class="cell bns-03" style="display:none;">
            <div class="con"> <a href="#" target="_blank" class="banner-link"> <i>图像检索</i></a> </div>
        </div>
    </div>
    <div class="banner-control" id="js_ban_button_box"> <a href="javascript:;" class="left">左</a> <a href="javascript:;" class="right">右</a> </div>
    <script type="text/javascript">
        ;(function(){

            var defaultInd = 0;
            var list = $('#js_ban_content').children();
            var count = 0;
            var change = function(newInd, callback){
                if(count) return;
                count = 2;
                $(list[defaultInd]).fadeOut(400, function(){
                    count--;
                    if(count <= 0){
                        if(start.timer) window.clearTimeout(start.timer);
                        callback && callback();
                    }
                });
                $(list[newInd]).fadeIn(400, function(){
                    defaultInd = newInd;
                    count--;
                    if(count <= 0){
                        if(start.timer) window.clearTimeout(start.timer);
                        callback && callback();
                    }
                });
            }

            var next = function(callback){
                var newInd = defaultInd + 1;
                if(newInd >= list.length){
                    newInd = 0;
                }
                change(newInd, callback);
            }

            var start = function(){
                if(start.timer) window.clearTimeout(start.timer);
                start.timer = window.setTimeout(function(){
                    next(function(){
                        start();
                    });
                }, 8000);
            }

            start();

            $('#js_ban_button_box').on('click', 'a', function(){
                var btn = $(this);
                if(btn.hasClass('right')){
                    //next
                    next(function(){
                        start();
                    });
                }
                else{
                    //prev
                    var newInd = defaultInd - 1;
                    if(newInd < 0){
                        newInd = list.length - 1;
                    }
                    change(newInd, function(){
                        start();
                    });
                }
                return false;
            });

        })();
    </script>
    <div class="container">
        <div class="register-box">
            <div class="reg-slogan"> 新用户注册</div>
            <form action="/imagesearch/register" method="post">
                <div class="reg-form" id="js-form-mobile"> <br>
                    <br>
                    <div class="cell">
                        <input type="email" name="email" id="js-mobile_ipt" class="text" placeholder="输入邮箱" />
                    </div>
                    <div class="cell">
                        <input type="password" name="password" id="js-mobile_pwd_ipt" class="text" placeholder="密码" />
                        <input type="text" name="passwd" id="js-mobile_pwd_ipt_txt" class="text" maxlength="20" style="display:none;" />
                        <b class="icon-form ifm-view js-view-pwd" title="查看密码" style="display: none"> 查看密码</b> </div>
                    <!-- !短信验证码 -->
                    <div class="cell">
                        <input type="text" name="username" id="js_ipt" placeholder="输入用户名">
                    </div>
                    <div class="bottom"> <button type="submit" id="js-mobile_btn"  class="button btn-green"> 立即注册</button></div>
                </div>
                <%
                    if (session.getAttribute("registerstatus")!=null){
                %>
                <p>该邮箱已经注册过！</p>
                <%
                    }
                %>
            </form>

            <div class="reg-form" id="js-form-mail" style="display: none;">
                <div class="cell">
                    <label for="js-mail_ipt">输入你的常用邮箱</label>
                    <input type="text" name="email" id="js-mail_ipt" class="text" />
                </div>
                <div class="cell">
                    <label for="js-mail_pwd_ipt">设置密码</label>
                    <input type="password" name="passwd" id="js-mail_pwd_ipt" class="text" />
                    <input type="text" name="passwd" id="js-mail_pwd_ipt_txt" class="text" maxlength="20" style="display:none;" />
                    <b class="icon-form ifm-view js-view-pwd" title="查看密码" style="display: none"> 查看密码</b> </div>
                <!-- !短信验证码 -->
                <div class="cell vcode">
                    <label for="js-mail_vcode_ipt">输入验证码</label>
                    <input type="text" name="code" id="js-mail_vcode_ipt" class="text" maxlength="4" />
                    <img id="js-mail_vcode_img" src="http://passport.115.com/?ct=securimage&ac=email" alt="code" /> <span> <a id="js-mail_vcode_a" href="javascript:;" code_src="http://passport.115.com/?ct=securimage&amp;ac=email"> 换一张</a></span> </div>
                <div class="user-agreement">
                    <input type="checkbox" id="js-mail_chk" checked="true" />
                    <label for="js-mail_chk">同意<a href="http://115.com/agreement.html" target="_blank">《JS代码网用户服务协议》</a></label>
                </div>
                <div class="bottom"> <a id="js-mail_btn" href="javascript:;" class="button btn-green"> 立即注册</a></div>
            </div>
        </div>

    </div>
</div>
</body>
</html>

