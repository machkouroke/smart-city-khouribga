function checkIfImageExists(url, callback) {
    const img = new Image();
    img.src = url;

    if (img.complete) {
        callback(true);
    } else {
        img.onload = () => {
            callback(true);
        };

        img.onerror = () => {
            callback(false);
        };
    }
}

let profilPicture = document.querySelectorAll("img.ref-student-photo, img.miniature, img.ref-image");
for (let image of profilPicture) {
    checkIfImageExists(image.src, (exists) => {
        console.log(image.src);
        if (!exists) {
            image.src = '/view/assets/img/notFound.png';
        }
    });
}
