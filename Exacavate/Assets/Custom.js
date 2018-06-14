window.addEventListener("load", init);

function init(){
    elem = document.getElementById("main-navigation");
    document.getElementById("mobileMenu").addEventListener("click", function(){
        elem.classList.toggle("activeMenu");
    });

}