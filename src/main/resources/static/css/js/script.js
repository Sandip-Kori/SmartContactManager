console.log("Script loaded");

// change theme work
let currentTheme = getTheme();
//initial -->

document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page

  changePageTheme(currentTheme, "");
  //set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked");
    if (currentTheme === "dark") {
      //theme ko light
      currentTheme = "light";
    } else {
      //theme ko dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localstorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localstorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  //localstorage mein update karenge
  setTheme(currentTheme);
  //remove the current theme

  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }
  //set the current theme
  document.querySelector("html").classList.add(theme);

  // change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}

//change page change theme




// actual code below

//console.log("Script loaded");
//
//let currentTheme = getTheme();
//
//// initial
//changeTheme();
//
//
//// Todo;
//function changeTheme(){
//
//    // set to web page
//    document.querySelector("html").classList.add(currentTheme);
//
//    // set the listener to change theme button
//    const changeThemeButton = document.querySelector('#theme_change_button');
//    changeThemeButton.querySelector("span").textContent = currentTheme =='light' ? 'Dark' : 'light';
//    changeThemeButton.addEventListener("click",(event) => {
//        const oldTheme=currentTheme;
//        console.log("change theme button clicked");
//        if(currentTheme === "dark"){
//            //theme ko light
//            currentTheme="light";
//        }else{
//            //theme lo dark
//            currentTheme="dark"
//        }
//
//        //localstorage mein update karenge
//        //remove the current theme
//        document.querySelector("html").classList.remove(oldTheme);
//        setTheme(currentTheme);
//        //set the current theme
//        document.querySelector("html").classList.add(currentTheme);
//
//        // change the text of button
//        changeThemeButton.querySelector("span").textContent = currentTheme =='light' ? 'Dark' : 'light';
//    })
//}
//
////set theme to localstorage
//function setTheme(theme){
//    localStorage.setItem("theme",theme);
//}
//
////get theme from localstorage
//function getTheme(){
//    let theme=localStorage.getItem("theme")
//    return theme ? theme : "light";
//}


