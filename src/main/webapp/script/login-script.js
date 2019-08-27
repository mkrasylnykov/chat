function chek_login () {
    if(document.forms.splash_form.j_username.value === '') {
        alert('Username не должен быть пустым!');
        return false;
    }
    
    if(document.forms.splash_form.j_password.value === '') {
        alert('Password не должен быть пустым!');
        return false;
    }

    return true;
}

function forgot_password() {
    alert("Пока функция не доступна!");
}
