<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" media="all">
            @import url(style/chat_style.css);
        </style>

        <title><fmt:message key="label.mtitle" /></title>
    </head>

    <body>
        <div class="chat_menu_main">
            <div class="chat_menu_user"></div>
        </div>
        <div id="chat_context">
            <div id="header">
                <div class="marquee-container" id="marquee_container">
                    <div class="marquee-subcontainer">
                        <div class="marquee-text" id="marquee_text">
                            <fmt:message key="label.mbaner"/>
                        </div>
                    </div>
                </div>
            </div>

            <div id="body">
                <div id="main">
                    <div id="top_panel">
                        <font face=arial size=2 color=44dd55>
                            <b>
                                &nbsp; <a href="javascript:void(0);" onclick="refMain();"> <fmt:message key="label.mrefresh"/> </a> (10 сек)
                                &nbsp; - <a href="javascript:void(0);" onclick="clearMsg();"> <fmt:message key="label.mclean"/> </a>
                                &nbsp; - <a href="<c:url value="/logout"/>"> <fmt:message key="label.mlogout"/> </a>
                                <br/>
                            </b>
                        </font>
                    </div>
                    <div id="mainout"></div>
                </div>
            </div>

            <div id="footer">
                <form name="formtext" action="send-msg.htm" method="POST">

                    <div class="input">
                        <div id="bbmenu">
                            <div id="b_b" class="editor_button" onclick="simpletag('b')">
                                <img title="Полужирный" src="img/msg_box_menu/b.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_i" class="editor_button" onclick="simpletag('i')">
                                <img title="Наклонный текст" src="img/msg_box_menu/i.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_u" class="editor_button" onclick="simpletag('u')">
                                <img title="Подчеркнутый текст" src="img/msg_box_menu/u.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_s" class="editor_button" onclick="simpletag('s')">
                                <img title="Зачеркнутый текст" src="img/msg_box_menu/s.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div class="editor_button">
                                <img src="img/msg_box_menu/brkspace.gif" alt="" border="0" width="5" height="25" />
                            </div>
                            <div id="b_left" class="editor_button" onclick="simpletag('left')">
                                <img title="Выравнивание по левому краю" src="img/msg_box_menu/l.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_center" class="editor_button" onclick="simpletag('center')">
                                <img title="По центру" src="img/msg_box_menu/c.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_right" class="editor_button" onclick="simpletag('right')">
                                <img title="Выравнивание по правому краю" src="img/msg_box_menu/r.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div class="editor_button">
                                <img src="img/msg_box_menu/brkspace.gif" alt="" border="0" width="5" height="25" />
                            </div>
                            <div id="b_emo" class="editor_button" onclick="ins_emo();">
                                <img title="Вставка смайликов" src="img/msg_box_menu/emo.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_emo_a" class="editor_button" onclick='script: window.open("smile.htm","","width=400,height=600,status=no,menubar=no,toolbar=no,scrollbars=yes")'>
                                <img title="Вставка суперсмайликов" src="img/msg_box_menu/emo_a.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div class="editor_button"  onclick="tag_url()">
                                <img title="Вставка ссылки" src="img/msg_box_menu/link.gif" width="23" height="25" border="0" alt="" />
                            </div>
                            <div class="editor_button"  onclick="tag_leech()">
                                <img title="Вставка защищенной ссылки" src="img/msg_box_menu/leech.gif" width="23" height="25" border="0" alt="" />
                            </div>
                            <div id="b_color" class="editor_button" onclick="ins_color();">
                                <img src="img/msg_box_menu/color.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div class="editor_button">
                                <img src="img/msg_box_menu/brkspace.gif" alt="" border="0" width="5" height="25" />
                            </div>
                            <div id="b_hide" class="editor_button" onclick="simpletag('hide')">
                                <img title="Скрытый текст" src="img/msg_box_menu/hide.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_quote" class="editor_button" onclick="simpletag('quote')">
                                <img title="Вставка цитаты" src="img/msg_box_menu/quote.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div class="editor_button" onclick="translit()">
                                <img title="Преобразовать выбранный текст из транслитерации в кириллицу" src="img/msg_box_menu/translit.gif" alt="" border="0" width="23" height="25"/>
                            </div>
                            <div id="b_spoiler" class="editor_button" onclick="simpletag('spoiler')">
                                <img src="img/msg_box_menu/spoiler.gif" alt="" border="0" width="23" height="25" />
                            </div>
                            <div id="b_youtube" class="editor_button" onclick="simpletag('youtube')">
                                <img title="Вставить видеоролик с youtube" src="img/msg_box_menu/youtube.gif" alt="" border="0" width="23" height="25" />
                            </div>
                        </div>

                        <iframe id="cp" src="color.htm" vspace="0" hspace="0" marginwidth="0" marginheight="0" style="visibility: hidden; display: none; position: absolute;" width="154" frameborder="0" height="104" scrolling="no"></iframe>
                        <div id="bb_emo" style="visibility: hidden; display: none; position: absolute; width: 145px; height: 95px; overflow: auto; border: 1px solid rgb(187, 187, 187); background: none repeat scroll 0% 0% rgb(233, 232, 242);">
                            <table border="0" cellpadding="0" cellspacing="0" width="120">
                                <tbody>
                                    <tr>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':wink:'); return false;">
                                                <img style="border: medium none;" alt="wink" src="img/smile/wink.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':winked:'); return false;">
                                                <img style="border: medium none;" alt="winked" src="img/smile/winked.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':smile:'); return false;">
                                                <img style="border: medium none;" alt="smile" src="img/smile/smile.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':am:'); return false;">
                                                <img style="border: medium none;" alt="am" src="img/smile/am.gif" />
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':belay:'); return false;">
                                                <img style="border: medium none;" alt="belay" src="img/smile/belay.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':feel:'); return false;">
                                                <img style="border: medium none;" alt="feel" src="img/smile/feel.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':fellow:'); return false;">
                                                <img style="border: medium none;" alt="fellow" src="img/smile/fellow.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':laughing:'); return false;">
                                                <img style="border: medium none;" alt="laughing" src="img/smile/laughing.gif" />
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':lol:'); return false;">
                                                <img style="border: medium none;" alt="lol" src="img/smile/lol.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':love:'); return false;">
                                                <img style="border: medium none;" alt="love" src="img/smile/love.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':no:'); return false;">
                                                <img style="border: medium none;" alt="no" src="img/smile/no.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':recourse:'); return false;">
                                                <img style="border: medium none;" alt="recourse" src="img/smile/recourse.gif" />
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':request:'); return false;">
                                                <img style="border: medium none;" alt="request" src="img/smile/request.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':sad:'); return false;">
                                                <img style="border: medium none;" alt="sad" src="img/smile/sad.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':tongue:'); return false;">
                                                <img style="border: medium none;" alt="tongue" src="img/smile/tongue.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':wassat:'); return false;">
                                                <img style="border: medium none;" alt="wassat" src="img/smile/wassat.gif" />
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':crying:'); return false;">
                                                <img style="border: medium none;" alt="crying" src="img/smile/crying.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':what:'); return false;">
                                                <img style="border: medium none;" alt="what" src="img/smile/what.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':bully:'); return false;">
                                                <img style="border: medium none;" alt="bully" src="img/smile/bully.gif" />
                                            </a>
                                        </td>
                                        <td style="padding: 2px;" align="center">
                                            <a href="#" onclick="bb_smiley(':angry:'); return false;">
                                                <img style="border: medium none;" alt="angry" src="img/smile/angry.gif" />
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <textarea cols="40" rows="10" name="messages" id="messages"></textarea>
                        <input type="button" value="SEND" onClick="if (!sendMsg()) {return false;};"/>
                    </div>
                </form>
            </div>
        </div>
                                
        <script type="text/javascript" src="script/jquery-1.6.1.js"></script>
        <script type="text/javascript" src="script/jquery.validate.js"></script>
        <script type="text/javascript" src="script/chat-script.js"></script>
        <script type="text/javascript" src="script/body-script.js"></script>
    </body>
</html>
