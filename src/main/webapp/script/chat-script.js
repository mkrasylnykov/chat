function tag_url() {
    var vm = document.getElementById("messages");
    
    if (vm.setSelectionRange) {
        vm.value = vm.value.substring(0, vm.selectionStart) + '[url]' + vm.value.substring(vm.selectionStart, vm.selectionEnd) + '[/url]' + vm.value.substring(vm.selectionEnd, vm.value.length)
    } else {
        vm.value = vm.value + '[url]' + ' [/url]';
    }
}

function setColor(color) {
    var vm = document.getElementById("messages");
    
    if (vm.setSelectionRange) {
        vm.value = vm.value.substring(0, vm.selectionStart) + '[color=' + color + ']' + vm.value.substring(vm.selectionStart, vm.selectionEnd) + '[/color]' + vm.value.substring(vm.selectionEnd, vm.value.length)
    } else {
        vm.value = vm.value + '[color=' + color + ']' + ' [/color]';
    }
}

function ins_color() {
    var vcp = document.getElementById("cp");
    vcp.style.visibility = "visible";
    vcp.style.left = "565px";
    vcp.style.top = "0px";
    vcp.style.zIndex = "99";
    
    $("#cp").toggle();
}

function ins_emo() {
    var vbb_emo = document.getElementById("bb_emo");
    vbb_emo.style.visibility = "visible";
    vbb_emo.style.left = "565px";
    vbb_emo.style.top = "0px";
    vbb_emo.style.zIndex = "99";
    
    $("#bb_emo").toggle();
}

function bb_smiley(bbscod) {
    var vm = document.getElementById("messages");
    vm.value = vm.value + bbscod;
}

function simpletag(bbcod) {
    var vm = document.getElementById("messages");
    
    if (vm.setSelectionRange) {
        vm.value = vm.value.substring(0, vm.selectionStart) + '[' + bbcod + ']' + vm.value.substring(vm.selectionStart, vm.selectionEnd) + '[/' + bbcod + ']' + vm.value.substring(vm.selectionEnd, vm.value.length)
    } else {
        vm.value = vm.value + '[' + bbcod + ']' + ' [/' + bbcod + ']';
    }
}

function clearMsg() {
    $("#mainout").empty();
}

function sendMsg() {
    if(document.forms.formtext.messages.value === '') {
        alert('Введите текст сообщения!');
        return false;
    }

    sendAjax();

    return true;
}

function sendAjax() {
    var comments = document.forms.formtext.messages.value;
    document.forms.formtext.messages.value = "";
    $.ajax({
        type: "POST",
        url: "send-msg.htm",
        data: "messages=" + comments,
        success: function(msg){
            var vm = document.getElementById("mainout");
            $("#mainout").append(msg);
            vm.scrollTop = vm.scrollHeight;
        }
    });

    return true;
}

function startMain() {
    getAllMsgAjax();
    getOnlineUsersAjax();

    return true;
}

function refMain() {
    getDeltaMsgAjax();
    getOnlineUsersAjax();

    return true;
}

function getAllMsgAjax() {
    $.ajax({
        type: "GET",
        url: "get-all-msg.htm",
        success: function(msg){
            var vm = document.getElementById("mainout");
            $("#mainout").empty();
            $("#mainout").append(msg);
            vm.scrollTop = vm.scrollHeight;
        }
    });

    return true;
}

function getDeltaMsgAjax() {
    $.ajax({
        type: "GET",
        url: "get-delta-msg.htm",
        success: function(msg){
            var vm = document.getElementById("mainout");
            $("#mainout").append(msg);
            vm.scrollTop = vm.scrollHeight;
        }
    });

    return true;
}

function getOnlineUsersAjax() {
    $.ajax({
        type: "POST",
        url: "who-is-online.htm",
        success: function(msg){
            $(".chat_menu_user").empty();
            $(".chat_menu_user").append(msg);
        }
    });

    return true;
}
