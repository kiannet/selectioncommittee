function validationRegister() {
    if (document.signupForm.surname.value == "") {
        alert("Пожалуйста, введите Вашу фамилию!");
        return false;
    } else if (document.signupForm.name.value == "") {
        alert("Пожалуйста, введите Ваше имя!");
        return false;
    } else if (document.signupForm.email.value == "") {
        alert("Пожалуйста, введите Ваш email!");
        return false;
    }
}