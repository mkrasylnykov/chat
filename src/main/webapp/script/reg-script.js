function reg_submit_chk () {
    if(document.forms.registration.name.value == '') {
        alert('Имя пользователя не может быть пустым!');
        return false;
    }

    if(document.forms.registration.password1.value.length < 6) {
        alert('Длина пароля должна быть не менее 6 символов!');
        return false;
    }

    if(document.forms.registration.password1.value != document.forms.registration.password2.value) {
        alert('Оба введенных пароля должны быть идентичны!');
        return false;
    }

    if(document.forms.registration.email.value == '') {
        alert('Введен неверный E-Mail адрес!');
        return false;
    }

    if (!(/[-!#$%&\'*+\./0-9=?A-Z^_`a-z{|}~]+@[-!#$%&\'*+\/0-9=?A-Z^_`a-z{|}~]+\.[-!#$%&\'*+\./0-9=?A-Z^_`a-z{|}~]+/.test(document.forms.registration.email.value))) {
        alert('Введен неверный E-Mail адрес!');
        return false;
    }

    return true;
}

function reg_login_chk () {
    if(document.forms.registration.name.value == '') {
        alert('Параметр не может быть пустым!');
        return false;
    } else {
        var test = document.forms.registration.name.value;
        $.ajax({
            type: "POST",
            url: "testuser.htm",
            data: "name=" + test,
            success: function(msg){
                $(".reg_info").empty();
                $(".reg_info").append(msg);
            }
        });
    }

    return true;
}
