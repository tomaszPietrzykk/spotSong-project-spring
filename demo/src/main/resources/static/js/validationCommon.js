function resetErrors(inputs, errorTexts, errorInfo){
    for(let i=0; i<inputs.length; i++){
        inputs[i].classList.remove("error-input");
    }
    for(let i=0; i<errorTexts.length; i++){
        errorTexts[i].innerText = "";
    }
    errorInfo.innerText = "";
}

function checkRequired(value){
    if(!value){
        return false;
    }
    value = value.toString().trim();
    return value !== "";

}

function  checkTextLengthRange(value, min, max){
    if(!value){
        return false;
    }
    value = value.toString().trim();
    const length = value.length;
    if(max && length > max){
        return false;
    }
    return !(min && length < min);

}

function checkDateFormat(value){
    return value instanceof Date;
}

function checkHttpUrl(value) {
    let url;
    try {
        url = new URL(value);
    } catch (_) {
        return false;
    }
    return url.protocol === "http:" || url.protocol === "https:";
}