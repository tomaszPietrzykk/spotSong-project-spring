function validateForm() {

    const authorName = document.getElementById("authorName")
    const authorLastName = document.getElementById("authorLastName")
    const nickname = document.getElementById("nickname")
    const dateOfBirth = document.getElementById("dateOfBirth")

    const errorAuthorName = document.getElementById("errorAuthorName")
    const errorAuthorLastName = document.getElementById("errorAuthorLastName")
    const errorNickname = document.getElementById("errorNickname")
    const errorDateOfBirth = document.getElementById("errorDateOfBirth")
    const errorsSummary = document.getElementById("errorsSummary")

    resetErrors([authorName, authorLastName, nickname, dateOfBirth],
        [errorAuthorName, errorAuthorLastName, errorNickname, errorDateOfBirth],
        errorsSummary);

    let valid = true;

    if(!checkRequired(authorName.value)){
        valid = false;
        authorName.classList.add("error-input");
        errorAuthorName.innerText = "Pole jest wymagane";
    }else if(!checkTextLengthRange(authorName.value, 2,60)){
        valid = false;
        authorName.classList.add("error-input");
        errorAuthorName.innerText = "Pole powinno zawierać od 2 do 60 znaków";
    }

    if(!checkRequired(authorLastName.value)){
        valid = false;
        authorLastName.classList.add("error-input");
        errorAuthorLastName.innerText = "Pole jest wymagane";
    }else if(!checkTextLengthRange(authorLastName.value, 2,60)){
        valid = false;
        authorLastName.classList.add("error-input");
        errorAuthorLastName.innerText = "Pole powinno zawierać od 2 do 60 znaków";
    }

    if(!checkRequired(dateOfBirth.value)){
        valid = false;
        dateOfBirth.classList.add("error-input");
        errorDateOfBirth.innerText = "Pole jest wymagane";
    }else if(!checkDateFormat(dateOfBirth.value)){
        valid = false;
        dateOfBirth.classList.add("error-input");
        errorDateOfBirth.innerText = "Data powinna być zapisana w formacie dd.MM.rrrr AUTHOR";
    }

    if(!valid){
        errorsSummary.innerText="Formularz zawiera błędy";
    }

    return valid;

}