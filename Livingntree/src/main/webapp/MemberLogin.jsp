<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css">
<style>
.container{
    display: flex;
    justify-content: center;
    width: 100%;
}
.container .contents{
    width: 400px;
    margin: 50px 0;
}
.container .contents .login input{
    display: block;
    width: 100%;
    height: 48px;
    line-height: 48px;
    margin-bottom: 10px;
    padding: 0 20px;
    border: 1px solid #e3e3e3;
}
.container .contents .login_idSave_wrap{
    display: flex;
    justify-content: flex-end;
}
.container .contents .login_idSave_wrap p{
    margin: 10px 0 20px;
}
.container .contents .login_idSave_wrap p input[type="checkbox"]{
    width: 24px;
    height: 24px;
    border: 1px solid #d9d9d9;
    border-radius: 0;
    background-image: url(img/icon/checkbox_off.svg);
    outline: 0;
    vertical-align: text-top;
    cursor: pointer;
}
.container .contents .login_idSave_wrap p input[type="checkbox"]:checked{
    background-image: url(img/icon/checkbox_on.svg);
}
.container .contents .login_idSave_wrap p label{
    margin: 0 15px 0 10px;
    vertical-align: middle;
}
.container .contents .login_button input[type="submit"]{
    width: 100%;
    height: 56px;
    padding: 19px 26px;
    font-size: 16px;
    font-weight: 700;
    line-height: 18px;
    border: 0;
    background: #d0ac88;
    color: #fff;
    cursor: pointer;
}
.container .contents .login_find{
    display: flex;
    justify-content: center;
}
.container .contents .login_find div{
    margin-top: 20px;
    padding: 0 10px;
}
.container .contents .login_find div a{
	font-size: 14px;
}
.container .contents .login_find div:nth-child(2){
    padding-left: 11px;
    background: url(../img/icon/line2.png) no-repeat left;
}
.container .contents .login_util{
    display: flex;
    justify-content: center;
    flex-direction: column;
    width: 100%;
    height: 232px;
    margin-top: 20px;
    border: 1px solid #e3e3e3;
    text-align: center;
}
.container .contents .login_util div:nth-child(1){
    font-size: 18px;
    font-weight: 700;
    color: #1a1a1a;
}
.container .contents .login_util div:nth-child(2){
    margin: 8px 0 23px 0;
    font-size: 14px;
    line-height: 1.5;
    color: #8a8a8a;
}
.container .contents .login_util div:nth-child(3){
    width: 152px;
    height: 56px;
    margin: 0 auto;
    border: 1px solid #d6d6d6;
}
.container .contents .login_util div:nth-child(3) a{
    display: block;
    width: 100%;
    height: 100%;
    line-height: 56px;
    font-size: 16px;
    font-weight: 700;
    color: #1a1a1a;
}
</style>
</head>
<body>
    <div class="container">
        <div class="contents">
            <form action="MemberLoginProc.do" method="post">
                <div class="login">
                    <input type="text" name="id">
                    <input type="password" name="pw">
                </div>
                <div class="login_idSave_wrap">
                    <p class="login_idSave">
                        <input type="checkbox" id="check_save_id" name="check_save_id">
                        <label for="check_save_id">아이디 저장</label>
                    </p>
                </div>
                <div class="login_button">
                    <input type="submit" value="로그인">
                </div>
            </form>
            <div class="login_find">
                <div><a href="#">아이디 찾기</a></div>
                <div><a href="#">비밀번호 찾기</a></div>
            </div>
            <div class="login_util">
                <div>아직 회원이 아니신가요?</div>
                <div>지금 회원가입을 하시면<br>다양하고 특별한 혜택이 준비되어 있습니다.</div>
                <div><a href="#">회원가입</a></div>
            </div>
        </div>
    </div>
</body>
</html>