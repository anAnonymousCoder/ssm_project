/**-----获取当前上下文路径-----**/
function getContextPath() {
    let pathName = document.location.pathname;
    let index = pathName.substr(1).indexOf("/");
    return pathName.substr(0, index + 1);
}
