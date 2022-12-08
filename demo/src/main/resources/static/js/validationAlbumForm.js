function validateForm() {

    const albumName = document.getElementById('albumName');
    const releaseDate = document.getElementById('releaseDate');
    const author = document.getElementById('author');

    const errorAlbumName = document.getElementById('errorAlbumName');
    const errorReleaseDate = document.getElementById('errorReleaseDate');
    const errorAuthor = document.getElementById('errorAuthor');
    const errorsSummary = document.getElementById('errorsSummary');

    resetErrors([albumName, releaseDate, author], [errorAlbumName, errorReleaseDate, errorAuthor], errorsSummary);

    let valid = true;

    if (!checkRequired(albumName.value)) {
        valid = false;
        albumName.classList.add("error-input");
        errorAlbumName.innerText = "Pole jest wymagane";
    } else if (!checkTextLengthRange(albumName.value, 2, 60)) {
        valid = false;
        albumName.classList.add("error-input");
        errorAlbumName.innerText = "Pole powinno zawierać od 2 do 60 znaków";
    }

    if (!checkRequired(releaseDate.value)) {
        console.log(releaseDate.value);
        valid = false;
        releaseDate.classList.add("error-input");
        errorReleaseDate.innerText = "Pole jest wymagane";
    } else if (!checkDateFormat(releaseDate.value)) {
        console.log(checkDateFormat(releaseDate.value));
        valid = false;
        releaseDate.classList.add("error-input");
        errorReleaseDate.innerText = "Data powinna być zapisana w formacie dd.MM.rrrr dasdasdas";
    }

    if (!checkRequired(author.value)) {
        valid = false;
        author.classList.add("error-input");
        errorAuthor.innerText = "Pole jest wymagane";
    } else if (!checkTextLengthRange(author.value, 2, 60)) {
        valid = false;
        author.classList.add("error-input");
        errorAuthor.innerText = "Pole powinno zawierać od 2 do 60 znaków";
    }

    if (!valid) {
        errorsSummary.innerText = "Formularz zawiera błędy";
    }

    return valid;

}