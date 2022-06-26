const links = document.querySelectorAll("#userId");
const modalTitle = document.querySelector(".modal-title");
let id = 0;
links.forEach(function (a) {
    a.addEventListener('click', function () {
        id = a.dataset.id;
        let getRequest = new XMLHttpRequest();
        getRequest.open('GET', "/user/get?id=" + id, false);
        getRequest.send(null);
        const username = getRequest.responseText;
        modalTitle.innerHTML = "Czy na pewno chcesz usunąć: <span class='text-danger font-weight-bold'>" + username + "</span>?";
    });
});

function redirect() {
    window.location.replace('/user/delete?id=' + id);
}