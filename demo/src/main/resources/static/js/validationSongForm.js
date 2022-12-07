function validateForm() {

    const songName = document.getElementById("songName");
    const duration = document.getElementById("duration");
    const author = document.getElementById("author");
    const album = document.getElementById("album");
    const lyrics = document.getElementById("lyrics");

    const errorSongName = document.getElementById("errorSongName");
    const errorDuration = document.getElementById("errorDuration");
    const errorAuthor = document.getElementById("errorAuthor");
    const errorAlbum = document.getElementById("errorAlbum");
    const lyricsError = document.getElementById("lyricsError");
    const errorsSummary = document.getElementById("errorsSummary");

    resetErrors([songName, duration, author, album, lyrics],
        [errorSongName, errorDuration, errorAuthor, errorAlbum, lyricsError],
        errorsSummary);

    let valid = true;

    if(!checkRequired(songName.value)){
        valid = false;
        songName.classList.add("error-input");
        errorSongName.innerText = "Pole jest wymagane";
    }else if(!checkTextLengthRange(songName.value, 2,60)){
        valid = false;
        songName.classList.add("error-input");
        errorSongName.innerText = "Pole powinno zawierać od 2 do 60 znaków";
    }

    if(!checkRequired(duration.value)){
        valid = false;
        duration.classList.add("error-input");
        errorDuration.innerText = "Pole jest wymagane";
    }

    if(!checkRequired(author.value)){
        valid = false;
        author.classList.add("error-input");
        errorAuthor.innerText = "Pole jest wymagane";
    }else if(!checkTextLengthRange(author.value, 2,60)){
        valid = false;
        author.classList.add("error-input");
        errorAuthor.innerText = "Pole powinno zawierać od 2 do 60 znaków";
    }

    if(!checkRequired(album.value)){
        valid = false;
        album.classList.add("error-input");
        errorAlbum.innerText = "Pole jest wymagane";
    }else if(!checkTextLengthRange(album.value, 2,60)){
        valid = false;
        album.classList.add("error-input");
        errorAlbum.innerText = "Pole powinno zawierać od 2 do 60 znaków";
    }

    if(!checkRequired(lyrics.value)){
        valid = false;
        lyrics.classList.add("error-input");
        lyricsError.innerText = "Pole jest wymagane";
    }else if(!checkHttpUrl(lyrics.value)){
        valid = false;
        lyrics.classList.add("error-input");
        lyricsError.innerText = "Ten link jest nieprawidłowy";
    }

    if(!valid){
        errorsSummary.innerText="Formularz zawiera błędy";
    }

    return valid;

}