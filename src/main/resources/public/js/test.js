const url = contextRoot + "images/";

/* Get all images: */
async function getAllImages() {
    const response = await fetch(url, {
        headers: {
            "Accept": "application/json"
        },
        method: "get"
    });
    const images = await response.json();
    allImagesToList(images);
};

/* Get image by id */
async function loadImageContentUrlById(id) {
    const response = await fetch(url + id + "/content", {
        method: "get"
    });
    const image = await response.blob();
    const imageObjectURL = URL.createObjectURL(image);//create local url for image
    placeUrlToImgElement(imageObjectURL, "image-list", id);

};

/* get image object by id */
async function getImageObject(id) {
    const response = await fetch(url + id, {
        headers: {
            "Accept": "application/json"
        },
        method: "get"
    });
    const data = await response.json();
    return data;
};
/* Delete image by id */
async function deleteImageById(id) {
    const response = await fetch(url + id + "/delete", {
        headers: {
            "Accept": "application/json"
        },
        method: "delete"
    });
    const data = await response.json();
    document.getElementById(data.id).remove();
};

/* Creates the figure element associated with the image */
const placeUrlToImgElement = (url, elementToAppendTo, imageId) => {
    const figureElement = document.createElement("figure");
    figureElement.id = imageId;

    const imageElement = document.createElement("img");
    imageElement.src = url;

    const formElement = document.createElement("form");
    const deleteButton = document.createElement("button");
    deleteButton.innerHTML = "Delete";
    deleteButton.onclick = function () {
        deleteImageById(imageId)
    };
    figureElement.appendChild(imageElement);
    figureElement.appendChild(formElement);
    figureElement.appendChild(deleteButton);
    document.getElementById(elementToAppendTo).appendChild(figureElement);
};

const allImagesToList = data => {
    data.forEach(imageObject => {
        loadImageContentUrlById(imageObject.id);
    });
};



